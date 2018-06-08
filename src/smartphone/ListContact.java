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
	private JPanel jPanelCenter = new JPanel();

	private JPanel jPanelNorthinCenter = new JPanel();
	private JPanel jPanelCenterinCenter = new JPanel();

	public ListContact(){
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
		
		JLabel[] contact = new JLabel[3];
//		for (int i = 0; i < contact.length; i++) {
//			JLabel JLcontact = new JLabel();
//			try {
//				JLcontact = deserializeObjet("File/ListContact/ListContact.ser");
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			contact[i] = JLcontact;
//			jPanelCenterinCenter.add(JLcontact);
//			
//			JLcontact.setBackground(Color.black);
//			JLcontact.setForeground(Color.white);
//			
//		}

		//add panel
		add(jPanelNorth, BorderLayout.NORTH);
		add(jPanelCenter, BorderLayout.CENTER);
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
		}	
	}
	public static JLabel deserializeObjet(String f) throws IOException, ClassNotFoundException {

		FileInputStream fichier = new FileInputStream(f);
		BufferedInputStream bfichier = new BufferedInputStream(fichier);
		ObjectInputStream obfichier = new ObjectInputStream(bfichier);
		JLabel afficheContact = (JLabel) obfichier.readObject();
		return afficheContact;
	}

}
