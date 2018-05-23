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
      <div class="d-flex justify-content-end">
        <a role="button" href="<c:url value='/collaborateurs/nouveau' />" class="btn">Ajouter un nouveau Collaborateur</a>

      </div>


      <div class="row">
        <div class="col">
          <h1>Les collaborateurs</h1>
        </div>
      </div>

        <form>
          <div class="form-row justify-content-center">
            <div class="col-4">
              <label for="recherche">Rechecher un nom ou un prénom qui commence par:</label>
            </div>
            <div class="col-2.5">
              <input id="recherche" type="text"/>
            </div>
            <div class="col align-items-center">
              <button type="submit"  class="btn">Rechercher</button>
            </div>
            <div class="col">
              <input type="checkbox" /> Voir les collaborateurs désactivés
            </div>

          </div>
          <div class="form-row">
            <div class="col-2 offset-md-2">

                <span>Filtrer par département:</span>

              </div>
              <div class="col-2.5">
              <select id="filtre_departement">
                <option selected>Tous</option>
                <option>Compatibilité</option>
                <option>Ressources Humaine</option>
                <option>Informatiques</option>
              </select>
            </div>
          </div>
        </form>
      </div>
      	
      	<c:forEach var ="collaborateur"  items="${listeCollaborateurs}">
			<div class="card-deck mb-3 text-center">
		      <div class="card mb-4 box-shadow">
		        <div class="card-header">
		          <h4 class="my-0 font-weight-normal"><c:out value="${collaborateur.getNom()}" /> <c:out value="${collaborateur.getPrenom()}" /></h4>
		        </div>
		        <div class="card-body">
		          <div class="row justify-content-around">
		            <div class="col media align-items-center">
		                <img class="mr-3" src="<c:out value="${collaborateur.getPhoto()}" />" alt="Logo">
		            </div>
		            <div class="col">
		              <ul class="list-unstyled mt-3 mb-4">
		                <li>Matricule</li>
		                <li>Date de naissance</li>
		                <li>Email Professionnelle</li>
		                <li>Numéro de sécurité sociale</li>
		              </ul>
		            </div>
		            <div class="col">
		              <ul class="list-unstyled mt-3 mb-4">
		                <li><c:out value="${collaborateur.getMatricule()}" /></li>
		                <li><c:out value="${collaborateur.getDdn()}" /></li>
		                <li><c:out value="${collaborateur.getEmailPro()}" /></li>
		                <li><c:out value="${collaborateur.getNumSecu()}" /></li>
		              </ul>
		            </div>
		          </div>
		          <div class="row justify-content-end">
					  <button type="button"  class="btn">Editer</button>
				  </div>
		        </div>
	        </div>
	      </div>
		</c:forEach>	
	</body>
</html>