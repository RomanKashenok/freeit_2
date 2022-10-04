<%@ page import="java.util.Date" pageEncoding="UTF-8" %>

<%
    String[] people = new String[]{"Tom", "Bob", "Sam"};
    String header = "Users list";
%>

<html>
<body>
<%--<h2>Hello World!</h2>--%>
<%--<p><%= new String("Hello").toUpperCase() %></p>--%>
<%--<p>Today <%= new Date() %></p>--%>

<%--<b>*******************</b>--%>
<%--<%--%>
<%--    for(int i = 1; i < 5; i++){--%>
<%--        out.println("<br>Hello " + i);--%>
<%--    }--%>
<%--%>--%>
<%--<b>*******************</b>--%>
<%--<%--%>
<%--    for(String person: people){--%>
<%--        out.println("<li>" + person + "</li>");--%>
<%--    }--%>
<%--%>--%>

<form action="books/" method="post">
    Title: <input name="title_p" size="45"/>
    <br><br>
    Author: <input name="author_p" size="45"/>
    <br></br>
    <input type="submit" value="Save" />
</form>
</body>
</html>

<%-- Scopes --%>
<%--1. Request--%>
<%--2. Session--%>
<%--3. Application--%>
