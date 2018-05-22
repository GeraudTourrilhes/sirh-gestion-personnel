package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			
				
				String matriculeParam = req.getParameter("matricule");
				resp.setContentType("text/html");
				if(matriculeParam == null)
				{
					resp.sendError(400, "Un matricule est attendu");
					/*resp.setStatus(400);
					resp.getWriter().write("Un matricule est attendu");*/
				}
				else
				{
					// code HTML ecrit dans le corps de la reponse
					resp.getWriter().write("<h1>Edition de collaborateur</h1>"
					+ "<p>Matricule : " + matriculeParam +  " </p>");
				}
				
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String matriculeParam = req.getParameter("matricule");
		String titreParam = req.getParameter("titre");
		String nomParam = req.getParameter("nom");
		String prenomParam = req.getParameter("prenom");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		String texte = "Les paramètres suivant sont incorrecte : ";
		if(matriculeParam == null || titreParam == null || nomParam == null || prenomParam == null)
		{
			if(matriculeParam == null)
			{
				texte += "matricule ";
			}
			if(titreParam == null)
			{
				texte += "titre ";
			}
			if(nomParam == null)
			{
				texte += "nom ";
			}
			if(prenomParam == null)
			{
				texte += "prénom ";
			}
			
			resp.sendError(400, texte);
			
		}
		else
		{
			resp.getWriter().write("<html><head> <meta charset=\"UTF-8\"> </head>"
					+ "<body><h1>Edition de collaborateur</h1>"
					+ "<p>Matricule : " + matriculeParam +  " </p>"
					+ "<p>Titre : " + titreParam +  " </p>"
					+ "<p>Nom : " + nomParam +  " </p>"
					+ "<p>Prénom : " + prenomParam +  " </p>"
							+ "<body><html>");
			resp.setStatus(201);
		}
		
	}
	
	
	
	
}
