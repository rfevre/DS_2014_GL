package da2ix;

public abstract class Fichier extends Noeud{

	public Fichier(String nom) {
		super(nom);
	}
	
	public boolean estFeuille() {
		return true;
	}
}
