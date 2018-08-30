<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>

<link rel="stylesheet" type="text/css" href="css/origin/common.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

</head>
<body>

<div align="center">
<h1><b>ログイン画面</b></h1>

<br>


<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>

<br>

<form method="post" action="LoginServlet">
<br><p class="example1"><b>ログインID</b> <input type="text" name="login_id" class="example1"></p>

<br><p class="example2"><b>パスワード</b> <input type="text" name="password" class="example1"></p>

<br>
<br>

<p><input type="submit" value="ログイン" class="example2"></p>
</form>
</div>
</body>
</html>