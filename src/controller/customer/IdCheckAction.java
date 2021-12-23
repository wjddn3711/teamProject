package controller.customer;

import controller.Action;
import controller.ActionForward;
import model.customer.CustomerDAO;
import model.customer.CustomerVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class IdCheckAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customer_id = request.getParameter("customer_id");
        CustomerDAO dao = new CustomerDAO();
        CustomerVO vo = new CustomerVO();
        vo.setCustomer_id(customer_id); // request 로 받은 id 를 넣는다
        int idCheck = dao.id_check(vo);
        PrintWriter out = response.getWriter();
        out.write(idCheck +"");
        // 문자열로 값을 내보냄
        // null 을 보냄으로서 페이지에 머무를 수 있도록 함
        return null;
    }
}
