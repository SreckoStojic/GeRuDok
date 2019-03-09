package actions;

import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;

import mainFrame.MainFrame;
import model.GraphSlot;

@SuppressWarnings("serial")
public class Undo extends AbstractGerudokActions{
	 private GraphSlot slot;

	public Undo(GraphSlot slot) {
		putValue("Name", MainFrame.getInstance().getResourceBundle().getString("miUndo"));
		putValue("SmallIcon", loadIcon("images/undo.png"));
		this.slot=slot;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		slot.getCommandManager().undoCommand();
		MainFrame.getInstance().getTree().updateUI();
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
		
		
		
		

	}

}
