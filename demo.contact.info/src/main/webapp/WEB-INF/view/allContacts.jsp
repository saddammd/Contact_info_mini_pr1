<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<thead>
<tr>
<td>Name</td>
<td>Email</td>
<td>Phone</td>
<td>Action</td>
</tr>
</thead>

<tbody>

<c:forEach var="cont" items="${contact}">
<c:url var="updatelink" value="/update">
<c:param name="id" value="${cont.id}">
</c:param>
</c:url>


<c:url var="deletelink" value="/delete">
<c:param name="ids" value="${cont.id}">
</c:param>
</c:url>


<tr>
<td>${cont.name}</td>
<td>${cont.email}</td>
<td>${cont.number}</td>
<td><a href = "${updatelink}">Edit</a></td>
<td><a href = "${deletelink}" onclick="return confirm('Are you sure you want to delete?')">Delete</a></td>
</tr>


</c:forEach>


</tbody>

</table>

<a href = "${pageContext.request.contextPath}/add">Back to Add Contact</a>

</body>
</html>