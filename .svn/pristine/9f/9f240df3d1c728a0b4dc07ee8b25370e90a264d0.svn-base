package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;
import javax.swing.tree.MutableTreeNode;

import mainFrame.MainFrame;
import model.Document;
import views.DocumentViewer;

@SuppressWarnings("serial")
public class CopyDocumentAction extends AbstractGerudokActions {
	public CopyDocumentAction()
	  {
	    putValue("SmallIcon", loadIcon("images/new-document.png"));
	    putValue("Name", "Copy document");
	    putValue("ShortDescription", "Copy document");
	    putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
	   
	  }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MutableTreeNode node = (MutableTreeNode) MainFrame.getInstance()
				.getTree().getSelectionPath().getLastPathComponent();
		if (node != null && node instanceof Document){
			Document document = (Document) node;
			DocumentViewer documentViewer=MainFrame.getInstance().selectInternalFrame(node.getParent()).getDocumentViewerForDocument(document);
			documentViewer.addCopyViewer(new DocumentViewer (documentViewer));
			MainFrame.getInstance().getListOfDocumet().add(document);
		
		}
	
	}

}
