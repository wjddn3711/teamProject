<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>


<!DOCTYPE html>
<html class="wide wow-animation" lang="ko">
<head>
    <title>상품신청</title>
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <mytag:icon />
    <!-- Stylesheets-->
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Roboto:100,300,300i,400,500,600,700,900%7CRaleway:500">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/fonts.css">
    <link rel="stylesheet" href="css/style.css">
    <!--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/"><img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
    <![endif]-->
    <mytag:preloader />
    <div class="page">

        <!-- Page Header-->
        <mytag:pageHeader pageSector="board"/>

        <!-- boardOne -->
        <section class="body">
            <h3>상품신청</h3>
            <hr>
            <div style="padding:40px;">
                <h4>연어회덮밥${boardList.board_title}</h4>
                <p style="align:right;">추천 수 : 222${boardList.board_like}</p>
                <button class="btn button-xs button-like" onclick="location.href='updateBoard.do&board_number=${boardList.board_number}'">나도 추천!</button><br> <!-- 좋아요 누르면 버튼 변경 -->
                <hr>
                <p style="color:black; font-size:18px;">신선한 연어회가 그릇을 가득 덮고 양파가 향을 잡아주는 연어회덮밥.${boardList.board_content}</p>
                <hr>
                <p>글 번호 : 글번호${boardList.board_number}</p><p style="align:right;">이름${boardList.customer_name}&nbsp;&nbsp;2012.3.22${boardList.board_date}</p>
            </div>
        </section>

        <!-- Page Footer-->
        <mytag:pageFooter />
    </div>
    <!-- Global Mailform Output-->
    <div class="snackbars" id="form-output-global"></div>
    <!-- Javascript-->
    <script src="js/core.min.js"></script>
    <script src="js/script.js"></script>
    <!-- coded by 마른오징어-->
    </body>
</html>