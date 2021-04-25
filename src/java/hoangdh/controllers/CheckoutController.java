/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangdh.controllers;

import hoangdh.daos.OrderDAO;
import hoangdh.daos.OrderDetailDAO;
import hoangdh.daos.ProductDAO;
import hoangdh.dtos.CartDTO;
import hoangdh.dtos.OrderDetailDTO;
import hoangdh.dtos.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CheckoutController", urlPatterns = {"/CheckoutController"})
public class CheckoutController extends HttpServlet {

    private final static String ERROR = "cart.jsp";
    private final static String SUCCESS = "home.jsp";

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
            boolean check = true;
            HttpSession session = request.getSession();
            ProductDAO daoP = new ProductDAO();
            String orderID = "";
            float total = 0;
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            LocalDateTime time = (LocalDateTime) session.getAttribute("ORDER_TIME");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            orderID = dtf.format(time);
            Timestamp orderDate = Timestamp.valueOf(time);
            OrderDAO daoO = new OrderDAO();
            daoO.newOrder(orderID, orderDate, 0, user.getUserID()); 

            OrderDetailDAO daoOD = new OrderDetailDAO();
            for (OrderDetailDTO od : cart.getCart().values()) {
                if ((daoP.checkQuantity(od.getProductID(), od.getQuantity()))) {
                } else {
                    check = false;
                }
            }
            if (check) {
                for (OrderDetailDTO od : cart.getCart().values()) {
                    daoP.buy(od.getProductID(), od.getQuantity());
                    total += (od.getPrice() * od.getQuantity());
                    daoOD.newOrderDetail(new OrderDetailDTO(od.getOrderDetailID(), od.getPrice(), od.getQuantity(), od.getOrderID(), od.getProductID()));
                }
//                daoOD.insert(cart.getCart().values());
            }

            
            daoO.updateTotal(orderID, total);
            
            cart.getCart().clear();
            
            session.setAttribute("CART", null);
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
