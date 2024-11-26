<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>所持しているアイテム一覧</title>
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
    <h1>所持しているアイテム一覧</h1>
    
    <%-- アイテムのリストをマップで定義 --%>
    <% Map<String, Integer> itemMap = new HashMap<>(); %>
    <% itemMap.put("アイテムA", 3); %>
    <% itemMap.put("アイテムB", 5); %>
    <% itemMap.put("アイテムC", 2); %>
    
    <%-- アイテム一覧をテーブルで表示 --%>
    <table>
        <thead>
            <tr>
                <th>アイテム名</th>
                <th>個数</th>
            </tr>
        </thead>
        <tbody>
            <%-- アイテムマップをループして表示 --%>
            <% for (Map.Entry<String, Integer> entry : itemMap.entrySet()) { %>
                <tr>
                    <td><%= entry.getKey() %></td>
                    <td><%= entry.getValue() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
    
    <a href="home.jsp">Home</a>
</body>
</html>
