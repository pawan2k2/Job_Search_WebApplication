<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ page import="java.util.List" %>
    <%@ page import="in.sp.beans.Application" %>
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
<h1>Applications Received</h1>
<%
    List<Application> apps = (List<Application>) request.getAttribute("apps");
    for (Application app : apps) {
%>

            <div class="bordered-div">
            <b>Applicant Name :</b><%=app.getApplicant_name()%><br>
                <b>Job Title:</b><%=app.getJob_title()%><br>
                <b>Job Id:</b><%=app.getJob_id()%><br>
                <b>Education :</b><%=app.getHigh_edu()%><br>
                <b>Gender :</b><%=app.getGender()%>
            </div>
<%
    }
%>
</body>
</html>