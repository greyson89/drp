<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE HTML>

<html>
<jsp:include page="importFile_Lib.jsp" />
<title>點滴注射管理</title>
</head>


<script type="text/javascript">
var drugQuantity = 6;


//更新出現欄位數量
function changeDrugQuantity(){
	drugQuantity = $("#drugQuantity :selected").val();

	$("#th1").css("color","red");
	$("#th1").text("test  6  drugQuantity= "+drugQuantity);
	
	for(i=10;i>drugQuantity;i--){
		$("#drug_"+i).css("display","none");
		
 	}
	for(i=1;i<=drugQuantity;i++){
		$("#drug_"+i).css("display","");
		
 	}
	

}




$(document).ready(function(){
// 	alert("總數" + $("#drugQuantity").val());
// 	$("#drugQuantity :selected").val(drugQuantity);

	//將drugQuantity寫入下拉選單
	$("#drugQuantity").children().each(function(){
	    if ($(this).text()==drugQuantity){
	        $(this).attr("selected","true");
	    }
	});
	
	changeDrugQuantity();
	

	
	
	
	  
	
});




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
				
				$(myList).each(function(index){
// 					alert("get resp " +  myList[index].runId);
					runId = "<td>"+myList[index].runId+"</td>";
					patientId = "<td>"+myList[index].patientId+"</td>";
					patientName = "<td>"+myList[index].ibeaconId+"</td>";
					bedId = "<td>"+myList[index].bedId+"</td>";
					total = "<td>"+myList[index].total+"</td>";
					speed = "<td>"+myList[index].speed+"</td>";
					insertTime = "<td>"+myList[index].insertTime+"</td>";
					status = "<td>"+myList[index].status+"</td>";
					drugQuantity = "<td>"+myList[index].drugQuantity+"</td>";
					$('#table>tbody').append("<tr>"+runId+patientId+patientName+bedId+total+speed+insertTime+status+drugQuantity);
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

<div class="container" style="margin:20px">
<!-- <div class="container-fluid" style="margin:20px"> -->
<div class="row">

	<jsp:include page="indexForInclude.jsp" />

	<div class="col-xs-6 col-md-8">
		<h1 id="th1">點滴注射管理</h1><br/>
		
		
		
		
<!-- 			<form class="form-horizontal" role="form"> -->
			<s:form action="setIbeacon"  theme="simple" cssClass="form-horizontal">
				<div class="form-group">
				
					<label for="patientId" class="col-sm-2 control-label">病號</label>
					<div class="col-sm-10">
						<s:textfield name="patientId"  id="patientId" cssClass="form-control"  />
					</div>
				</div>
					
				<div class="form-group">
					<label for="ibeaconId" class="col-sm-2 control-label">ibeacon編號</label>
					<div class="col-sm-10">
						<s:textfield name="ibeaconId"  id="ibeaconId" required="true" cssClass="form-control" />
					</div>
				</div>
				
				<div class="form-group">					
					<label for="bedId" class="col-sm-2 control-label">床號</label>
					<div class="col-sm-10">
			      		<s:textfield name="bedId" id="bedId" cssClass="form-control" />
			      	</div>
			    </div>
			    
			    <div class="form-group">  	
					<label for="speed" class="col-sm-2 control-label">預計流速(cc/min)</label>
			      	<div class="col-sm-10">
			      		<s:textfield name="speed" id="speed" cssClass="form-control" />
			      	</div>
			    </div>
			    
			    <div class="form-group">  	
					<label for="drugQuantity" class="col-sm-2 control-label">藥品總數</label>
			      	<div class="col-sm-10">
			      		<select class="form-control" id="drugQuantity" name="drugQuantity" onchange="changeDrugQuantity();">
			      			<option value="0">請選擇</option>
			      			<option value="1">1</option>
			      			<option value="2">2</option>
			      			<option value="3">3</option>
			      			<option value="4">4</option>
			      			<option value="5">5</option>
			      			<option value="6">6</option>
			      			<option value="7">7</option>
			      			<option value="8">8</option>
			      			<option value="9">9</option>
			      			<option value="10">10</option>
			      		</select>
			      	</div>
			    </div>
			      	
			      	
			    <div id="drug_1">  	
					<div class="form-group">  	
						<label for="drugQuantity" class="col-sm-2 control-label" >藥品1</label>
				      	<div class="col-sm-10">
				      		<s:textfield name="drugId_1" id="drugId_1" cssClass="form-control" />
				      	</div>
				    </div>
				    
				    <div class="form-group">  	
						<label for="drugQuantity" class="col-sm-2 control-label">藥品1容量(cc)</label>
				      	<div class="col-sm-10">
				      		<s:textfield name="drugCc_1" id="drugCc_1" cssClass="form-control" disabled="disabled"/>
				      	</div>
				    </div>
				</div>
				
				
				<div id="drug_2">  	
				    <div class="form-group">  	
						<label for="drugQuantity" class="col-sm-2 control-label" >藥品2</label>
				      	<div class="col-sm-10">
				      		<s:textfield name="drugId_2" id="drugId_2" cssClass="form-control" />
				      	</div>
				    </div>
				    
				    <div class="form-group">  	
						<label for="drugQuantity" class="col-sm-2 control-label">藥品2容量(cc)</label>
				      	<div class="col-sm-10">
				      		<s:textfield name="drugCc_2" id="drugCc_2" cssClass="form-control" disabled="disabled"/>
				      	</div>
				    </div>
				</div>
				    
				<div id="drug_3">  	    
					  <div class="form-group">  	
						<label for="drugQuantity" class="col-sm-2 control-label" >藥品3</label>
				      	<div class="col-sm-10">
				      		<s:textfield name="drugId_3" id="drugId_3" cssClass="form-control" />
				      	</div>
				    </div>
				    
				    <div class="form-group">  	
						<label for="drugQuantity" class="col-sm-2 control-label">藥品3容量(cc)</label>
				      	<div class="col-sm-10">
				      		<s:textfield name="drugCc_3" id="drugCc_3" cssClass="form-control" disabled="disabled"/>
				      	</div>
				    </div>
				</div>    
				    
				    
				<div id="drug_4">  					    
				      <div class="form-group">  	
						<label for="drugQuantity" class="col-sm-2 control-label" >藥品4</label>
				      	<div class="col-sm-10">
				      		<s:textfield name="drugId_4" id="drugId_4" cssClass="form-control" />
				      	</div>
				    </div>
				    
				    <div class="form-group">  	
						<label for="drugQuantity" class="col-sm-2 control-label">藥品4容量(cc)</label>
				      	<div class="col-sm-10">
				      		<s:textfield name="drugCc_4" id="drugCc_4" cssClass="form-control" disabled="disabled"/>
				      	</div>
				    </div>
				    
				</div>
				    
				    
				<div id="drug_5">  		    
				      <div class="form-group">  	
						<label for="drugQuantity" class="col-sm-2 control-label" >藥品5</label>
				      	<div class="col-sm-10">
				      		<s:textfield name="drugId_5" id="drugId_5" cssClass="form-control" />
				      	</div>
				    </div>
				    
				    <div class="form-group">  	
						<label for="drugQuantity" class="col-sm-2 control-label">藥品5容量(cc)</label>
				      	<div class="col-sm-10">
				      		<s:textfield name="drugCc_5" id="drugCc_5" cssClass="form-control" disabled="disabled"/>
				      	</div>
				    </div>
			    </div>
				
				<div id="drug_6">  		
					  <div class="form-group">  	
						<label for="drugQuantity" class="col-sm-2 control-label" >藥品6</label>
				      	<div class="col-sm-10">
				      		<s:textfield name="drugId_6" id="drugId_6" cssClass="form-control" />
				      	</div>
				    </div>
				    
				    <div class="form-group">  	
						<label for="drugQuantity" class="col-sm-2 control-label">藥品6容量(cc)</label>
				      	<div class="col-sm-10">
				      		<s:textfield name="drugCc_6" id="drugCc_6" cssClass="form-control" disabled="disabled"/>
				      	</div>
				    </div>
				</div>
				
				
				<div id="drug_7">  	
					  <div class="form-group">  	
						<label for="drugQuantity" class="col-sm-2 control-label" >藥品7</label>
				      	<div class="col-sm-10">
				      		<s:textfield name="drugId_7" id="drugId_7" cssClass="form-control" />
				      	</div>
				    </div>
				    
				    <div class="form-group">  	
						<label for="drugQuantity" class="col-sm-2 control-label">藥品7容量(cc)</label>
				      	<div class="col-sm-10">
				      		<s:textfield name="drugCc_7" id="drugCc_7" cssClass="form-control" disabled="disabled"/>
				      	</div>
				    </div>
			    
			    </div>
					
					
				<div id="drug_8">  		
	  				<div class="form-group">  	
						<label for="drugQuantity" class="col-sm-2 control-label" >藥品8</label>
				      	<div class="col-sm-10">
				      		<s:textfield name="drugId_8" id="drugId_8" cssClass="form-control" />
				      	</div>
				    </div>
				    
				    <div class="form-group">  	
						<label for="drugQuantity" class="col-sm-2 control-label">藥品8容量(cc)</label>
				      	<div class="col-sm-10">
				      		<s:textfield name="drugCc_8" id="drugCc_8" cssClass="form-control" disabled="disabled"/>
				      	</div>
				    </div>
			    </div>
	
	
				<div id="drug_9">  	
					
					  <div class="form-group">  	
						<label for="drugQuantity" class="col-sm-2 control-label" >藥品9</label>
				      	<div class="col-sm-10">
				      		<s:textfield name="drugId_9" id="drugId_9" cssClass="form-control" />
				      	</div>
				    </div>
				    
				    <div class="form-group">  	
						<label for="drugQuantity" class="col-sm-2 control-label">藥品9容量(cc)</label>
				      	<div class="col-sm-10">
				      		<s:textfield name="drugCc_9" id="drugCc_9" cssClass="form-control" disabled="disabled"/>
				      	</div>
				    </div>
			    </div>
			    
			    <div id="drug_10">  	
					
					  <div class="form-group">  	
						<label for="drugQuantity" class="col-sm-2 control-label" >藥品10</label>
				      	<div class="col-sm-10">
				      		<s:textfield name="drugId_10" id="drugId_10" cssClass="form-control" />
				      	</div>
				    </div>
				    
				    <div class="form-group">  	
						<label for="drugQuantity" class="col-sm-2 control-label">藥品10容量(cc)</label>
				      	<div class="col-sm-10">
				      		<s:textfield name="drugCc_10" id="drugCc_10" cssClass="form-control" disabled="disabled"/>
				      	</div>
				    </div>
			    </div>
				
			<s:submit  value="新增"  method="setIbeacon" cssClass="btn btn-default"/>
			<button type="reset" value="清除" class="btn btn-default">清除</button> 
			</s:form>
<!-- 			</form> -->
			
			
			
			
			
	</div>
</div>
</div>	


</body>









</html>