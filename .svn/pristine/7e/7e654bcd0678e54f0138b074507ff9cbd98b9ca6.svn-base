package actions;

import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;

import mainFrame.MainFrame;
import model.Trash;

@SuppressWarnings("serial")
public class EmptyTrashAction extends AbstractGerudokActions {
	public  EmptyTrashAction() 
		// TODO Auto-generated constructor stub
	 {
		putValue("SmallIcon", loadIcon("images/empty_trash.png"));
		putValue("Name", "Empty trash");
		putValue("ShortDescription", "Empty trash");
	

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MutableTreeNode node = (MutableTreeNode) MainFrame.getInstance()
				.getTrash().getSelectionPath().getLastPathComponent();
		if (node instanceof Trash){
			Trash trash = MainFrame.getInstance().getTrashModel();
			trash.emptyTrash();
			MainFrame.getInstance().getDesktopPane().updateUI();
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
					.getTrash());
		}
		
	}

}
