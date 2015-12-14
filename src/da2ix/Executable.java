package da2ix;

public class Executable extends Fichier{
	
	int taille;
	Algorithme algo;
	public Executable(String nom, int taille, Algorithme algo){
		super(nom);
		this.taille = taille;
		this.algo = algo;
	}
	
	public int taille(){
		return this.taille;
	}
	
	public void ouvrir(){
		algo.executer();
	}
	
	public void ouvrir(Noeud o){
		algo.executer(o);
	}
}
