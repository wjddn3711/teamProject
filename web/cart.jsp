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
<mytag:preloader />
<div class="page">

    <!-- Page Header-->
    <mytag:pageHeader pageSector="product"/>

    <!-- productList -->
    <section class="body">
        <h3>장바구니</h3>
        <hr>

        <!-- 검색창 및 필터검색 버튼 -->
        <section class="section section-lg bg-default">
            <div class="container">
                <!-- <h3 class="oh-desktop"><span class="d-inline-block wow slideInUp">Selected Pizzas</span></h3> -->

                <div class="row row-lg row-30">
                    <!-- Product-->
                    <c:forEach var="v" items="${cart}">
                        <div class="col-sm-6 col-lg-4 col-xl-3">
                            <article class="product wow fadeInLeft" data-wow-delay=".15s">
                                <div class="product-figure"><img src="${v.product_image}" alt="" width="161" height="162"/>
                                </div>
                                <div class="product-rating"><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span><span class="mdi mdi-star"></span>
                                </div>
                                <h6 class="product-title">${v.product_name}</h6>
                                <div class="product-price-wrap">
                                    <div class="product-price">₩ ${v.product_price}</div>
                                </div>
                                <div class="product-button">
                                    <div class="button-wrap"><a class="button button-xs button-primary button-winona" href="productAdd.pd?product_number=${v.product_number}">장바구니에 추가</a></div>
                                    <div class="button-wrap"><a class="button button-xs button-secondary button-winona" href="productDetail.pd?product_number=${v.product_number}">상세보기</a></div>
                                </div><mytag:productTypeBadge filter="${v.product_type}" />
                            </article>
                        </div>
                    </c:forEach>
                    <!-- 예시글 끝 -->
                </div>
                <c:if test="${product_set!=null}">
                    <div class="row row-lg row-30">
                        <tr style="padding:30px; border-bottom: 2px solid black;">
                            <td>
                                <ul>
                                    1주차 : <li>${product_set.product_set_1st}</li>
                                </ul>
                                <hr>
                                <ul>
                                    2주차 : <li>${product_set.product_set_2nd}</li>
                                </ul>
                                <hr>
                                <ul>
                                    3주차 : <li>${product_set.product_set_3rd}</li>
                                </ul>
                                <hr>
                                <ul>
                                    4주차 : <li>${product_set.product_set_4th}</li>
                                </ul>
                            </td>
                        </tr>
                    </div>
                </c:if>

                <div class="row row-lg row-30">
                    <h1>총 금액 : ${totalPrice}</h1>
                </div>
            </div>
        </section>

    </section>

    <!-- Page Footer-->
    <mytag:pageFooter />

</div> <!-- /div page -->

<!-- Javascript-->
<script src="js/core.min.js"></script>
<script src="js/script.js"></script>
<!-- coded by 마른오징어-->
</body>
</html>