<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>サンプル5</title>

<link rel="stylesheet" type="text/css" href="css/origin/common2.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

</head>
<body>

<div class="header" align="right">
<p class="example8"><font color="white"><b>${userInfo.name} さん</b></font> <a href="Sample1.html"><font class="example1">ログアウト</font></a>　</p>
</div>

<div align="center">
<h1><b>ユーザ情報更新</b></h1>
</div>

<br></br>

<div class="wrapper">
<form method="post" action="example.cgi">
<br><p class="example3"><b>ログインID</b> id</p>

<br><p class="example4"><b>パスワード</b> <input type="text" name="パスワード" class="example7"></p>

<br><p class="example5"><b>パスワード(確認)</b> <input type="text" name="パスワード(確認)" class="example7"></p>

<br><p class="example6"><b>ユーザ名</b> <input type="text" name="ユーザ名" value="サンプル" class="example7"></p>

<br><p class="example7"><b>生年月日</b> <input type="text" name="生年月日" value="サンプル" class="example7"></p>

<div align="center">
<br><p><a href="Sample2.html"><input type="button" value="更新" class="example1"></a></p>
</div>
</form>

<br><p><a href="Sample2.html"><font class="example2">戻る</font></a></p>
</div>

</body>
</html>