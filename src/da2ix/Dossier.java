package da2ix;

import java.util.*;

public class Dossier extends Noeud implements Iterable<Noeud>{

	private Set<Noeud> contenu;
	
	public Dossier(String nom) {
		super(nom);
		this.contenu = new HashSet<Noeud>();
	}

	@Override
	public int taille() {
		Iterator<Noeud> it = contenu.iterator();
		Noeud fils;
		int tailleTotal = toString().length();
		while(it.hasNext()){
			fils = it.next();
			tailleTotal += fils.taille();
		}
		return tailleTotal;
	}

	@Override
	public void ouvrir() {
		String result = toString()+"\n";	
		Iterator<Noeud> it = contenu.iterator();
		Noeud fils;
		while(it.hasNext()){
			fils = it.next();
			result += "\t|- " + fils + " ("+fils.taille()+"K)\n";
		}
		result += contenu.size() + "noeud(s), total " + taille() + "K";
		System.out.println(result);
	}

	@Override
	public boolean estFeuille() {
		return false;
	}
	
	public void ajouter(Noeud n){
		contenu.add(n);
	}
	
	public void enlever(Noeud n){
		contenu.remove(n);
	}
	
	@Override
	public Iterator<Noeud> iterator() {
		return contenu.iterator();
	}
	
	public Iterator<Noeud> getContenu(){
		return iterator();
	}
	
}
