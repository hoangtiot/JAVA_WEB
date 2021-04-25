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
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

    private static final String ERROR = "management.jsp";
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
            HttpSession session = request.getSession();
            boolean flag = true;
            ProductError error = new ProductError("", "", "", "", "");

            String productID = request.getParameter("productID");

            String name = request.getParameter("name");
            if (!name.matches(".{1,25}")) {
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
            if (!description.matches(".{1,25}")) {
                error.setDescriptionError("Description cant contains special characters.");
                flag = false;
            }
            String categoryID = request.getParameter("categoryID");
            String img = request.getParameter("img");
            if (!request.getParameter("img").startsWith("img/")) {
                img = "img/" + request.getParameter("img");
            }
            ProductDAO dao = new ProductDAO();
            List<ProductDTO> list = dao.getListProduct();
            session.setAttribute("LIST_ALL", list);
            if (flag) {
                ProductDTO dto = new ProductDTO(productID, name, price, quantity, description, categoryID, img);
                boolean check = dao.update(dto);
                if (check) {
                    url = SUCCESS;
                }
                list = dao.getListProduct();
                session.setAttribute("LIST_ALL", list);
                session.setAttribute("ERROR_MSG", null);
            } else {
                session.setAttribute("ERROR_MSG", error);
                session.setAttribute("ERROR_ID", productID);
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
