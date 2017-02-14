<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>登录</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<center>
		<form action="<%=request.getContextPath() %>/j_spring_security_check" method="post">
			<table>
				<tr>
					<td>用户名:<input type="text" id="loginName"/></td>
				</tr>
				<tr>
					<td>密码:<input type="password" id="loginPwd"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="登录"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
