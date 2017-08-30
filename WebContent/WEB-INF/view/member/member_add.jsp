<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../member/member_head.jsp" />

<div id="container">
<img src="${img}/bjimage.jpg" style="width:200px">
	<form id="join_form" onsubmit="memberAdd()">
		<fieldset>
			<legend>Member Add:</legend>
			<span id="join_id">ID: </span> 
			<input name="id" type="text" placeholder="아이디" /><br /> 
			<span id="join_pass">PASSWORD: </span>
			<input name="password" type="password" placeholder="비밀번호" value="1" /><br />
			<span id="join_name">NAME: </span> 
			<input name="name" type="text" placeholder="이름" value="홍길동"><br /> 
			<span id="join_birth">생년월일: </span>
			<input name="birthday" type="text" placeholder="생년월일" value="2000/05/05"/><br /> 
			<span id="join_email">이메일: </span>
			<input type="email" name="email" placeholder="이메일" value="dinryu@test.com" /><br />
			<span id="join_gender">성별: </span>
			<input type="radio" name="gender" value="male" checked /> 남자 
			<input type="radio" name="gender" value="female" /> 여자 <br />  		
			<h3>전 공</h3>
			<select name="major">
				<option value="computer" selected>컴퓨터공학</option>
				<option value="economics">소프트웨어공학</option>
				<option value="tourism">관광학</option>
				<option value="art">미술학</option>
			</select><br />
			<h3>수강과목</h3>
			<input type="checkbox" name="subject" value="java" checked />자바 <br />
			<input type="checkbox" name="subject" value="c" checked />C언어 <br />
			<input type="checkbox" name="subject" value="html" checked />HTML <br />
			<input type="checkbox" name="subject" value="css" />CSS <br /> 
			<input type="checkbox" name="subject" value="javascript" />자스<br /> 
			<input type="checkbox" name="subject" value="sql" />SQL<br /> 
			<input type="checkbox" name="subject" value="python" />파이썬<br /> 
			<input id="join_yes_btn" type="submit" value="등록" />
			<input id="join_no_btn" type="reset" value="취소" /> 
			<input type="hidden" name="action" value="join" /> 
			<input type="hidden" name="page" value="main" />
		</fieldset>
	</form>
</div>
<jsp:include page="../common/footer.jsp" />

