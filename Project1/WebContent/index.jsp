<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<head>
  <title>首頁 - 點滴監控系統</title>
  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-theme.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.3.7/js/tether.min.js" integrity="sha384-XTs3FgkjiBgo8qjEjBk0tGmf3wPrWtA6coPfQDfFEY8AnYJwjalXCiosYRBIBZX8" crossorigin="anonymous"></script>
  <script src="bootstrap/js/bootstrap.js"></script>
  <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
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



<body bgcolor='white'>

<div class="container-fluid" style="margin:20px">
<div class="row">
  <div class="col-xs-12 col-md-8">
    <div class="list-group">
      <a href="${main}" class="list-group-item">首頁</a>
      <a href="${monitor }" class="list-group-item">X即時監控</a>
      <a href="${patient }" class="list-group-item">病患資料</a>
      <a href="${ibeacon }" class="list-group-item">ibeacon配對管理</a>
      <a href="#" class="list-group-item">X歷史紀錄</a>
      <a href="#" class="list-group-item">X位置圖</a>
    </div>
</div>
</div>
</div>





<!-- <ul>   -->
<%--   <s:url action="list_leagues" var="list_leagues_url"/> --%>
<%--   <li><a href='${list_leagues_url}'>List all leagues</a></li> --%>
<%--   <s:url action="reg_entry" var="reg_entry_url"/> --%>
<%--   <li><a href='${reg_entry_url}'>Register for a league</a></li> --%>
<!-- </ul> -->


<!-- <ul> -->
<%--   <s:url action="add_league_form" var="add_league_form_url"/> --%>
<%--   <li><a href='${add_league_form_url}'>Add a new league</a></li> --%>
<!-- </ul> -->

</body>

</html>
