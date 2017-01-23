<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>现在是一个list页面</h2>
    <table style="border:1px solid;" cellpadding="0" cellspacing="0">
        <thead>
            <th>序号</th>
            <th>编号</th>
            <th>供应商编号</th>
        </thead>
        <c:forEach items="${list}" var="vo" varStatus="index">
            <tr>
                <td>${index.count}</td>
                <td>${vo.id}</td>
                <td>${vo.supplierId}</td>
            </tr>
        </c:forEach>
        测试一下demo库的用户：${count}个
    </table>

