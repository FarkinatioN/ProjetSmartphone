package smartphone;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class affichage extends JFrame {
	
	
	private JPanel panbtn1=new JPanel();
	
	private ImageIcon homeImage = new ImageIcon ("Image/homebutton.png");
	private JButton home = new JButton(homeImage);
	private JButton back = new JButton("Back");
	private JButton allelements = new JButton("All elements");
	private JLabel label1 = new JLabel();
	
	
	private JPanel jPanelNorth = new JPanel();
	private JPanel jPanelSouth = new JPanel();
	
	private Dimension d = new Dimension(480, 800);
	
	public affichage() {
		// default parameters
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(d);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
		label1.setText("Hello World!");
		
		jPanelNorth.add(label1);
		jPanelSouth.add(home);
		jPanelSouth.add(back);
		jPanelSouth.add(allelements);
		
		
		// add panel 
		add(jPanelNorth, BorderLayout.NORTH);
		add(jPanelSouth, BorderLayout.SOUTH);
		panbtn1.setLayout(new BorderLayout());
		//panbtn1.add(home);
		
		
		home.addActionListener(new Hello());
		
		back.addActionListener(new Hello());
		allelements.addActionListener(new Hello());
		
		
		// pack();
	}

}

class Hello implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	
	
	
	
	
	
	
	
	
	
	

}
