package dev.sgp.service;

import java.util.*;

import dev.sgp.entite.VisiteWeb;

public class StatistiqueService {
	List<VisiteWeb> listeVisiteWebs = new ArrayList<>();

	public List<VisiteWeb> listerVisiteWebs() {
		return listeVisiteWebs;
	}

	public void sauvegarderVisiteWeb(VisiteWeb visiteWeb) {
		listeVisiteWebs.add(visiteWeb);
	}
	
	public boolean ifExist(VisiteWeb visiteWeb) {
		boolean result = false;
		for (VisiteWeb visitWeb : listeVisiteWebs) {
			if(visitWeb.getChemin().equals(visiteWeb.getChemin()))
			{
				result = true;
			}
		}
		return result;
	}
	
	public void modifierVisiteWeb(VisiteWeb visiteWeb) {
		listeVisiteWebs.contains(visiteWeb);
	}
	
	
}
