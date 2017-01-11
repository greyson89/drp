<%@page import="freemarker.ext.servlet.IncludePage"%>
<%@page import="org.apache.struts2.components.Include"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="js/js/jquery-3.1.1.min.js"></script>
  <script src="bootstrap/js/bootstrap.js"></script>
  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-theme.css">
<title>即時監控</title>
</head>
<body>
<div class="container-fluid" style="margin:20px">
<table width="100%">
	<tr>
		<td width="300px">
				<jsp:include page="index.jsp"></jsp:include>		
		</td>
		<td width="500px">
				<h1>即時監控</h1>	
		</td>
		<td width="224px">
		</td>
	</tr>

</table>
</div>
</body>
</html>