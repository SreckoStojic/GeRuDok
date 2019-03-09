package actions;

import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;

import mainFrame.MainFrame;
import model.Project;
import model.Trash;
import model.Workspace;

@SuppressWarnings("serial")
public class RestoreAction extends AbstractGerudokActions {
    public RestoreAction(){
    	
    	putValue("SmallIcon", loadIcon("images/restore.png"));
		putValue("Name", "Restore");
		putValue("ShortDescription", "Restore");
		
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MutableTreeNode node = (MutableTreeNode) MainFrame.getInstance()
				.getTrash().getSelectionPath().getLastPathComponent();
		if (node instanceof Project){
			Trash trash = MainFrame.getInstance().getTrashModel();
			trash.restore(node);
			MainFrame.getInstance().getDesktopPane().updateUI();
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
					.getTrash());
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
					.getTree());
		}
		
	}

}
