package smartphone;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GalerieImage extends DefaultFrame{

	//Composition JpanelNorthinCenter
	private JLabel TextListGalerie = new JLabel("Pellicule");

	//création Panel
	private JPanel jPanelCenter = new JPanel();

	private JPanel jPanelNorthinCenter = new JPanel();

	public GalerieImage(){
		
		//Taille text
		Font taille = new Font("Arial",Font.BOLD,24);
		TextListGalerie.setFont(taille);
		
		//jPanelCenter modif
		jPanelCenter.setBackground(Color.BLACK);

		//jPanelNorthinCenter création
		jPanelNorthinCenter.setLayout(new GridLayout());
		//jPanelNorthinCenter modif
		jPanelNorthinCenter.setBackground(Color.BLACK);
		//ajout objet dans panel nord du panel centre
		jPanelNorthinCenter.add(TextListGalerie);
		jPanelNorthinCenter.add(Box.createHorizontalGlue());
		jPanelNorthinCenter.add(Box.createHorizontalGlue());
		jPanelNorthinCenter.add(Box.createHorizontalGlue());
		//modif couleur fond et écriture texte
		TextListGalerie.setBackground(Color.black);
		TextListGalerie.setForeground(Color.white);
		
		//add panel
		add(jPanelCenter, BorderLayout.CENTER);
		jPanelCenter.add(jPanelNorthinCenter, BorderLayout.NORTH);
		


	}

}
