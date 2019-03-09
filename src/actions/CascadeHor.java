package actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;

import mainFrame.MainFrame;

@SuppressWarnings("serial")
public class CascadeHor extends AbstractGerudokActions {
	
	public CascadeHor() {
		// TODO Auto-generated constructor stub
	  
		putValue("Name", MainFrame.getInstance().getResourceBundle().getString("miCHorizontaly"));
	    putValue("SmallIcon", loadIcon("images/cascade-view.png"));
	    putValue("ShortDescription", MainFrame.getInstance().getResourceBundle().getString("miCHorizontaly"));
	    putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
	    
	}    

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		cascadeHor();
	}
	
	private void cascadeHor() {
		JInternalFrame[] activatedInternalFrames = MainFrame.getInstance().getDesktopPane().getAllFrames();
		int numberOfActivated = activatedInternalFrames.length;
		int numberOfVisible = 0;
		
		for (int i = 0; i < numberOfActivated; i++) {
			if (activatedInternalFrames[i].isVisible() == true) 
				numberOfVisible++;
		}
		
		if (numberOfVisible == 0)
			return;
		
		Dimension desktopPaneDimension = MainFrame.getInstance().getDesktopPane().getSize();
		int newWidth = desktopPaneDimension.width - numberOfVisible*25;
		int newHeight = desktopPaneDimension.height - numberOfVisible*25;
		
		int j = 0;
		for (int i = 0; i < numberOfActivated; i++) {
			if (activatedInternalFrames[i].isVisible() == true) {
				activatedInternalFrames[i].setSize(newWidth, newHeight);
				activatedInternalFrames[i].setLocation(30*j, 30*j);
				activatedInternalFrames[i].moveToFront();
				j++;
			}
		}
	}
	

}
