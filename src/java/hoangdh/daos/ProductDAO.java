/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangdh.daos;

import hoangdh.dtos.ProductDTO;
import hoangdh.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ProductDAO {

    public List<ProductDTO> getListProduct() throws SQLException {
        List<ProductDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "";
                sql = "SELECT ProductID, Name, Price, Quantity, ProDescription, CategoryID, ProductImage FROM tblProducts";

                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    String productID = rs.getString(1);
                    String name = rs.getString(2);
                    float price = rs.getFloat(3);
                    int quantity = rs.getInt(4);
                    String description = rs.getString(5);
                    String categoryID = rs.getString(6);
                    String img = rs.getString(7);
                    list.add(new ProductDTO(productID, name, price, quantity, description, categoryID, img));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<ProductDTO> search(String search) throws SQLException {
        List<ProductDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "";
                sql = "SELECT ProductID, Name, Price, Quantity, ProDescription, CategoryID, ProductImage FROM tblProducts WHERE Name LIKE ?";

                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    String productID = rs.getString(1);
                    String name = rs.getString(2);
                    float price = rs.getFloat(3);
                    int quantity = rs.getInt(4);
                    String description = rs.getString(5);
                    String categoryID = rs.getString(6);
                    String img = rs.getString(7);
                    list.add(new ProductDTO(productID, name, price, quantity, description, categoryID, img));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public void insert(ProductDTO product) throws SQLException {

        Connection conn = null;
        PreparedStatement stm = null;
//        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblProducts (ProductID, Name, Price, Quantity, ProDescription, CategoryID, ProductImage) VALUES (?, ?, ?, ?, ?, ?, ?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, product.getProductID());
                stm.setString(2, product.getName());
                stm.setFloat(3, product.getPrice());
                stm.setInt(4, product.getQuantity());
                stm.setString(5, product.getDescription());
                stm.setString(6, product.getCategoryID());
                stm.setString(7, product.getImg());

                stm.executeUpdate();
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

    public boolean update(ProductDTO product) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
//        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblProducts SET Name = ?,  Price = ?, Quantity = ?, ProDescription = ?, CategoryID = ?, ProductImage = ? WHERE ProductID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, product.getName());
                stm.setFloat(2, product.getPrice());
                stm.setInt(3, product.getQuantity());
                stm.setString(4, product.getDescription());
                stm.setString(5, product.getCategoryID());
                stm.setString(6, product.getImg());
                stm.setString(7, product.getProductID());

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

    public boolean delete(String id) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
//        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "DELETE FROM tblProducts WHERE ProductID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, id);

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

    public boolean buy(String id, int number) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblProducts SET Quantity = Quantity - ? WHERE ProductID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, number);
                stm.setString(2, id);

                check = stm.executeUpdate() > 0;

            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean checkQuantity(String id, int number) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int quantity = 0;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT Quantity FROM tblProducts WHERE ProductID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    quantity = rs.getInt(1);
                }
                if (quantity >= number) {
                    check = true;
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public ProductDTO getDetail(String id) throws SQLException {
        ProductDTO dto = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT Name, Price, Quantity, ProDescription, CategoryID, ProductImage FROM tblProducts WHERE ProductID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String name = rs.getString(1);
                    float price = rs.getFloat(2);
                    int quantity = rs.getInt(3);
                    String description = rs.getString(4);
                    String categoryID = rs.getString(5);
                    String img = rs.getString(6);
                    dto = new ProductDTO(id, name, price, quantity, description, categoryID, img);
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return dto;
    }

    public List<ProductDTO> getProductByCategory(String cateID) throws SQLException {
        ProductDTO dto = null;
        List<ProductDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT ProductID, Name, Price, Quantity, ProDescription, ProductImage FROM tblProducts WHERE CategoryID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, cateID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    String productID = rs.getString(1);
                    String name = rs.getString(2);
                    float price = rs.getFloat(3);
                    int quantity = rs.getInt(4);
                    String description = rs.getString(5);
                    String img = rs.getString(6);
                    dto = new ProductDTO(productID, name, price, quantity, description, cateID, img);
                    list.add(dto);
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean backUp(String id, int quantity) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
//        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblProducts Quantity = ? WHERE ProductID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, quantity);
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
