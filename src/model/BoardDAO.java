package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
    // 1. DBMS와의 연동(JDBC) => 공통로직 : JDBCUtil클래스에서 불러와 사용
    // 2. 비즈니스 메서드(CRUD) => 각각의 DAO마다 사용하는 로직

    // 1) 코드의 재사용성 증가
    // 2) 유지보수 용이
    // 3) 협업 용이
    Connection conn=null;
    PreparedStatement pstmt=null;

    String sql;


}
//    public ArrayList<BoardVO> selectAll(){
//        conn=JDBCUtil.connect();
//        ArrayList<BoardVO> datas=new ArrayList<BoardVO>();
//        try {
//            pstmt=conn.prepareStatement(sql_selectAll);
//            ResultSet rs=pstmt.executeQuery();
//            while(rs.next()) {
//                BoardVO vo=new BoardVO();
//
//                vo.setBid(rs.getInt("bid"));
//                vo.setContent(rs.getString("content"));
//                vo.setTitle(rs.getString("title"));
////                vo.setWriter(rs.getString("writer"));
//
//                datas.add(vo);
//            }
//            rs.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            JDBCUtil.disconnect(pstmt,conn);
//        }
//        return datas;
//    }
//    public ArrayList<BoardVO> selectMine(BoardVO vo){
//        conn=JDBCUtil.connect();
//        ArrayList<BoardVO> datas=new ArrayList<BoardVO>();
//        try {
//            pstmt=conn.prepareStatement(sql_selectMine);
////            pstmt.setString(1,keyword);
////            pstmt.setString(2,keyword);
//            ResultSet rs=pstmt.executeQuery();
//            if(rs.next()) {
////                BoardVO vo=new BoardVO();
//
//                vo.setBid(rs.getInt("bid"));
//                vo.setContent(rs.getString("content"));
//                vo.setTitle(rs.getString("title"));
//
//
//                datas.add(vo);
//            }
//            rs.close();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            JDBCUtil.disconnect(pstmt, conn);
//        }
//        return datas;
//    }
//
//    public ArrayList<BoardVO> selectSearch(String keyword) {
//        // 인자를 int타입으로 고정 -> 유지보수 불리
//        // title,content,writer,... -> VO를 인자로설정!
//        conn=JDBCUtil.connect();
//        ArrayList<BoardVO> datas=new ArrayList<BoardVO>();
//        try {
//            pstmt=conn.prepareStatement(sql_selectOne);
//            pstmt.setString(1,keyword);
//            pstmt.setString(2,keyword);
//            ResultSet rs=pstmt.executeQuery();
//            if(rs.next()) {
//                BoardVO vo=new BoardVO();
//
//                vo.setBid(rs.getInt("bid"));
//                vo.setContent(rs.getString("content"));
//                vo.setTitle(rs.getString("title"));
//
//
//                datas.add(vo);
//            }
//            rs.close();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            JDBCUtil.disconnect(pstmt, conn);
//        }
//        return datas;
//    }
//    public boolean insert(BoardVO vo) {
//        conn=JDBCUtil.connect();
//        try {
//            pstmt=conn.prepareStatement(sql_insert);
//            pstmt.setString(1, vo.getWriter());
//            pstmt.setString(2, vo.getTitle());
//            pstmt.setString(3, vo.getContent());
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        } finally {
//            JDBCUtil.disconnect(pstmt, conn);
//        }
//        return true;
//    }
//    public boolean update(BoardVO vo) {
//        conn=JDBCUtil.connect();
//        try {
//            pstmt=conn.prepareStatement(sql_update);
//            pstmt.setString(1, vo.getTitle());
//            pstmt.setString(2, vo.getWriter());
//            pstmt.setString(3, vo.getContent());
//            pstmt.setInt(4, vo.getBid());
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        } finally {
//            JDBCUtil.disconnect(pstmt,conn);
//        }
//        return true;
//    }
//    public boolean delete(BoardVO vo) {
//        conn=JDBCUtil.connect();
//        try {
//            pstmt=conn.prepareStatement(sql_delete);
//            pstmt.setInt(1, vo.getBid());
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        } finally {
//            JDBCUtil.disconnect(pstmt, conn);
//        }
//        return true;
//    }
//}
