package controller.customer;
import controller.Action;
import controller.ActionForward;
import model.customer.CustomerDAO;
import model.customer.CustomerVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyPageAction implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActionForward forward = new ActionForward();
        // mypage 로 이동
        /*
        마이페이지에서는 select 을 통하여 수정, 탈퇴, 구독 정보보기를 진행할 예정
        그렇기에 mypage 로 이동할때 모든 정보를 들고 갈 수 있도록 한다
        userData: 회원 정보 , userSubscribe : 구독정보

        그렇기에 mypage 로 넘어올때 customer_id 를 parameter로 받는다
         */
        // 로그인이 되어있는 경우 마이페이지에 접근할 수 있기 때문에 customer_id 가 세션에 저장되어있다 가정하고 진행한다
        HttpSession session = request.getSession();
        String customer_id = (String) session.getAttribute("customer_id");
        CustomerDAO dao = new CustomerDAO();
        CustomerVO vo = new CustomerVO();
        vo.setCustomer_id(customer_id);
        CustomerVO userData = dao.selectOne(vo); // 유저 데이터를 받아옴
        // 현재 order_subscription 구독 DAO 가 완료 되지 않아 아직 못넘겨줌

        forward.setPath("mypage.jsp");
        forward.setRedirect(false);
        return forward;
    }
}
