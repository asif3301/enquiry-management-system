<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Registration</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        margin: 0;
        padding: 0;
        height: 100vh;
        background: linear-gradient(135deg, #a8edea, #fed6e3);
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    /* 👇 moved more upward */
    .content {
        margin-top: 25px; /* was 40px before */
        width: 100%;
        text-align: center;
    }

    h2 {
        color: #333;
        margin-bottom: 6px; /* even less gap with table */
        font-size: 28px;
    }

    h3 {
        color: green;
        text-align: center;
        margin-top: 4px;
        margin-bottom: 6px;
    }

    table {
        width: 85%;
        margin: 5px auto 25px auto; /* table closer to heading */
        border-collapse: collapse;
        box-shadow: 0 4px 20px rgba(0,0,0,0.1);
        background-color: #fff;
        border-radius: 10px;
        overflow: hidden;
    }

    th, td {
        padding: 14px 18px;
        text-align: center;
        border-bottom: 1px solid #eee;
    }

    th {
        background-color: #4CAF50;
        color: white;
        font-size: 16px;
        text-transform: uppercase;
    }

    tr:hover {
        background-color: #f9f9f9;
        transition: background-color 0.2s ease-in-out;
    }

    a {
        text-decoration: none;
        color: #007bff;
        font-weight: bold;
    }

    a:hover {
        color: #0056b3;
    }

    footer {
        width: 100%;
        margin-top: 25px;
        text-align: center;
    }
</style>
</head>
<body>

<div class="content">
    <h2>All Registrations</h2>

    <h3>
    <%
    if(request.getAttribute("updateStatus") != null){
        out.println(request.getAttribute("updateStatus"));
    }
    %>
    </h3>

    <table>
    <tr> 
    <th>Id</th>
    <th>Name</th>
    <th>Course</th>
    <th>Email</th>
    <th>Mobile</th>
    <th>Delete</th>
    <th>Update</th>
    </tr>

    <%
    ResultSet result = (ResultSet) request.getAttribute("res");

    while(result.next()){ %>
    <tr> 
    <td><%=result.getInt(1) %></td>
    <td><%=result.getString(2) %></td>
    <td><%=result.getString(3) %></td>
    <td><%=result.getString(4) %></td>
    <td><%=result.getString(5) %></td>
    <td><a href="DeleteRegistrationController?id=<%= result.getInt(1) %>">Delete</a></td>
    <td><a href="UpdateRegistrationController?id=<%= result.getInt(1) %>">Update</a></td>
    </tr>
    <% } %>
    </table>
</div>

<footer>
    <%@ include file="menu.jsp" %>
</footer>

</body>
</html>
