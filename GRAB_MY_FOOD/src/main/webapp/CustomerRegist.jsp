<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f6f8;
        background: url("images/loginback.webp") center/cover no-repeat fixed;
    padding: 20px;
    color: #111827;
    }

    #RegistForm {
        width: 350px;
        margin: 80px auto;
        padding: 20px;
        background-color: #ffffff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);
        backdrop-filter: blur(0px);
     background: rgba(255, 255, 255, 0.65);
    }

    #RegistForm h3 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    #RegistForm input {
        width: 100%;
        padding: 8px;
        margin: 8px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    #RegistForm button {
        width: 100%;
        padding: 10px;
        margin-top: 10px;
        background-color: #28a745;
        border: none;
        color: white;
        font-size: 15px;
        border-radius: 4px;
        cursor: pointer;
    }

    #RegistForm button:hover {
        background-color: #1e7e34;
    }
</style>

<meta charset="UTF-8">

<title>GRAB MY FOOD</title>
</head>
<body>
<% String msg= (String) request.getAttribute("msg");
if(msg!=null){
	 %>
	 <script > window.alert(" <%= msg%>  "); </script>
	 <%
}
%>
<h3 style=" color:gold">  GRAB MY FOOD </h3>
<div id="RegistForm">
<h3>Customer Registration</h3>
<form action="CustomerRegistServlet" method="post">
UserName: <input type="text" id="uname" name="uname">
Contact Number: <input type="text" id="contact" name="contact">
Address: <input type="text" id="address" name="address">
Password: <input type="text" id="pasword" name="password">
<button type="submit">Register</button>
</form>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>