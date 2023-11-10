<html>
<head>
    <title>authentication</title>
    <style>
        form {
            display: inline-block;
            text-align: center;
            position: relative;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            outline: 1px solid #012866;
            padding: 20px;

            border-radius: 10px;
            box-shadow: 2px 4px 10px #012866;
        }

        form .field {
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            align-items: flex-start;
            margin: 10px;
        }

        form h2 {
            margin: 0;
        }

        form input {
            padding: 0.2em 0.5em;
            margin-top: 5px;
        }
        form input:active {
            border-color: #012866;
        }

        form input[type="submit"] {
            background-color: #012866;
            color: white;
            width: 90%;
            border-radius: 10px;
            border: none;
            cursor: pointer;
            transition: opacity .3s;
            padding: 0.5em;
            margin-bottom: 10px;
        }
        form input[type="submit"]:hover{
            opacity: 0.7;
        }

        form a {
            font-size: 0.8em;
            text-decoration: none;
            color: #012866;
        }
        form a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<form method="post">
    <h2> Sign In </h2>
    <div class="field"><label>Login:</label><input name="login" autofocus/></div>
    <div class="field"><label>Password:</label> <input type="password" name="password"/></div>

    <input type="submit" value="Send"/>
    <a href="login">Dont have account?</a>
</form>
</body>
</html>