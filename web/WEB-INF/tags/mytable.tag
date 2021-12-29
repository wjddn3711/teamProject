<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="tableWrapper2">
    <table>
        <tr>
            <th colspan="4">내 밥상보기</th>
        </tr>
        <tr style="padding-bottom: 100px; text-align: center; border-bottom: 3px solid black;">
            <td>1주차</td><td>2주차</td><td>3주차</td><td>4주차</td>
        </tr>
        <tr style="padding:30px; border-bottom: 2px solid black;">
            <td>
                <ul>
                    <c:forEach var="menu" items="${product_set_1st}"> <li><c:out value="${menu}" /></li> </c:forEach>
                </ul>
            </td>
            <td>
                <ul style="list-style:circle; ">
                    <li>해물우동</li>
                    <li>새우볶음밥</li>
                    <li>가지튀김</li>
                </ul>
            </td>
            <td>

            </td>
            <td>

            </td>
        </tr>
        <tr>
            <td colspan="4"><div style="float:left;">구독 시작일 : ${starting_date}</div><div style="float:right;">구독 종료일 : ${expiration_date}</div></td>
        </tr>
    </table>
</div>