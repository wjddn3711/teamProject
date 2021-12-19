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
//public class BoardDeleteAction implements Action{
//    @Override
//    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        BoardDAO dao = new BoardDAO();
//        BoardVO vo = new BoardVO();
//        vo.setBid(Integer.parseInt(request.getParameter("bid")));
//        dao.delete(vo);
//
//        ActionForward forward = new ActionForward();
//        forward.setPath("boardList.do");
//        forward.setRedirect(true);
//        return forward;
//    }
//}
