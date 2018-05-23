package dev.sgp.filtre;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.StatistiqueService;
import dev.sgp.util.Constantes;

public class FrequentationFilter implements Filter{

	private FilterConfig config = null;
	private StatistiqueService statService = Constantes.STAT_SERVICE;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		long before = System.currentTimeMillis();
		chain.doFilter(req, resp);
		long after = System.currentTimeMillis();
		String path = ((HttpServletRequest) req).getRequestURI();
		VisiteWeb visiteWeb = new VisiteWeb(path, (int) (after - before));
		if(!statService.ifExist(visiteWeb))
		{
			statService.sauvegarderVisiteWeb(visiteWeb);
		}
		
		//config.getServletContext().log(path + " : " + (after - before));
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		config.getServletContext().log("FrequentationFilter initialized");
		
	}

		
}
