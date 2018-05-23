
<!doctype html>
<html lang="fr">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-4.1.1-dist/css/bootstrap.css">
	<script src="<%=request.getContextPath()%>/bootstrap-4.1.1-dist/js/bootstrap.js"> </script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/index.css">


    <title>SGP App</title>
  </head>
  <body>

    <nav class="navbar navbar-expand-lg navbar-light bg-light nav-tabs">

      <img class="mr-1" src="<%=request.getContextPath()%>/img/index.png" alt="Logo">
       <a class="navbar-brand active" href="<%=request.getContextPath()%>/collaborateurs/lister">Collaborateurs</a>
       <a class="navbar-brand" href="#">Statictiques</a>
       <a class="navbar-brand" href="#">Activités</a>
    </nav>
    <div class="container-fluid">
      <div class="row">
        <div class="col">
          <h1>Nouveau Collaborateur</h1>
        </div>
      </div>
      <form method="POST">
        <div class="form-group">
          <label for="nom">Nom</label>
          <input type="text" class="form-control" id="nom" name="nom">
          <div class="invalid-tooltip">
            Le nom est obligatoire!
          </div>
        </div>
        <div class="form-group">
          <label for="prenom">Prenom</label>
          <input type="text" class="form-control" id="prenom" name="prenom">
          <div class="invalid-tooltip">
            Le prénom est obligatoire!
          </div>
        </div>
        <div class="form-group">
          <label for="ddn">Date de naissance</label>
          <input type="date" class="form-control" id="ddn" name="ddn">
          <div class="invalid-tooltip">
            Le date de naissance est obligatoire!
          </div>
        </div>
        <div class="form-group">
          <label for="adresse">Adresse</label>
          <input class="form-control" id="adresse" name="adresse">
          <div class="invalid-tooltip">
            L'adresse' est obligatoire!
          </div>
        </div>
        <div class="form-group">
          <label for="numSecu">Numéro de sécurité sociale</label>
          <input type="text" class="form-control" id="numSecu" name="numSecu">
          <div class="invalid-tooltip">
            Le numéro de sécurité sociale est obligatoire!
          </div>
        </div>
        
        <div class="row justify-content-end">
          <button type="submit" class="btn btn-primary">Créer</button>
        </div>

      </form>

    </div>
  </body>
</html>
