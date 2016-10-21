<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="title"/></title>
</head>
<body bgcolor="#CCCCFF">
	<s:form action="login" method="post" >
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<table border="1" align="center" bgcolor="#AABBCCDD">
			<tr>
				<td>
					<s:textfield name="username" label="用户名字" size="18" />
				</td>
			</tr>
			<tr>
				<td>
					<s:password name="password" label="用户密码" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<s:submit value="登录" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<s:a href="http://localhost:8888/Struts2Demo/register.jsp">注册</s:a>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>