package controller.product;
import controller.Action;
import controller.ActionForward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SubscribeAction implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isSoup = request.getParameter("isSoup");
        HttpSession session = request.getSession();

//        session.setAttribute("subscribe_order", subscribe_order);
        return null;
    }
}
