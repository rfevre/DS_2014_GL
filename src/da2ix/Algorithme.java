package da2ix ;
/** Cette classe doit être dérivée pour
* définir le code des exécutables du
* système DA2IX. */
public abstract class Algorithme {
	/** Le code exécuté lors de
	* l’ouverture de l’exécutable */
	public void executer() { }
	/** Le code exécuté sur un noeud
	* de l’arborescence DA2IX */
	public void executer(Noeud n) { }
}
