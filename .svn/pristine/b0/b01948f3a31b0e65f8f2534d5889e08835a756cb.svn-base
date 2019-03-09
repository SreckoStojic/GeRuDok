package actions;

import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;

import mainFrame.MainFrame;
import model.GraphSlot;

@SuppressWarnings("serial")
public class Redo extends AbstractGerudokActions{
	private GraphSlot slot;

	public Redo(GraphSlot slot) {
		this.slot = slot;
		putValue("Name", MainFrame.getInstance().getResourceBundle().getString("miRedo"));
		putValue("SmallIcon", loadIcon("images/redo.png"));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		slot.getCommandManager().doCommand();
		MainFrame.getInstance().getTree().updateUI();
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());

	}

}
