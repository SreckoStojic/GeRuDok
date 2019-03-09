package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

import mainFrame.MainFrame;
import model.Document;
import model.GraphSlot;
import model.Page;
import model.Project;
import model.TextSlot;
import model.Trash;
import model.Workspace;
import views.DocumentViewer;
import views.PageViewer;
import views.ProjectViewer;
import elements.CircleElement;
import elements.RectangleElement;

@SuppressWarnings("serial")
public class DeleteItem extends AbstractGerudokActions  {
	public DeleteItem() {
		putValue("SmallIcon", loadIcon("images/delete-icon.png"));
		putValue("Name", "Delete");
		putValue("ShortDescription", "Delete");
		putValue(ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		TreePath path = MainFrame.getInstance().getTree().getSelectionPath();
		if (path != null) {
			removeSelected();
		}
	}

	private void removeSelected() {

		MutableTreeNode node = (MutableTreeNode) MainFrame.getInstance()
				.getTree().getSelectionPath().getLastPathComponent();
		ProjectViewer projectViewer = (ProjectViewer) MainFrame.getInstance().getDesktopPane().getSelectedFrame();
		if (node instanceof Project) {
			Project project = (Project) node;
			Workspace workspace = (Workspace) project.getParent();
			if(JOptionPane.showConfirmDialog(MainFrame.getInstance(),MainFrame.getInstance().getResourceBundle().getString("emptyTrashQuestion"),
			   MainFrame.getInstance().getResourceBundle().getString("confirmDelete"), JOptionPane.YES_NO_OPTION) == 1){
				
				workspace.remove(project);	
			}
			else {
				Trash trash = (Trash) MainFrame.getInstance().getTrash().getModel().getRoot();
				trash.insert(project, trash.getChildCount());
				workspace.remove(project);
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
						.getTrash());
			
				
			}
			
			                                                             // model iz controlera obavestava viewer
  							                                             // da je doslo do promene
			MainFrame.getInstance().getDesktopPane().updateUI();
			
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
					.getTree());
			
			

		} else if (node instanceof Document) {
			Document document = (Document) node;
			Project project = (Project) document.getParent();
			project.remove(document); // model iz controlera obavestava viewer
										// da je doslo do promene
			MainFrame.getInstance().getDesktopPane().updateUI();
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
					.getTree());
		} else if (node instanceof Page) {
			Page page = (Page) node;
			Document document = (Document) page.getParent();
			document.remove(page); // model iz controlera obavestava viewer da
									// je doslo do promene
			DocumentViewer documentViewer = projectViewer.getSelectedDocumentViewer();
			documentViewer.removePageViewerForPage(page);
			MainFrame.getInstance().getTree().updateUI();
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
					.getTree());
		} else if (node instanceof TextSlot) {
			TextSlot textSlot = (TextSlot) node;
			Page page = (Page) textSlot.getParent();
			DocumentViewer documentViewer = projectViewer.getSelectedDocumentViewer();

			PageViewer pageViewer = documentViewer.getPageViewerForPage(page);
			pageViewer.removeTextViewerForSlot(textSlot);

			page.remove(textSlot);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
					.getTree());
		} else if (node instanceof GraphSlot) {
			GraphSlot graphSlot = (GraphSlot) node;
			Page page = (Page) graphSlot.getParent();
			DocumentViewer documentViewer = projectViewer.getSelectedDocumentViewer();

			PageViewer pageViewer = documentViewer.getPageViewerForPage(page);
			pageViewer.removeGraphViewerForSlot(graphSlot);
			page.remove(graphSlot);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
					.getTree());
		} else if (node instanceof CircleElement) {
			CircleElement circleElement = (CircleElement) node;
			GraphSlot graphSlot = (GraphSlot) circleElement.getParent();
			graphSlot.remove(circleElement);

			DocumentViewer documentviewer = projectViewer.getSelectedDocumentViewer();

			Page page = (Page) graphSlot.getParent();
			PageViewer pageviewer = documentviewer.getPageViewerForPage(page);
			pageviewer.update(null, null);

			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
					.getTree());
		} else if (node instanceof RectangleElement) {
			RectangleElement recElement = (RectangleElement) node;
			GraphSlot graphSlot = (GraphSlot) recElement.getParent();
			graphSlot.remove(recElement);

			DocumentViewer documentviewer = projectViewer.getSelectedDocumentViewer();

			Page page = (Page) graphSlot.getParent();
			PageViewer pageviewer = documentviewer.getPageViewerForPage(page);
			pageviewer.update(null, null);

			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
					.getTree());

		}
		Workspace workspace = MainFrame.getInstance().getWorkspace();
	    if (workspace.getChildCount() == 0){
	    	TreePath path = (TreePath)new TreePath(MainFrame.getInstance().getTree().getModel().getRoot());
	    	MainFrame.getInstance().getTree().setSelectionPath(path);
	    	ActionManager actionManager = MainFrame.getInstance().getActionManager();
	    	actionManager.getNewProject().setEnabled(true);
	    	
	    	
            MainFrame.getInstance().getDesktopPane().updateUI();
			
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
					.getTree());
	    	
		
	     }
	    else {
	    	TreePath path = (TreePath)new TreePath(MainFrame.getInstance().getTree().getModel().getChild(workspace, 0));
	    	MainFrame.getInstance().getTree().setSelectionPath(path);
	    	MainFrame.getInstance().getTree().setLeadSelectionPath(path);
            MainFrame.getInstance().getDesktopPane().updateUI();
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance()
					.getTree());
	    	
	    }

	}

}