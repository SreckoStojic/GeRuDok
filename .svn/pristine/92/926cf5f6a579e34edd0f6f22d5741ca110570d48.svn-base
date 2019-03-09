package actions;

import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;

import mainFrame.MainFrame;
import model.Trash;

@SuppressWarnings("serial")
public class DeleteFromTrashAction extends AbstractGerudokActions {
	public DeleteFromTrashAction(){
		putValue("SmallIcon", loadIcon("images/delete-icon.png"));
		putValue("Name", "Delete");
		putValue("ShortDescription", "Delete");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MutableTreeNode node = (MutableTreeNode) MainFrame.getInstance()
				.getTrash().getSelectionPath().getLastPathComponent();
		Trash trash = (Trash) MainFrame.getInstance().getTrash().getModel().getRoot();
		trash.remove(node);
		MainFrame.getInstance().getDesktopPane().updateUI();
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
				.getTrash());
		
	}

}
