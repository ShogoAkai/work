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
    <td>UserID</td>
    <td>ItemID</td>
    <td>ItemPrice</td>
    <td>ItemName</td>
</tr>
<%
ArrayList<ShopInfoBean> list = (ArrayList<ShopInfoBean>)request.getAttribute("shoplist");
Iterator<ShopInfoBean> ite = list.iterator();
%>
<h1><%=list.get(0)%></h1>
//結果の表示
<%
while(ite.hasNext()){
    //Point: Iteratorの次の要素をbeanへ格納させてください．
    ShopInfoBean bean = ite.next();
%>
    <tr>
    <td><%=bean.getUserID()%></td>
    <td><%=bean.getItemID()%></td>
    <td><%=bean.getItemPrice()%></td>
    <td><%=bean.getItemName()%></td>
    </tr>
<%
}
%>
</table>
<hr/>
追加の場合は,IDは自動設定されるので指定しないでください．
更新と削除は，ID指定が必須．
<%-- Point: actionの先を，pnwのex06の中にある，KadaiListProcessServletへ転送されるようにしてください．ヒント: 相対パス--%>
<!-- <form action="./ShopListProcessServlet" method="post">
ID: <input type="text" name="id"><br>
ユーザ名：<input type="text" name="userid" ><br>
パスワード：<input type="password" name="pass" ><br>
<input type="submit" name="btn" value="追加">
<input type="submit" name="btn" value="更新">
<input type="submit" name="btn" value="削除">
</form> -->
<a href="UpdatePointsServlet">戻る</a>
</body>
</html>