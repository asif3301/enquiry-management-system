<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>

<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #74ebd5, #9face6);
        height: 100vh;
        margin: 0;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        background: rgba(255, 255, 255, 0.95);
        padding: 40px 35px;
        border-radius: 15px;
        box-shadow: 0 8px 25px rgba(0,0,0,0.15);
        width: 400px;
        animation: fadeIn 1s ease-in-out;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(-20px); }
        to { opacity: 1; transform: translateY(0); }
    }

    h2 {
        margin-bottom: 25px;
        color: #333;
        text-align: center;
        font-size: 24px;
    }

    .form-group {
        margin: 18px 0;
        position: relative;
    }

    .form-group input {
        width: 86%;
        padding: 12px 40px 12px 15px;
        border: 1px solid #ddd;
        border-radius: 8px;
        font-size: 14px;
        transition: all 0.3s ease;
    }

    .form-group input:focus {
        border-color: #28a745;
        box-shadow: 0 0 8px rgba(40,167,69,0.3);
        outline: none;
    }

    .form-group i {
        position: absolute;
        right: 12px;
        top: 12px;
        color: #aaa;
    }

    .btn {
        margin-top: 20px;
        width: 100%;
        background: #28a745;
        border: none;
        padding: 14px;
        border-radius: 8px;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        color: white;
        transition: background 0.3s ease;
    }

    .btn:hover {
        background: #218838;
    }

    .extra {
        text-align: center;
        margin-top: 15px;
        font-size: 14px;
        color: #555;
    }

    .extra a {
        color: #28a745;
        text-decoration: none;
        font-weight: 500;
    }

    .extra a:hover {
        text-decoration: underline;
    }
</style>

<!-- FontAwesome Icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

</head>
<body>

<div class="container">
    <h2>Register Here</h2>
    <form action="RegistrationController" method="post">
        
        <div class="form-group">
            <input type="text" name="name" placeholder="Full Name" required/>
            <i class="fa fa-user"></i>
        </div>

        <div class="form-group">
            <input type="text" name="course" placeholder="Course" required/>
            <i class="fa fa-book"></i>
        </div>

        <div class="form-group">
            <input type="email" name="email" placeholder="Email Address" required/>
            <i class="fa fa-envelope"></i>
        </div>

        <div class="form-group">
            <input type="tel" name="mobile" placeholder="Mobile Number" pattern="[0-9]{10}" required/>
            <i class="fa fa-phone"></i>
        </div>

        <input type="submit" value="Register" class="btn"/>
    </form>

    <div class="extra">
        Already have an account? <a href="index.jsp">Login</a>
    </div>
</div>

</body>
</html>


 