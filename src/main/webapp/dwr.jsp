<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'dwrReverse.jsp' starting page</title>
    <script type='text/javascript' src='<%=basePath%>/dwr/interface/DWRReverse.js'></script>
    <script type='text/javascript' src='<%=basePath%>/dwr/engine.js'></script>
    <script type='text/javascript' src='<%=basePath%>/dwr/util.js'></script>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script type="text/javascript">
        function getData(){
            DWRReverse.sendMessage(null);
        }
        function receiveMessages(message) {
            var msg = eval("("+message+")");
            var temp  = msg.split(",");
            var username = temp[1];
            var password = temp[2];
            var age = temp[3];
            var tel = temp[4];
            var newRow = document.getElementById('tableData').insertRow(2);
            var cell0 = newRow.insertCell(0);
            var cell1 = newRow.insertCell(1);
            var cell2 = newRow.insertCell(2);
            var cell3 = newRow.insertCell(3);
            cell0.innerHTML = username;
            cell1.innerHTML = password;
            cell2.innerHTML = age;
            cell3.innerHTML = tel;
        }
    </script>
</head>
<!-- 注：这个是要在使用reverse-ajax的页面必须的 -->
<body onload="dwr.engine.setActiveReverseAjax(true);getData();">
<div align="center">
    <table title=用户表 class="list" align="center" id="tableData">
        <tr id="titleData">
            <td colspan="4">
                用户表
            </td>
            <td colspan="1" onclick="getData()" style="size:10px">
                <a href="#"></a>
            </td>
        </tr>
        <tr id="headData" bgcolor="#fffce7" style="color:#968054">
            <td width="9%">
                用户名
            </td>
            <td width="20%">
                密码
            </td>
            <td width="33%">
                年龄
            </td>
            <td width="22%">
                电话
            </td>
        </tr>
    </table>
</div>
</body>
</html>

