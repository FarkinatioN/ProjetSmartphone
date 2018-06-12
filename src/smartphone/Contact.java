package smartphone;

import java.awt.Component;
import java.io.Serializable;

public class Contact implements Serializable{
	private static final long serialVersionUID = 1L;
	private Component Nom;
	private Component Prenom;
	private Component Num;
	
	public Contact (Component nom, Component prenom, Component num){
		this.Nom=nom;
		this.Prenom=prenom;
		this.Num=num;
	}

	public Component getNom() {
		return Nom;
	}

	public void setNom(Component nom) {
		this.Nom = nom;
	}

	public Component getPrenom() {
		return Prenom;
	}

	public void setPrenom(Component prenom) {
		this.Prenom = prenom;
	}

	public Component getNum() {
		return Num;
	}

	public void setNum(Component num) {
		this.Num = num;
	}

	public void add(String nom2, String prenom2, String num2) {
		
	}
}
