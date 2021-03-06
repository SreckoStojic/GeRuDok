package gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import mainFrame.MainFrame;


@SuppressWarnings("serial")
public class StatusBar extends JPanel {
	
	private JLabel langStatusBar;
	private JLabel milos;
	private JLabel srecko;


  public StatusBar() {
    super(new GridLayout(1, 3));

    Border loweredbevel = BorderFactory.createLoweredBevelBorder();

    this.langStatusBar = new JLabel(MainFrame.getInstance().getResourceBundle().getString("langStatusBar"));
    this.langStatusBar.setHorizontalAlignment(0);
    this.langStatusBar.setBorder(loweredbevel);
    this.langStatusBar.setBorder(new LineBorder(Color.BLUE));
    this.milos = new JLabel(MainFrame.getInstance().getResourceBundle().getString("milos"));
    this.milos.setHorizontalAlignment(0);
    this.milos.setBorder(loweredbevel);
    this.milos.setBorder(new LineBorder(Color.BLUE));
    this.srecko = new JLabel(MainFrame.getInstance().getResourceBundle().getString("srecko"));
    this.srecko.setHorizontalAlignment(0);
    this.srecko.setBorder(loweredbevel);
    this.srecko.setBorder(new LineBorder(Color.BLUE));
    
    setPreferredSize(new Dimension(100, 23));

    Border loweredetched = BorderFactory.createEtchedBorder(1);
    setBorder(loweredetched);
    setBackground(Color.LIGHT_GRAY);

    add(this.langStatusBar);
    add(this.milos);
    add(this.srecko);
  }
  
  public void setLangStatusBar(JLabel langStatusBar) {
		this.langStatusBar = langStatusBar;
  }

  public JLabel getMilos() {
		return milos;
  }

  public void setMilos(JLabel milos) {
		this.milos = milos;
  }

  public JLabel getSrecko() {
		return srecko;
  }

  public void setSrecko(JLabel srecko) {
		this.srecko = srecko;
  }
  
  public JLabel getLangStatusBar() {
		return langStatusBar;
  }
}