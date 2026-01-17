<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        background-color: #f0f4f8;
    }

    /* Fixed header at the very top */
    .header {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        background-color: #74ebd5,#9face6;
        padding: 12px 20px;
        display: flex;
        align-items: center;
        justify-content: flex-start; /* All items to the left */
        box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        z-index: 1000;
    }

    .logo {
        color: white;
        font-size: 20px;
        font-weight: bold;
        margin-right: 30px;
    }

    .header a,
    .header input[type="submit"] {
        color: white;
        text-decoration: none;
        font-weight: bold;
        margin-right: 15px;
        padding: 8px 14px;
        border: none;
        border-radius: 6px;
        background-color: #007bff;
        transition: background-color 0.3s, transform 0.2s;
        cursor: pointer;
    }

    .header a:hover,
    .header input[type="submit"]:hover {
        background-color: #0056b3;
        transform: scale(1.05);
    }

    .header form {
        display: inline;
        margin: 0;
    }

    /* Add padding to avoid content hiding under fixed header */
    .content {
        padding: 80px 30px;
        color: #333;
    }
</style>
</head>
<body>

<div class="header">
    <div class="logo"></div>
    <a href="RegistrationController">Create Registration</a>
    <a href="ReadRegistrationController">List Registration</a>
    <form action="LogoutController" method="post">
        <input type="submit" value="Logout"/>
    </form>
</div>

<div class="content">
    
    
</div>

</body>
</html>
