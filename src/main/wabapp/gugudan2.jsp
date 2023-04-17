<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
// int 로 바꿔주는 이유 범용 저장소 (request) 는 오브젝트로 저장함
int dan = (int) request.getAttribute("dan");
int limit = (int) request.getAttribute("limit");
%>

<h1><%=dan%>단</h1>
<%  for (int i = 1; i <= limit ; i++) { %>
     <div><%=dan%> * <%=i%> = <%=dan * i%></div>
<% } %>


<!-- // test 빨간 사각형
<div class="a"></div>
<style>
.a {
    width : 100px;
    height: 100px;
    background-color: red;
    }
</style>
-->