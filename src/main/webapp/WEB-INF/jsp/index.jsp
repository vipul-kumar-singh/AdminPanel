<%@ page import="java.util.Set" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Panel</title>
</head>
<body>
<% Set<String> classNameList = (Set<String>) request.getAttribute("ClassList"); %>

<h2 class="welcome-title">Admin Panel</h2>

<b>Entities Available :</b>
<ul>
    <%
        if (request.getAttribute("ClassList") != null) {
            for (String className : classNameList) {
    %>
    <li><%=className%>
    </li>
    <%
            }
        }
    %>
</ul>
</body>
</html>

