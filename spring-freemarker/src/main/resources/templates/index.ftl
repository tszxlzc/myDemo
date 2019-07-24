<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8"/>
    <title>FreeMarker</title>
</head>
<#-- html  引入-->
<script src="static/test.js"></script>
<#-- include 引入 ： 也不知道什么原因要放到sub目录下才可以引入，和 index.ftl同级目录就会报错-->
<script>
    <#include "sub/hello.js">
</script>
<body>
<h1>${message}</h1>
<span>
    <#include "sub/include.ftl">
</span>
<br>
<span>
    <#include "sub/include.html">
</span>
</body>
</html>