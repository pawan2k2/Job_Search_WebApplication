<html>
<head>
    <meta charset="UTF-8">
    <title>JobSearch Portal</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
            text-align: center;
        }
        h2 {
            color: #dc3545;
            margin-bottom: 20px;
        }
        .portal {
            border: 3px solid #343a40;
            border-radius: 10px;
            padding: 15px;
            margin-bottom: 20px;
        }
        .portal h4 {
            color: #007bff;
            margin-bottom: 10px;
        }
        a {
            display: block;
            color: #007bff;
            text-decoration: none;
            margin: 5px 0;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Welcome to JobSearch</h2>
        <div class="portal">
            <h4>User Portal :</h4>
            <a href="openlogin">User Login</a>
            <a href="newRegistration">New User</a>
        </div>
        <div class="portal">
            <h4>Recruiter Portal:</h4>
            <a href="openRecruiterLogin">Recruiter Login</a>
            <a href="newRecuriter">New Recruiter</a>
        </div>
    </div>
</body>
</html>
