<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ新規登録</title>

<link rel="stylesheet" type="text/css" href="css/origin/common2.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

</head>
<body>

<div class="header" align="right">
<p class="example8"><font color="white"><b>${userInfo.name} さん</b></font> <a href="LogoutServlet"><font class="example1">ログアウト</font></a>　</p>
</div>

<div align="center">
<h1><b>ユーザ新規登録</b></h1>
</div>


<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>


<br></br>

<div class="wrapper">
<form method="post" action="UserCreateServlet">
<br><p class="example3"><b>ログインID</b> <input type="text" name="login_id" class="example7"></p>

<br><p class="example4"><b>パスワード</b> <input type="text" name="password" class="example7"></p>

<br><p class="example5"><b>パスワード(確認)</b> <input type="text" name="passwordcheck" class="example7"></p>

<br><p class="example6"><b>ユーザ名</b> <input type="text" name="name" class="example7"></p>

<br><p class="example7"><b>生年月日</b> <input type="date" name="birth_date" class="example7"></p>

<div align="center">
<br><p><input type="submit" value="登録" class="example1"></p>
</div>
</form>

<br><p><a href="UserListServlet"><font class="example2">戻る</font></a></p>
</div>

</body>
</html>