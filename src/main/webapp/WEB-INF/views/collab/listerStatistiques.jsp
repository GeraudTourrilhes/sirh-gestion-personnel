<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SGP - App</title>
		<link rel="stylesheet" href="<c:url value='/bootstrap-4.1.1-dist/css/bootstrap.css' />">
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light nav-tabs">

      <img class="mr-1" src="<c:url value='/img/index.png' />" alt="Logo">
       <a class="navbar-brand active" href="<c:url value='/collaborateurs/lister' />">Collaborateurs</a>
       <a class="navbar-brand" href="<c:url value='/statistiques/lister' />">Statistiques</a>
       <a class="navbar-brand" href="#">Activités</a>
    </nav>
    <div class="container-fluid">


      <div class="row">
        <div class="col">
          <h1>Statistiques</h1>
        </div>
      </div>
      <table>
      	<tr>
      		<th>Chemin</th>
      		<th>Temps d'exécution</th>
     	</tr>
     	
      	<c:forEach var="visiteWeb"  items="${requestScope.listeVisiteWebs}">
			<tr>
				<td><c:out value="${visiteWeb.chemin}" /></td>
				<td><c:out value="${visiteWeb.tempsExecution}" /></td>
			</tr>
		</c:forEach>	
      </table>
      

	</body>
</html>