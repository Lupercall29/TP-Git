package application.services;

import application.domaine.Utilisateur;
import application.repositories.UtilisateurRepository;

public class UtilisateurService {

	private final UtilisateurRepository utilisateurRepository;

	public UtilisateurService() {
		utilisateurRepository = new UtilisateurRepository();
	}

	public  void creerUtilisateur(String prenom , String nom,String mail){
		char element1 = prenom.charAt(0);
		String id = element1+nom;
		Utilisateur utilisateur = new Utilisateur(id,nom,prenom,mail);
		utilisateurRepository.getUtilisateurs().add(utilisateur);
	}
}
