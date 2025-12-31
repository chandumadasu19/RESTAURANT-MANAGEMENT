<%@ page import="model.*,CustmDao.*,java.util.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0 10px;
    }

    h3 {
        text-align: center;
        margin-top: 20px;
    }

    hr {
        margin: 20px 0;
    }

    /* NAVBAR */
    #nav {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: #222;
        padding: 10px 20px;
        border-radius: 5px;
    }

    #nav h2 {
        margin: 0;
        color: lime;
    }

    #nav ul {
        list-style: none;
        margin: 0;
        padding: 0;
        display: flex;
    }

    #nav ul li {
        margin-left: 15px;
    }

    #nav ul li a {
        text-decoration: none;
        color: white;
        font-weight: bold;
    }

    #nav ul li a:hover {
        color: gold;
    }

    /* RESTAURANT LIST */
    ul {
        padding: 0;
    }

    ul li {
        list-style: none;
        margin: 10px 0;
        padding: 10px;
        background-color: white;
        border-radius: 5px;
    }

    ul li:hover {
        background-color: #e9f5ff;
    }

    /* TABLES */
    table {
        width: 100%;
        border-collapse: collapse;
        background-color: white;
        margin-top: 10px;
    }

    table th {
        background-color: #007bff;
        color: white;
        padding: 8px;
    }

    table td {
        padding: 8px;
        text-align: center;
        border-bottom: 1px solid #ddd;
    }

    /* PROFILE SECTION */
    #profile {
        background-color: white;
        padding: 15px;
        border-radius: 5px;
        margin-top: 10px;
    }

    #profile button {
        margin-top: 10px;
        padding: 8px 15px;
        background-color: #28a745;
        border: none;
        color: white;
        border-radius: 4px;
        cursor: pointer;
    }

    #profile button:hover {
        background-color: #1e7e34;
    }
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Custommodel cm= (Custommodel)session.getAttribute("custom");
session.setAttribute("custom",cm);
String msg= (String) request.getAttribute("msg");
if(msg!=null){
	 %>
	 <script > window.alert(" <%= msg%>  "); </script>
	 <%
}
%>
<h3 style=" color:gold">  GRAB MY FOOD </h3>
<hr>

<div id="nav">
<div id="restname" style="font-style: italic; color:lime;"><h2><%=cm.getUsername() %></h2></div>
<divid="nav-btn">
<ul style="color:black">
<li><a href=#items>HOME</a></li>
<li><a href="#orderslist">ORDERS</a></li>
<li><a href="#history">HISTORY</a></li>
<li><a href="#profile">PROFILE</a></li>
<li><a href="Customlogout">LOGOUT</a></li>
</ul>
</div>
</div>
<hr>
<h3>RESTIARANTUS LIST</h3>
<% CustomDaoInter dao = new CustomDaoClass();
List<Clientmodel> rlist= dao.getRestlist();
if(rlist.size()>0){%>
<ul>
<% for(Clientmodel i: rlist){ 
if(i.getStatus().equalsIgnoreCase("active")){
%>
<a href="customrest.jsp?restid=<%=i.getId()%>&rname=<%=i.getRestname()%>"><li style="border:1px solid;">
RESTAURANT NAME: <%=i.getRestname() %>
ADDRESS        : <%=i.getAddress() %>
Status         : <%= i.getStatus() %>
 </li>
 </a>
 <%}else{ %>
 <a href="#" onclick=alert("RESTURANT IS NOT ACCEPTING ORDERS")>
 <li style="border:1px solid; color:gray;">
RESTAURANT NAME: <%=i.getRestname() %>
ADDRESS        : <%=i.getAddress() %>
Status         : <%= i.getStatus() %>
 </li>
 </a>S
 <%} } %>
</ul>

<%}else{ %>
<h3 style="color:red">NO RESTARUNTS</h3>
<%} %>
<hr>
<div id="orders">
<h3>RUNNING ORDERS</h3>
<% List<Ordersmodel> olist=dao.getolist(cm.getId()); 
if(olist.size()>0){%>
<table>
<tr>
<th>OEDER ID</th>
<th>QUENTITY</th>
<th>PRICE</th>
<th>ITEM ID</th>
<th>CLIENT ID</th>
</tr>
<%for(Ordersmodel i : olist){ %>

<tr>
<td><%=i.getId() %></td>
<td><%=i.getQty() %></td>
<td><%=i.getPrice() %></td>
<td><%=i.getItemid() %></td>
<td><%=i.getClientid() %></td>
</tr>
<%} %>

</table>
<%
 } else{
%>
<h3 style="color:red">NO CURRENT ORDERS</h3>
<%} %>
</div>
<hr>
<div id="history">
<h3>HISTORY OF MY ORDERS</h3>
<% List<Ordersmodel> hlist = dao.customhist(cm.getId());
 if(olist.size()>0){
%>
<table>
<tr>
<th>OEDER ID</th>
<th>QUENTITY</th>
<th>PRICE</th>
<th>ITEM ID</th>
<th>CLIENT ID</th>
</tr>
<%for(Ordersmodel i : olist){ %>

<tr>
<td><%=i.getId() %></td>
<td><%=i.getQty() %></td>
<td><%=i.getPrice() %></td>
<td><%=i.getItemid() %></td>
<td><%=i.getClientid() %></td>
</tr>
<%} %>

</table>
<%
 } else{
%>
<h3 style="color:red">NO ORDERS</h3>
<%} %>
</div>
<hr>
<div  style="border:2px solid" id="profile">
<h3>USER PROFILE: </h3>
USER NAME    :  <%=cm.getUsername() %>
CONTACT NUM  :  <%=cm.getContact() %>
ADDRESS      :  <%= cm.getAddress() %>
ID           :  <%=cm.getId() %>
<form action="UpdateCustom.jsp" method="post">
    <input type="hidden" name="id" value="<%= cm.getId()%>">
    <button type="submit">UPDATE</button>
</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>