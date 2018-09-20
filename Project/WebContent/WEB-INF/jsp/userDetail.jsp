<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ情報詳細参照</title>

<link rel="stylesheet" type="text/css" href="css/origin/common2.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

</head>
<body>

<div class="header" align="right">
<p class="example8"><font color="white"><b>${userInfo.name} さん</b></font> <a href="LogoutServlet"><font class="example1">ログアウト</font></a>　</p>
</div>

<div align="center">
<h1><b>ユーザ情報詳細参照</b></h1>
</div>

<br></br>

<div class="wrapper">
<br><p class="example3"><b>ログインID</b> ${user.login_id}</p>

<br><p class="example6"><b>ユーザ名</b> ${user.name}</p>

<br><p class="example7"><b>生年月日</b> ${user.birth_date}</p>

<br><p class="example7"><b>登録日時</b> ${user.create_date}</p>

<br><p class="example7"><b>更新日時</b> ${user.update_date}</p>
<br><p><a href="UserListServlet"><font class="example2">戻る</font></a></p>
</div>

</body>
</html>