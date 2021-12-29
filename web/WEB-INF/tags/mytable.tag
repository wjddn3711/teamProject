<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="tableWrapper2">
    <table>
        <tr>
            <th colspan="4">내 밥상보기</th>
        </tr>
<%--        <tr style="padding-bottom: 100px; text-align: center; border-bottom: 3px solid black;">--%>
<%--            <td>1주차</td><td>2주차</td><td>3주차</td><td>4주차</td>--%>
<%--        </tr>--%>
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
            <td>

            </td>
        </tr>
        <tr>
            <td colspan="4"><div style="float:left;">구독 시작일 : ${order.starting_date}</div><div style="float:right;">구독 종료일 : ${order.expiration_date}</div></td>
        </tr>
    </table>
</div>