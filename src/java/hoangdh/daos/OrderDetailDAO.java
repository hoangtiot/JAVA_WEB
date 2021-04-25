/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangdh.daos;

import hoangdh.dtos.OrderDetailDTO;
import hoangdh.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author PC
 */
public class OrderDetailDAO {

    public boolean newOrderDetail(OrderDetailDTO dto) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
//        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblOrderDetail (OrderDetailID, Price, Quantity, OrderID, ProductID) VALUES (?, ?, ?, ?, ?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getOrderDetailID());
                stm.setFloat(2, dto.getPrice());
                stm.setInt(3, dto.getQuantity());
                stm.setString(4, dto.getOrderID());
                stm.setString(5, dto.getProductID());
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

    public boolean insert(Collection<OrderDetailDTO> list) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;

        for (OrderDetailDTO dto : list) {
            try {
                conn = DBUtils.getConnection();
                if (conn != null) {
                    String sql = "INSERT INTO tblOrderDetail (OrderDetailID, Price, Quantity, OrderID, ProductID) VALUES (?, ?, ?, ?, ?)";
                    stm = conn.prepareStatement(sql);
                    stm.setString(1, dto.getOrderDetailID());
                    stm.setFloat(2, dto.getPrice());
                    stm.setInt(3, dto.getQuantity());
                    stm.setString(4, dto.getOrderID());
                    stm.setString(5, dto.getProductID());
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
        }
        return check;
    }
}
