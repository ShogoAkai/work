<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="ja">
    <head>
        <meta charset="utf-8">
        <title>ユーザログイン</title>
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
            .login-container {
                background-color: #fff;
                padding: 40px; /* パディングを増やす */
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                width: 400px; /* 幅を広げる */
            }
            .login-container h2 {
                margin-bottom: 30px; /* マージンを増やす */
            }
            .login-container input {
                display: block;
                width: 100%;
                padding: 15px; /* パディングを増やす */
                margin: 15px 0; /* マージンを増やす */
                border-radius: 5px;
                border: 1px solid #ddd;
                font-size: 16px; /* フォントサイズを増やす */
            }
            .login-container button {
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
            .login-container button:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <div class="login-container">
            <h2>ユーザログイン</h2>
            <form action="LoginServlet" method="get">
                <input type="text" name="Username" placeholder="ユーザネーム" required>
                <input type="password" name="Password" placeholder="パスワード" required>
                <button type="submit">ログイン</button>
            </form>
            <form action="user_entry.jsp" method="post">
                <button type="submit">新規登録へ</button>
            </form>
        </div>
    </body>
</html>
