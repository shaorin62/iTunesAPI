<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/static/include/header.jsp"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>음원검색</title>
</head>
<body>
<h2>Hello! <br> ${resultList[0].artistName}</h2>

    <table>
        <caption>검색결과 리스트</caption>
        <colgroup>
            <col style="width: 10%;">
            <col style="width: 20%;">
            <col style="width: 25%;">
            <col style="width: 20%;">
            <col style="width: auto;">
        </colgroup>
        <thead>
            <tr>
                <th>이미지</th>
                <th>아티스트명</th>
                <th>앨범이름</th>
                <th>음악이름</th>
                <th>previewUrl</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="result" items="${resultList}" varStatus="status">
                <tr>
                    <td style="text-align: center"><img alt="아티스트" src="<c:out value="${result.artworkUrl60}"/>"></td>
                    <td style="text-align: center"><a href="<c:out value="${result.artistViewUrl}"/>"> <c:out value="${result.artistName}"/></a></td>
                    <td style="text-align: center"><a href="<c:out value="${result.collectionViewUrl}"/>"><c:out value="${result.collectionName}"/></a></td>
                    <td style="text-align: center"><c:out value="${result.trackName}"/></td>
                    <td style="text-align: center">
                        <video controls="controls" width="220" height="40">
                            <source src="<c:out value='${result.previewUrl}'/>" type="audio/x-m4a" />
                        </video>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>