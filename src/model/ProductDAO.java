package model;

import model.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO {
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs = null;
    String sql_insert = "insert into product(product_name, product_price, product_type, details, product_image) values(?,?,?,?,?)";
    String sql_delete = "delete from product";
    String sql_select = "select * from product";
    public ArrayList<ProductVO> selectAll(){
        ArrayList<ProductVO> datas = new ArrayList<ProductVO>();
        ProductVO vo = null; //초기 vo null 로
        conn = JDBCUtil.connect();
        try {
            pstmt = conn.prepareStatement(sql_select);
            rs = pstmt.executeQuery();
            while(rs.next()){
                vo = new ProductVO();
                vo.setProduct_number(rs.getInt("product_number"));
                vo.setProduct_name(rs.getString("product_name"));
                vo.setProduct_price(rs.getInt("product_price"));
                vo.setProduct_type(rs.getString("product_type"));
                vo.setProduct_details(rs.getString("details"));
                vo.setProduct_image(rs.getString("product_image"));
                datas.add(vo);
                System.out.println(vo);
            }
            rs.close();
            return datas;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("product selectAll 중 문제 발생");
        }finally {
            JDBCUtil.disconnect(pstmt,conn);
        }
        return null;
    }

    public void insertAll(ArrayList<ProductVO> datas) {
        conn = JDBCUtil.connect();
        try {
            pstmt = conn.prepareStatement(sql_insert);
            for (ProductVO data : datas) {
                pstmt.setString(1,data.getProduct_name());
                pstmt.setInt(2,data.getProduct_price());
                pstmt.setString(3,data.getProduct_type());
                pstmt.setString(4,data.getProduct_details());
                pstmt.setString(5,data.getProduct_image());
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("init 데이터 insert 중 문제발생");
        } finally {
            JDBCUtil.disconnect(pstmt,conn);
        }
    }

    public void deleteAll(){
        conn = JDBCUtil.connect();
        try {
            pstmt = conn.prepareStatement(sql_delete);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("init 데이터 delete 중 문제발생");
        }
    }
    
}
