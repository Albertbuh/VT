<jsp:useBean id="tradeManager" scope="request" class="beans.TradeManager"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>catalog</title>
    <style>
        nav {
            display: flex;
            justify-content: space-between;
            align-items: center;
            position: relative;
            background-color: #012866;
            color: white;
            padding: 10px;
            margin: 5px 20px;
        }

        nav .button-section button {
            padding: 6px;
            margin: 0 4px;
            border: none;
            font-weight: bold;
            cursor: pointer;
            transition: background-color .3s, color .3s, outline .3s;
        }

        nav .button-section .btn-signin {
            color: white;
            background-color: transparent;
            outline: 1px solid white;
        }

        nav .button-section .btn-signin:hover {
            background-color: white;
            color: #012866;
        }

        nav .button-section .btn-login {
            color: #012866;
            background-color: white;
            outline: 1px solid black;
        }

        nav .button-section .btn-login:hover {
            background-color: transparent;
            color: white;
            outline: 1px solid white;
        }

        nav .links-section {
            position: absolute;
            left: 50%;
            transform: translateX(-50%);
        }

        nav .links-section a {
            padding: 5px 20px;
            color: white;
            text-decoration: none;
            font-size: 2vw;
            font-weight: bold;
            transition: background-color .3s, opacity .15s;
        }

        nav .links-section a:hover {
            background-color: rgba(255, 255, 255, 0.5);
        }

        nav .links-section a:active {
            opacity: 0.5;
            text-decoration: underline;
        }

        .trade-container {
            display: grid;
            grid-template-columns: 150px 1fr 200px;
            align-items: center;
            margin: 20px;
            height: 150px;
            position: relative;
            padding: 5px;
        }
        .trade-container:hover {
            border: 2px #012866 solid;
        }
        .trade-container p,
        .trade-container span,
        .trade-container h2{
            padding: 0;
            margin: 0;
            margin-bottom: 5px;
        }

        .trade-container img {
            height: 100%;
            width: 100%;
            object-fit: cover;
        }

        .trade-container .desc-section {
            padding-left: 20px;
            height: 100%;
            vertical-align:top;
            position: relative;
        }

        .trade-container .desc-section a {
            text-decoration: none;
            color: black;
        }
        .trade-container .desc-section a:hover {
            text-decoration: underline;
        }

        .trade-container .desc-section .by-user {
            color: #808080;
        }
        .trade-container .desc-section p {
            font-size: 0.8em;
        }
        .trade-container .bid-section {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;

            font-size: 1.2em;
            font-weight: bold;
        }
        .trade-container .bid-section .price {
            outline: 2px #012866 solid;
            padding: 6px;
        }
        .trade-container .bid-section button {
            width: 30%;
            background-color: #012866;
            color: white;
            border: none;
            padding: 10px;
            cursor: pointer;
            transition: opacity .15s;
            margin: 5px;
        }
        .trade-container .bid-section button:hover {
            opacity:50%;
        }
        .trade-container .bid-section button:active {
            opacity:90%;
        }
        .trade-container .bid-section .date {
            position: absolute;
            top: 1vh;
            right: 1vh;
            font-size: 0.6em;
            color: #808080;
        }

        .trade-container .button-container {
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;

        }

    </style>
</head>
<body>
<c:import url="header.jsp"/>


<c:forEach var="trade" items="${tradeManager.trades}">
<div class="trade-container">
<%--    <img src="${trade.requestInformation.lot.imageName}" alt="">--%>
    <img src="https://images.pexels.com/photos/268533/pexels-photo-268533.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="">
    <div class="desc-section">
        <h2><a href="#">${trade.requestInformation.lot.name}</a></h2>
        <p>${trade.requestInformation.lot.descriptionPath}</p>

        <span class="max-bid-user">${trade.maxBidUserLogin}</span>
    </div>

    <div class="bid-section">
        <span class="price">
            <fmt:formatNumber type="number" maxFractionDigits="2" value="${trade.maxBid}"/> BYN
        </span>
        <form class="button-container" method="post">
            <input type="number" value="${trade.id}" name="tradeId" hidden>
            <input type="number" value="10" name="bidUp" id="bidUp${trade.id}" hidden>
            <button type="submit" onclick="document.getElementById('bidUp${trade.id}').value = 10">+10</button>
            <button type="submit" onclick="document.getElementById('bidUp${trade.id}').value = 20">+20</button>
            <button type="submit" onclick="document.getElementById('bidUp${trade.id}').value = 50">+50</button>
        </form>
        <span class="date" id="date-field">published: ${trade.startDateTime}</span>
    </div>
</div>
</c:forEach>


</html>
