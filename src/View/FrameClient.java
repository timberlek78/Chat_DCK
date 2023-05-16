package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FrameClient extends JFrame {

	/*
	 * VARIABLES
	 */
	private String      IP;
	private int         port;
	private PanelClient panelClient;
	private PanelDeco   panelJolie;

	/*
	 * Constructeur principale
	 */
	public FrameClient(String IP,int port) {
		this.IP   = IP;
		this.port = port;

		//Ajoute le panel à la frame
		this.setSize(new Dimension(600, 500));
		this.setLayout(new GridLayout(1, 2));
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon(getClass().getResource("./images/icon.png")).getImage());
		this.setResizable(false);

		this.panelClient = new PanelClient(this);
		this.panelJolie  = new PanelDeco  (this, this.panelClient.getClient());

		this.add(this.panelJolie);
		this.add(this.panelClient);

		this.setVisible(true);
		this.addWindowListener(new GereFenetre());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void changementPseudo(String ch) {
		this.panelClient.changementPseudo(ch);
	}

	//Creation de la classe privé GereFenetre.
	private class GereFenetre extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			FrameClient.this.panelClient.disconnect();
		}
	}

	//Methodes
	public PanelClient getPanel(){return this.panelClient;}
	public String getIp(){return this.IP;}
	public int getPort(){return this.port;}
}