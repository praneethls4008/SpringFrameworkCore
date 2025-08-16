<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Student Login Page</title>
    <style>
        .error {
            color: red;
            font-size: 14px;
            margin-left: 10px;
             position:fixed;
        }
    </style>
</head>
<body>
<div>
    <h2>Login Page</h2>

     <!-- Global login error message -->
        <c:if test="${not empty loginError}">
            <div class="global-error">${loginError}</div>
        </c:if>

    <form:form action="/student/auth" method="POST" modelAttribute="studentCreateRequestDTO">

        <div>
            <form:label path="username">Username</form:label>
            <form:input path="username" placeholder="enter username"/>
            <form:errors path="username" cssClass="error"/>
        </div>

        <div>
            <form:label path="password">Password</form:label>
            <form:password path="password" placeholder="enter password"/>
            <form:errors path="password" cssClass="error"/>
        </div>

        <div>
            <input type="submit" value="Login"/>
        </div>

    </form:form>
</div>
</body>
</html>
