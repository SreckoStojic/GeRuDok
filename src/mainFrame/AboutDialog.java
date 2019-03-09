package mainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class AboutDialog extends JDialog {
	
	public AboutDialog(Frame parent){
		super(parent,MainFrame.getInstance().getResourceBundle().getString("aboutTitle"),true);
		setSize(500,400);
		setLayout(new BorderLayout());
		setLocationRelativeTo(parent);
		JPanel top = new JPanel();
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		JPanel botom = new JPanel();
		JLabel lbltop = new JLabel();
		JButton ok = new JButton(MainFrame.getInstance().getResourceBundle().getString("miOK"));
		botom.add(ok);
		botom.setPreferredSize(new Dimension(100,40));
		botom.setBackground(Color.LIGHT_GRAY);
		JTextArea taMilos=new JTextArea();
		JTextArea taSrecko=new JTextArea();
		left.setLayout(new BoxLayout(left,BoxLayout.Y_AXIS));
		right.setLayout(new BoxLayout(right,BoxLayout.Y_AXIS));
		
		
		ok.setToolTipText(MainFrame.getInstance().getResourceBundle().getString("closeAbout"));
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getMe().dispose();
				
			}
		});

		ImagePanel panelMilos = new ImagePanel(new ImageIcon(getClass().getResource("/images/milos.png")).getImage());
		panelMilos.setPreferredSize(new Dimension(230,250));
		ImagePanel panelSrecko = new ImagePanel(new ImageIcon(getClass().getResource("/images/srecko.png")).getImage());
		panelSrecko.setPreferredSize(new Dimension(230,250));
		
		
		lbltop.setText(MainFrame.getInstance().getResourceBundle().getString("tim96"));
		top.add(lbltop);
		
		left.setPreferredSize(new Dimension(230,100));
		right.setPreferredSize(new Dimension(230,100));
		
		
		top.setBackground(Color.LIGHT_GRAY);
		top.setPreferredSize(new Dimension(100,30));
		add(top,BorderLayout.NORTH);
		add(botom,BorderLayout.SOUTH);
		taMilos.setText(MainFrame.getInstance().getResourceBundle().getString("aboutMilos"));
		taMilos.setEditable(false);
		taSrecko.setText(MainFrame.getInstance().getResourceBundle().getString("aboutSrecko"));
		taSrecko.setEditable(false);
		
		
		
		left.add(taMilos);
		left.add(panelMilos);
		add(left,BorderLayout.WEST);
		
		
		right.add(taSrecko);
		right.add(panelSrecko);
		add(right,BorderLayout.EAST);
		
		
		
		
		setResizable(false);
		
		
	}
	
	private AboutDialog getMe() {
		return this;
	}

}
