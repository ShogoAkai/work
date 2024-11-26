<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, pnw.Slot.*"%>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>ランキング表示</title>
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
    <h1>あなたの得点: <%= session.getAttribute("Point")%>点</h1>
    
    <!-- <h2>ランキング</h2> -->
    <table border="1">
        <tr>
            <td>順位</td>
            <td>User Name</td>
            <td>Point</td>
        </tr>
        <%
        ArrayList<UserPointBean> list = (ArrayList<UserPointBean>)session.getAttribute("userlist");
        String currentUser = (String) session.getAttribute("username"); // Assume username is stored in session
        int userRank = -1;
        int userPoint = -1;
        Iterator<UserPointBean> ite = list.iterator();
        int num = 1 ;
        while(ite.hasNext() && num <= 10){
            UserPointBean bean = ite.next();
            if(bean.getID().equals(currentUser)){
                userRank = num;
                userPoint = bean.getpoint();
            }
        %>
            <tr>
                <td><%=num %></td>
                <td><%=bean.getID()%></td>
                <td><%=bean.getpoint()%></td>
            </tr>
        <%
            num += 1; 
        }
        %>
    </table>

    <%
    // Display user's rank if not in top 10
    if(userRank == -1){
        ite = list.iterator();
        num = 1;
        while(ite.hasNext()){
            UserPointBean bean = ite.next();
            if(bean.getID().equals(currentUser)){
                userRank = num;
                userPoint = bean.getpoint();
                break;
            }
            num += 1;
        }
    }
    %>
    <!-- <h2>あなたの順位: <%=userRank %> 位</h2>
    <h2>あなたの得点: <%=userPoint %> 点</h2> -->
    
    <a href="home.jsp">home</a>
</body>
</html>
