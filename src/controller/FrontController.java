package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FrontController", value = "/FrontController")
public class FrontController extends HttpServlet {
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
        if (command.equals("main")){
            try{
                forward = new MainAction().execute(request, response);
            } catch (Exception e){
                System.out.println("main.do 수행중 문제 발생");
            }
        }
        // 만약 forward 가 null 이라면 null pointer exception 이 발생하기 떄문에 대비
        if(forward!=null){
            if(forward.isRedirect()){
                response.sendRedirect(forward.getPath());
            }
            else{
                RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
                dispatcher.forward(request,response);
            }
        }
//        if(command.equals("boardList")){ // 상품게시판 메인화면
//            System.out.println("boardList 명령");
//            // 현재 만들어진 게시판을 ArrayList 로 반환 받는다
//            try{
//                ActionForward forward = new BoardListAction().execute(request, response);
//            }catch (Exception e){
//                e.printStackTrace();
//                System.out.println("boardList 수행중 오류 발생!");
//            }
//        }
//        else if(command.equals("searchBoard")){
//            System.out.println("search 상품 신청 게시판");
//            try{
//                ActionForward forward = new BoardSearchAction().execute(request, response);
//            }catch (Exception e){
//                e.printStackTrace();
//                System.out.println("boardSearch 수행중 오류 발생!");
//            }
//        }
//        else if(command.equals("insertBoard")){
//            System.out.println("insert 상품 신청 게시판");
//            try{
//                ActionForward forward = new BoardInsertAction().execute(request, response);
//            }catch (Exception e){
//                e.printStackTrace();
//                System.out.println("boardInsert 수행중 오류 발생!");
//            }
//        }
//        else if(command.equals("deleteBoard")){
//            System.out.println("delete 상품 신청 게시판");
//            try{
//                ActionForward forward = new BoardDeleteAction().execute(request, response);
//            }catch (Exception e){
//                e.printStackTrace();
//                System.out.println("boardDelete 수행중 오류 발생!");
//            }
//        }
//        else if(command.equals("updateBoard")){
//            System.out.println("update 상품 신청 게시판");
//            try{
//                ActionForward forward = new BoardFavAction().execute(request, response);
//            }catch (Exception e){
//                e.printStackTrace();
//                System.out.println("boardSearch 수행중 오류 발생!");
//            }
//        }
//        else if(command.equals("categoryBoard")){
//            System.out.println("category 상품 신청 게시판");
//            try{
//                ActionForward forward = new BoardCategoryAction().execute(request, response);
//            }catch (Exception e){
//                e.printStackTrace();
//                System.out.println("boardCategory 수행중 오류 발생!");
//            }
//        }
    }
}
