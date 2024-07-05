<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Recruiter Portal</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 0;
    }
    .container {
        max-width: 800px;
        margin: 20px auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
        color: #333;
        text-align: center;
    }
    .link-list {
        list-style-type: none;
        padding: 0;
    }
    .link-list li {
        margin-bottom: 10px;
    }
    .link-list a {
        display: block;
        padding: 10px;
        background-color: #4CAF50;
        color: white;
        text-decoration: none;
        border-radius: 4px;
        text-align: center;
    }
    .link-list a:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Welcome, Recruiter!</h1>
        <ul class="link-list">
            <li><a href="newJobPost">Create New Job Post</a></li>
            <li><a href="jobsOfParticularRecruiter">View Posted Jobs</a></li>
            <li><a href="removeJobs">Remove Posted Job</a></li>
            <li><a href="applications/${rec.getRecuritermail()}">View Applications Received</a></li>
        </ul>
    </div>
</body>
</html>