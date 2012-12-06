<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var = "currentPage" value = "${param.currentPage }"/>
<c:set var = "url" value = "${param.url }"/>
<c:set var = "startPage" value = "${param.startPage }"/>
<c:set var = "endPage" value = "${param.endPage }"/>
<c:set var = "numPages" value = "${param.numPages }"/>
<c:set var = "op" value = "${param.op }"/>
<c:set var = "option" value = "${param.option }"/>
<c:set var = "optionvalue" value = "${param.optionvalue }"/>
<div class="page">

	<ul>
    <c:choose>
      <c:when test="${1 >= currentPage}">
        <li class="disabled"><a href="#">&laquo;</a></li>
      </c:when>
      <c:otherwise>
        <li><a href="${url}?op=${op }&${option }=${optionvalue }&page=${currentPage - 1}">&laquo;</a></li>
      </c:otherwise>
    </c:choose>
    
    <c:forEach var="i" begin="${startPage}"  end="${endPage}">
      <c:choose>
	      <c:when test="${i == currentPage}">
	        <li class="active"><a href="${url}?op=${op }&${option }=${optionvalue }&page=${i}">${i}</a></li>
	      </c:when>
	      <c:otherwise>
          <li><a href="${url}?op=${op }&${option }=${optionvalue }&page=${i}">${i}</a></li>
	      </c:otherwise>
      </c:choose>
    </c:forEach>
	  
	  <c:choose>
      <c:when test="${ currentPage >= numPages}">
        <li><a href="#">&raquo;</a></li>
      </c:when>
      <c:otherwise>
        <li><a href="${url}?op=${op }&${option }=${optionvalue }&page=${currentPage + 1}">&raquo;</a></li>
      </c:otherwise>
    </c:choose>
	</ul>
</div>