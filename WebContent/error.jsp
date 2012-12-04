<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>ERROR!!!</title>
<link href = "css/reset.css" rel = "stylesheet" type = "text/css">
<link href = "css/reset2.css" rel="stylesheet" type = "text/css">
</head>
<body>
  <div class="container">
    <div class="alert alert-error">
      <c:out value="${error}"/>
      
      <c:if test="${errorMsgs != null || errorMsgs.size() > 0 }">
        <h3>Errors:</h3>
        <ul>
          <c:forEach var="msg" items="${errorMsgs}">
            <li>${msg}</li>
          </c:forEach>
        </ul>
      </c:if>
    </div>
  </div>
</body>
</html>
