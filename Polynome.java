package equation;

	/**
	 * Cette class permet de définir un polynome avec deux attributs (degre et elements), 
	 * deux constructeurs() et des methodes(somme, addition, toString, derive et calcul)
	 * 
	 * @author Makane MBAYE
	 * @version 1.0
	 * @date 12/02/2022
	 * @file Polynome.java
	 */

public class Polynome {
	//Les variable
	private int degre;
	private int[] elements;
	
	/**
	 * Ce constructeur qui est tableau d'entier qui contient les émlément du polynome qui a comme longueur
	 * degre-1 
	 * @param tab int[] (un tableau d'entier)
	*/
	public Polynome(int[] tab) {
		this.degre=tab.length-1;
		elements=new int[tab.length];
		for(int i=0;i<=degre;i++)
			this.elements[i]=tab[i];
	}
	
	/**
	*Ce constructeur permet de construire un polynome apartir de son degré
	*/
	public Polynome(int degre) {
		this.degre=degre;
		elements=new int[degre+1];
		for(int i=0;i<=degre;i++)
			this.elements[i]=0;
	}
	
	/**
	 * le getter du variable elements pour récupérer l'élément du polynome à un position donner
	 * 
	 */
	public int getElements(int i) {
		int retour;
		// Pour ne pas dépassé la longueur du tableau
		if (i<throwis.elements.length) {
			retour=this.elements[i];
		}else {
			retour=0;
		}
		return retour;
	}

	/**
	 * le setter du variable elements pour modifier un élément à la position i par x
	 * @param i et x
	 */ 

	public void setElements(int i, int x) {
		if (i<this.elements.length) {
			this.elements[i] = x;
		}
		else ;
		
	}
	
	//le getter du variable degre
	public int getDegre() {
		return degre;
	}

	//le setter du variable degre
	public void setDegre(int degre) {
		this.degre = degre;
	}
	
	/**
	 * Cette methode return la somme de deux polynome (le polynome de départ et le polynome donné en argument)
	*@param     polynome p
	* 
	* 
	* @return retourne un polynome
	*/
	public Polynome addition(Polynome p) {
		int degreMax=Math.max(p.degre,this.degre);
		Polynome pr=new Polynome(degreMax);
		for(int i=0;i<=degreMax;i++) {
			pr.setElements(i,this.getElements(i)+p.getElements(i));
		}
		return pr;
	}
	
	/**
	 * Cette mathode permet d'afficher le polynome sous forme: 2+2X^1+3X^2+4X^3
	*/
	public String toString() {
		String s=""+this.elements[0];
		for(int i=1;i<=this.degre;i++) {
			if (this.elements[i]>0) {
				s+="+"+this.elements[i]+"X^"+i;
			} else {
				if(this.elements[i]<0)
					s+=this.elements[i]+"X^"+i;

			}
			
		}
		return s;
	}
	
	public Polynome derive() {
		Polynome Pd=new Polynome(this.degre-1);
		for (int i = 0; i < this.degre; i++) {
			Pd.elements[i] = (i+1)*this.elements[i+1];
		}
		//Pd.degre=this.degre;
		return Pd;
	}
	
	public int calcul(int x) {
		int Retour = 0;
		for(int i = 0;i <= this.degre;i++) {
			Retour+=this.elements[i]*Math.pow(x, i);
		}
		return Retour;
	}
	
	
//////////////////////////Methode main////////////////////////////////////////////////////////	

	public static void main(String[] args) {
		int[] t1= {1, 2,3};
		int[] t2= {0,2,1,4};
		int[] s= {1,4,4,4};
		Polynome p=new Polynome(t1);
		Polynome n=new Polynome(t2);
		Polynome m=new Polynome(s);
		
		System.out.println(p.toString());
		System.out.println("");
		System.out.println(n.toString());
		System.out.println("");
		System.out.println(m.toString());
		
		Polynome somme=p.addition(n);
		System.out.println("");
		System.out.println(somme.toString());
		
		Polynome derive=p.derive();
		System.out.println("");
		System.out.println(derive.toString());
	}

}
