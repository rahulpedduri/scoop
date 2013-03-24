<%-- 
    Document   : functions
    Created on : Oct 11, 2012, 10:43:32 PM
    Author     : Rahul
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/tlds/scoop.tld" prefix="pre" %>
<%@page pageEncoding="UTF-8"%>

<jsp:useBean id="func" scope="page" class="scoop.doers.GetPermissions">
    <jsp:setProperty name="func" property="username" value="rahuldon74"></jsp:setProperty>
    <jsp:setProperty name="func" property="cp" value="${cp}"></jsp:setProperty>
    <jsp:setProperty name="func" property="context" value="${pageContext.servletContext}"></jsp:setProperty>
</jsp:useBean>
<c:set var="okay" value="${func.fetch}" ></c:set>

<c:choose>
    <c:when test="${okay && (func.message == 'normal')}">
        <div id="functions">
            <ul id="root_ul">
            <c:forEach items="${func.header}" var="key">
                <li>${key.key}
                    <ul class="inner">
                    <c:forEach items="${key.value}" var="vals">
                        <li>${vals.perm_display_name}</li>
                    </c:forEach>
                    </ul>
                </li>
            </c:forEach>
            </ul>
            <%--
            <c:set var="flag" value="${false}"></c:set>
            <ul id="root_ul">
            <c:forEach items="${func.perm}" var="item">
                <ul> ${item.perm_category}
                    
                <c:if test="${flag}">
                    <c:choose>
                        <c:when test="${item.perm_category==previous}">
                             <li>
                                 <a href="">${item.perm_display_name}</a>
                             </li>
                        </c:when>
                        <c:when test="${item.perm_category!=previous}">
                        </ul>
                            <ul>${item.perm_category}
                                <li>
                                     <a href="">${item.perm_display_name}</a>
                                </li>
                        </c:when>
                    </c:choose>
                </c:if>

               
                <c:set var="flag" value="${true}" scope="page"></c:set>
                <c:set var="previous" value="${item.perm_category}" scope="page"></c:set>
            </c:forEach>
            </ul>
            --%>
        </div>
    </c:when>
    <c:when test="${okay && (func.message=='empty_result')}">
        <div id="login">
            LOGIN
        </div>
    </c:when>
    <c:otherwise>somethin wrong</c:otherwise>
</c:choose>

