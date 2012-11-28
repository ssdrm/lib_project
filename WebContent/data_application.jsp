<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<title>직접신청쓰기</title>

<meta http-equiv="content-type" content="text/html; charset=utf-8">

<style type="text/css">
A:link {
    text-decoration: none;
    color: black;
}

A:visited {
    text-decoration: none;
    color: black;
}

A:hover {
    text-decoration: none;
    color: black;
}

</style>
<link href = "css/share.css" rel = "stylesheet" type = "text/css">
<script src="js/jquery.share.js"></script>
</head>
<body>

<jsp:include page="share/navi.jsp">
			<jsp:param name="" value=""/>
		</jsp:include>
		
		
    <DIV id="pop_title">
        <p align="center">
            <IMG src="img/appleication_write_title.jpg" width="680" height="83" alt="title">
        </p>
    </DIV>
    <TABLE border="0" cellSpacing="0" cellPadding="0" width="680"
        align="center" height="233">
        <TBODY>
            <TR>
                <TD bgColor="#d1d1d1" height="2" colSpan="2"></TD>
            </TR>
            <TR>
                <TD bgColor="#d1d1d1" height="1" colSpan="2"></TD>
            </TR>
            <TR>
                <TD bgColor="#f1f1f1" height="30" vAlign="middle" width="120"
                    align="left"><IMG class="req_img" src="img/request_title_name.jpg"
                    width="26" height="10"><FONT color="#ff0000">*</FONT>
                <!--도서명--></TD>
                <TD height="30">
                    <form name="form2">
                        <INPUT id="bname" class="inptxt w400" name="bname" maxLength="100"
                            value="" type="text">
                    </form>
                </TD>
            </TR>
            <TR>
                <TD bgColor="#d1d1d1" height="1" colSpan="2"></TD>
            </TR>
            <TR>
                <TD bgColor="#f1f1f1" height="30" vAlign="middle" width="120"
                    align="left"><IMG class="req_img"
                    src="img/request_title_author.jpg" width="26" height="10"><FONT
                    color="#ff0000">*</FONT>
                <!--저자--></TD>
                <TD height="30">
                    <form name="form3">
                        <INPUT id="bauth" class="inptxt w400" name="bauth" value=""
                            type="text">
                    </form>
                </TD>
            </TR>
            <TR>
                <TD bgColor="#d1d1d1" height="1" colSpan="2"></TD>
            </TR>
            <TR>
                <TD bgColor="#f1f1f1" height="30" vAlign="middle" width="120"
                    align="left"><IMG class="req_img" src="img/request_title_pub.jpg"
                    width="27" height="10"><FONT color="#ff0000">*</FONT>
                <!--출판사--></TD>
                <TD height="30">
                    <form name="form4">
                        <INPUT id="bpub" class="inptxt w400" name="bpub" value=""
                            type="text">
                    </form>
                </TD>
            </TR>
            <TR>
                <TD bgColor="#d1d1d1" height="1" colSpan="2"></TD>
            </TR>
            <!--도서 자동예약기능-->
            <TR>
                <TD bgColor="#d1d1d1" height="1" colSpan="2"></TD>
            </TR>
            <TR>
                <TD bgColor="#d1d1d1" height="1" colSpan="2"></TD>
            </TR>
            <TR>
                <TD bgColor="#f1f1f1" height="98" vAlign="middle" width="120"
                    align="left"><IMG class="req_img"
                    src="img/request_title_reason.jpg" width="36" height="10">
                <!--신청사유--></TD>
                <TD height="98"><TEXTAREA id="reason" onload="change()"
                        class="inptxt  w400" name="reason" rows="5" cols="36"></TEXTAREA><BR>
                <SPAN style="color: rgb(255, 0, 0); font-size: 9pt;" id="rea_error"
                    name="rea_error"></SPAN></TD>
            </TR>
            <TR>
                <TD bgColor="#d1d1d1" height="1" colSpan="2"></TD>
            </TR>
        </TBODY>
    </TABLE>
    <p align="center">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        <A href=""> <IMG alt=등록 src="img/btn_hope_book_01.gif"></A>
        &nbsp;&nbsp;<A href=""> <IMG alt=취소 src="img/btn_hope_book_02.gif"></A>
    </p>
    </div>

</body>

</html>