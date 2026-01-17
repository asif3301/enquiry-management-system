<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enquiry Management System</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(135deg, #74ebd5 0%, #ACB6E5 100%);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .login-box {
        background: #fff;
        padding: 30px 40px;
        border-radius: 12px;
        box-shadow: 0px 8px 20px rgba(0,0,0,0.2);
        text-align: center;
        width: 300px;
    }

    h2 {
        margin-bottom: 20px;
        color: #333;
    }

    .login-box input[type="text"],
    .login-box input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 8px 0 15px;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 14px;
    }

    .login-box input[type="submit"] {
        background: #4CAF50;
        color: white;
        padding: 10px;
        width: 100%;
        border: none;
        border-radius: 6px;
        font-size: 16px;
        cursor: pointer;
        transition: 0.3s ease;
    }

    .login-box input[type="submit"]:hover {
        background: #45a049;
    }
</style>
</head>
<body>
    <div class="login-box">
        <h2>Login Here</h2> 
        
        <form action="Verifylogin" method="post">
            <input type="text" name="email" placeholder="Enter your email" required/>
            <input type="password" name="password" placeholder="Enter your password" required/>
            <input type="submit" value="Login"/>
        </form>
   

       
        <%
        if(request.getAttribute("error") != null){
        	out.println(request.getAttribute("error"));
        }
        
        %>
    </div>
</body>
</html>