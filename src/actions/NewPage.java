package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;
import javax.swing.tree.MutableTreeNode;

import mainFrame.MainFrame;
import model.Document;
import model.Page;
import views.DocumentViewer;
import views.PageViewer;
import views.ProjectViewer;

@SuppressWarnings("serial")
public class NewPage extends AbstractGerudokActions  {
	public NewPage()
	  {
	    putValue("SmallIcon", loadIcon("images/new-page.png"));
	    putValue("Name", "New Page");
	    putValue("ShortDescription", "New Page");
	    putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
	   
	  }
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (MainFrame.getInstance().getTree().getSelectionPath()
				.getLastPathComponent() != null) {
			MutableTreeNode node = (MutableTreeNode) MainFrame.getInstance()
					.getTree().getSelectionPath().getLastPathComponent();
			ProjectViewer projectViewer = (ProjectViewer) MainFrame.getInstance().getDesktopPane().getSelectedFrame();

			if ((node instanceof Document)) {
				Document document = (Document) node;
				String name=MainFrame.getInstance().getResourceBundle().getString("Page");
				Page page = new Page(document, name+" "
						+ (node.getChildCount() + 1));
				node.insert(page, (node.getChildCount()));
				PageViewer pageviewer = new PageViewer(page);

				DocumentViewer documentViewer = projectViewer.getSelectedDocumentViewer();
				documentViewer.addPageViewer(pageviewer);

				MainFrame.getInstance().getTree().updateUI();
			}
		}
	}

}
