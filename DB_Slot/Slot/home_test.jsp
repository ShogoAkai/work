<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, pnw.Slot.*"%>
<html lang="ja">
    <head>
        <meta charset="utf-8">
        <title>ホーム画面</title>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400;700&display=swap');

            body {
                font-family: 'Noto Sans JP', sans-serif;
                margin: 0;
                padding: 0;
                overflow-x: hidden; /* 横スクロールバーを隠す */
            }
            .container {
                width: 80%;
                margin: auto;
                padding: 20px;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                background-color: #4CAF50;
                color: white;
                padding: 10px 20px;
            }
            .mypage-icon {
                cursor: pointer;
                font-size: 24px;
            }
            .sidebar {
                height: 100%;
                width: 250px; /* 固定幅に変更 */
                position: fixed;
                top: 0;
                left: -250px; /* 初期状態でサイドバーを隠す */
                background-color: #333;
                overflow-x: hidden;
                transition: left 0.5s; /* left位置の変化のみをアニメーション */
                padding-top: 60px;
                z-index: 1;
            }
            .sidebar h1 {
                color: white; 
            }
            .sidebar a {
                padding: 10px 15px;
                text-decoration: none;
                font-size: 22px;
                color: #818181;
                display: block;
                transition: color 0.3s; /* colorの変化のみをアニメーション */
            }
            .sidebar a:hover {
                color: #f1f1f1;
            }
            .closebtn {
                position: absolute;
                top: 20px;
                right: 25px;
                font-size: 36px;
                margin-left: 50px;
            }
            .main-content {
                transition: margin-left 0.5s;
                padding: 16px;
            }
            .button {
                display: block;
                width: 200px;
                padding: 10px;
                margin: 10px auto;
                background-color: #4CAF50;
                color: white;
                text-align: center;
                text-decoration: none;
                border-radius: 5px;
                transition: background-color 0.3s ease;
            }
            .button:hover {
                background-color: #4CAF50;
            }
            .grid-container {
                display: grid;
                grid-template-columns: 1fr 1fr;
                grid-template-rows: 1fr 1fr;
                gap: 20px;
                height: 60vh;
                margin: 20px 0;
            }
            .grid-item {
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                border: 1px solid #ddd;
                border-radius: 5px;
                padding: 20px;
                background-color: #f9f9f9;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
        </style>
    </head>
    <body>
        <div class="sidebar" id="mySidebar">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
            <h1>マイページ</h1>
            <a href="shop_buy.jsp">アイテム販売</a>
            <a href="shop_sell.jsp">アイテム購入</a>
            <a href="use_item.jsp">所持アイテム</a>
            <a href="user_login.jsp">ログアウト</a>
        </div>

        <div class="main-content">
            <header>
                <div class="logo">
                    <h1>ホームページ</h1>
                </div>
                <div class="mypage-icon" onclick="openNav()">☰</div>
            </header>
            <div class="container">
                <h2>ようこそ、 <%= session.getAttribute("UName")%>さん！</h2>
                <h2>ようこそ、 <%= session.getAttribute("User_ID")%>さん！</h2>
                <p>ここはホームページのメインコンテンツです。</p>
            </div>
            <div class="container">
                <h1>ホーム画面</h1>
                <div class="grid-container">
                    <div class="grid-item">
                        <a href="slot.jsp" class="button">スロット</a>
                        <p>運を試してみよう！</p>
                    </div>
                    <div class="grid-item">
                        <a href="gacha.jsp" class="button">ガチャ</a>
                        <p>素敵なアイテムをゲット！</p>
                    </div>
                    <div class="grid-item">
                        <a href="ShopListShowServlet" class="button">ショップ</a>
                        <p>アイテムを購入しましょう。</p>
                    </div>
                    <div class="grid-item">
                        <a href="RankingServlet" class="button">ランキング</a>
                        <p>自分のランキングを確認してみよう！</p>
                    </div>
                </div>
            </div>
        </div>

        <script>
            function openNav() {
                document.getElementById("mySidebar").style.left = "0";
                document.querySelector(".main-content").style.marginLeft = "250px";
            }

            function closeNav() {
                document.getElementById("mySidebar").style.left = "-250px";
                document.querySelector(".main-content").style.marginLeft = "0";
            }
        </script>
    </body>
</html>
