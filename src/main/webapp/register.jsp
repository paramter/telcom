<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>
</head>
<body>
	<center>
		<form action="register.do" method="post">
			<table>
				<tr>
					<td>用户名:<input type="text" id="username" name="username"/><td>
				</tr>
				<tr>
					<td>密码:<input type="text" id="password" name="password"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="注册"/></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>