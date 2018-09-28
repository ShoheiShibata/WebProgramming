<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ一覧画面</title>

<link rel="stylesheet" type="text/css" href="css/origin/common2.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">





</head>
<body>

<div class="header" align="right">
<p class="example8"><font color="white"><b>${userInfo.name} さん</b></font><a href="LogoutServlet"> <font class="example1">ログアウト</font></a>　</p>
</div>

<div align="center">
<h1><b>ユーザ一覧</b></h1>
</div>

<div class="wrapper">
<div align="right">
<p><a href="UserCreateServlet"><font class="example2">新規登録</font></a></p>
</div>

<form method="post" action="UserListServlet">
<p class="example1"><b>ログインID</b> <input type="text" name="login_id" class="example2"></p>

<p class="example2"><b>ユーザ名</b> <input type="text" name="name" class="example2"></p>

<p class="example2"><b>生年月日</b> <input type="date" name="birth_datefrom" max="9999-12-31"class="example3"><b class="example"> ～ </b><input type="date" name="birth_dateto" max="9999-12-31" class="example3"></p>

<div align="right">
<p><input type="submit" value="検索" class="example1"></p>
</div>
</div>
</form>


<br><p><hr class="example"></p>
<br>

<div class="wrapper">
<table >
<thead>
<tr>
<th class="example1">ログインID</th>
<th class="example1">ユーザ名</th>
<th class="example2">生年月日</th>
<th class="example3"></th>
</tr>
</thead>
<tbody>
 <c:forEach var="user" items="${userList}" >
<tr>
<td>${user.login_id}</td>
<td>${user.name}</td>
<td>${user.birth_date}</td>
<td>　
<a href="UserDetailServlet?id=${user.id}"><input type="submit" value="詳細" class="example4"></a>　
<c:if test="${userInfo.login_id != 'admin'}"><c:if test="${userInfo.login_id != user.login_id}"><div class="example"></c:if></c:if><a href="UserUpdateServlet?id=${user.id}"><input type="submit" value="更新" class="example5"></a></div>　
<c:if test="${userInfo.login_id != 'admin'}"><div class="example"></c:if><a href="UserDeleteServlet?id=${user.id}"><input type="submit" value="削除" class="example6"></a></div>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>

</body>
</html>