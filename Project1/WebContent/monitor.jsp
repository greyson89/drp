<%@page import="freemarker.ext.servlet.IncludePage"%>
<%@page import="org.apache.struts2.components.Include"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<title>Insert title here</title>
</head>
<body>
<table width="100%">
	<tr>
		<td width="40%">
				<jsp:include page="index.jsp"></jsp:include>		
		</td>
		<td width="60%">
				<h1>即時監控</h1>	
		</td>
	</tr>

</table>

</body>
</html>