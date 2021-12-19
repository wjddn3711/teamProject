//package controller;
//
//import model.BoardDAO;
//import model.BoardVO;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class BoardInsertAction implements Action{
//    @Override
//    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 게시글을 작성
//        BoardDAO dao = new BoardDAO();
//        BoardVO vo = new BoardVO();
//        // 작성자 아이디를 uid , 제목을 title, 내용을 content 라고 가정하고 진행
//
//        vo.setUid(Integer.parseInt(request.getParameter("uid")));
//        vo.setContent(request.getParameter("content"));
//        vo.setTitle(request.getParameter("title"));
//        dao.insert(vo);
//
//        ActionForward forward = new ActionForward();
//        forward.setPath("boardList.do");
//        forward.setRedirect(true);
//        return forward;
//    }
//}
