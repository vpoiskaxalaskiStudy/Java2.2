
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    <%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  </head>
  <body>
<%--
  <h2>Пример работы foreach</h2>
  <c:forEach items="${empdata}" var="List">
    <c:out value="${List}"></c:out>
  </c:forEach>
  <h2>Пример работы условного оператора</h2>
  <c:set var="age" value="20"/>
  <c:if test="${age >= 18}">
    <c:out value="Вам: ${age} лет. Поэтому вы можете голосовать!"/>
  </c:if>
  <c:if test="${age < 18}">
    <c:out value="Вам: ${age} лет. Поэтому вы не можете голосовать!"/>
  </c:if>
  <h2>Пример работы с forTokens</h2>
  <c:forTokens items = "Мне,всё,до,пизды" delims = "," var = "name">
    <c:out value = "${name}"/>
  </c:forTokens>
  <h2>Пример работы с formatNumber</h2>
  <c:set var = "balance" value = "120000.2309" />
  <fmt:formatNumber type = "number" pattern = "###.###E0" value = "${balance}" />
  <h2>Пример работы с parseNumber</h2>
  <fmt:parseNumber var = "i" integerOnly = "true" type = "number" value = "${balance}" />
  <c:out value = "${i}" />
  <h2>Пример работы с bundle</h2>
  <fmt:bundle basename = "Bundel" prefix = "count.">
    <fmt:message key = "one"/><br/>
    <fmt:message key = "two"/><br/>
    <fmt:message key = "three"/><br/>
  </fmt:bundle>
  <h3>Books info</h3>
  <c:import var="books" url="books.xml"></c:import>
  <x:parse xml="${books}" var="output"></x:parse>
  <x:out select="$output/books/book[1]/name"></x:out>
  <br>
  <b>Цена второй книги</b>
  <x:out select="$output/books/book[2]/price"></x:out>

  <c:set var = "string1" value = "This is first String."/>
  <c:set var = "string2" value = "${fn:substring(string1, 5, 15)}" />
  <h2>Пример работы с functions</h2>
  <p>Final sub string : ${string2}</p>      <c:set var = "string1" value = "This is first String."/>
  <c:set var = "string2" value = "${fn:substring(string1, 5, 15)}" />
  <p>Final sub string : ${string2}</p>
  <c:set var="justastring" value="Hi, How are you??"/>
  ${fn:substringBefore(justastring, "are")} --%>
  <MyTag name="pasport"></MyTag>
  </body>
</html>
