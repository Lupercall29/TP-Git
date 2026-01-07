package application.services;

import application.domaine.Etat;
import application.domaine.Tache;
import application.repositories.TacheRepository;

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



}
