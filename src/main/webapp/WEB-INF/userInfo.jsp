<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f8f9fa;
        text-align: center;
        padding: 20px;
    }
    pre {
        font-size: 16px;
        background-color: #ffffff;
        border: 1px solid #dee2e6;
        padding: 20px;
        max-width: 500px;
        margin: 0 auto;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    b {
        color: #007bff;
    }
</style>
</head>
<body>
    <pre>
        <b>User Name :</b> ${user.getUsername()}
        <b>Gender :</b> ${user.getGender()}
        <b>City :</b> ${user.getCity()}
        <b>Birth-year :</b> ${user.getBirthyear()}
        <b>Highest Education :</b> ${user.getHighEdu()}
    </pre>
</body>
</html>