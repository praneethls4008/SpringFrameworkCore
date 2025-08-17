<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
  <head><title>Student Register Page</title></head>
  <style>
          .error {
              color: red;
              font-size: 14px;
              margin-left: 10px;
              position:fixed;
          }
      </style>
  <body>
    <div>
        <h2>Register Account</h2>

        <!-- Global login error message -->
                <c:if test="${not empty loginError}">
                    <div class="global-error">${loginError}</div>
                </c:if>

	<form:form action="${pageContext.request.contextPath}/student/newaccount" method="POST" modelAttribute="studentCreateRequestDTO">
       <div>
                  <form:label path="username">Username</form:label>
                  <form:input path="username" placeholder="Enter New username"/>
                  <form:errors path="username" cssClass="error"/>
              </div>

              <div>
                  <form:label path="password">Password</form:label>
                  <form:password path="password" placeholder="Enter New password"/>
                  <form:errors path="password" cssClass="error"/>
              </div>

              <div>
                  <input type="submit" value="Register"/>
              </div>

	</form:form>
    </div>
  </body>
</html>