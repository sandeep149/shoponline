<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName }">

<title>Shop with me - ${title}</title>

<script>
	window.menu = '${title}';
	
	window.contextRoot = '${contextRoot}'
</script>

<!-- Bootstrap core css -->
<link href="${css}/bootstrap.min.css" rel="stylesheet"/>

<!-- Bootstrap Readable CSS -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet"/>
<!-- Botstrap data table CSS -->

<link href="${css}/dataTables.bootstrap.css" rel="stylesheet"/>


<!-- Custom styles for this template -->
 <link href="${ css }/myapp.css" rel="stylesheet"/> 
    
</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<!-- loading the home page  -->
			<!--  when user click home -->
			<c:if test="${ userClickHome == true  }">
				<%@include file="home.jsp"%>
			</c:if>
			<!-- when user click about  -->
			<c:if test="${ userClickAbout == true  }">
				<%@include file="about.jsp"%>
			</c:if>
			<!-- whne user click contact -->
			<c:if test="${ userClickContact == true  }">
				<%@include file="contact.jsp"%>
			</c:if>
			<!-- when user click products -->
			<c:if
				test="${ userClickAllProducts == true or  userClickCategoryProducts == true }">
				<%@include file="listproduct.jsp"%>
			</c:if>
			
			<!-- when user click show products -->
			<c:if
				test="${ userClickShowProduct == true }">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			
			<!-- when user click manage products -->
			<c:if
				test="${ userClickManageProducts == true }">
				<%@include file="manageProducts.jsp"%>
			</c:if>
		</div>

		<!-- Footer comes here -->
		<%@include file="./shared/footer.jsp"%>
		
		<!-- /.container -->
		<!-- Bootstrap core JavaScript -->
		<script src="${ js }/jquery.js"></script>
		<script src="${ js }/bootstrap.min.js"></script>
		<script src="${ js }/bootstrap.bundle.min.js"></script>
		<!-- // jquery validation -->
		<script src="${ js }/jquery.validate.js"></script>
		<script src="${ js }/jquery.validate.mim.js"></script>
		

		<!-- DataTable Plugin -->
		<script src="${ js}/jquery.dataTables.js"></script>

		<!-- DataTable Bootstrap css -->
		<script src="${ js }/dataTables.bootstrap.js"></script>
		
		<!-- Bootbox css -->
		<script src="${ js }/bootbox.min.js"></script>


		<!-- self coded javascript  -->
		<script src="${ js }/myapp.js"></script>

		
	</div>

</body>

</html>
