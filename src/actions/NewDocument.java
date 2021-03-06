package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;
import javax.swing.tree.MutableTreeNode;

import mainFrame.MainFrame;
import model.Document;
import model.Project;

@SuppressWarnings("serial")
public class NewDocument extends AbstractGerudokActions  {
	public NewDocument()
	  {
	    putValue("SmallIcon", loadIcon("images/new-document.png"));
	    putValue("Name", "New Document");
	    putValue("ShortDescription", "New Document");
	    putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
	   
	  }
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (MainFrame.getInstance().getTree().getSelectionPath() != null){
			MutableTreeNode node = (MutableTreeNode)MainFrame.getInstance().getTree().getSelectionPath().getLastPathComponent();
			
			if ((node instanceof Project)){
				Project project = (Project)node;
				String name=MainFrame.getInstance().getResourceBundle().getString("Document");
				Document document = new Document(project, name+ " " + (node.getChildCount()+1));
				node.insert(document, node.getChildCount());
				MainFrame.getInstance().getTree().updateUI();
			
			
			
			}
		}
		
		
	
	}

}
