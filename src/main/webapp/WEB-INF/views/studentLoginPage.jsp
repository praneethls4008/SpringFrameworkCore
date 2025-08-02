<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>Student Login Page</title></head>
  <body>
    <div>
        <h2>Login Page</h2>
	<form action="/student/auth" method="POST">
        <div>
            <div>
                <label> username </label>
                <input name='username' placeholder='enter username'/>
            </div>
            <div>
                 <label> password </label>
                 <input type='password' name='password' placeholder='enter password'/>
            </div>
	 <input type='submit' value='Login'/>
        </div>
	</form>
    </div>
  </body>
</html>