<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<head>
<jsp:include page="importFile_Lib.jsp" />
  <title>首頁 - 點滴監控系統</title>

</head>

<script type="text/javascript">
$(document).ready(function(){
	
	
});


</script>


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
<s:url action="mainAction" var="uploadPage">
	<s:param name="actionType">upload</s:param>
</s:url>



<body bgcolor='white'>

  
<!-- <div class="container" style="margin:20px"> -->
<!-- <div class="container-fluid" style="margin:20px"> -->
<div class="row">
	<div class="col-xs-6 col-md-2">
		<ul class="list-group">
	      <li class="list-group-item"><a href="${main}" class="list-group-item">首頁</a></li>
	      <li class="list-group-item"><a href="${monitor }" class="list-group-item">即時監控</a></li>
	      <li class="list-group-item"><a href="${patient }" class="list-group-item">病患資料</a></li>
	      <li class="list-group-item"><a href="${ibeacon }" class="list-group-item">點滴注射管理</a></li>
	      <li class="list-group-item"><a href="${uploadPage }" class="list-group-item">上傳測試</a></li>
	      <li class="list-group-item"><a href="#" class="list-group-item">X歷史紀錄</a></li>
	      <li class="list-group-item"><a href="#" class="list-group-item">X位置圖</a></li>
	    </ul>
	</div>		
<!-- </div> -->
<!-- </div> -->




</body>

</html>
