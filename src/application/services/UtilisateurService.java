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

	public Utilisateur rechercherUtilisateurParId (String id) {

        return utilisateurRepository.getUtilisateurs().stream()
                .filter(utilisateur -> utilisateur.getIdentifiant().equals(id))
                .findAny()
				.orElseThrow(()-> new RuntimeException("Utilisateur non trouvé"));
	}

	public void modifierCourrielUtilisateur (String id, String nouveauCourriel) {

		Utilisateur utilisateurAModifier = rechercherUtilisateurParId(id);
		utilisateurAModifier.setCourriel(nouveauCourriel);


	}

	public void afficherToutLesUtilisateur(){
		utilisateurRepository.getUtilisateurs().forEach(utilisateur -> IO.println(utilisateur.toString()));
	}

	public void  supprimerUtilisateur(String id){
		Utilisateur utilisateurAsup = rechercherUtilisateurParId(id);
		utilisateurRepository.getUtilisateurs().remove(utilisateurAsup);
	}
}