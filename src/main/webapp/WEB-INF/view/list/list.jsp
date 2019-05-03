<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/static/include/header.jsp"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>음원순위</title>
</head>
<body>

<table>
    <caption>음원순위 리스트</caption>
    <colgroup>
        <col style="width: 10%;">
        <col style="width: 20%;">
        <col style="width: 20%;">
        <col style="width: 25%;">
        <col style="width: 25%;">
    </colgroup>
    <thead>
    <tr>
        <th>순위</th>
        <th>이미지</th>
        <th>발매일</th>
        <th>아티스트명</th>
        <th>음악이름</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="result" items="${resultList}" varStatus="status">
        <tr>
            <td style="text-align: center"><c:out value="${result.ranking}"/></td>
            <td style="text-align: center"><img alt="아티스트" src="<c:out value="${result.artworkUrl100}"/>"></td>
            <td style="text-align: center"><c:out value="${result.releaseDate}"/></td>
            <td style="text-align: center"><c:out value="${result.artistName}"/></td>
            <td style="text-align: center"><c:out value="${result.name}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>