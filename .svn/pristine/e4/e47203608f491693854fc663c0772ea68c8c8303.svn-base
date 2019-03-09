package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;

import mainFrame.MainFrame;

@SuppressWarnings("serial")
public class TileHor extends AbstractGerudokActions {
	
	public TileHor() {
		// TODO Auto-generated constructor stub
	  
		putValue("Name", MainFrame.getInstance().getResourceBundle().getString("miTileH"));
	    putValue("SmallIcon", loadIcon("images/tile-h.png"));
	    putValue("ShortDescription", MainFrame.getInstance().getResourceBundle().getString("miTileH"));
	    putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.ALT_MASK));
	    
	}    
	    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		tileHor();
	}
	
	private void tileHor() {
		JInternalFrame[] activatedInternalFrames = MainFrame.getInstance().getDesktopPane().getAllFrames();
		int numberOfActivated = activatedInternalFrames.length;
		int numberOfVisible = 0;
		
		for (int i = 0; i < numberOfActivated; i++) {
			if (activatedInternalFrames[i].isVisible() == true) {
				numberOfVisible++;
			}
		}
		
		if (numberOfVisible == 0)
			return;
		
		Dimension dimensionOfDesktopPane = MainFrame.getInstance().getDesktopPane().getSize();
		int newWidth = dimensionOfDesktopPane.width;
		int newHeight = dimensionOfDesktopPane.height/numberOfVisible;
		
		int j = 0;
		for (int i = 0; i < numberOfActivated; i++) {
			if (activatedInternalFrames[numberOfActivated-1-i].isVisible() == true){
				activatedInternalFrames[numberOfActivated-1-i].setLocation(0, j*newHeight);
				activatedInternalFrames[numberOfActivated-1-i].setSize(newWidth, newHeight);
				j++;
			}
		}
	}
}
