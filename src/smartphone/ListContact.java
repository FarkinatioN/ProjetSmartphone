package smartphone;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

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
		Contact newContact = new Contact(Contact.getNom(), Contact.getPrenom(), Contact.getNum());
		FileInputStream fcontact = new FileInputStream("File/ListContact/ListContact.ser");
		try{
			ObjectInputStream in = new ObjectInputStream (fcontact) ;
			newContact = (Contact) in.readObject() ;
			in.close();
		}
		catch (Exception ex){
			System.err.println ("Erreur de lecture " + ex) ;
		}
		javax.swing.ListModel model = new javax.swing.DefaultListModel();
		javax.swing.JList liste = new javax.swing.JList(model);
		 
		//ajout d'un élément dans la liste
		((javax.swing.DefaultListModel)liste.getModel()).addElement(newContact);
		jPanelCenterinCenter.add(liste);
		liste.setBackground(Color.black);
		liste.setForeground(Color.white);


		//add panel
		getContentPane().add(jPanelNorth, BorderLayout.NORTH);
		getContentPane().add(jPanelCenter, BorderLayout.CENTER);
		jPanelCenter.add(jPanelNorthinCenter, BorderLayout.NORTH);

		jPanelCenter.add(jPanelCenterinCenter, BorderLayout.CENTER);

		//ouverture de la fenêtre AddContact
		contactEcouteur mouse = new contactEcouteur();
		addContact.addMouseListener(mouse);


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

}
