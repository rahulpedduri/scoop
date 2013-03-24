<%-- 
    Document   : article
    Created on : Sep 30, 2012, 11:05:49 PM
    Author     : Rahul
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/tlds/scoop.tld" prefix="pre" %>

<%@page pageEncoding="UTF-8"%>

<jsp:useBean id="article" scope="page" class="scoop.doers.GetArticle">
    <jsp:setProperty name="article" property="article_id" value="1"></jsp:setProperty>
    <jsp:setProperty name="article" property="cp" value="${cp}"></jsp:setProperty>
    <jsp:setProperty name="article" property="context" value="${pageContext.servletContext}"></jsp:setProperty>
</jsp:useBean>
<c:set var="okay" value="${article.fetch}" ></c:set>

<c:choose>
<c:when test="${okay}">
    <div id="article">
       

        <h1>${article.article.heading}</h1>
        <p>${article.article.last_modified}</p>
        <span>${article.article.rating}</span>
        <span>
            <p>
                  <jsp:include page="${article.article.resource_tiny}" ></jsp:include>
            </p>
        </span>
    </div>

</c:when>
            <c:otherwise>somethin wrong</c:otherwise>
</c:choose>
   