<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .registration-container {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 350px;
            text-align: center;
        }
        h1 {
            color: #343a40;
            margin-bottom: 20px;
        }
        label {
            display: block;
            text-align: left;
            margin: 10px 0 5px;
            color: #495057;
        }
        input[type="text"], input[type="number"], input[type="password"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin: 10px 0 20px;
            border: 1px solid #ced4da;
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="registration-container">
        <h1>New Registration Form</h1>
        <form action="register" method="post">
            <label for="username">User-name:</label>
            <input type="text" id="username" name="username" required><br>
            <label for="city">City:</label>
            <input type="text" id="city" name="city" required><br>
            <label for="birthyear">Birth-Year:</label>
            <input type="number" id="birthyear" name="birthyear" required><br>
            <label for="highEdu">Highest Qualification:</label>
            <input type="text" id="highEdu" name="highEdu" required><br>
            <label for="gender">Gender:</label>
            <input type="text" id="gender" name="gender" required><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>
            <input type="submit" value="Register">
        </form>
    </div>
</body>
</html>