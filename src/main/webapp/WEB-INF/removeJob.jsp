<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ page import="java.util.List" %>
<%@ page import="in.sp.beans.Job" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        .bordered-div {
            border: 1px solid black;
            padding: 10px;
            margin: 10px;
        }
    </style>
</head>
<body>
<h1>Click on the job which one you want to delete.</h1>
<%
    List<Job> jobs = (List<Job>) request.getAttribute("jobs");
    for (Job job : jobs) {
%>

            <div class="bordered-div">
                <a href="removejob/<%=job.getJob_id()%>"><%=job.getJob_title()%></a>
            </div>
<%
    }
%>

</body>
</html>