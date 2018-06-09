package smartphone;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Menu extends DefaultFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ImageIcon contactImage = new ImageIcon("Image/contact.png");
	private JButton contact = new JButton(contactImage);
	private ImageIcon galerieImage = new ImageIcon("Image/galerie.png");
	private JButton galerie = new JButton(galerieImage);
	private ImageIcon calendarImage = new ImageIcon("Image/calendar.png");
	private JButton calendar = new JButton(calendarImage);
	private ImageIcon callImage = new ImageIcon("Image/call.png");
	private JButton call = new JButton(callImage);
	private ImageIcon messageImage = new ImageIcon("Image/message.png");
	private JButton message = new JButton(messageImage);
	private ImageIcon folderImage = new ImageIcon("Image/folder.png");
	private JButton folder = new JButton(folderImage);
	private ImageIcon storeImage = new ImageIcon("Image/store.png");
	private JButton store = new JButton(storeImage);


	//création Panel
	private JPanel jPanelCenter = new JPanel();

	public Menu() {
		// default parameters
		//setVisible(true);

		//jPanelCenter
		jPanelCenter.setLayout(new GridLayout(3,2));
		jPanelCenter.setBackground(Color.BLACK);

		jPanelCenter.add(contact);
		jPanelCenter.add(galerie);
		jPanelCenter.add(calendar);
		jPanelCenter.add(call);
		jPanelCenter.add(message);
		jPanelCenter.add(folder);
		jPanelCenter.add(store);

		JButton[] buttons = new JButton[2];
		for (int i = 0; i<2; i++) {
			JButton jb = new JButton();
			buttons[i] = jb;

			jPanelCenter.add(jb);

			jb.setBackground(Color.black);
			jb.setBorderPainted(false);
			jb.setFocusPainted(false);
			jb.setContentAreaFilled(false);
		}

		//jPanelNorth
		//jPanelNorth.add(dateLabel);


		// add panel
		add(jPanelCenter, BorderLayout.CENTER);

		contact.setBackground(Color.black);
		galerie.setBackground(Color.black);
		calendar.setBackground(Color.black);
		call.setBackground(Color.black);
		message.setBackground(Color.black);
		folder.setBackground(Color.black);
		store.setBackground(Color.black);

		contact.setBorderPainted(false);
		galerie.setBorderPainted(false);
		calendar.setBorderPainted(false);
		call.setBorderPainted(false);
		message.setBorderPainted(false);
		folder.setBorderPainted(false);
		store.setBorderPainted(false);

		contact.setFocusPainted(false);
		galerie.setFocusPainted(false);
		calendar.setFocusPainted(false);
		call.setFocusPainted(false);
		message.setFocusPainted(false);
		folder.setFocusPainted(false);
		store.setFocusPainted(false);

		contact.setContentAreaFilled(false);
		galerie.setContentAreaFilled(false);
		calendar.setContentAreaFilled(false);
		call.setContentAreaFilled(false);
		message.setContentAreaFilled(false);
		folder.setContentAreaFilled(false);
		store.setContentAreaFilled(false);

		// pack();

		//ouverture de la fenêtre contact
		contactEcouteur mouseContact = new contactEcouteur ();
		contact.addMouseListener(mouseContact);
		
		//ouverture de la fenêtre galerie
		galerieEcouteur mouseGalerie = new galerieEcouteur();
		galerie.addMouseListener(mouseGalerie);
		
		
	}
	class galerieEcouteur extends MouseAdapter {
		@Override
		public void mouseReleased(MouseEvent e) {
			GalerieImage gal = new GalerieImage();
			gal.setVisible(true);
			gal.setSize(480, 800);
			gal.setResizable(false);
			gal.setLocationRelativeTo(null);
		}
	}
	class contactEcouteur extends MouseAdapter {
		@Override
		public void mouseReleased(MouseEvent e) {
			ListContact contact = new ListContact();
			contact.setVisible(true);
			contact.setSize(480, 800);
			contact.setResizable(false);
			contact.setLocationRelativeTo(null);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}