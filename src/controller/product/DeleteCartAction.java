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
import java.util.ArrayList;

public class DeleteCartAction implements Action{

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // product_number 를 뷰에서 받아와 해당 상품을 지운뒤 다시 장바구니로
        HttpSession session = request.getSession();
        if(request.getParameter("undoSubscribe")!=null){
            session.removeAttribute("product_set");
            session.removeAttribute("product_set_price"); // 세션에서 장바구니 관련 속성을 지운다
        }
        int product_number = Integer.parseInt(request.getParameter("product_number"));
        ProductCart cart = (ProductCart) session.getAttribute("cart");
        ArrayList<ProductSingleCart> singleProducts = cart.getSingleProducts();
        for (int i = 0; i < singleProducts.size(); i++) {
            if(singleProducts.get(i).getProductVO().getProduct_number()==product_number){
                singleProducts.remove(i); // 해당 상품을 지우고 탈출
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
