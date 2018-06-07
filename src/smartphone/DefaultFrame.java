package smartphone;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DefaultFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private ImageIcon homeImage = new ImageIcon("Image/home.png");
	private JButton home = new JButton(homeImage);
	private ImageIcon backImage = new ImageIcon("Image/back.png");
	private JButton back = new JButton(backImage);
	private ImageIcon overviewImage = new ImageIcon("Image/overview.png");
	private JButton overview = new JButton(overviewImage);
	

	//création Panel
	private JPanel jPanelSouth = new JPanel();	

	public DefaultFrame() {
		// default parameters
		setUndecorated(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(480, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.BLACK);
		jPanelSouth.setBackground(Color.BLACK);

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

		// add panel
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

	}
	public JButton getback() {
		return back;
	}

	public void removeback() {
		remove(back);
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
			if (a.getSource()==home)
				setVisible(false);
			else
				dispose();
		}
	}
}