
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Core</title>
</head>
<body>
<c:out value="Тэг <c:out> используется для вывода данных на экран"/><br/>
<h3>Тег c:set используется для определения переменной</h3>
<c:set var="hello"  scope="page" value="Hello my dear friend"/>
<c:out value="${hello}"/>
<c:remove var="hello" scope="page"/><br/>
<h3>Условие if</h3>
<c:set var="str" scope="page" value="${852}"/>
<c:if test="${str > 850}">
    str = <c:out value="${str}"/><br/>
</c:if>
<h3>Тег c:choose в Java является аналогом оператора switch</h3>
<c:set var="dig" scope="page" value="${15}"/>
<c:choose>
    <c:when test="${dig <= 20}">
        less than 20
    </c:when>
    <c:when test="${dig > 20}">
        more than 20
    </c:when>
    <c:otherwise>
        nothing
    </c:otherwise>
</c:choose><br/>

<c:forEach var="clip" items="${headerValues}" varStatus="сounter">
    <tr>
        <td>${сounter.count}></td>
        <td>${clip.key.toString()}</td>
    </tr>
    <br/>
</c:forEach><br/>

<c:catch var ="exception">
    <% int x = 5/0;%>
</c:catch>

<c:if test = "${exception != null}">
    <p>Возникло исключение : ${exception} <br/>
        Сообщение : ${exception.message}</p>
</c:if>
</body>
</html>
