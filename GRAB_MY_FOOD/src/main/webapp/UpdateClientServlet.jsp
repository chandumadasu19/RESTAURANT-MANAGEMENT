<%@ page import="model.Clientmodel, java.util.*, model.Itemmodel, ClientDao.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f6f8;
        margin: 0;
        padding: 20px;
    }

    h3 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
    }

    form {
        width: 400px;
        margin: auto;
        padding: 20px;
        background-color: #ffffff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0,0,0,0.15);
    }

    form input {
        width: 100%;
        padding: 8px;
        margin: 8px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    form button {
        width: 100%;
        padding: 10px;
        margin-top: 12px;
        background-color: #28a745;
        border: none;
        color: white;
        font-size: 15px;
        border-radius: 5px;
        cursor: pointer;
    }

    form button:hover {
        background-color: #1e7e34;
    }
</style>

<body>
<% 
Clientmodel cm=(Clientmodel) session.getAttribute("client");
Integer id=Integer.parseInt(request.getParameter("id"));
%>
<h3>Client Updatesion page</h3>
<form action="Updateclient" method="post">
<input type="hidden" id="id" name="id" value="<%=id%>">
Restuarant Name: <input type="text" id="restname" name="restname">
Contact Number: <input type="text" id="contact" name="contact">
Address: <input type="text" id="address" name="address">
Password: <input type="text" id="pasword" name="password">
<button type="submit">UPDATE</button>
</form>
</body>
</html>