<%@ page import="model.*,CustmDao.*,java.util.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f6f8;
        margin: 0;
        padding: 15px;
    }

    h3 {
        text-align: center;
        margin-top: 15px;
    }

    hr {
        margin: 20px 0;
    }

    /* ITEM LIST */
    ul {
        padding: 0;
        display: flex;
        flex-wrap: wrap;
        gap: 15px;
        justify-content: center;
    }

    ul li {
        list-style: none;
        width: 260px;
        padding: 15px;
        background-color: white;
        border-radius: 8px;
        box-shadow: 0 0 8px rgba(0,0,0,0.1);
    }

    ul li h5 {
        margin: 5px 0;
        color: #333;
    }

    ul li input[type="number"] {
        width: 60px;
        padding: 5px;
        margin-top: 8px;
    }

    ul li button {
        margin-left: 10px;
        padding: 6px 12px;
        background-color: #007bff;
        border: none;
        color: white;
        border-radius: 4px;
        cursor: pointer;
    }

    ul li button:hover {
        background-color: #0056b3;
    }

    /* CART SECTION */
    #cart {
        margin-top: 30px;
        padding: 15px;
        background-color: white;
        border-radius: 8px;
        box-shadow: 0 0 8px rgba(0,0,0,0.1);
    }

    #cart table {
        margin: auto;
        border-collapse: collapse;
        width: 60%;
    }

    #cart th {
        background-color: #28a745;
        color: white;
        padding: 8px;
    }

    #cart td {
        padding: 8px;
        text-align: center;
        border-bottom: 1px solid #ddd;
    }

    #cart h3 {
        margin-top: 15px;
    }

    #cart button {
        display: block;
        margin: 15px auto;
        padding: 10px 20px;
        background-color: #ff9800;
        border: none;
        color: white;
        font-size: 15px;
        border-radius: 5px;
        cursor: pointer;
    }

    #cart button:hover {
        background-color: #e68900;
    }
</style>

</head>
<body>

<% Custommodel cm= (Custommodel)session.getAttribute("custom");
session.setAttribute("custom",cm);
String rname= request.getParameter("rname");
int rid=Integer.parseInt(request.getParameter("restid"));
%>
<h3 style=" color:gold">  GRAB MY FOOD </h3>
<hr>
<h3><%=rname %> ITEAMS LIST</h3>
<% CustomDaoInter dao = new CustomDaoClass();
List<Itemmodel> ilist= dao.getRestitems(rid);
if(ilist.size()>0){
%>
<ul>
<% for(Itemmodel i: ilist){ %>
<li Style="border:1px solid black;">
    <h5>ITEM NAME: <%=i.getIname() %></h5>
    <h5>ITEM PRICE: <%=i.getIprice() %></h5>
    <h5>DESCRIPTION: <%=i.getDes() %></h5>
     <input type="number" id="qty_<%=i.getId()%>" value="1" min="1">
     <button 
        type="button"
        onclick="addToCart('<%=i.getId()%>',
                           '<%=i.getIname()%>',
                           <%=i.getIprice()%>)">
        ADD
    </button>
</li>
<%} %>
</ul>
<%}else{ %>
<h3>  NO ITEMS IN THIS RESTUARANT</h3>
<%} %>

<hr>
<div id="cart">
    <h3>CART OF <%=rname %></h3>
    <table border="1" width="50%">
        <thead>
            <tr>
                <th>Item</th>
                <th>Price</th>
                <th>Qty</th>
                <th>Total</th>
            </tr>
        </thead>
        <tbody id="cartBody"></tbody>
    </table>

    <h3>Grand Total: ₹ <span id="grandTotal">0</span></h3>

    <form action="OrderServlet" method="post">
        <input type="hidden" name="cartData" id="cartData">
        <button type="submit">ORDER</button>
    </form>
</div>
<script>
    // cart object to store items
    let cart = {};

    function addToCart(id, name, price) {
        // get quantity value
        let qty = parseInt(document.getElementById("qty_" + id).value);

        // if item already exists, increase quantity
        if (cart[id]) {
            cart[id].qty += qty;
        } else {
            cart[id] = {
                id: id,
                name: name,
                price: price,
                qty: qty
            };
        }

        renderCart();
    }

    function renderCart() {
        let cartBody = document.getElementById("cartBody");
        cartBody.innerHTML = "";

        let grandTotal = 0;
        let cartArray = [];

        for (let id in cart) {
            let item = cart[id];
            let total = item.price * item.qty;
            grandTotal += total;
            console.log(item);

            cartBody.innerHTML += `
                <tr>
                    <td>${item.name}</td>
                    <td>₹ ${item.price}</td>
                    <td>${item.qty}</td>
                    <td>₹ ${total}</td>
                </tr>
            `;

            cartArray.push(item);
        }

        // update grand total
        document.getElementById("grandTotal").innerText = grandTotal;

        // send cart data to servlet as JSON
        document.getElementById("cartData").value = JSON.stringify(cartArray);
       
    }
</script>


<%@ include file="footer.jsp" %>
</body>
</html>