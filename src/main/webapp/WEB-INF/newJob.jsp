<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add New Job</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 0;
    }
    .container {
        max-width: 400px;
        margin: 50px auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
    form {
        display: flex;
        flex-direction: column;
    }
    label {
        margin-bottom: 10px;
        font-weight: bold;
    }
    input[type="text"], input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        font-size: 16px;
    }
    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
    <div class="container">
        <h3>New Job</h3>
        <form action="addJob" method="post">
            <label for="job_title">Job Title:</label>
            <input type="text" id="job_title" name="job_title" required><br>

            <label for="job_id">Job ID:</label>
            <input type="text" id="job_id" name="job_id" required><br>

            <label for="job_desc">Job Description:</label>
            <input type="text" id="job_desc" name="job_desc" required><br>

            <label for="company">Company Name:</label>
            <input type="text" id="company" name="company" required><br>

            <label for="stipend">Stipend:</label>
            <input type="text" id="stipend" name="stipend" required><br>

            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>