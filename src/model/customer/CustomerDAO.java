package model.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JDBCUtil;

public class CustomerDAO {

    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    int check;

    String sql_insert = "insert into customer values(?,?,?,?,?,?)";
    String sql_id_check = "select customer_id from customer where customer_id=?";
    String sql_selectOne="select * from customer where customer_id=?";
    String sql_update = "update customer set customer_id=?,customer_password=?, customer_name=?, phone_number=?, ZIP_code=?, detailed_address=?";
    String sql_delete = "delete from customer where customer_id=? and customer_password=?";
    String sql_login_check = "select customer_password from customer where customer_id=?";

    // 회원가입(c)
    public boolean insert(CustomerVO vo) {
        try {
            conn = JDBCUtil.connect();
            pstmt = conn.prepareStatement(sql_insert);
            pstmt.setString(1, vo.getCustomer_id());
            pstmt.setString(2, vo.getCustomer_password());
            pstmt.setString(3, vo.getCustomer_name());
            pstmt.setInt(4, vo.getPhone_number());
            pstmt.setInt(5, vo.getZIP_code());
            pstmt.setString(6, vo.getDetailed_address());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("회원가입 문제발생");
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return true;
    }

    // 아이디 중복 체크
    public int id_check(CustomerVO vo) {
        try {
            conn = JDBCUtil.connect();
            pstmt = conn.prepareStatement(sql_id_check);
            pstmt.setString(1, vo.getCustomer_id());
            rs = pstmt.executeQuery();

            if (rs.next()) { // 이미 존재하거나 아이디가 공백일때
                check = 0; // 같은 아이디 있음
            } else {
                check = 1; // 같은 아이디 없음
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("아이디 중복확인 문제발생");
            e.printStackTrace();
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return check;
    }

    // 로그인체크
    public int login_check(CustomerVO vo) {
        try {
            conn = JDBCUtil.connect();
            pstmt = conn.prepareStatement(sql_login_check);
            pstmt.setString(1, vo.getCustomer_id());
            rs = pstmt.executeQuery();
            // rs에 데이터 없으면 로그인페이지 이동(아이디 없음)
            // pw비교 O→ 로그인완료 X→로그인페이지로 이동(패스워드 틀림)

            if (rs.next()) {
                if (vo.getCustomer_password().equals(rs.getString("customer_password"))) {
                    check = 1; // 아이디와 패스워드 일치
                } else {
                    check = -1; // 패스워드 틀림
                }
            } else {
                check = 0; // 아이디 없음
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("로그인 문제발생");
            e.printStackTrace();
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return check;
    }

    // 회원정보조회(r)
    public CustomerVO selectOne(CustomerVO vo) {
        CustomerVO data=null;
        try {
            conn=JDBCUtil.connect();
            pstmt=conn.prepareStatement(sql_selectOne);
            pstmt.setString(1, vo.getCustomer_id());
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()) {
                data=new CustomerVO();
                data.setCustomer_id(rs.getString("customer_id"));
                data.setCustomer_password(rs.getString("customer_password"));
                data.setCustomer_name(rs.getString("customer_name"));
                data.setPhone_number(rs.getInt("phone_number"));
                data.setZIP_code(rs.getInt("ZIP_code"));
                data.setDetailed_address(rs.getString("detailed_address"));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("회원정보 조회 문제발생");
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return data;
    }


    // 정보수정(u)
    public int update(CustomerVO vo) {
        try {
            conn = JDBCUtil.connect();
            pstmt = conn.prepareStatement(sql_update);
            pstmt.setString(1, vo.getCustomer_id());
            pstmt.setString(2, vo.getCustomer_password());
            pstmt.setString(3, vo.getCustomer_name());
            pstmt.setInt(4, vo.getPhone_number());
            pstmt.setInt(5, vo.getZIP_code());
            pstmt.setString(6, vo.getDetailed_address());
            check = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("정보 수정 문제발생");
            e.printStackTrace();
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return check;
    }

    // 탈퇴(d)
    public boolean delete(CustomerVO vo) {
        try {
            conn = JDBCUtil.connect();
            pstmt = conn.prepareStatement(sql_delete);
            pstmt.setString(1, vo.getCustomer_id());
            pstmt.setString(2, vo.getCustomer_password());
            check = pstmt.executeUpdate();
            if (check == 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("탈퇴 문제발생");
            e.printStackTrace();
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return false;
    }
}
