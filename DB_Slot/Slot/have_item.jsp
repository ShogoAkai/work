<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, pnw.Slot.*"%>
<html>  
    <head>
        <meta charset="UTF-8">
        <title>所持アイテム</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                padding: 20px;
            }
            h1 {
                text-align: center;
                color: #333;
            }
            table {
                width: 50%;
                margin: 20px auto;
                border-collapse: collapse;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0,0,0,0.1);
            }
            table th, table td {
                border: 1px solid #ccc;
                padding: 10px;
                text-align: center;
            }
            table th {
                background-color: #f0f0f0;
                color: #333;
            }
            table tbody tr:nth-child(even) {
                background-color: #f9f9f9;
            }
            table tbody tr:hover {
                background-color: #f0f0f0;
            }
            a {
                display: block;
                width: 100px;
                text-align: center;
                padding: 10px;
                background-color: #4CAF50;
                color: #fff;
                text-decoration: none;
                margin: 20px auto;
                border-radius: 5px;
            }
            a:hover {
                background-color: #4CAF50;
            }
        </style>
    </head>      
<body>
<h1>所持アイテム</h1>
<table border="1">
<tr>
    <td>アイテム名</td>
    <td>所持数</td>
</tr>
<%
ArrayList<Integer> list = (ArrayList<Integer>)request.getAttribute("itemlist");
Iterator<Integer> ite = list.iterator();
%>
    <tr>
    <td>ノーマル</td>
    <td><%=ite.next()%></td>
    </tr>
    <tr>
    <td>レア</td>
    <td><%=ite.next()%></td>
    </tr>
    <tr>
    <td>スーパーレア</td>
    <td><%=ite.next()%></td>
    </tr>
</table>
<hr/>
<a href="UpdatePointsServlet">戻る</a>
</body>
</html>