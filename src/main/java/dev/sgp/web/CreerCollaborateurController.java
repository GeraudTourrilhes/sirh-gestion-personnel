package dev.sgp.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.regex.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;
public class CreerCollaborateurController extends HttpServlet{
	

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/collab/creerCollaborateurs.jsp")
		.forward(req, resp);
			
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		String nom =req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		LocalDate ddn =  (req.getParameter("ddn").isEmpty()) ? null :LocalDate.parse(req.getParameter("ddn"));
		String adresse = req.getParameter("adresse");
		String numSecu = req.getParameter("numSecu");
		resp.setCharacterEncoding("utf-8");
		
		
		String texte = "Les paramètres suivant sont incorrecte : ";
		if(nom.isEmpty() || prenom.isEmpty() || ddn == null || adresse.isEmpty()|| numSecu.isEmpty() || !numSecu.matches("^[0-9]{15}$"))
		{
			if(nom.isEmpty())
			{
				texte += "Nom ";
			}
			if(prenom.isEmpty())
			{
				texte += "Prénom ";
			}
			if(ddn == null)
			{
				texte += "Date de naissance ";
			}
			if(adresse.isEmpty())
			{
				texte += "Adresse ";
			}
			if(numSecu.isEmpty() || !numSecu.matches("^[0-9]{15}$"))
			{
				texte += "Numéro de sécurité sociale ";
			}
			
			resp.sendError(400, texte);
			
		}
		else
		{
			Properties properties = new Properties();
			try{
				properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
			}catch (Exception e) {
				e.printStackTrace();
			}
			String photo = req.getContextPath() + "/img/photo.png";
			Boolean actif = true;
			ZonedDateTime dateHeureCreation = ZonedDateTime.now();
			String emailPro = prenom + "." + nom + "@" + properties.getProperty("emailProSuffixe");
			String matricule = "M" + Collaborateur.id;
			
			Collaborateur collaborateur = new Collaborateur(matricule, nom, prenom, ddn, adresse, numSecu, emailPro, photo, dateHeureCreation, actif);
			
			Constantes.COLLAB_SERVICE.sauvegarderCollaborateur(collaborateur);
			resp.sendRedirect(req.getContextPath() + "/collaborateurs/lister");
		}
	}
	
	
}
