<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<head>
  <title>首頁 - 點滴監控系統</title>
  <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="js/js/jquery-3.1.1.min.js"></script>
  <script src="bootstrap/js/bootstrap.js"></script>
  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-theme.css">
<%--   <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.3.7/js/tether.min.js" integrity="sha384-XTs3FgkjiBgo8qjEjBk0tGmf3wPrWtA6coPfQDfFEY8AnYJwjalXCiosYRBIBZX8" crossorigin="anonymous"></script> --%>
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
<s:url action="uploadTest" var="uploadTest"/>



<body bgcolor='white'>

  
<!-- <div class="container" style="margin:20px"> -->
<!-- <div class="container-fluid" style="margin:20px"> -->
<div class="row">
	<div class="col-xs-4 col-md-4">
		<ul class="list-group">
	      <li class="list-group-item"><a href="${main}" class="list-group-item">首頁</a></li>
	      <li class="list-group-item"><a href="${monitor }" class="list-group-item">X即時監控</a></li>
	      <li class="list-group-item"><a href="${patient }" class="list-group-item">病患資料</a></li>
	      <li class="list-group-item"><a href="${ibeacon }" class="list-group-item">ibeacon配對管理</a></li>
	      <li class="list-group-item"><a href="${uploadTest }" class="list-group-item">上傳測試</a></li>
	      <li class="list-group-item"><a href="#" class="list-group-item">X歷史紀錄</a></li>
	      <li class="list-group-item"><a href="#" class="list-group-item">X位置圖</a></li>
	    </ul>
	</div>		
<!-- </div> -->
<!-- </div> -->




</body>

</html>
