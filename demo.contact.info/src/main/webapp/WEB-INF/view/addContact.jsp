<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Contact</title>
</head>
<body>

<h1>Add Contact</h1>

<table>
<form:form action="save" modelAttribute="add" method="post">

<tr>
<td>
<form:label path="name">Name</form:label>
</td>

<td>
<form:input path="name"/>
</td>
</tr>

<tr>
<td>
<form:label path="email">Email</form:label>
</td>

<td>
<form:input path="email"/>
</td>
</tr>

<tr>
<td>
<form:label path="number">Phone_No</form:label>
</td>

<td>
<form:input path="number"/>
</td>
</tr>

<tr><td>
<button type="submit">submit</button>
</td></tr>
</form:form>

<tr><td>
<a href = "${pageContext.request.contextPath}/showall">View All Contacts</a>
</td></tr>

</table>
</body>
</html>