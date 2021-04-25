/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangdh.controllers;

import hoangdh.daos.ProductDAO;
import hoangdh.dtos.CartDTO;
import hoangdh.dtos.OrderDetailDTO;
import hoangdh.dtos.ProductDTO;
import hoangdh.dtos.UserDTO;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
@WebServlet(name = "CartAddController", urlPatterns = {"/CartAddController"})
public class CartAddController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "cart.jsp";

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
            HttpSession session = request.getSession(true);
            UserDTO user = null;
            String orderID = "";
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            try {
                user = (UserDTO) session.getAttribute("LOGIN_USER");

            } catch (Exception e) {
            }
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            if (cart == null) {
                cart = new CartDTO();
                LocalDateTime now = LocalDateTime.now();
                session.setAttribute("ORDER_TIME", now);  
            }

            orderID = dtf.format((LocalDateTime) session.getAttribute("ORDER_TIME"));

            String productID = request.getParameter("productID");
            String orderDetailID = "";

            if (user == null) {
                orderDetailID = "G" + productID + orderID;
            } else {
                orderDetailID = user.getUserID() + productID + orderID;
            }
            int quantity = 1;

            float price = Float.parseFloat(request.getParameter("price"));
            OrderDetailDTO od = new OrderDetailDTO(orderDetailID, price, quantity, orderID, productID);
            cart.add(od);
//            cart.getCart().values().;
            session.setAttribute("CART", cart);
            ProductDAO dao = new ProductDAO();
            List<ProductDTO> list = dao.getListProduct();
            session.setAttribute("LIST_ALL", list);
            url = SUCCESS;
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
