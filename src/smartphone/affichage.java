package smartphone;

import java.awt.BorderLayout;
import java.awt.Component;
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
	
	private ImageIcon homeImage = new ImageIcon ("Image/home.png");
	private JButton home = new JButton(homeImage);
	private ImageIcon backImage = new ImageIcon("Image/back.png");
	private JButton back = new JButton(backImage);
	private ImageIcon overviewImage = new ImageIcon("Image/overview.png");
	private JButton overview = new JButton(overviewImage);
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
		
		jPanelSouth.add(back);
		jPanelSouth.add(home);
		jPanelSouth.add(overview);
		
		
		// add panel 
		add(jPanelNorth, BorderLayout.NORTH);
		add(jPanelSouth, BorderLayout.SOUTH);
		panbtn1.setLayout(new BorderLayout());
		//panbtn1.add(home);
		
		back.addActionListener(new Hello());
		home.addActionListener(new Hello());
		overview.addActionListener(new Hello());
		
		
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
