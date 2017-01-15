<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<head>
<jsp:include page="importFile_Lib.jsp" />
  <title>首頁 - 點滴監控系統</title>
</head>



<s:url action="mainAction" var="main"  >
	<s:param name="actionType">main</s:param>
</s:url>
<s:url action="mainAction" var="monitor"  >
	<s:param name="actionType">monitor</s:param>
</s:url>
<s:url action="mainAction" var="patient"  >
	<s:param name="actionType">patient</s:param>
</s:url>
<s:url action="mainAction" var="ibeacon" >
	<s:param name="actionType">ibeacon</s:param>
</s:url>
<s:url action="uploadTest" var="uploadTest"/>



<body bgcolor='white'>

  
<div class="container" style="margin:20px">
<!-- <div class="container-fluid" style="margin:20px"> -->
<div class="row">
	<jsp:include page="indexForInclude.jsp" />
</div>
</div>






</body>


<script type="text/javascript">
$(document).ready(function(){
	
	
});


</script>


</html>
