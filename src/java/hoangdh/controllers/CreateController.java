/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangdh.controllers;

import hoangdh.daos.CategoryDAO;
import hoangdh.daos.ProductDAO;
import hoangdh.dtos.CategoryDTO;
import hoangdh.dtos.ProductDTO;
import hoangdh.dtos.ProductError;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {

    private static final String ERROR = "create.jsp";
    private static final String SUCCESS = "management.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            boolean flag = true;
            ProductError error = new ProductError("", "", "", "", "");

            String productID = request.getParameter("productID");
            if (!productID.matches("^[a-zA-Z0-9]{1,20}$")) {
                error.setProductIDError("Product ID cant contains special characters.");
                flag = false;
            }
            ProductDAO dao = new ProductDAO();
            List<ProductDTO> list = dao.getListProduct();
            for (ProductDTO p : list) {
                if (productID.equalsIgnoreCase(p.getProductID())) {
                    error.setProductIDError("Product ID isexisted.");
                    flag = false;
                }
            }
            String name = request.getParameter("name");
            if (!name.matches("^[a-zA-Z0-9]{1,25}")) {
                error.setNameError("Name cant contains special characters.");
                flag = false;
            }
            float price = Float.parseFloat(request.getParameter("price"));
            if (price <= 0) {
                error.setPriceError("Price must be > 0.");
                flag = false;
            }
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            if (quantity <= 0) {
                error.setQuantityError("Quantity must be > 0.");
                flag = false;
            }
            String description = request.getParameter("description");
            if (!description.matches("^[a-zA-Z0-9]{1,25}")) {
                error.setDescriptionError("Description cant contains special characters.");
                flag = false;
            }

            String categoryID = request.getParameter("categoryID");
            String img = "img/" + request.getParameter("img");
            if (flag) {
                ProductDTO dto = new ProductDTO(productID, name, price, quantity, description, categoryID, img);

                dao.insert(dto);

                request.setAttribute("LIST_ALL", list);
//                CategoryDAO daoC = new CategoryDAO();
//                List<CategoryDTO> listCate = daoC.getListCategory();
//                session.setAttribute("LIST_CATE", listCate);

                url = SUCCESS;
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("ERROR_MSG", error);
            }
        } catch (Exception e) {
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
