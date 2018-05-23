package dev.sgp.web;

import java.io.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.StatistiqueService;
import dev.sgp.util.Constantes;


public class ListerStatistiquesController extends HttpServlet{

	private StatistiqueService statService = Constantes.STAT_SERVICE;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<VisiteWeb> visiteWebs = statService.listerVisiteWebs();
		req.setAttribute("listeVisiteWebs", visiteWebs);
		req.getRequestDispatcher("/WEB-INF/views/collab/listerStatistiques.jsp")
		.forward(req, resp);
			
	}
	
}
