package smartphone;

import java.awt.*;

import javax.swing.*;

public class GalerieImage extends DefaultFrame{
	private static final long serialVersionUID = 1L;

	//Composition JpanelNorthinCenter
	private JLabel TextListGalerie = new JLabel("Pellicule");

	//création Panel
	private JPanel jPanelCenter = new JPanel(new BorderLayout());
	private JPanel jPanelNorthinCenter = new JPanel(new BorderLayout());
	private JPanel jPanelCenterinCenter = new JPanel();

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
		jPanelNorthinCenter.add(Box.createHorizontalGlue());
		jPanelNorthinCenter.add(TextListGalerie);
		jPanelNorthinCenter.add(Box.createHorizontalGlue());
		jPanelNorthinCenter.add(Box.createHorizontalGlue());
		//modif couleur fond et écriture texte
		TextListGalerie.setBackground(Color.black);
		TextListGalerie.setForeground(Color.white);
		
		//création jPanelCenterinCenter
		
		//modif du JpanelCenterinCenter
		jPanelCenterinCenter.setLayout(new GridLayout(1, 0, 0, 0));
		jPanelCenterinCenter.setBackground(Color.BLACK);
		
		//add panel
		getContentPane().add(jPanelCenter, BorderLayout.CENTER);
		jPanelCenter.add(jPanelNorthinCenter, BorderLayout.NORTH);
		jPanelCenter.add(jPanelCenterinCenter, BorderLayout.CENTER);	


	}

}
