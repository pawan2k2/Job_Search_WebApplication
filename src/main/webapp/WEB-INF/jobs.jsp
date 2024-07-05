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
<h1>Jobs</h1>
<%
    List<Job> jobs = (List<Job>) request.getAttribute("jobs");
    for (Job job : jobs) {
%>

            <div class="bordered-div">
                <a href="jobs/<%=job.getJob_id()%>"><%=job.getJob_title()%></a>
                <p><%=job.getStipend()%></p>
            </div>
<%
    }
%>

</body>
</html>