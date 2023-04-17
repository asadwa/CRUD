<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>


<%
  List<Map<String,Object>> articleRows = (List<Map<String,Object>>) request.getAttribute("articleRows");
%>

<!doctype html>
<html lang="ko">
<head>
  <!-- 상단탭에 나오는 이름 -->
  <title>게시물 리스트</title>
</head>
<body>
  <h1>게시물 리스트</h1>
  <ul>
    <li><%= articleRows.get(0).get("id")%>번</li>

  </ul>
</body>
</html>