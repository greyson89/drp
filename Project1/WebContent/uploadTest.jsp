<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<head>
<jsp:include page="importFile_Lib.jsp" />
  <title>上傳測試</title>
</head>
<body>

<!-- <div class="container" style="margin:20px"> -->
<div class="container-fluid" style="margin:20px">
<div class="row">

	<jsp:include page="indexForInclude.jsp" />

	<div class="col-xs-6 col-md-8">
		<h3>是否存入DB = ${status }</h3>
		<h3>id = ${ id}</h3>
		<h3>time =  ${ time }</h3>
		<h3>drip = ${ drip}</h3>
		<h3>rssi = ${ rssi}</h3>
		<h3>ip = ${ ip}</h3>
	</div>
	<div class="col-xs-8 col-md-8">
		<s:form action="uploadConfirm"  >
		
		<table class="table">
			<thead>
				<tr>
					<td>
						<label>啟動ibeacon</label>
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						ibeaconId = <s:textfield name="ibeaconId"/>
					</td>
					<td>
						<s:submit />
					</td>
				</tr>
			</tbody>
		</table>
		</s:form>
		<br/>
		
		<s:form action="upload"  >
			<table class="table">
				<thead>
					<tr>
						<th>
							傳送模擬資料
						</th>
					</tr>				
				</thead>
				<tbody>
					<tr>
						<td>id = <s:textfield name="id"/></td>
						<td>drip = <s:textfield name="drip"/></td>
					</tr>
					<tr>
						<td>timeClock = <s:textfield name="time"/></td>
						<td>rssi = <s:textfield name="rssi"/><br/></td>
					</tr>
					<tr>
						<td>ip = <s:textfield name="ip"/></td>
						<td><s:submit /></td>
					</tr>
				</tbody>
		
			</table>
		</s:form>
	
	</div>
	
</div>
</div>

	

	
</body>
</html>