import application.domaine.Tache;
import application.domaine.Utilisateur;
import application.services.TacheService;
import application.services.UtilisateurService;


void main() {

	TacheService taches = new TacheService();
	UtilisateurService utilisateurs = new UtilisateurService();


	//Placez vos appels de méthodes icicre

	utilisateurs.modifierCourrielUtilisateur("jdupont", "dupont.jean@mail.com");

	IO.println(utilisateurs.rechercherUtilisateurParId("jdupont"));

	utilisateurs.creerUtilisateur("robert","roger","robert@gmail.com");
    utilisateurs.afficherToutLesUtilisateur();

	TacheService tacheService = new TacheService();
	tacheService.creationTache("test","je suis bien la tache test");
}