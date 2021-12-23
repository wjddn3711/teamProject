package controller.board;


import controller.Action;
import controller.ActionForward;
import model.board.BoardDAO;
import model.board.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardInsertAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 게시글을 작성
        BoardDAO dao = new BoardDAO();
        BoardVO vo = new BoardVO();
        ActionForward forward = null;
        // 작성자 아이디를 uid , 제목을 title, 내용을 content 라고 가정하고 진행
        vo.setCustomer_id(request.getParameter("customer_id"));
        vo.setBoard_content(request.getParameter("board_content"));
        vo.setBoard_title(request.getParameter("board_title"));
        if(dao.insert(vo)){
            forward = new ActionForward();
            forward.setPath("boardDone.jsp");
            forward.setRedirect(true);
        }
        // 아니라면 에러
        return forward;
    }
}
