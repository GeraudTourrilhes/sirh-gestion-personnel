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
					resp.setStatus(400);
					resp.getWriter().write("Un matricule est attendu");
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
		if(matriculeParam == null || titreParam == null || nomParam == null || prenomParam == null)
		{
			resp.setStatus(400);
			if(matriculeParam == null)
			{
				resp.getWriter().write("<p>Un matricule est attendu</p>");
			}
			if(titreParam == null)
			{
				resp.getWriter().write("<p>Un titre est attendu</p>");
			}
			if(nomParam == null)
			{
				resp.getWriter().write("<p>Un nom est attendu</p>");
			}
			if(prenomParam == null)
			{
				resp.getWriter().write("<p>Un pr&eacute;nom est attendu</p>");
			}
			
		}
		else
		{
			
			resp.getWriter().write("<h1>Edition de collaborateur</h1>"
					+ "<p>Matricule : " + matriculeParam +  " </p>"
					+ "<p>Titre : " + titreParam +  " </p>"
					+ "<p>Nom : " + nomParam +  " </p>"
					+ "<p>Pr&eacute;nom : " + prenomParam +  " </p>");
			resp.setStatus(201);
		}
		
	}
	
	
	
	
}
