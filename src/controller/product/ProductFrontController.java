package controller.product;

import controller.ActionForward;
import controller.MainAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "ProductFrontController", value = "/ProductFrontController")
public class ProductFrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        actionDO(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        actionDO(request,response);
    }

    private void actionDO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActionForward forward = null;
        // 1.요청을 파악
        String uri = request.getRequestURI();
        String cp = request.getContextPath();
        // 문자열 조작을 통하여 .do 파일에 대한 분석 (ex: main.do -> command = main)
        String command = uri.substring(cp.length() + 1, uri.length() - 3);
        System.out.println(command);

        // 로직이 바뀌어도 서버데이터에 부담을 주지 않는다
        if (command.equals("subscribe")){
            try{
                forward = new MainAction().execute(request, response);
            } catch (Exception e){
                System.out.println("subscribe 수행중 문제 발생");
            }
        }
        else if(command.equals("productAdd")){
            try{
                forward = new CartAction().execute(request, response);
            } catch (Exception e){
                System.out.println("productAdd 수행중 문제 발생");
            }
        }
        else if(command.equals("productList")){
            try{
                forward = new ProductListAction().execute(request, response);
            } catch (Exception e){
                System.out.println("productList 수행중 문제 발생");
            }
        }
        else if(command.equals("productDetail")){
            try{
                forward = new ProductDetailAction().execute(request, response);
            } catch (Exception e){
                System.out.println("productDetail 수행중 문제 발생");
            }
        }
        else if(command.equals("productFilter")){
            try{
                forward = new ProductCategoryAction().execute(request, response);
            } catch (Exception e){
                System.out.println("productFilter 수행중 문제 발생");
            }
        }

        if(forward!=null){
            if(forward.isRedirect()){
                response.sendRedirect(forward.getPath());
            }
            else{
                RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
                dispatcher.forward(request,response);
            }
        }

    }
}
