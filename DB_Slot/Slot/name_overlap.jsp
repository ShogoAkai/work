<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="ja">
    <head>
        <meta charset="utf-8">
        <title>登録失敗</title>
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
            .error-container {
                background-color: #fff;
                padding: 40px; /* パディングを増やす */
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                width: 400px; /* 幅を広げる */
                text-align: center;
            }
            .error-container h2 {
                color: red;
                margin-bottom: 30px; /* マージンを増やす */
            }
            .error-container p {
                margin-bottom: 30px; /* マージンを増やす */
                font-size: 16px;
            }
            .error-container button {
                display: block;
                width: 100%;
                padding: 15px; /* パディングを増やす */
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px; /* フォントサイズを増やす */
                margin: 10px 0; /* ボタン間のマージンを確保 */
            }
            .error-container button:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <div class="error-container">
            <h2>登録失敗</h2>
            <p>この名前は使えません、もう一度やり直してください。</p>
            <form action="user_entry.jsp" method="post">
                <button type="submit">新規登録画面に戻る</button>
            </form>
        </div>
    </body>
</html>
