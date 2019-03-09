package actions;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import mainFrame.MainFrame;

@SuppressWarnings("serial")
public class GridView extends AbstractGerudokActions{

	 public GridView()
	  {
	    putValue("SmallIcon", loadIcon("images/grid_view.png"));
	    putValue("Name", MainFrame.getInstance()
				.getResourceBundle().getString("miGridView"));
	    putValue("ShortDescription", MainFrame.getInstance()
				.getResourceBundle().getString("miGridView"));
	    putValue(ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
	  }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 MainFrame.getInstance().getDesktopPane().setLayout(new GridLayout(4, 4));
		 MainFrame.getInstance().getDesktopPane().validate();
	}
	

}
