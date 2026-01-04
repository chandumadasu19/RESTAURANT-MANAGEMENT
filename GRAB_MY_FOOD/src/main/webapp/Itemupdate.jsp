<%@ page import="model.Clientmodel, java.util.*, model.Itemmodel, ClientDao.*" language="java" contentType="text/html; charset=UTF-8"
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

    h3 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
    }

    form {
        width: 380px;
        margin: auto;
        padding: 20px;
        background-color: white;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0,0,0,0.15);
     
           backdrop-filter: blur(0px);
     background: rgba(255, 255, 255, 0.65);
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
        background-color: #007bff;
        border: none;
        color: white;
        font-size: 15px;
        border-radius: 5px;
        cursor: pointer;
    }

    form button:hover {
        background-color: #0056b3;
    }
</style>

<meta charset="UTF-8">
<title>GRAB MY FOOD</title>
</head>
<body>
<% 
Clientmodel cm=(Clientmodel) session.getAttribute("client");
Integer id=Integer.parseInt(request.getParameter("id"));
%>
<h3 style=" color:gold">  GRAB MY FOOD </h3><hr>
<h3 style=" color:white;" >UPDADING ITEM DETAILS:</h3>
<form Action="updateitem" method="post">
<input type="hidden" name="id" value="<%= id%>">
ITEAM NAME : <input type="text" id="iname" name="iname">
PRICE : <input type="text" id="iprice" name="iprice">
DESCRIPTION : <input type="text" id="ides" name="ides">
STATUS     : <input type="text" id="istatus" name="istatus">
<button type="submit">UPDATE</button>
</form>

</body>
</html>