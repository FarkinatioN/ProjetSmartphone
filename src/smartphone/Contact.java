package smartphone;

import java.io.Serializable;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class Contact implements Serializable{
	
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
	public String toString(){
		return Nom + "  " + Prenom + "  " + Num;
	}
}
