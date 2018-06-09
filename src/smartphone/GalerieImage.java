package smartphone;

import java.awt.*;

import javax.swing.*;

public class GalerieImage extends DefaultFrame{
	private static final long serialVersionUID = 1L;

	//Composition JpanelNorthinCenter
	private JLabel TextListGalerie = new JLabel("Pellicule");

	//cr�ation Panel
	private JPanel jPanelCenter = new JPanel(new BorderLayout());

	private JPanel jPanelNorthinCenter = new JPanel();

	public GalerieImage(){
		
		//Taille text
		Font taille = new Font("Arial",Font.BOLD,24);
		TextListGalerie.setFont(taille);
		
		//jPanelCenter modif
		jPanelCenter.setBackground(Color.BLACK);

		//jPanelNorthinCenter cr�ation
		jPanelNorthinCenter.setLayout(new GridLayout());
		//jPanelNorthinCenter modif
		jPanelNorthinCenter.setBackground(Color.BLACK);
		//ajout objet dans panel nord du panel centre
		jPanelNorthinCenter.add(Box.createHorizontalGlue());
		jPanelNorthinCenter.add(TextListGalerie);
		jPanelNorthinCenter.add(Box.createHorizontalGlue());
		jPanelNorthinCenter.add(Box.createHorizontalGlue());
		//modif couleur fond et �criture texte
		TextListGalerie.setBackground(Color.black);
		TextListGalerie.setForeground(Color.white);
		
		//add panel
		add(jPanelCenter, BorderLayout.CENTER);
		jPanelCenter.add(jPanelNorthinCenter, BorderLayout.NORTH);
		


	}

}
