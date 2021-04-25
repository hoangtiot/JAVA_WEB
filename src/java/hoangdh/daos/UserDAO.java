/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangdh.daos;

import hoangdh.dtos.UserDTO;
import hoangdh.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class UserDAO {
    public UserDTO checkLogin(String userID, String password) throws SQLException{
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement stm= null;
        ResultSet rs= null;
        try {
            conn = DBUtils.getConnection();
            if(conn != null){
                String sql = "SELECT UserID, fullName, address, phone, email, RoleID from tblUsers "
                        +    "WHERE UserID = ? AND password = ?";
                stm = conn.prepareStatement(sql);
                
                stm.setString(1, userID);
                stm.setString(2, password);
                
                rs = stm.executeQuery();
                if(rs.next()){
                    String fullName = rs.getString("fullName");
                    String address= rs.getString("address");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String roleID = rs.getString("RoleID");
                    user = new UserDTO(userID, fullName, address, phone, email, "***", roleID);
                }
            }
            
        } catch (Exception e) {
        }finally{
            if(rs!=null) rs.close();
            if(stm!=null) stm.close();
            if(conn!=null) conn.close();
        }
        
        return user;
    }
    
    
}
