package smartphone;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class affichage extends JFrame {

	private ImageIcon homeImage = new ImageIcon("Image/home.png");
	private JButton home = new JButton(homeImage);
	private ImageIcon backImage = new ImageIcon("Image/back.png");
	private JButton back = new JButton(backImage);
	private ImageIcon overviewImage = new ImageIcon("Image/overview.png");
	private JButton overview = new JButton(overviewImage);

	private JPanel jPanelNorth = new JPanel();
	private JPanel jPanelSouth = new JPanel();
	
	
	private Dimension d = new Dimension(480, 800);

	public affichage() {
		// default parameters
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(d);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
		
		
		
		
		getContentPane().setBackground(Color.BLACK);
		jPanelSouth.setBackground(Color.black);
		jPanelNorth.setBackground(Color.BLACK);
		

		jPanelSouth.add(back);
		jPanelSouth.add(home);
		jPanelSouth.add(overview);
		
		
		
		
		// add panel
		add(jPanelNorth, BorderLayout.NORTH);
		add(jPanelSouth, BorderLayout.SOUTH);
		
		back.setBackground(Color.black);
		home.setBackground(Color.black);
		overview.setBackground(Color.black);

		// pack();
	}

}




