<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>학생관리시스템</title>
<link rel="stylesheet" href="${css}/member.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div id="wrapper">
<div>
	<h1 id="title_comm">Grade Management System</h1> 
</div>
<div id="container" style="margin-top:100px">
	<form id="login_box" name="login_box" > 
		<img src="${img}/java.png" alt="" /><br />
		<span id="login_id">ID</span>
		<input type="text" id="input_id" name="input_id" value="lee"/> <br />
		<span id="login_pass">PASSWORD</span> 
		<input type="text" id="input_pass" name="input_pass" value="1"/> <br /><br />
		<input id="login_btn" type="submit" value="LOGIN" onclick="loginAlert()" />
		<input type="hidden" name="action" value="login" />
		<input type="hidden" name="page" value="main" />
		<input id="cancel_btn" type="reset"  value="CANCEL" />
	</form>
</div>
</div>

</body>
</html>
<jsp:include page="../common/footer.jsp" />