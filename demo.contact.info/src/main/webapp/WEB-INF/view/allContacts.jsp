<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
					<td><a href="${updatelink}">Edit</a></td>
					<td><a href="${deletelink}"
						onclick="return confirm('Are you sure you want to delete?')">Delete</a></td>
				</tr>


			</c:forEach>


		</tbody>

	</table>

	<div>
		<a href="${pageContext.request.contextPath}/">Back to Add Contact</a>
	</div>



	<div>

		<!-- when page number less than 2 hide "prev" else display prev -->
		<c:if test="${pageNo>1}">
			<a href="${pageContext.request.contextPath}/showall?pno=${pageNo-1}">Prev</a>
		</c:if>

		<!-- Printing the paginations -->
		<c:forEach var="page_size" begin="1" end="${pagesize}">

			<!-- when page no is clicked make the link as text -->




			<c:choose>
				<c:when test="${pageNo==page_size}">
				${page_size}
				</c:when>


				<c:otherwise>
					<a
						href="${pageContext.request.contextPath}/showall?pno=${page_size}">${page_size}</a>
				</c:otherwise>

			</c:choose>
		</c:forEach>


		<!-- Displaying the next page no when 3 is clicked -->
		<c:if test="${pageNo>=pagesize}">
			<c:forEach begin="${pagesize+1}" end="${totalpages}"
				var="next_page_size">

				<c:choose>
					<c:when test="${pageNo==next_page_size}">
				${next_page_size}
				</c:when>


					<c:otherwise>
						<a
							href="${pageContext.request.contextPath}/showall?pno=${next_page_size}">${next_page_size}</a>
					</c:otherwise>

				</c:choose>
			</c:forEach>



		</c:if>

		<!-- when page number is equal to last page no then hide "next" -->
		<c:if test="${pageNo < totalpages}">
			<a href="${pageContext.request.contextPath}/showall?pno=${pageNo+1}">Next</a>
		</c:if>
	</div>








































</body>
</html>