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

public class FindIdAction implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ajax 를 통해 입력된 이름과 전화번호를 받아온다
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String customer_name = request.getParameter("name");
        String phone_number = request.getParameter("phoneNumber");

        CustomerDAO dao = new CustomerDAO();
        CustomerVO vo = new CustomerVO();
        vo.setCustomer_name(customer_name);
        vo.setPhone_number(phone_number);
        String id = dao.validationId(vo);
        if(id!=null){ // 만약 해당하는 아이디가 있다면
            out.write( "회원님의 아이디는 "+id+"입니다. \n확인 후 로그인 해주세요");
        }
        else{
            out.println("해당하는 아이디가 존재하지 않습니다!");
        }
        return null;
    }
}
