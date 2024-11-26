<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="ja">
    <head>
        <meta charset="utf-8">
        <title>新規ユーザ登録</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                background-color: #f0f0f0;
            }
            .entry-container {
                background-color: #fff;
                padding: 40px; /* パディングを増やす */
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                width: 400px; /* 幅を広げる */
            }
            .entry-container h2 {
                margin-bottom: 30px; /* マージンを増やす */
            }
            .entry-container input {
                display: block;
                width: 100%;
                padding: 15px; /* パディングを増やす */
                margin: 15px 0; /* マージンを増やす */
                border-radius: 5px;
                border: 1px solid #ddd;
                font-size: 16px; /* フォントサイズを増やす */
            }
            .entry-container button {
                display: block;
                width: 100%;
                padding: 15px; /* パディングを増やす */
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px; /* フォントサイズを増やす */
                margin-top: 15px; /* ボタン間のマージンを確保 */
            }
            .entry-container button:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <div class="entry-container">
            <h2>新規ユーザ登録</h2>
            <form action="UserEntryServlet" method="post">
                <input type="text" name="userName" placeholder="ユーザネーム" required>
                <input type="password" name="password" placeholder="パスワード" required>
                <!-- <input type="text" name="dateBirth" placeholder="生年月日 (yyyy-mm-dd)" required> -->
                <button type="submit">登録</button>
            </form>
        </div>
    </body>
</html>
