package da2ix ;
public abstract class Noeud {
	String nom ;
	public Noeud(String nom) { this.nom = nom ; }
	public String toString() { return nom ; }
	public abstract int taille() ;
	public abstract void ouvrir() ;
	public abstract boolean estFeuille() ;
	public boolean equals(Object o) {
	Noeud n = (Noeud) o ;
	return this.nom.equals(n.nom) ;
}
}