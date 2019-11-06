<!Doctype html>

<html>
    <head>
        <title>Hello World JSP!</title>
    </head>
    <body>
        <p>Hello World. This is your first JSP!</p>

        Name : <%=request.getParameter("nm").toUpperCase()%>
    </body>
</html>