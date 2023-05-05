package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FramePseudo extends JFrame implements ActionListener
{
	private JTextField txtPsd;
	private JButton btnValide,btnAnnuler;
	private JLabel lblPsd;
	private FrameClient frameClient;

	public FramePseudo(FrameClient frameClient)
	{
		this.setLayout(new GridLayout(2,2));
		this.setTitle("Changement Pseudo");
		this.setLocationRelativeTo(null);
		this.setSize(250,130);
		this.setResizable(false);

		this.frameClient = frameClient;

		/*creation des composants */

		this.txtPsd     = new JTextField();
		this.btnValide  = new JButton ("Valider");
		this.btnAnnuler = new JButton ("Annuler");
		this.lblPsd  	= new JLabel  ("Pseudo" );

		this.txtPsd.setEditable(true);

		/*positionnement des composants*/

		this.add(this.lblPsd);
		this.add(this.txtPsd);
		this.add(this.btnAnnuler);
		this.add(this.btnValide);

		/*Activation des composants */
		this.btnAnnuler.addActionListener(this);
		this.btnValide.addActionListener(this);

		this.setVisible(true);
	}

	public void actionPerformed (ActionEvent e)
	{
		if(e.getSource() == this.btnAnnuler)
			this.dispose();
		if(e.getSource() == this.btnValide)
		{
			this.frameClient.changementPseudo(this.txtPsd.getText());
			this.dispose();
		}

	}
}