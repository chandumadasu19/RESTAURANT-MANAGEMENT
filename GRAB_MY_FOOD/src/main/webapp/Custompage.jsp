<%@ page import="model.*,CustmDao.*,java.util.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>  
<style type="text/css">
/* ===== RESET ===== */
* {
    margin: 0;
    padding: 0;
   
    font-family: system-ui, -apple-system, BlinkMacSystemFont, sans-serif;
}

/* ===== BODY ===== */
body {
    background: url("images/loginback.webp") center/cover no-repeat fixed;
    padding: 20px;
    margin-left: 200px;
    color: #111827;
    width: 60%;
}

/* ===== PAGE TITLE ===== */
h3 {
    text-align: center;
    margin: 20px 0;
    font-weight: 600;
}

h3[style*="gold"] {
    font-size: 24px;
}

/* ===== NAVBAR ===== */
#nav {
    background: #ffffff;
    border: 1px solid #e5e7eb;
    border-radius: 10px;
    padding: 14px 22px;
    display: flex;
    justify-content: space-between;
    align-items: center;
     background: rgba(255, 255, 255, 0.8);
    backdrop-filter: blur(0px);
}

#restname h2 {
    color: #dc2626;
    font-style: italic;
}

#nav ul {
    list-style: none;
    display: flex;
    gap: 14px;
}

#nav ul li a {
    text-decoration: none;
    color: #374151;
    padding: 6px 10px;
    border-radius: 6px;
    font-size: 14px;
}

#nav ul li a:hover {
    background: #f3f4f6;
}

/* ===== DIVIDER ===== */
hr {
    border: none;
    height: 1px;
    background: #e5e7eb;
    margin: 30px 0;
}

/* ===== SECTIONS ===== */
#orders, #history, #profile {
    background: #ffffff;
    border: 1px solid #e5e7eb;
    border-radius: 10px;
    padding: 20px;
    margin-top: 20px;
     background: rgba(255, 255, 255, 0.8);
    backdrop-filter: blur(0px);
}

/* ===== RESTAURANT LIST ===== */
ul {
    list-style: none;
    margin-top: 18px;
}

ul li {
    background: #ffffff;
    padding: 14px 18px;
    border-radius: 8px;
    border: 1px solid #e5e7eb;
    margin-bottom: 10px;
    font-size: 14px;
}

ul li:hover {
    background: #f9fafb;
}

ul li[style*="gray"] {
    background: #f3f4f6;
    color: #9ca3af;
}

/* ===== TABLE ===== */
table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 14px;
}

th {
    background: #f9fafb;
    padding: 10px;
    font-size: 13px;
    text-align: left;
}

td {
    padding: 10px;
    border-top: 1px solid #e5e7eb;
    font-size: 13px;
}

/* ===== BUTTON ===== */
button {
    margin-top: 16px;
    padding: 10px;
    width: 100%;
    background: #dc2626;
    color: white;
    border: none;
    border-radius: 6px;
    font-size: 14px;
    cursor: pointer;
}

button:hover {
    background: #b91c1c;
}

/* ===== ERROR ===== */
h3[style*="red"] {
    color: #dc2626 !important;
}
ul li {
    background: rgba(255, 255, 255, 0.8);
    backdrop-filter: blur(0px);
    -webkit-backdrop-filter: blur(0px);
    padding: 14px 18px;
    border-radius: 8px;
    border: 1px solid rgba(255,255,255,0.4);
    margin-bottom: 10px;
}

</style>

<meta charset="UTF-8">
<title>GRAB MY FOOD</title>
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
<li><a href="#items"><i class="fa-solid fa-house"></i> Home</a></li>
<li><a href="#orderslist"><i class="fa-solid fa-bag-shopping"></i> Orders</a></li>
<li><a href="#history"><i class="fa-solid fa-clock-rotate-left"></i> History</a></li>
<li><a href="#profile"><i class="fa-solid fa-user"></i> Profile</a></li>
<li><a href="Customlogout"><i class="fa-solid fa-right-from-bracket"></i> Logout</a></li>

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