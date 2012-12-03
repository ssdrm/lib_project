<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="ko" >
<head>
<meta charset="utf-8" />

<title>시간  </title>
<style type="text/css">
#t{width:180px;background-color:red;height:80px;margin-left:120px;}
</style>


</head>
<body>
	<div id="t">
	<script type="text/javascript">

 today = new Date();

document.write();

document.write(today.getYear()+" &nbsp;-");
document.write((today.getMonth()+1)+"-&nbsp;&nbsp;");
document.write(today.getDate()+"<BR>");



if(today.getHours()<=12)
	document.write("오전 "+today.getHours()+"시 ");
else
	document.write("오후 "+(today.getHours()-12)+"시 ");

document.write(today.getMinutes()+"분 ");
document.write(today.getSeconds()+"초 ");
document.write("");
</script>



	</div>
	</body>
	</html>

