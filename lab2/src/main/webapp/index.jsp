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

        .request-container {
            display: grid;
            grid-template-columns: 150px 1fr 200px;
            align-items: center;
            margin: 20px;
            height: 150px;
            position: relative;
            padding: 5px;
        }
        .request-container:hover {
            border: 2px #012866 solid;
        }
        .request-container p,
        .request-container span,
        .request-container h2{
            padding: 0;
            margin: 0;
            margin-bottom: 5px;
        }

        .request-container img {
            height: 100%;
            width: 100%;
            object-fit: cover;
        }

        .request-container .desc-section {
            padding-left: 20px;
            height: 100%;
            vertical-align:top;
            position: relative;
        }

        .request-container .desc-section a {
            text-decoration: none;
            color: black;
        }
        .request-container .desc-section a:hover {
            text-decoration: underline;
        }

        .request-container .desc-section .by-user {
            color: #808080;
        }
        .request-container .desc-section p {
            font-size: 0.8em;
        }
        .request-container .desc-section .price {
            position: absolute;
            bottom: 5%;
            font-weight: bold;
            font-size: 1.5em;
        }

        .request-container .button-section form{
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            gap: 10px;
        }
        .request-container .button-section button {
            width: 30%;
            background-color: #012866;
            color: white;
            border: none;
            padding: 10px;
            cursor: pointer;
            transition: opacity .15s;
        }
        .request-container .button-section button:hover {
            opacity:50%;
        }
        .request-container .button-section button:active {
            opacity:90%;
        }
        .request-container .button-section .date {
            position: absolute;
            top: 1vh;
            right: 1vh;
            font-size: 0.6em;
            color: #808080;
        }

        .request-container h1 {
            color: #012866;
        }
    </style>
<%--    <link rel="stylesheet" href="./css/header.css" type="text/css">--%>
</head>
<body>
<c:import url="header.jsp"/>


<c:forEach var="trade" items="${tradeManager.trades}">
<div class="request-container">
    <img src="https://images.pexels.com/photos/268533/pexels-photo-268533.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="">
    <div class="desc-section">
        <h2><a href="#">${trade.requestInformation.lot.name}</a></h2>
        <p>${trade.requestInformation.lot.descriptionPath}</p>
        <span class="price">
            <fmt:formatNumber type="number" maxFractionDigits="2" value="${trade.maxBid}"/> BYN
        </span>
        <span class="max-bid-user">${trade.maxBidUserLogin}</span>
    </div>

    <div class="button-section">
        <span class="date" id="date-field">published: ${trade.startDateTime}</span>
    </div>
</div>
</c:forEach>


</html>
