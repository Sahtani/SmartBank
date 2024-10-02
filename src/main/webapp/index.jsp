<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<form action="hello-servlet" method="post">
    Project: <input type="text" name="project"><br>
    Status: <input type="text" name="status"><br>
    Amount: <input type="number" name="amount"><br>
    Duration: <input type="number" name="duration"><br>
    Monthly Payment: <input type="number" name="monthlyPayment"><br>
    Email: <input type="email" name="email"><br>
    Phone: <input type="text" name="phone"><br>
    Title: <input type="text" name="title"><br>
    Last Name: <input type="text" name="lastName"><br>
    First Name: <input type="text" name="firstName"><br>
    ID Number: <input type="text" name="idNumber"><br>
    Date of Birth: <input type="date" name="dateOfBirth"><br>
    Employment Start Date: <input type="date" name="employmentStartDate"><br>
    Monthly Income: <input type="number" name="monthlyIncome"><br>
    Has Existing Loans: <input type="checkbox" name="hasExistingLoans" value="true"><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>