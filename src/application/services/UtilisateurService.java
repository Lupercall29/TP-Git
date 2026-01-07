package application.services;

import application.domaine.Utilisateur;
import application.repositories.UtilisateurRepository;

import java.util.Optional;

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

	public Optional<Utilisateur> rechercherUtilisateurParId (String id) {

        return utilisateurRepository.getUtilisateurs().stream()
                .filter(utilisateur -> utilisateur.getIdentifiant().equals(id))
                .findAny();
	}

}
