package da2ix;

public class Raccourci extends Noeud {
	
	private Noeud cible;
	
	public Raccourci(Noeud cible){
		super("Raccourci vers " + cible.toString());
		this.cible = cible;
	}

	public int taille() {
		return cible.toString().length();
	}

	public void ouvrir() {
		cible.ouvrir();
	}

	public boolean estFeuille() {
		return cible.estFeuille();
	}

}
