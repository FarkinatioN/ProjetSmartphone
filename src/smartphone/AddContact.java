package smartphone;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class AddContact extends DefaultFrame {
	private static final long serialVersionUID = 1L;
	
	private JLabel LastName = new JLabel("Nom : ");
	private JLabel FirstName = new JLabel("Prénom : ");
	private JLabel Number = new JLabel("Num\u00E9ro : ");
	private JLabel Photo = new JLabel("Choisir une photo depuis la galerie : ");

	private JTextField TextLastName = new JTextField(15);
	private JTextField TextFirsttName = new JTextField(15);
	private JTextField TextNumber = new JTextField(15);
	private JButton Parcourir = new JButton("Parcourir");

	private JButton buttonOk = new JButton("Ok");
	private JButton buttonCancel = new JButton("Cancel");


	private JPanel panel_center = new JPanel();
	private JPanel panel_south = new JPanel();

	public AddContact(){
		setUndecorated(true);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panel_center.setBackground(Color.BLACK);
		panel_south.setBackground(Color.BLACK);

		panel_center.setLayout(new GridLayout(8,0));

		panel_center.add(LastName);
		panel_center.add(TextLastName);
		panel_center.add(FirstName);
		panel_center.add(TextFirsttName);
		panel_center.add(Number);
		panel_center.add(TextNumber);
		panel_center.add(Photo);
		panel_center.add(Parcourir);


		panel_south.add(buttonOk);
		panel_south.add(buttonCancel);

		EcouteurCancel ecouteurCancel = new EcouteurCancel();
		buttonCancel.addActionListener(ecouteurCancel);

		EcouteurOK ecouteurOK = new EcouteurOK();
		buttonOk.addActionListener(ecouteurOK);

		getContentPane().add(panel_center);
		getContentPane().add(panel_south, BorderLayout.SOUTH);

		pack();

		//Couleur text
		LastName.setForeground(Color.white);
		FirstName.setForeground(Color.white);
		Number.setForeground(Color.white);
		Photo.setForeground(Color.white);

	}
	class Ecouteur implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource()==buttonOk)
				setVisible(true);
			else
				dispose();
		}
	}

	class EcouteurOK implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e){
			AddContact newContact = new AddContact();
			if (e.getSource()==buttonOk){
				FileOutputStream fichier = null;
				try {
					fichier = new FileOutputStream("File/ListContact/ListContact.txt");
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				BufferedOutputStream bfichier = new BufferedOutputStream(fichier);
				ObjectOutputStream obfichier = null;
				try {
					obfichier = new ObjectOutputStream(bfichier);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					obfichier.writeObject(newContact);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					obfichier.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}

		}
		public void serializeObjet(AddContact newContact) throws IOException {
			FileOutputStream fichier = new FileOutputStream("File/ListContact/ListContact.ser");
			BufferedOutputStream bfichier = new BufferedOutputStream(fichier);
			ObjectOutputStream obfichier = new ObjectOutputStream(bfichier);
			obfichier.writeObject(newContact);
			obfichier.close();
		}

	}

	class EcouteurCancel implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent a) {
			dispose();
		}
	}
}


