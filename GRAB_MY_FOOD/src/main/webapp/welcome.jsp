<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

<title>Insert title here</title>
</head>
<style>
   /* RESET */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: "Segoe UI", Arial, sans-serif;
}

/* BODY */
body {
 background-image: url("images/loginback.webp");
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    background-attachment: fixed;
        padding: 40px 15px;
    color: #333;
}

/* TITLE */
h3 {
    text-align: center;
    color: #e74c3c;
    margin-bottom: 35px;
    font-size: 28px;
    letter-spacing: 1px;
}

/* LOGIN CONTAINER */
#loginforms {
    display: flex;
    justify-content: center;
    gap: 30px;
    backdrop-filter: blur(0px);

    flex-wrap: wrap;
}

/* CARD */
.login-card {
    width: 340px;
    background: #ffffff;
    padding: 28px;
    border-radius: 18px;
    box-shadow: 0 12px 30px rgba(0,0,0,0.1);
    transition: transform 0.3s ease;
    backdrop-filter: blur(0px);
     background: rgba(255, 255, 255, 0.65);
}

.login-card:hover {
    transform: translateY(-6px);
}

/* CARD HEADING */
.login-card h4 {
    text-align: center;
    margin-bottom: 20px;
    color: #2c3e50;
}

/* INPUT GROUP */
.input-group {
    position: relative;
    margin-bottom: 15px;
}

.input-group i {
    position: absolute;
    top: 50%;
    left: 12px;
    transform: translateY(-50%);
    color: #aaa;
}

.input-group input {
    width: 100%;
    padding: 10px 12px 10px 38px;
    border-radius: 10px;
    border: 1px solid #ccc;
    outline: none;
}

.input-group input:focus {
    border-color: #e74c3c;
}

/* BUTTON */
.login-card button {
    width: 100%;
    padding: 12px;
    background: #e74c3c;
    border: none;
    border-radius: 25px;
    color: white;
    font-weight: bold;
    cursor: pointer;
    transition: background 0.3s ease;
}

.login-card button:hover {
    background: #c0392b;
}

/* LINKS */
.login-card p,
.login-card h4 {
    text-align: center;
    margin-top: 15px;
}

.login-card a {
    color: #e74c3c;
    text-decoration: none;
    font-weight: bold;
}

.login-card a:hover {
    text-decoration: underline;
}

/* RESPONSIVE */
@media (max-width: 768px) {
    #loginforms {
        flex-direction: column;
        align-items: center;
    }
}

</style>

<body>
<% String msg= (String) request.getAttribute("msg");
if(msg!=null){
	 %>
	 <script > window.alert(" <%= msg%>  "); </script>
	 <%
}
%>
<h3>WELCOME TO GRAB MY FOOD</h3>

<div id="loginforms">

    <!-- CLIENT LOGIN -->
    <div class="login-card">
        <h4><i class="fa fa-store"></i> Client Login</h4>

        <form action="ClientLoginServlet" method="post">

            <div class="input-group">
                <i class="fa fa-phone"></i>
                <input type="text" name="contact" placeholder="Contact Number">
            </div>

            <div class="input-group">
                <i class="fa fa-lock"></i>
                <input type="password" name="password" placeholder="Password">
            </div>

            <button type="submit">Login</button>
        </form>

        <p>New User? <a href="ClientRegist.jsp">Register</a></p>
    </div>

    <!-- CUSTOMER LOGIN -->
    <div class="login-card">
        <h4><i class="fa fa-user"></i> Customer Login</h4>

        <form action="CustomerLoginServlet" method="post">

            <div class="input-group">
                <i class="fa fa-phone"></i>
                <input type="text" name="contact" placeholder="Contact Number">
            </div>

            <div class="input-group">
                <i class="fa fa-lock"></i>
                <input type="password" name="password" placeholder="Password">
            </div>

            <button type="submit">Login</button>
        </form>

        <p>New User? <a href="CustomerRegist.jsp">Register</a></p>
    </div>

</div>


<%@ include file="footer.jsp" %>
</body>
</html>