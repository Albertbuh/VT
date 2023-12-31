<jsp:useBean id="user" scope="session" class="beans.User"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>morcepan</title>
    <meta charset="UTF-8">

    <style>
        h2 {
            text-align: center;
        }
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

        form {
            position: absolute;
            display: flex;
            flex-direction: column;
            justify-content: flex-start;
            align-items: start;

            border: 2px #012866 solid;
            border-radius: 10px;

            top: 50%;
            left:50%;
            transform: translate(-50%, -50%);
            padding: 10px;
        }

        form * {
            margin: 6px
        }

        form label {
            font-weight: bold;
            font-size: 1.2em;
            color: #012866;
            display: block;
        }

        input[type="submit"] {
            background-color: #012866;
            color: white;
            border: none;
            padding: 10px;
            font-weight: bold;
            cursor: pointer;
            transition: opacity .3s;
        }

        input[type="submit"]:hover {
            opacity: 50%;
        }

    </style>
</head>
<body>
<c:import url="header.jsp"/>
<form method="post" id="new_request" enctype='multipart/form-data' >
    <div class="field"><label>Lot name</label><input name="lot_name" autofocus/></div>
    <div class="field"><label>Lot image</label><input name="lot_image" type="file"/></div>
    <div class="field"><label>Lot price</label><input name="lot_price" type="number" step="0.01"/></div>
    <div class="field"><label>Trade period</label><input name="trade_period"/></div>
    <label>Lot description</label><textarea rows="4" cols="50" name="lot_description" form="new_request">Some desc</textarea>
    <input type="submit" value="send" form="new_request"/>
</form>


</body>
</html>