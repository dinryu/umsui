<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>학생관리</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/member.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div id="wrapper">
	<header>
	<h1 id="title">학 생 관 리</h1>
	<a id="go_main" href="<%=request.getContextPath()%>/WEB-INF/common/index.jsp">메인으로 가기</a><br />
	</header>
<br/><br/>
<div id="container">

	<form id="login_box" action="<%=request.getContextPath()%>/common.do" method="get">
		<img id="login_img" src="<%=request.getContextPath()%>/resources/img/oracle.png" alt="" /><br />
		<span id="login_id">ID</span>
		<input type="text" name="id" id="kim" /> <br />
		<span id="login_pass">PASSWORD</span> 
		<input type="text" name="pass" id="2" /> <br /><br />
		<div>
			<input id="login_tbn" type="submit" value="LOGIN"/>
			<input id="cancel_btn" type="reset" value="CANCEL"> 
			<input type="hidden" name="action" value="login"/>
			<input type="hidden" name="page" value="main">
			
		</div>	
	</form>
</div>
<br/><br/>
<footer>
		<div id="footer-box">
			<p>Posted by: Hege Refsnes</p>
	  		<p>Contact information: <a href="mailto:dinryu@naver.com">
	  		</a>.</p>
	  		<a href="utjil/jdbc_test.jsp">db연결 테스트</a><br/>
	  		<a href="utjil/update_email.jsp">이메일 업데이트</a>	 		
		</div>
	</footer>