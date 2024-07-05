<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Job Details</title>
<style>
    .job-details {
        border: 1px solid black;
        padding: 10px;
        margin: 10px;
    }
</style>
</head>
<body>
    <h2>${job.getJob_title()}</h2>
    <div class="job-details">
        <b>Job Id :</b> ${job.getJob_id()}<br>
        <b>Job Description :</b> ${job.getJob_desc()}<br>
        <b>Company Name :</b> ${job.getCompany()}<br>
        <b>Stipend :</b> ${job.getStipend()}<br>
        <a href="apply/${job.getJob_id()}/${job.getRecruitermail()}/${job.getJob_title()}">Apply</a>
    </div>
</body>
</html>