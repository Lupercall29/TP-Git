package application.services;

import application.domaine.Etat;
import application.domaine.Tache;
import application.domaine.Utilisateur;
import application.repositories.TacheRepository;

import java.util.List;

public class TacheService {

	private int compteurId = 11;
	private final TacheRepository tacheRepository;

	public TacheService() {
		tacheRepository = new TacheRepository();
	}

	private void assignerTache(String idUtilisateur, int idTache) {

		Tache tacheAssigner = tacheRepository.getTaches().stream()
				.filter(tache -> tache.getId() == idTache)
				.findAny()
				.orElseThrow(()-> new RuntimeException("Tache non trouvée."));

		tacheAssigner.setIdUtilisateurAssigne(idUtilisateur);
		tacheAssigner.setEtat(Etat.EN_COURS);

		IO.println(tacheAssigner.toString());
	}

	public void rechercherParUtilisateur(String identifiant){
		List<Tache> tacheUtilisateur = tacheRepository.getTaches().stream()
				.filter(tache -> tache.getIdUtilisateurAssigne()!=null && tache.getIdUtilisateurAssigne().equals(identifiant))
				.toList();
		tacheUtilisateur.forEach(tache -> IO.println(tache.toString()));
	}



}
