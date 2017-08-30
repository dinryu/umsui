<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../member/member_head.jsp"/>

<div id="container">
	<form action="${ctx}/member/service_update.jsp" method="get">
	<table id="member_detail_tab">
		<tr>
			<td colspan="2" rowspan="3"><img src="${ctx}/img/ann.jpg" style="width:100px"></td>
			<td>name</td>
			<td><input type="text" name="name" placeholder="" /></td>
		</tr>
		<tr>
			<td>id</td>
			<td></td>
		</tr>
		<tr>
			<td>ssn</td>
			<td></td>
		</tr>
		<tr>
			<td>phone</td>
			<td colspan="3"></td>
			
		</tr>
		<tr>
			<td>email</td>
			<td colspan="3"></td>
			
		</tr>
		<tr>
			<td>adress</td>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td>major</td>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td>subject</td>
			<td colspan="3"></td>
		</tr>
	
	</table>
	<input type="submit" id="confirm_btn" value="수 정"/>
	<input type="button" onclick="javascript:cancel()" value="취 소"/>
	<input type="hidden" name="id" value="" />
	</form>
</div>
<br /><br /><br /><br />

<jsp:include page="../common/footer.jsp"/>


	