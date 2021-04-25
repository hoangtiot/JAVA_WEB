/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangdh.controllers;

import hoangdh.daos.CategoryDAO;
import hoangdh.dtos.CategoryDTO;
import java.io.IOException;
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
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String CREATE = "CreateController";
    private static final String SEARCH = "SearchController";
    private static final String DELETE = "DeleteController";
    private static final String UPDATE = "UpdateController";
    private static final String LOGIN = "LoginController";
    private static final String LOGIN_GOOGLE = "LoginGoogleController";
    private static final String DETAIL = "DetailController";
    private static final String CATE = "CategoryController";
    private static final String MANAGEMENT = "ManagementController"; 
    private static final String CART = "CartController"; 
    private static final String CART_ADD = "CartAddController"; 
    private static final String CART_UPDATE = "CartUpdateController"; 
    private static final String CART_DELETE = "CartDeleteController"; 
    private static final String CART_CHECKOUT = "CheckoutController"; 
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
            String action = request.getParameter("action");
            if ("Search".equals(action)){
                url = SEARCH;
            }else if ("Delete".equals(action)){
                url = DELETE;
            }else if ("Update".equals(action)){
                url = UPDATE;
            }else if ("Create".equals(action)){
                url = CREATE;
            }else if ("Login".equals(action)){
                url = LOGIN;
            }else if ("Detail".equals(action)){
                url = DETAIL;
            }else if ("ProductByCate".equals(action)){
                url = CATE;
            }else if ("Management".equals(action)){
                url = MANAGEMENT;
            }else if ("Cart".equals(action)){
                url = CART;
            }else if ("Add to Cart".equals(action)){
                url = CART_ADD;
            }else if ("Update Cart".equals(action)){
                url = CART_UPDATE;
            }else if ("Delete from Cart".equals(action)){
                url = CART_DELETE;
            }else if ("Check out".equals(action)){
                url = CART_CHECKOUT;
            }
            

            CategoryDAO daoC = new CategoryDAO();
            List<CategoryDTO> listCate = daoC.getListCategory();
            request.getSession().setAttribute("LIST_CATE", listCate);
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
