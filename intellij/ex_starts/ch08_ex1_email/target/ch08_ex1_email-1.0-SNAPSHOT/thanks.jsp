<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>    
</head>

<body>
    <h1>Thanks for joining our email list</h1>
    <p>Here is the information that you entered:</p>
    <label>Email:</label><span>${sessionScope.user.email}</span><br>
    <label>First Name:</label><span>${sessionScope.user.firstName}</span><br>
    <label>Last Name:</label><span>${sessionScope.user.lastName}</span><br>

    <p>The current date is ${requestScope.currentDate}</p>

    <p>
        The first address on our list is ${sessionScope.users[0].email}<br>
        The second address on our list is ${sessionScope.users[1].email}
    </p>

    <p>For customer service, contact ${initParam.custServEmail}</p>

    <p>
        To enter another email address, click on the Back button in your browser or the Return button shown below.
    </p>

    <form action="" method="get">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>
</body>
</html>