<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<script type="text/javascript">
$(document).ready(function(){
	
	
});


$("button").click(function(){
	  $.post("",
	  {
	  },
	  function(data,status){
	    alert("Data: " + data + "\nStatus: " + status);
	  });
	});
	
	

</script>


<body>

<div class="container" style="margin:20px">
<!-- <div class="container-fluid" style="margin:20px"> -->
<div class="row">

	<jsp:include page="indexForInclude.jsp" />

	<div class="col-xs-8 col-md-8">
		<div class="table-responsive">
		<table class="table table-hover">
			<h3>即時監控</h3>
			<thead>
				<tr>
					<th>
						ibeacon<br/>
						編號
					</th>
					<th>
						病歷號
					</th>
					<th>
						病患名稱
					</th>
					<th>
						床號
					</th>
					<th>
						總量
					</th>
					<th>
						預計流速
					</th>
					<th>
						預計結束時間
					</th>
					<th>
						剩餘量
					</th>
					<th>
						實際流速
					</th>
					<th>
						實際剩餘時間
					</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
					</td>
				</tr>
			
			</tbody>
			
		</table>
		</div>
	</div>


	
</div>
</div>

</body>
</html>