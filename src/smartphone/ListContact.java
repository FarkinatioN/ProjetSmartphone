package smartphone;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;


public class ListContact extends DefaultFrame{
	private static final long serialVersionUID = 1L;

	//Composition pour le jPanelNorth
	private JLabel TextAddContact = new JLabel("Ajouter un nouveau contact");
	private ImageIcon addContactImage = new ImageIcon("Image/addContact.png");
	private JButton addContact = new JButton(addContactImage);

	//Composition JpanelNorthinCenter
	private JLabel TextListContact = new JLabel("Liste des contacts");

	//création Panel
	private JPanel jPanelNorth = new JPanel();
	private JPanel jPanelCenter = new JPanel(new BorderLayout());

	private JPanel jPanelNorthinCenter = new JPanel();
	private JPanel jPanelCenterinCenter = new JPanel();
	
	private JPanel panelListe = new JPanel(new GridLayout(10,1));
	
	//AddContact contactpourliste;

	public ListContact() throws FileNotFoundException{
		// default parameters
		setUndecorated(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(480, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.BLACK);

		jPanelNorth.setBackground(Color.BLACK);
		jPanelCenter.setBackground(Color.BLACK);
		jPanelNorthinCenter.setBackground(Color.BLACK);
		jPanelCenterinCenter.setBackground(Color.BLACK);

		//jPanelNorth création
		jPanelNorth.setLayout(new GridLayout());

		//ajout objet dans panel nord
		jPanelNorth.add(Box.createHorizontalGlue());
		jPanelNorth.add(TextAddContact);
		jPanelNorth.add(addContact);

		//modif couleurs fond et écriture objets et textes
		TextAddContact.setBackground(Color.black);
		TextAddContact.setForeground(Color.white);

		addContact.setBackground(Color.black);
		addContact.setBorderPainted(false);
		addContact.setFocusPainted(false);
		addContact.setContentAreaFilled(false);

		//jPanelNorthinCenter création
		jPanelNorthinCenter.setLayout(new GridLayout());
		//ajout objet dans panel nord du panel centre
		jPanelNorthinCenter.add(TextListContact);
		jPanelNorthinCenter.add(Box.createHorizontalGlue());
		jPanelNorthinCenter.add(Box.createHorizontalGlue());
		jPanelNorthinCenter.add(Box.createHorizontalGlue());
		//modif couleur fond et écriture texte
		TextListContact.setBackground(Color.black);
		TextListContact.setForeground(Color.white);

		//jPanelCenterinCenter création
		jPanelCenterinCenter.setLayout(new GridLayout());

		//Composition panelCenter
		//JList list = new JList();
		//Contact newContact = new Contact(Contact.getNom(), Contact.getPrenom(), Contact.getNum());
		
		//this.contactpourliste=contactpourliste;
		//contactpourliste.getListedesContacts();
		
		ArrayList<Contact> contactpourliste = new ArrayList<Contact>();
		
		try{
			FileInputStream fcontact = new FileInputStream("File/ListContact/ListContact.ser");
			ObjectInputStream in = new ObjectInputStream (fcontact) ;
			contactpourliste = (ArrayList<Contact>) in.readObject() ;
			if (contactpourliste != null)
			in.close();
		}
		catch (Exception ex){
			System.err.println ("Erreur de lecture " + ex) ;
		}
		
		JLabel[] labelContact = new JLabel[((ArrayList<Contact>) contactpourliste).size()];
		for (int i = 0; i<((ArrayList<Contact>) contactpourliste).size(); i++) {
			//JLabel labContact = new JLabel();
			//JLabel labContact2 = CreationJlabel(labContact);
			JLabel labContact = new JLabel();
			labContact.setText(contactpourliste.get(i).getNom() + " " + contactpourliste.get(i).getPrenom() + " " + contactpourliste.get(i).getNum());
			labelContact[i] = labContact;
			
			panelListe.add(labContact);

			labContact.setBackground(Color.black);
			labContact.setForeground(Color.white);
		}

		//ajout d'un élément dans la liste
		jPanelCenterinCenter.add(panelListe);
		panelListe.setBackground(Color.black);
		panelListe.setForeground(Color.white);


		//add panel
		getContentPane().add(jPanelNorth, BorderLayout.NORTH);
		getContentPane().add(jPanelCenter, BorderLayout.CENTER);
		jPanelCenter.add(jPanelNorthinCenter, BorderLayout.NORTH);

		jPanelCenter.add(jPanelCenterinCenter, BorderLayout.CENTER);

		//ouverture de la fenêtre AddContact
		contactEcouteur mouse = new contactEcouteur();
		addContact.addMouseListener(mouse);
		dispose();


	}
	class contactEcouteur extends MouseAdapter {
		@Override
		public void mouseReleased(MouseEvent e) {
			AddContact contact = new AddContact();
			contact.setVisible(true);
			contact.setSize(480, 800);
			contact.setResizable(false);
			contact.setLocationRelativeTo(null);
			dispose();
		}
	}
	public void add(Component nom2, Component prenom2, Component num2) {

	}
//	
//	public JLabel CreationJlabel(JLabel x){
//		x=new JLabel();
//		return x;
//	}

}
