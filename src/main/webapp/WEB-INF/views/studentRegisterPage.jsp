<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>Student Register Page</title></head>
  <body>
    <div>
        <h2>Register Account</h2>
	<form action="/student/newaccount" method="POST">
        <div>
            <div>
                <label> username </label>
                <input name='username' placeholder='enter new username'/>
            </div>
            <div>
                 <label> password </label>
                 <input type='password' name='password' placeholder='enter new password'/>
            </div>
	 <input type='submit' value='Register'/>
        </div>
	</form>
    </div>
  </body>
</html>