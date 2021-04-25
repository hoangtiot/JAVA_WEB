/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangdh.daos;

import hoangdh.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author PC
 */
public class OrderDAO {
    public void newOrder(String orderID, Timestamp orderDate, float orderTotal, String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
//        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblOrders (OrderID, OrderDate, OrderTotal, UserID) VALUES (?, ?, ?, ?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, orderID);
                stm.setTimestamp(2, orderDate);
                stm.setFloat(3, orderTotal);
                stm.setString(4, userID);
                int r = stm.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
//            if (rs != null) {
//                rs.close();
//            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    public boolean updateTotal(String id, float total) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
//        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblOrders SET OrderTotal = ? WHERE OrderID = ?";
                stm = conn.prepareStatement(sql);                
                stm.setFloat(1, total);
                stm.setString(2, id);

                check = stm.executeUpdate() > 0;

            }
        } catch (Exception e) {
        } finally {
//            if (rs != null) {
//                rs.close();
//            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}
