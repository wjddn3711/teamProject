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
</head>
<body>
<div class="preloader">
    <div class="wrapper-triangle">
        <div class="pen">
            <div class="line-triangle">
                <div class="triangle"></div>
                <div class="triangle"></div>
                <div class="triangle"></div>
                <div class="triangle"></div>
                <div class="triangle"></div>
                <div class="triangle"></div>
                <div class="triangle"></div>
            </div>
            <div class="line-triangle">
                <div class="triangle"></div>
                <div class="triangle"></div>
                <div class="triangle"></div>
                <div class="triangle"></div>
                <div class="triangle"></div>
                <div class="triangle"></div>
                <div class="triangle"></div>
            </div>
            <div class="line-triangle">
                <div class="triangle"></div>
                <div class="triangle"></div>
                <div class="triangle"></div>
                <div class="triangle"></div>
                <div class="triangle"></div>
                <div class="triangle"></div>
                <div class="triangle"></div>
            </div>
        </div>
    </div>
</div>
<div class="page">

    <!-- Page Header-->
    <mytag:pageHeader pageSector="board"/>

    <!-- menuList -->
    <section class="board">
        <h3>상품신청</h3>
        <hr>

        <div class="tableWrapper">
            <table style="min-width:300px; padding-left:60px; padding-right:60px;">
                <colgroup>
                    <col style="width:20%;" />
                    <col style="width:40%;" />
                    <col style="width:20%;" />
                    <col style="width:20%;" />
                </colgroup>
                <tr>
                    <th colspan="4">
                        <button class="button2 button-md button-primary button-winona wow fadeInRight" style="float: left;" onclick="location.href='boardRequest.jsp'">나도 신청하기</button>
                        <form style=" float: right; padding-left:10px; display:inline;"><input type="text" name="search"><input type="submit" value="검색" style="font-size:17px;"></form>
                    </th>
                </tr>
                <tr>
                    <th colspan="4">
                        <div style="text-align:right;">&nbsp;&nbsp;정렬 :&nbsp;
                            <a href="categoryBoard.do?category=favorite" class="filter">추천순</a>&nbsp;|&nbsp;
                            <a href="categoryBoard.do?category=recent" class="filter">최신순</a>&nbsp;|&nbsp;
                            <a href="categoryBoard.do?category=mine" class="filter">내 글 보기</a>
                        </div>
                    </th>
                </tr>
                <tr>
                    <th>추천수</th><th>음식명</th><th>작성자</th><th>날짜</th>
                </tr>
                <c:forEach var="v" items="${boardList}" >
                    <tr>
                        <td>${v.board_fav}</td><td>${v.board_title}</td><td>${v.customer_id}</td><td>${v.board_date}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td>${v.board_like}</td><td>${v.board_title}</td><td>${v.customer_id}</td><td>${v.board_date}</td>
                </tr>

            </table>
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