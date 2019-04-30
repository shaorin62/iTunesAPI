<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/static/include/header.jsp"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>검색결과 값</title>
</head>
<body>
<h2>Hello! <br> ${resultList[0].artistViewUrl}</h2>

    <table>
        <caption>검색결과 리스트</caption>
        <colgroup>
            <col style="width: 10%;">
            <col style="width: 10%;">
            <col style="width: 10%;">
            <col style="width: 10%;">
            <col style="width: 10%;">
            <col style="width: 10%;">
            <col style="width: 40%;">
        </colgroup>
        <thead>
            <tr>
                <th>artistName</th>
                <th>collectionName</th>
                <th>trackName</th>
                <th>artistViewUrl</th>
                <th>collectionViewUrl</th>
                <th>artworkUrl30</th>
                <th>previewUrl</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="result" items="${resultList}" varStatus="status">
                <tr>
                    <td><c:out value="${result.artistName}"/></td>
                    <td><c:out value="${result.collectionName}"/></td>
                    <td><c:out value="${result.trackName}"/></td>
                    <td><c:out value="${result.artistViewUrl}"/></td>
                    <td><c:out value="${result.collectionViewUrl}"/></td>
                    <td><img src="<c:out value="${result.artworkUrl30}"/>"></td>
                    <td><c:out value="${result.previewUrl}"/></td>
                </tr>
            </c:forEach>

        </tbody>
    </table>
</body>
</html>