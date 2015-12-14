package da2ix;

public class Document extends Fichier{
	String contenu;
	Executable appli;
	
	public Document(String nom, String contenu){
		this(nom,contenu,null);
	}
	
	public Document(String nom, String contenu, Executable appli){
		super(nom);
		this.contenu=contenu;
		this.appli=appli;
	}
	
	public String getContenu(){
		return this.contenu;
	}
	
	public int taille(){
		return toString().length() + contenu.length();
	}
	
	public void ouvrir(){
		if (appli==null) {
			System.out.println(contenu);
		}
		else{
			appli.ouvrir(this);
		}
	}
	
	

}
