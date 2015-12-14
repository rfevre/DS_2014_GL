package da2ix;

public class Test {
	
	/*
	 * Q1) Quel(s) design(s) pattern(s) vu(s) en cours peut-on identifier sur le diagramme de classes ou dans le code qui vous
	 * est fourni ci-dessus ? Indiquez les classes (ou les méthodes) concernées ainsi que le rôle qu’elles jouent par rapport à
	 * la définition générale du pattern (exemple : « Algorithme joue le rôle de MachinAbstrait, et Executable celui de
	 * MachinConcret, dans le pattern Bidulateur »).
	 * 
	 * Réponse:
	 * 
	 * - Patron de méthode
	 * Noeud est ClasseAbstraite, Dossier est ClasseConcrete
	 * Fichier est ClasseAbstraite, Document et Executable sont ClasseConcrete
	 * - Composite
	 * Noeud est Composant, Dossier est Composite
	 * - Decorator
	 * Noeud est ComposantAbstrait, Raccourci est DecorateurConcret
	 * 
	 * 
	 * Q5) Que doit-on ajouter comme attribut, de quel type, et dans quelle classe,
	 * si l’on souhaite pouvoir « remonter » dans l’arborescence du système de fichiers (c’est-à-dire pouvoir accéder au « père » d’un nœud) ?
	 * Est-il nécessaire d’ajouter une association sur le diagramme des classes ? Si oui, laquelle ? Si non, pourquoi ?
	 * 
	 * Réponse:
	 * 
	 * On peut ajouter un attribut "parent" de type Noeud dans la classe Noeud.
	 * Dans la méthode ajouter on saisit le parent du paramètre n (n.setParent(this))
	 * Dans la méthode supprimer on PEUT le retirer (n.setParent(null)) mais pas obligatoire
	 * 
	 * Il faut rajouter sur l'uml une relation "est parent de" avec 0..1 pour le fils, 0..* pour le père
	 */
	
	public static void main(String [] args) {
		Noeud [] noeuds = new Noeud[10] ;
		Dossier d1 = new Dossier("C:") ; noeuds[0] = d1 ;
		Dossier d2 = new Dossier("Mes Documents"); noeuds[1] = d2 ;
		Executable e = new Executable("cut", 564,
				new Algorithme() {
					public void executer(Noeud n)
					{ // on suppose que n est un Document
					Document d = (Document) n ;
					java.util.StringTokenizer s ;
					s = new java.util.StringTokenizer(d.getContenu()) ;
					while (s.hasMoreTokens())
						System.out.print(s.nextToken() + " / ") ;
						System.out.println();
					}
				}) ;
		noeuds[2] = e ;
		noeuds[3] = new Executable("premiers", 871,
				new Algorithme() {
					public void executer()
					{ // affiche les nombres premiers entre 2 et 100
					java.util.BitSet b = new java.util.BitSet() ;
					for (int i=2; i<100; i++)
						if (!b.get(i))
						{
							for (int j=i*2; j<100; j+=i)
								b.set(j) ;
							System.out.print(i + "\t") ;
						}
					System.out.println() ;
					}
				}) ;
		noeuds[4] = new Raccourci(noeuds[3]);
		noeuds[5] = new Raccourci(noeuds[1]);
		noeuds[6] = new Document("citation.txt", "\"Une vie sans examen ne vaut pas la peine d’être vécue.\"\n\t\t#Socrate.", e);
		noeuds[7] = new Document("image.bmp", "00100\n00100\n11111\n00100\n00100\n");
		noeuds[8] = new Raccourci(noeuds[6]) ;
		noeuds[9] = new Raccourci(noeuds[8]) ;
		// on définit le contenu du dossier d1
		d1.ajouter(noeuds[1]) ; d1.ajouter(noeuds[2]) ;
		d1.ajouter(noeuds[4]) ; d1.ajouter(noeuds[5]) ;
		d1.ajouter(noeuds[6]) ;
		// on définit le contenu du dossier d2
		d2.ajouter(noeuds[3]) ; d2.ajouter(noeuds[7]) ;
		d2.ajouter(noeuds[8]) ; d2.ajouter(noeuds[9]) ;
		for (int i=0; i<noeuds.length; i++)
		{
			System.out.println("J’ouvre le noeud \"" +
			noeuds[i].toString() + "\"") ;
			noeuds[i].ouvrir() ;
			System.out.println() ;
		}
	}
}
