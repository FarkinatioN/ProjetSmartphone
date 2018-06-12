package smartphone;

import java.io.Serializable;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class Contact implements Serializable, ListModel<ListeDesContacts>{
	private static final long serialVersionUID = 1L;
	private static String Nom;
	private static String Prenom;
	private static String Num;
	
	public Contact (String nom2, String prenom2, String num2){
		this.Nom=nom2;
		this.Prenom=prenom2;
		this.Num=num2;
	}

	public static String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		this.Nom = nom;
	}

	public static String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		this.Prenom = prenom;
	}

	public static String getNum() {
		return Num;
	}

	public void setNum(String num) {
		this.Num = num;
	}

	public void add(String nom2, String prenom2, String num2) {
		
	}

	@Override
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ListeDesContacts getElementAt(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}
	public String toString(){
		return Nom + "  " + Prenom + "  " + Num;
	}
}
