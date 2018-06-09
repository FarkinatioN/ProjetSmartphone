package smartphone;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class UnlockScreen extends DefaultFrame{

//	private ImageIcon unlockImage = new ImageIcon("Image/unlock.png");
//	private JButton unlockBtn = new JButton(unlockImage);

	private JLabel unlock = new JLabel("Glisser pour d\u00E9verouiller");
	
	private JPanel jPanelCenter = new JPanel();
	private final JSlider slider = new JSlider();

	public UnlockScreen() {

		// default parameters
		setVisible(true);

		// création du panel south dans le center
		jPanelCenter.setLayout(new GridLayout(2,1));
		unlock.setHorizontalAlignment(SwingConstants.CENTER);
		jPanelCenter.add(unlock);
//		jPanelCenter.add(unlockBtn);

		//modif dans le panel
		jPanelCenter.setBackground(Color.black);
//		unlockBtn.setBackground(Color.black);
//		unlockBtn.setBorderPainted(false);
//		unlockBtn.setFocusPainted(false);
//		unlockBtn.setContentAreaFilled(false);
		
		unlock.setHorizontalTextPosition(SwingConstants.CENTER);
		unlock.setBounds(150, 300, 200, 30);

		unlock.setForeground(Color.white);

		//Taille text
		Font taille = new Font("Arial",Font.BOLD,20);
		unlock.setFont(taille);

		// add panel
		getContentPane().add(jPanelCenter, BorderLayout.CENTER);
		slider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		
		slider.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		slider.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		slider.setMinimum(50);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setToolTipText("Slide to unlock");
		slider.setForeground(Color.WHITE);
		slider.setBackground(Color.BLACK);
		
		jPanelCenter.add(slider);

	}

}
