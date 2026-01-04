<%@ page import="model.*, java.util.*, ClientDao.*,model.Clientmodel, java.util.*, model.Itemmodel,model.Ordersmodel" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<meta charset="UTF-8">
<title>GRAB MY FOOD</title>
<style>
/* RESET */
* {
    margin: 0;
    padding: 0;
    
    font-family: "Segoe UI", Arial, sans-serif;
}

/* BODY BACKGROUND */
body {
    background: url("images/loginback.webp") center/cover no-repeat fixed;
}

/* PAGE WRAPPER (WHITE GLASS LAYER) */
.page-wrapper {
    background: rgba(255,255,255,0.9);
    backdrop-filter: blur(6px);
    padding: 20px;
    border-radius: 18px;
}

/* HEADINGS */
h3 {
    text-align: center;
    margin: 25px 0;
    color: #e74c3c;
    letter-spacing: 1px;
}

/* DIVIDER */
hr {
    border: none;
    height: 2px;
    background: #ddd;
    margin: 30px 0;
}

/* NAVBAR */
#nav {
    background: #ffffff;
    padding: 18px 25px;
    border-radius: 16px;
    box-shadow: 0 10px 25px rgba(0,0,0,0.1);
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex-wrap: wrap;
    backdrop-filter: blur(0px);
     background: rgba(255, 255, 255, 0.65);
}

#restname h2 {
    color: #27ae60;
    font-style: italic;
}

#nav ul {
    list-style: none;
    display: flex;
    gap: 12px;
    flex-wrap: wrap;
}

#nav ul li a {
    text-decoration: none;
    padding: 8px 16px;
    background: #f3f4f6;
    border-radius: 25px;
    color: #333;
    font-weight: 600;
    transition: 0.3s;
}

#nav ul li a:hover {
    background: #e74c3c;
    color: #fff;
}

/* ITEMS GRID */
#items ul {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(260px, 1fr));
    gap: 25px;
}

#items li {
    list-style: none;
    background: #ffffff;
    padding: 20px;
    border-radius: 18px;
    box-shadow: 0 10px 25px rgba(0,0,0,0.12);
    transition: transform 0.3s;
    backdrop-filter: blur(0px);
     background: rgba(255, 255, 255, 0.65);
}

#items li:hover {
    transform: translateY(-6px);
}

/* ITEM TEXT */
#items li span {
    display: block;
    margin-bottom: 8px;
    color: #444;
}

/* FORMS */
form {
    margin-top: 12px;
}

input[type="text"] {
    width: 100%;
    padding: 10px;
    margin-top: 6px;
    border-radius: 10px;
    border: 1px solid #ccc;
}

input:focus {
    outline: none;
    border-color: #e74c3c;
}

/* BUTTONS */
button {
    padding: 10px 18px;
    border: none;
    border-radius: 25px;
    background: #e74c3c;
    color: white;
    font-weight: bold;
    cursor: pointer;
    transition: 0.3s;
}

button:hover {
    background: #c0392b;
}

/* ADD ITEM FORM */
form[action="AdditemServlet"] {
    background: #ffffff;
    padding: 25px;
    border-radius: 18px;
    max-width: 420px;
    margin: auto;
    box-shadow: 0 10px 25px rgba(0,0,0,0.12);
    backdrop-filter: blur(0px);
     background: rgba(255, 255, 255, 0.65);
}

/* PROFILE CARD */
#profile {
    background: #ffffff;
    padding: 25px;
    border-radius: 18px;
    box-shadow: 0 10px 25px rgba(0,0,0,0.12);
    max-width: 500px;
    margin: auto;
    line-height: 1.9;
    backdrop-filter: blur(0px);
     background: rgba(255, 255, 255, 0.65);
}

/* TABLE */
table {
    width: 100%;
    border-collapse: collapse;
    background: #ffffff;
    border-radius: 18px;
    overflow: hidden;
    box-shadow: 0 10px 25px rgba(0,0,0,0.12);
}

table th {
    background: #e74c3c;
    color: white;
    padding: 14px;
}

table td {
    padding: 12px;
    text-align: center;
    border-bottom: 1px solid #eee;
}

/* RESPONSIVE */
@media (max-width: 768px) {
    #nav {
        flex-direction: column;
        gap: 15px;
    }
}


</style>

</head>
<body>
<div class="page-wrapper">
<% Clientmodel cm= (Clientmodel)session.getAttribute("client");
session.setAttribute("client",cm);
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
<div id="restname" style="font-style: italic; color:lime;"><h2><%=cm.getRestname() %></h2></div>
<divid="nav-btn">
<ul>
<li><a href="#items"><i class="fa fa-home"></i>Home</a></li>
<li><a href="#orderslist"><i class="fa fa-receipt"></i>Orders</a></li>
<li><a href="#history"><i class="fa fa-clock"></i>History</a></li>
<li><a href="#profile"><i class="fa fa-user"></i>Profile</a></li>
<li><a href="Clientlogout"><i class="fa fa-sign-out-alt"></i>Logout</a></li>
<li><a href="Clientstatus?id=<%=cm.getId()%>&status=<%=cm.getStatus()%>"><%=cm.getStatus() %></a></li>
</ul>
</div>
</div>
<hr>
<div id="items">
<h3>ITEMS</h3>
<% ClientDaoInter dao= new ClientDaoclass();
List<Itemmodel> list= dao.getitemlist(cm.getId()); 
if(list.size()>0){%>
<ul>
<% for(Itemmodel i:list){ %>
<li style="border: 1px solid, margin:5px; color:black;">
  <span><b>Item:</b> <%=i.getIname()%></span>
<span><b>Price:</b> ₹<%=i.getIprice()%></span>
<span><b>Description:</b> <%=i.getDes()%></span>
<span><b>Status:</b> <%=i.getStatus()%></span>

   <form action="Itemupdate.jsp?id=<%=i.getId() %>">
      <input type="hidden" name="id" value="<%= i.getId()%>">
   
   <button>UPDATE</button>
   </form>
       <form action="Deleteitem">
   <input type="hidden" name="id" value="<%= i.getId()%>">
   <button>DELETE</button>
   </form>
</li>
<%} %>
</ul>
<%}else{ %>
<h4 style="color:red">THERE IS NO ITEMS ADDED PLEASE ADD</h4>
<%} %>
</div>
<hr>
<h3>ADD ITEM</h3>
<form Action="AdditemServlet" method="post">
<input type="hidden" name="irestid" value="<%= cm.getId()%>">
ITEAM NAME : <input type="text" id="iname" name="iname">
PRICE : <input type="text" id="iprice" name="iprice">
DESCRIPTION : <input type="text" id="ides" name="ides">
<button type="submit">ADD</button>
</form>
<hr>
<div style="border:2px solid" id="profile">
<h3>PROFILE</h3>
RESTURANT NAME: <%=cm.getRestname() %><br>
CONTACT NUMBER : <%=cm.getContact() %><br>
REST ID : <%=cm.getId() %>
ADDRESS : <%=cm.getAddress() %>
STATUS  : <%=cm.getStatus() %>
<form action="UpdateClientServlet.jsp" method="post">
    <input type="hidden" name="id" value="<%= cm.getId()%>">
    <button type="submit">UPDATE</button>
</form>

<form action="DeleteClientServlet" method="post">
    <input type="hidden" name="id" value="<%= cm.getId()%>">
    <button type="submit"
            onclick="return confirm('Are you sure you want to delete?')">
        DELETE
    </button>
</form>
</div>
<hr>
<div id="orderslist">
<h3>ORDERS LIST</h3>
<% List<Ordersmodel> olist = dao.clientorders(cm.getId());
 if(olist.size()>0){
%>
<table>
<tr>
<th>OEDER ID</th>
<th>ITEM ID</th>
<th>CUSTOMER ID</th>
<th>STATUS</th>
</tr>
<%for(Ordersmodel i : olist){ %>

<tr>
<td><%=i.getId() %></td>
<td><%=i.getItemid() %></td>
<td><%=i.getCustomerid() %></td>
<td><%=i.getStatus() %></td>
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
<h3>HISTORY LIST</h3>
<% List<Ordersmodel> hlist = dao.clienthist(cm.getId());
 if(olist.size()>0){
%>
<table>
<tr>
<th>OEDER ID</th>
<th>ITEM ID</th>
<th>CUSTOMER ID</th>
<th>STATUS</th>
</tr>
<%for(Ordersmodel i : olist){ %>

<tr>
<td><%=i.getId() %></td>
<td><%=i.getItemid() %></td>
<td><%=i.getCustomerid() %></td>
<td><%=i.getStatus() %></td>
</tr>
<%} %>

</table>
<%
 } else{
%>
<h3 style="color:red">NO ORDERS</h3>
<%} %>
</div>
<%@ include file="footer.jsp" %>
</div>
</body>
</html>