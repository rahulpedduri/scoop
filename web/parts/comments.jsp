<%-- 
    Document   : comments
    Created on : Oct 14, 2012, 9:05:17 PM
    Author     : Rahul
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/tlds/scoop.tld" prefix="pre" %>
<%@taglib uri="/WEB-INF/tlds/utils.tld" prefix="u" %>

<%@page pageEncoding="UTF-8"%>

<jsp:useBean id="comments" scope="page" class="scoop.doers.GetComments">
    <jsp:setProperty name="comments" property="article_id" value="1"></jsp:setProperty>
    <jsp:setProperty name="comments" property="cp" value="${cp}"></jsp:setProperty>
    <jsp:setProperty name="comments" property="context" value="${pageContext.servletContext}"></jsp:setProperty>
</jsp:useBean>
<c:set var="okay" value="${comments.fetch}" ></c:set>

${ (comments.message == 'emtpy_resource') }
<c:choose>
    <c:when test="${okay || (comments.message == 'empty_resource') }">
    <div id="comments">
        <ul>
        <c:forEach items="${comments.comm}" var="comm">
            <li id="${comm.comment_id}">
                <a href="#">
                    <img src="${comm.resource_tiny}" class="tiny_image"/>
                </a>
                <a href="#">
                    ${comm.first_name} ${comm.last_name}:
                </a>
                <span class="comment">${comm.comment}</span>
                <span class="light">${comm.comment_added_on}</span>
            </li>
        </c:forEach>
            </ul>
    </div>

</c:when>
            <c:otherwise>somethin wrong</c:otherwise>
</c:choose>
