<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ削除確認</title>

<link rel="stylesheet" type="text/css" href="css/origin/common2.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

</head>
<body>

<div class="header" align="right">
<p class="example8"><font color="white"><b>${userInfo.name} さん</b></font> <a href="LogoutServlet"><font class="example1">ログアウト</font></a>　</p>
</div>

<div align="center">
<h1><b>ユーザ削除確認</b></h1>
</div>

<br></br>

<div class="wrapper">
<p class="example8">ログインID : ${user.login_id}</p>

<p>を本当に削除してよろしいでしょうか。</p>
</div>

<br></br>

<div align="center">
<br><p class="example1"><a href="UserListServlet"><input type="submit" value="キャンセル" class="example1"></a>
<form method="post" action="UserDeleteServlet"><input type="hidden" name="id" value="${user.id}"><input type="submit" value="OK" class="example1"></form></p>
</div>

</body>
</html>