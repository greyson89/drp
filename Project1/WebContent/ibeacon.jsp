<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>點滴注射管理</title>
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


// 		$.ajax({
// 		  	type:"post",
// 		  	url:"refreshMonitor",
// 		  	dataType:"json",
// 		  	success:function(data){
// // 		  		var obj = JSON.parse(data );

// 				var myList = data.list;

// 				$("#table>tbody").remove();
// 				$("#table").append("<tbody></tbody>");
// 				$(myList).each(function(index){
					
// 					ibeaconId = "<td>"+myList[index].ibeaconId+"</td>";
// 					patientId = "<td>"+myList[index].patientId+"</td>";
// 					patientName = "<td>"+myList[index].patientName+"</td>";
// 					bedId = "<td>"+myList[index].bedId+"</td>";
// 					total = "<td>"+myList[index].total+"</td>";
// 					estSpeed = "<td>"+myList[index].estSpeed+"</td>";
// 					estEndTime = "<td>"+myList[index].estEndTime+"</td>";
// 					remain = "<td>"+myList[index].remain+"</td>";
// 					realSpeed = "<td>"+myList[index].realSpeed+"</td>";
// 					realEndTime = "<td>"+myList[index].realEndTime+"</td>";
// 					$('#table>tbody').append("<tr>"+ibeaconId+patientId+patientName+bedId+total+estSpeed+estEndTime+remain+realSpeed+realEndTime+"</tr>");

// 				});
				
// 		  	}
		  
// 	  });
	 
	 

</script>







<body>

<div class="container" style="margin:20px">
<!-- <div class="container-fluid" style="margin:20px"> -->
<div class="row">

	<jsp:include page="indexForInclude.jsp" />

	<div class="col-xs-6 col-md-8">
		<h1>點滴注射管理</h1><br/>
			<s:form action="loadIbeaconHistory" theme="simple" role="form">
			
<!-- 			test<br/> -->
<!-- 			<input type="text" class="form-control" placeholder="病號"/> -->
<%-- 			<s:textfield name="searchPatientId" required="true" class="form-control" placeholder="病號"/> --%>
<!-- 			<button type="submit" class="btn btn-default">查詢</button> -->
<!-- 			test<br/> -->
			
			
			<table class="table" id="table">
				<thead>
					<tr>
						<th>
							<label>讀取  病患過往資料<font color="red">${searchResult}</font></label>
						</th>
						<th>
							<label>病號</label>
							<s:textfield name="searchPatientId" required="true"/>
						</th>
						<th>
							<s:textfield name="searchRunId"   />
						</th>
						<th>
							<s:submit  value="讀取資料" />
						</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
			</s:form>
			
			
			<s:form action="setIbeacon"  theme="simple">
				
			<table class="table">
				<thead>
					<tr>
						<th>
							<label>${ pageType }  ibeancon設定</label>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<label>病號</label><br/>
							<s:textfield name="patientId"  id="patientId"  />
						</td>
						<td>
							<label>ibeacon編號</label><br/>
					      	<s:textfield name="ibeaconId"  required="true"/>
						</td>
					</tr>
					<tr>
						<td>
							<label class="">床號</label><br/>
					      	<s:textfield name="bedId" />
						</td>
						<td>
							<label  class="">預計流速(cc/min)</label><br/>
					      	<s:textfield name="speed" />
						</td>
					</tr>	
					<tr>
						<td>
							<label  class="">藥品1</label><br/>
					      	<s:textfield name="drugId1" />
						</td>
						<td>
							<label  class="">藥品1容量(cc)</label><br/>
							<s:textfield name="drugCc1" />
						</td>
					</tr>
					<tr>
						<td>
							<label  class="">藥品2</label><br/>
					      	<s:textfield name="drugId2" />
						</td>
						<td>
							<label  class="">藥品2容量(cc)</label><br/>
							<s:textfield name="drugCc2" />
						</td>
					</tr>		
					<tr>
						<td>
							<br/>
							<s:submit  value="新增"  method="setIbeacon"/>
	<%-- 										<s:submit  value="修改"  method="editPatient"/> --%>
						</td>
						<td>
							<br/>
							<button type="reset" value="清除" class="btn btn-default">清除</button> 
						</td>
					</tr>
				</tbody>
			</table>
			</s:form>
			
	</div>
</div>
</div>	


</body>
</html>