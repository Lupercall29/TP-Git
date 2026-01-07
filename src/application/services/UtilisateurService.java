package application.services;

import application.domaine.Utilisateur;
import application.repositories.UtilisateurRepository;

import java.util.Optional;

public class UtilisateurService {

	private final UtilisateurRepository utilisateurRepository;

	public UtilisateurService() {
		utilisateurRepository = new UtilisateurRepository();
	}

	public Optional<Utilisateur> rechercherUtilisateurParId (String id) {

        return utilisateurRepository.getUtilisateurs().stream()
                .filter(utilisateur -> utilisateur.getIdentifiant().equals(id))
                .findAny();
	}

}
