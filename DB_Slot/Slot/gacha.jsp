<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Capsule-Toy</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f0f0f0;
            padding: 20px;
        }
        .container {
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            max-width: 600px;
        }
        .output {
            font-size: 20px;
            margin-top: 20px;
        }
        button {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
            border-radius: 4px;
        }
        button:hover {
            background-color: #0056b3;
        }
        input[type="number"], input[type="password"] {
            padding: 8px;
            font-size: 16px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }
        input[type="number"]:focus, input[type="password"]:focus {
            outline: none;
            border-color: #007bff;
        }
        a {
            display: block;
            width: 100px;
            text-align: center;
            padding: 10px;
            background-color: #ec4d53;
            color: #fff;
            text-decoration: none;
            margin: 20px auto;
            border-radius: 5px;
        }
        a:hover {
            background-color: #ec4d53;
        }
    </style>
</head>
<form name = Form2 action="UpdatePointsServlet" method="get">
    <input type="hidden" name = normal id = "n" value=0>
    <input type="hidden" name = rare id = "r" value=0>
    <input type="hidden" name = srare id = "sr" value=0>
    <input type="hidden" name = point id = "pnt" value="<%= session.getAttribute("Point")%>">
</form>
<body>
<div class="container">
    <h2>Capsule-Toy</h2>
    <p>あなたのポイント: <span id="credit"><%= session.getAttribute("Point")%></span></p>
    <p>ガチャ1回につき、10ポイント消費します。</p>
    <img src="./images/gachagacha.png" alt="Gacha Machine"><br>
    <button onclick="playGacha()">Spin the Gacha</button>
    <div class="output" id="randomNumber"></div>
    <p>Rarity Count:</p>
    <ul id="rarityCount">
        <li>Rarity Super Rare: <span id="count3Stars">0</span></li>
        <li>Rarity Rare: <span id="count2Stars">0</span></li>
        <li>Rarity Normal: <span id="count1Star">0</span></li>
    </ul>
</div>

<div class="container">
    <h2>Add Credits</h2>
    <p>Administrator credits: <input type="number" id="adminCredits" min="0"></p>
    <p>Password: <input type="password" id="adminPassword"></p>
    <button onclick="addCredits()">Add Credits</button>
</div>

<script>
let count3Stars = 0;
let count2Stars = 0;
let count1Star = 0;

function playGacha() {
    const creditElement = document.getElementById("credit");
    let currentCredit = parseInt(creditElement.textContent);

    if (currentCredit >= 10) {
        const newCredit = currentCredit - 10;
        creditElement.textContent = newCredit;
        document.getElementById( "pnt" ).value = newCredit;

        let randomNumber = Math.floor(Math.random() * 100) + 1;

        if (randomNumber >= 1 && randomNumber <= 9) {
            const adjustedProbability = Math.random();
            if (adjustedProbability < 0.5) {
                randomNumber = Math.floor(Math.random() * 91) + 10;
            }
        }

        let rarity = '';
        if (randomNumber >= 1 && randomNumber <= 9) {
            rarity = 'Rarity: Super Rare';
            count3Stars++;
        } else if (randomNumber >= 10 && randomNumber <= 30) {
            rarity = 'Rarity: Rare';
            count2Stars++;
        } else {
            rarity = 'Rarity: Normal';
            count1Star++;
        }

        document.getElementById("randomNumber").innerHTML = "Capsule Number: " + randomNumber + '<br>' + rarity;
        updateRarityCount();
    } else {
        alert("Insufficient credits");
    }
}

function addCredits() {
    const adminCredits = parseInt(document.getElementById("adminCredits").value);
    const adminPassword = document.getElementById("adminPassword").value;

    if (adminPassword === "0000") {
        if (!isNaN(adminCredits) && adminCredits > 0) {
            const creditElement = document.getElementById("credit");
            const currentCredit = parseInt(creditElement.textContent);
            const newCredit = currentCredit + adminCredits;
            creditElement.textContent = newCredit;
            alert(adminCredits + " credit(s) added successfully.");
        } else {
            alert("Please enter a valid number of credits.");
        }
    } else {
        alert("Incorrect password. Unauthorized to add credits.");
    }
}

function updateRarityCount() {
    document.getElementById("count3Stars").textContent = count3Stars;
    document.getElementById("count2Stars").textContent = count2Stars;
    document.getElementById("count1Star").textContent = count1Star;
    document.getElementById( "n" ).value = count1Star;
    document.getElementById( "r" ).value = count2Stars;
    document.getElementById( "sr" ).value = count3Stars;
}
</script>


<a href="javascript:document.Form2.submit()" class="a">Home</a>


</body>
</html>
