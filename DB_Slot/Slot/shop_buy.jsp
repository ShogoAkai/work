<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, pnw.Slot.*"%>
<html>  
    <head>
        <meta charset="UTF-8">
        <title>shop</title>
    </head>      
<body>
<h1>shop</h1>
<table border="1">
<tr>
    <td>商品ID</td>
    <td>アイテム名</td>
    <td>価格</td>
</tr>
<%
ArrayList<ShopInfoBean> list = (ArrayList<ShopInfoBean>)request.getAttribute("shoplist");
Iterator<ShopInfoBean> ite = list.iterator();
%>
<h1>所持ポイント<%=session.getAttribute("Point")%></h1>
<%
while(ite.hasNext()){
    //Point: Iteratorの次の要素をbeanへ格納させてください．
    ShopInfoBean bean = ite.next();
%>
    <tr>
    <td><%=bean.getGoodsID()%></td>
    <td><%=bean.getItemName()%></td>
    <td><%=bean.getItemPrice()%></td>
    </tr>
<%
}
%>
</table>
<hr/>
<form action="ShopListShowServlet" method="get">
<input type="number" name="id" placeholder="商品ID" required>
<input type="submit" name="btn" value="購入">
</form>
<a><%=session.getAttribute("shop_buy_text")%></a>
<a href="UpdatePointsServlet">戻る</a>
</body>
</html>