<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Contact</title>
</head>
<body>

<h1>Add Contact</h1>
<form:form action="save" modelAttribute="edit" method="post">

<form:hidden path="id"/>

<form:label path="name">Name</form:label>
<form:input path="name"/>

<form:label path="email">Email</form:label>
<form:input path="email"/>

<form:label path="number">Phone_No</form:label>
<form:input path="number"/>

<button type="submit">submit</button>
</form:form>

</body>
</html>