<%--
  Created by IntelliJ IDEA.
  User: nstah
  Date: 20.09.23
  Time: 01:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="localizations.localization" var="loc"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trade Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        header {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        .trade-details {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin: 10px 0 5px;
        }

        select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical; /* Allow vertical resizing */
        }

        button {
            width: 100%;
            padding: 8px 16px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #0056b3;
        }

        .reviews {
            margin-top: 20px;
        }

        .review {
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 10px;
            margin-bottom: 10px;
        }
    </style>
</head>

<jsp:include page="common/header.jsp"/>
<body>
<div class="trade-details">
    <h2>${trade.getName()}</h2>
    <p><strong><fmt:message key="trade.author" bundle="${loc}"/>:</strong> ${trade.getAuthor()}</p>
    <p><strong><fmt:message key="trade.description" bundle="${loc}"/>:</strong> ${trade.getDescription()}</p>
    <p><strong><fmt:message key="trade.mark" bundle="${loc}"/>:</strong> ${trade.getAverageMark()}</p>

    <security:authorize access="isAuthenticated()">
        <form:form id="reviewForm" method="post" action="/review" modelAttribute="review">
            <form:label path="mark" for="marks"><fmt:message key="review.markSection" bundle="${loc}"/>:</form:label>
            <form:select path="mark" id="marks" name="mark" required="true">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </form:select>


            <form:button type="submit">Submit Review</form:button>
        </form:form>
    </security:authorize>

 
</div>

</body>

</html>

