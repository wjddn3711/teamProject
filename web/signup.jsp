<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>


<!DOCTYPE html>
<html class="wide wow-animation" lang="ko">
<head>
  <title>회원가입</title>
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
  <mytag:pageHeader pageSector=" "/>

  <!-- 회원가입 form -->
  <section class="body">
    <h3>회원가입</h3>
    <div class="tableWrapper">
      <form action="newMember.do" method="post">
        <table>
          <tr>
            <td>이름</td>
            <td><input name="customer_name" type="text" placeholder="이름"></td>
            <td></td>
          </tr>
          <tr>
            <td>아이디</td>
            <td><input type="text" placeholder="아이디"></td>
            <td><a class="btn button-xs button-like" href="#">중복확인</a></td>
          </tr>
          <tr>
            <td>비밀번호</td>
            <td><input type="password" placeholder="비밀번호는 안전하게"></td>
            <td></td>
          </tr>
          <tr>
            <td>비밀번호 확인</td>
            <td><input type="password"></td>
            <td></td>
          </tr>
          <tr>
            <td rowspan="2">주소</td>
            <td><input name="ZIP_code" type="text" id="sample4_postcode" placeholder="우편번호"></td>
            <td><input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><mytag:postcode /></td>
          </tr>
          <tr>
            <td colspan="2" style="text-align:left; border-top:dotted;"><input name="detailed_address" type="text" id="sample4_detailAddress" placeholder="상세주소"></td>
          </tr>
          <tr>
            <td>핸드폰 번호</td>
            <td><input name="phone_number" type="text" placeholder="eg.) 01012341234"></td>
            <td></td>
          </tr>
          <tr style="border-bottom:none;">
            <td colspan="3"><button class="button2 button-md button-primary button-winona wow fadeInRight" type="submit" formmethod="post">가입하기!</button></td>
          </tr>
        </table>
      </form>
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