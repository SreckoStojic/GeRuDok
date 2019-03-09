package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import mainFrame.MainFrame;
import model.GraphSlot;
import command.DeleteComand;

@SuppressWarnings("serial")
public class DeleteElementAction extends AbstractGerudokActions {
	private GraphSlot slot;

	public DeleteElementAction(GraphSlot slot)
	// TODO Auto-generated constructor stub
	{
		putValue("SmallIcon", loadIcon("images/delete-icon.png"));
		putValue("Name", "DeleteElement");
		putValue("ShortDescription",MainFrame.getInstance().getResourceBundle().getString("miDelete"));
		putValue(ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));
		this.slot = slot;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	
		slot.getCommandManager().addCommand(new DeleteComand(slot));
	
		slot.deleteElement(this.slot.getSelectionModel()
				.getSelectionList());
		
		slot.getSelectionModel().removeAllFromSelectionList();
		
		MainFrame.getInstance().getTree().updateUI();
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
	}

}
