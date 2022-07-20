<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%
List<String> errors = (List<String>)request.getAttribute("errors");
%>

<head>
    <title>App - Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/x-icon" href="../images/favicon.ico">
    <link href="../css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/signInStyles.css">
</head>

<body class="text-center">
<div class="form-signin bg-light">
    <form action="/app/signin" method="post">
        <img class="mb-4" src="../images/android-chrome-512x512.png" alt="company-logo" width="72">
        <h1 class="h3 mb-3 fw-normal">Login</h1>

        <div class="form-floating">
            <input type="text" name="username" class="form-control" id="floatingInput" placeholder="Username">
            <label for="floatingInput">Username</label>
        </div>
        <div class="form-floating">
            <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
            <label for="floatingPassword">Password</label>
        </div>

        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="true" name="keepSession"> Remember me
            </label>
        </div>

<%
if(errors != null && errors.size() > 0){
%>
<ul>
<% for(String error: errors){%>
<li><%=error%></li>
</ul>
<%} }%>

        <a class="py-2 d-none d-md-inline-block" href="/passwordRecovery">Forgot your password?</a>
        <a class="py-2 d-none d-md-inline-block" href="/signUp">I don't have an account</a>

        <button class="w-100 btn btn-lg btn-dark" type="submit">Sign in</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2022–2023</p>
    </form>
</div>


<!-- Bootstrap JS -->
<script src="../js/boostrap/bootstrap.bundle.min.js"></script>
</body>

</html>
