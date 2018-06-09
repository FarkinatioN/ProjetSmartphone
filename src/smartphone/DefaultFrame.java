package smartphone;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.*;

public class DefaultFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private ImageIcon homeImage = new ImageIcon("Image/home.png");
	private JButton home = new JButton(homeImage);
	private ImageIcon backImage = new ImageIcon("Image/back.png");
	private JButton back = new JButton(backImage);
	private ImageIcon overviewImage = new ImageIcon("Image/overview.png");
	private JButton overview = new JButton(overviewImage);
	
	private JLabel operateur = new JLabel("Swisscom");

	//création Panel
	private JPanel jPanelSouth = new JPanel();
	private JPanel jPanelHeure = new JPanel();
	
	//ajout Heure
	SimpleDateFormat h = new SimpleDateFormat ("hh:mm   ");
	Date currentTime = new Date();
	JLabel heureString = new JLabel(h.format(currentTime));

	public DefaultFrame() {		
		
		// default parameters
		setUndecorated(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(480, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.BLACK);		
		
		//jPanelHeure en BoxLayout
		jPanelHeure.setLayout(new BoxLayout(jPanelHeure, BoxLayout.LINE_AXIS));
		
		//création du panel
		jPanelHeure.add(operateur);
		jPanelHeure.add(Box.createHorizontalGlue());
		jPanelHeure.add(heureString);
		
		//modification dans le panel
		operateur.setForeground(Color.white);
		heureString.setForeground(Color.white);
		jPanelHeure.setBackground(Color.black);

		// jPanelSouth --> le panel en BoyLayout
		jPanelSouth.setLayout(new BoxLayout(jPanelSouth, BoxLayout.LINE_AXIS));

		// add space with horizontal glue
		jPanelSouth.add(Box.createHorizontalGlue());
		jPanelSouth.add(back);
		jPanelSouth.add(Box.createHorizontalGlue());
		jPanelSouth.add(home);
		jPanelSouth.add(Box.createHorizontalGlue());
		jPanelSouth.add(overview);
		jPanelSouth.add(Box.createHorizontalGlue());
		
		//modif jPanelSouth
		jPanelSouth.setBackground(Color.BLACK);

		// add panel
		add(jPanelHeure, BorderLayout.NORTH);
		add(jPanelSouth, BorderLayout.SOUTH);

		back.setBackground(Color.black);
		home.setBackground(Color.black);
		overview.setBackground(Color.black);

		back.setBorderPainted(false);
		home.setBorderPainted(false);
		overview.setBorderPainted(false);

		back.setFocusPainted(false);
		home.setFocusPainted(false);
		overview.setFocusPainted(false);

		back.setContentAreaFilled(false);
		home.setContentAreaFilled(false);
		overview.setContentAreaFilled(false);

		//retour sur page d'avant dans ce cas home
		EcouteurBack retour = new EcouteurBack();
		back.addActionListener(retour);
		//retour home
		EcouteurHome retourHome = new EcouteurHome();
		home.addActionListener(retourHome);
		//ecouteur over
		EcouteurOver over = new EcouteurOver();
		overview.addMouseListener(over);

	}
	class EcouteurBack implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent a) {
			dispose();
		}
	}
	class EcouteurHome implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent a) {
			Menu a1 = new Menu ();
			a1.setVisible(true);
		}
	}
	class EcouteurOver extends MouseAdapter{
		@Override
		public void mouseReleased(MouseEvent f){
			System.exit(0);
		}
	}
	public static String getDateFormatted(String format){
		DateTimeFormatter dateTimeFormatted = DateTimeFormatter.ofPattern(format);  
	    LocalDateTime now = LocalDateTime.now();  
		return dateTimeFormatted.format(now);
	}
}