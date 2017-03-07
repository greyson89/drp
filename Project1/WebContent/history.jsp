<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE HTML>

<html>
<jsp:include page="importFile_Lib.jsp" />
<title>歷史紀錄查詢</title>
</head>


<script type="text/javascript">

function loadSelect(temp){
	$("#runId").val(temp.id);
}

function loadPatientHistory(){
		if($("#searchPatientId").val())
// 		alert("test => " + $("#searchPatientId").val());
		$.ajax({
		  	type:"post",
		  	url:"loadPatientHistory",
		  	dataType:"json",
		  	data:{patientId : $("#searchPatientId").val()} , 
		  	success:function(data){
	// 		  		var obj = JSON.parse(data );
				var myList = data.list;
				console.log(data);
				$("#table>tbody").remove();
				$("#table").append("<tbody></tbody>");
				$("#patientId").val($("#searchPatientId").val());
				
				$(myList).each(function(index){
// 					alert("get resp " +  myList[index].runId);
					
					button = "<td><button type='submit' id='"+myList[index].runId+"' class='btn btn-success' onclick='loadSelect(this);' >讀取</button> </td>";
					
					runId = "<td>"+myList[index].runId+"</td>";
					patientId = "<td>"+myList[index].patientId+"</td>";
					patientName = "<td>"+myList[index].ibeaconId+"</td>";
					bedId = "<td>"+myList[index].bedId+"</td>";
					total = "<td>"+myList[index].total+"</td>";
					speed = "<td>"+myList[index].speed+"</td>";
					insertTime = "<td>"+myList[index].insertTime+"</td>";
					status = "<td>"+myList[index].status+"</td>";
					drugQuantity = "<td>"+myList[index].drugQuantity+"</td>";
					$('#table>tbody').append("<tr>"+button+runId+patientId+patientName+bedId+total+speed+insertTime+status+drugQuantity);
					$(myList[index].drugIdList).each(function(index2){
						$('#table>tbody>tr').append( "<td>"+myList[index].drugIdList[index2]+"</td>" + "<td>"+myList[index].drugCcList[index2]+"</td>" );
					});
					
					$('#table>tbody').append("</tr>");
	
				});
			
		  	}
  
		});
	
	
	
}


	 
	 

</script>









<body>

<!-- <div class="container" style="margin:20px"> -->
<div class="container-fluid" style="margin:20px">
<div class="row">

	<jsp:include page="indexForInclude.jsp" />

	<div class="col-xs-6 col-md-8">
		<h1>點滴注射管理</h1><br/>
			
<!-- 			test<br/> -->
<!-- 			<input type="text" class="form-control" placeholder="病號"/> -->
<%-- 			<s:textfield name="searchPatientId" required="true" class="form-control" placeholder="病號"/> --%>
<!-- 			<button type="submit" class="btn btn-default">查詢</button> -->
<!-- 			test<br/> -->
			<label>讀取過往病患資料</label>
			<input type="text" class="form-control" id="searchPatientId" placeHolder="輸入病號" />
			<button type="button" class="btn btn-default" onclick="loadPatientHistory()">查詢</button>
			
			
<%-- 			<label>病號</label><s:textfield name="searchPatientId" required="true"/> --%>
<%-- 			<s:submit  value="讀取資料" cssClass="btn btn-default" /> --%>
			
			<s:form action="load_select_history" theme="simple">
			<input type="hidden" name="patientId" id="patientId">
			<input type="hidden" name="runId" id="runId">
			<table class="table table-striped" id="table">
				<thead>
					<tr>
						<th>
							
						</th>
						<th>
							#
						</th>
						<th>
							病號
						</th>
						<th>
							ibeacon編號
						</th>
						<th>
							床號
						</th>
						<th>
							total
						</th>
						<th>
							預計流速(cc/min)
						</th>
						<th>
							就診時間
						</th>
						<th>
							status
						</th>
						<th>
							藥劑總數
						</th>
						<th>
							藥劑名1
						</th>
						<th>
							CC數
						</th>
						<th>
							藥劑名2
						</th>
						<th>
							CC數
						</th>
						<th>
							藥劑名3
						</th>
						<th>
							CC數
						</th>
						<th>
							藥劑名4
						</th>
						<th>
							CC數
						</th>
						<th>
							藥劑名5
						</th>
						<th>
							CC數
						</th>
						<th>
							藥劑名6
						</th>
						<th>
							CC數
						</th>
						<th>
							藥劑名7
						</th>
						<th>
							CC數
						</th>
						<th>
							藥劑名8
						</th>
						<th>
							CC數
						</th>
						<th>
							藥劑名9
						</th>
						<th>
							CC數
						</th>
						<th>
							藥劑名10
						</th>
						<th>
							CC數
						</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
			</s:form>

	</div>
</div>
</div>	


</body>









</html>