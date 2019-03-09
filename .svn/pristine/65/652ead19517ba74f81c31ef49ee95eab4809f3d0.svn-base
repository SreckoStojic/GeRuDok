package actions;

import java.awt.event.ActionEvent;

import javax.swing.tree.MutableTreeNode;

import mainFrame.MainFrame;
import model.Document;
import model.Project;

@SuppressWarnings("serial")
public class PasteDocumentAction extends AbstractGerudokActions {
	
        public PasteDocumentAction() {
        	putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle()
    				.getString("miPaste"));
    		putValue(NAME,
    				MainFrame.getInstance().getResourceBundle()
    						.getString("miPaste"));
    		putValue(SMALL_ICON, loadIcon("images/paste.png"));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MutableTreeNode node = (MutableTreeNode) MainFrame.getInstance()
				.getTree().getSelectionPath().getLastPathComponent();
		if (node instanceof Project && node != null){
			
	    Document document=MainFrame.getInstance().getListOfDocumet().get(0);
	    Project p=(Project)node;
	    p.addDocumentCopy(document);
			
			
		MainFrame.getInstance().getTree().updateUI();
		}
		
	}

}
