<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Welcome to Job Search</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f8f9fa;
        text-align: center;
        padding: 20px;
    }
    h1 {
        color: #343a40;
        margin-bottom: 20px;
    }
    a {
        text-decoration: none;
        color: #007bff;
        margin: 10px;
        padding: 10px 20px;
        border: 2px solid #007bff;
        border-radius: 5px;
        transition: all 0.3s ease;
        display: inline-block;
    }
    a:hover {
        background-color: #007bff;
        color: #fff;
    }
</style>
</head>
<body>
    <h1>Hi ${user.getUsername()}, welcome to Job Search</h1>
    <a href="profiledetail">Personal Information</a>
    <a href="jobs">Jobs</a>
    <a href="appliedJob/${user.getUsername()}">Applied Jobs</a>
</body>
</html>