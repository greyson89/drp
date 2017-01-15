<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<link rel="icon" href="/dir/favicon.ico" mce_href="icon/favicon.ico" type="image/x-icon" > 
	<link rel="shortcut icon" href="icon/favicon.ico"" mce_href="icon/favicon.ico" type="image/x-icon"> 
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="js/js/jquery-3.1.1.min.js"></script>
  <script src="bootstrap/js/bootstrap.js"></script>
  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-theme.css">
<title>即時監控</title>
</head>

<script type="text/javascript">
refreshTime = 30000;
$(document).ready(function(){
	$("#btn2").click(function(){
// 		$("#table>tbody").remove();
		refreshTime=60000;
		alert("刷新時間更新為"+refreshTime);
	});
	
	$("#btn").click(function(){
// 		alert("test2");
		refreshTime=5000;
		alert("刷新時間更新為"+refreshTime);
	});
	
	  
	
});


 setInterval(function(){
		$.ajax({
		  	type:"post",
		  	url:"refreshMonitor",
		  	dataType:"json",
		  	success:function(data){
// 		  		var obj = JSON.parse(data );

				var myList = data.list;

				$("#table>tbody").remove();
				$('h4').html("刷新時間: <font color='red'>"+data.nowTime+"</font>");
				$("#table").append("<tbody></tbody>");
				$(myList).each(function(index){
					
					ibeaconId = "<td>"+myList[index].ibeaconId+"</td>";
					patientId = "<td>"+myList[index].patientId+"</td>";
					patientName = "<td>"+myList[index].patientName+"</td>";
					bedId = "<td>"+myList[index].bedId+"</td>";
					total = "<td>"+myList[index].total+"</td>";
					estSpeed = "<td>"+myList[index].estSpeed+"</td>";
					estEndTime = "<td>"+myList[index].estEndTime+"</td>";
					remain = "<td>"+myList[index].remain+"</td>";
					realSpeed = "<td>"+myList[index].realSpeed+"</td>";
					realEndTime = "<td>"+myList[index].realEndTime+"</td>";
					difference = "<td>"+myList[index].difference+"</td>";
					if(index==1){
						$('#table>tbody').append("<tr class='danger'>"+ibeaconId+patientId+patientName+bedId+total+estSpeed+estEndTime+remain+realSpeed+realEndTime+difference+"</tr>");
					}else{
						$('#table>tbody').append("<tr>"+ibeaconId+patientId+patientName+bedId+total+estSpeed+estEndTime+remain+realSpeed+realEndTime+difference+"</tr>");
					}
				});
				
		  	}
		  
	  });
	 
	 
	 }, 10000);

</script>


<body>

<!-- <div class="container" style="margin:20px"> -->
<div class="container-fluid" style="margin:20px">
<div class="row">

	<jsp:include page="indexForInclude.jsp" />
	<div class="col-xs-6 col-md-8">
<!-- 		<div class="table-responsive"> -->
		<h3>即時監控</h3>
		<h4>刷新時間: <font color="RED">等待刷新</font></h4>
		<table class="table table-hover" id="table">
			
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
						總量(cc)
					</th>
					<th>
						預計流速(cc/min)
					</th>
					<th>
						預計結束時間
					</th>
					<th>
						剩餘量(cc)
					</th>
					<th>
						實際流速(cc/min)
					</th>
					<th>
						實際剩餘時間
					</th>
					<th>
						誤差時間
					</th>
				</tr>
			</thead>
			<tbody id="tbody">
			
			</tbody>
			
		</table>
<!-- 		</div> -->
	</div>


	
</div>
</div>

</body>
</html>