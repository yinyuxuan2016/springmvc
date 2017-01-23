<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title><decorator:title default='合同管理演示'/></title>
   <jsp:include page="base.jsp" flush="true" />
    <decorator:head />
</head>
<body>
<div id="publicHeader"></div>
<div class="wrap">
    <div class="container">
        <jsp:include page="left.jsp" flush="true" />
        <div id="right">
            sitemesh演示
            <decorator:body></decorator:body>
            <hr/>
            zhengdb126@163.com
        </div>
    </div>
</div>
<div id="publicFooter"></div>
</body>
</html>

