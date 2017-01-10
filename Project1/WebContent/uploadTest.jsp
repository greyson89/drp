<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<head>
  <title>首頁 - 上傳測試</title>
  <link rel="stylesheet" type="text/css" href="js/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="js/css/bootstrap-theme.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.3.7/js/tether.min.js" integrity="sha384-XTs3FgkjiBgo8qjEjBk0tGmf3wPrWtA6coPfQDfFEY8AnYJwjalXCiosYRBIBZX8" crossorigin="anonymous"></script>
  <script src="/js/js/bootstrap.js"></script>
  <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
</head>
<body>
	<h2>是否存入DB = ${status }</h2>
	<h2>id = ${ id}</h2>
	<h2>time =  ${ time }</h2>
	<h2>drip = ${ drip}</h2>
	<h2>rssi = ${ rssi}</h2>
	<h2>ip = ${ ip}</h2>
	
	<s:form action="uploadConfirm"  >
		ibeaconId = <s:textfield name="ibeaconId"/>
		<s:submit />
	</s:form>
	<br/>
	
	<s:form action="upload"  >
		<table>
		<tr>
			<td>id = <s:textfield name="id"/>	</td>
			<td>drip = <s:textfield name="drip"/></td>
		</tr>
		<tr>
			<td>time = <s:textfield name="time"/></td>
			<td>rssi = <s:textfield name="rssi"/><br/></td>
		</tr>
		<tr>
			<td>ip = <s:textfield name="ip"/></td>
			<td><s:submit /></td>
		</tr>
		</table>
	</s:form>
</body>
</html>