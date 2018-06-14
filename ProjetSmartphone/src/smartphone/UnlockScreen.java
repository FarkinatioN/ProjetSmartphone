package smartphone;

import java.awt.*;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.event.*;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;;

public class UnlockScreen extends DefaultFrame{

	private static final long serialVersionUID = 1L;
	private ImageIcon unlockImage = new ImageIcon("Image/unlock.png");
	private JButton unlockBtn = new JButton(unlockImage);

	private Icon sliderImage = new ImageIcon("Image/slider.png");

	private JLabel unlock = new JLabel("Glisser pour déverouiller");

	private JPanel jPanelCenter = new JPanel();
	
	private final JSlider slider = new JSlider();

	// Date
	SimpleDateFormat h = new SimpleDateFormat ("dd MMMM yyyy");
	Date dateDay = new Date();
	JLabel heureString = new JLabel(h.format(dateDay));

	public UnlockScreen() {

		// default parameters
		setVisible(true);
		jPanelCenter.setForeground(Color.WHITE);

		//modif dans le panel
		jPanelCenter.setBackground(Color.black);

		//Taille text
		Font taille = new Font("Arial",Font.BOLD,20);

		// add panel
		getContentPane().add(jPanelCenter, BorderLayout.CENTER);

		//devérouiller
		sliderUnlock slideU = new sliderUnlock();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setBounds(84, 615, 314, 24);
		slider.setPreferredSize(new Dimension(150, 30));
		slider.setValue(0);
		slider.addMouseListener(slideU);
		jPanelCenter.setLayout(null);

		slider.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		slider.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		slider.setBackground(Color.black);

		//ajout dans panel
		jPanelCenter.add(slider);
		unlock.setHorizontalAlignment(SwingConstants.CENTER);
		jPanelCenter.add(unlock);
		jPanelCenter.add(unlockBtn);

		//modif unlocBtn
		unlockBtn.setBackground(Color.black);
		unlockBtn.setBorderPainted(false);
		unlockBtn.setFocusPainted(false);
		unlockBtn.setContentAreaFilled(false);
		unlockBtn.setBounds(165, 150, 150, 150);

		unlock.setHorizontalTextPosition(SwingConstants.CENTER);
		unlock.setBounds(124, 578, 234, 24);

		unlock.setForeground(Color.white);
		unlock.setFont(taille);
		heureString.setFont(new Font("Tahoma", Font.PLAIN, 20));


		//date
		heureString.setBackground(Color.BLACK);
		heureString.setForeground(Color.WHITE);
		heureString.setBounds(182, 414, 126, 44);
		jPanelCenter.add(heureString);

	}

	class sliderUnlock extends MouseAdapter{
		@Override
		public void mouseReleased(MouseEvent arg0) {
			int valeur = slider.getValue();
			if (valeur == 100){
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
			else
				slider.setValue(0);
		}
	}
	public static String getDateFormatted(String format){
		DateTimeFormatter dateTimeFormatted = DateTimeFormatter.ofPattern(format);  
		LocalDateTime now = LocalDateTime.now();  
		return dateTimeFormatted.format(now);
	}
}
