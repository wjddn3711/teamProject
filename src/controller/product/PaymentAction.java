package controller.product;
import controller.Action;
import controller.ActionForward;
import model.order.OrderDAO;
import model.order.OrderSet;
import model.order.Order_detailVO;
import model.order.Order_singleVO;
import model.product.ProductCart;
import model.product.ProductSingleCart;
import model.subscription.Order_subscriptionVO;
import model.subscription.Order_suscriptionDAO;
import model.subscription.Product_setVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PaymentAction implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ProductCart cart = (ProductCart) session.getAttribute("cart");
        String customer_id = (String) session.getAttribute("customer_id");
        OrderDAO dao = new OrderDAO();
        OrderSet os= new OrderSet();
        Order_singleVO oss = new Order_singleVO();
        oss.setCustomer_id(customer_id);
        os.setSingle(oss); // id 넣기

        ArrayList<ProductSingleCart> products = cart.getSingleProducts();
        ArrayList<Order_detailVO> orderDetail = new ArrayList<>();
        for (ProductSingleCart product : products) {
            Order_detailVO od = new Order_detailVO();
            od.setProduct_number(product.getProductVO().getProduct_number());
            od.setProduct_count(product.getProduct_count());
            orderDetail.add(od);
        }
        os.setDetails(orderDetail);

        ActionForward forward = null;
        if(dao.insert(os)){
            System.out.println("주문 정보 저장완료");
            Order_suscriptionDAO odao = new Order_suscriptionDAO();
            Order_subscriptionVO ovo = new Order_subscriptionVO();
            if(session.getAttribute("product_set")!=null){ // 구독 주문을 하였다면
                Product_setVO productSetVO = (Product_setVO) session.getAttribute("product_set");
                ovo.setSoup_check(productSetVO.getSoup_check());
                ovo.setProduct_set_number(productSetVO.getProduct_set_number());
                ovo.setCustomer_id(customer_id);
                if(odao.insert(ovo)){
                    System.out.println("주문 성공!");
                    forward = new ActionForward();
                    forward.setPath("orderDone.jsp");
                    forward.setRedirect(true);
                    return forward;
                }
            }
        }
        // 만약 insert 실패라면 실패 메시지
        System.out.println("실패!");
        forward = null;
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter(); // 스크립트 printwriter
        out.println("<script>alert('결제 실패!');history.go(-1);</script>"); // forward가 null 일때는 front controller 가 끝나고 난뒤 이 문항을 실행한다
        // 문서에 글을 쓸 준비 !
        return null;
    }
}
