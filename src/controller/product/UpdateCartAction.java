package controller.product;
import controller.Action;
import controller.ActionForward;
import model.product.ProductCart;
import model.product.ProductSingleCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UpdateCartAction implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int product_number = Integer.parseInt(request.getParameter("product_number"));
        int product_count = Integer.parseInt(request.getParameter("product_count"));

        if(product_count<=0){ // 만약 수정하고 싶은 개수가 0보다 작거나 같다면 업데이트 될 수 없도록 한다
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter(); // 스크립트 printwriter
            out.println("<script>alert('상품 개수는 1개이상 으로 선택해주세요!');history.go(-1);</script>"); // forward가 null 일때는 front controller 가 끝나고 난뒤 이 문항을 실행한다
            return null;
        }

        HttpSession session = request.getSession();
        ProductCart cart = (ProductCart) session.getAttribute("cart"); // 세션에서 카트 정보를 갖고 온다
        ArrayList<ProductSingleCart> singleProducts = cart.getSingleProducts();

        for (ProductSingleCart singleProduct : singleProducts) {
            if(singleProduct.getProductVO().getProduct_number()==product_number){
                singleProduct.setProduct_count(product_count);
                break;
            }
        }
        cart.setSingleProducts(singleProducts); // 추가 한것으로 업데이트
        ActionForward forward = new ActionForward();
        forward.setPath("cart.jsp");
        forward.setRedirect(true); // 넘겨줄 데이터 X
        return forward;
    }
}
