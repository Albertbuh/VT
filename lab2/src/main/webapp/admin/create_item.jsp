<jsp:useBean id="user" scope="request" class="beans.User"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>morcepan</title>

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


    </style>
</head>
<body>
<c:import url="../header.jsp"/>
<c:choose>
    <c:when test="${user.role == 'ADMIN'}">
        <h2>Hello admin</h2>
    </c:when>
    <c:when test="${user.role == 'USER'}">
        <h2>Hello user</h2>
    </c:when>
</c:choose>
</body>
</html>