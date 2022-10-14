<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <table width="700" align="center" border="1">
    <tr>
     <td> 이름 </td>
     <td> 제목 </td>
     <td> 조회수 </td>
     <td> 작성일 </td>
    </tr>
   <c:forEach items="${list}" var="bdto">
     <tr>
     <td> ${bdto.name} </td>
     <td> <a href="content?id=${bdto.id}"> ${bdto.title} </a> </td>
     <td> ${bdto.readnum} </td>
     <td> ${bdto.writeday} </td>
    </tr>
   </c:forEach>
    <tr>
     <td colspan="4"> <a href="write"> 글쓰기 </a> </td>
    </tr>
  </table>
</body>
</html>