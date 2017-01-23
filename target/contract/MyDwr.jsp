<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Dwr Demo</title>
    <script type='text/javascript' src='${pageContext.request.contextPath}/dwr/engine.js'></script>
    <script type='text/javascript' src='${pageContext.request.contextPath}/dwr/util.js'></script>
    <script type='text/javascript' src='${pageContext.request.contextPath}/dwr/interface/Demo.js'></script>
    <script type='text/javascript' src='${pageContext.request.contextPath}/js/jquery1.8.js'></script>
    <script type="text/javascript">
        //此函数中可以调用java类的方法，除了java方法本身的参数外，还要将回调函数名作为参数传给java方法
        function sayHello(name) {
            Demo.getHello(name, dwrHandler);
        }

        //这是dwr的一个回调函数，data参数即java方法getHello(String name)的返回值
        function dwrHandler(data) {
            alert(data);
        }
    </script>
</head>

<body>
<input>
<button onclick="sayHello($('input').val());">提交</button>