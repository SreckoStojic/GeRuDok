package views;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import mainFrame.MainFrame;
import model.Document;
import model.Project;
import observers.GeRuDokEvent;

@SuppressWarnings("serial")
public class ProjectViewer extends JInternalFrame implements Observer {
	private JTabbedPane documentsTab = new JTabbedPane();
	private Project project;
	public static int offset = 0;
	private ArrayList<DocumentViewer> documentViewers = new ArrayList<DocumentViewer>();

	public ProjectViewer(Project project) {
		super(project.toString(), true, true, true, true);
		this.project = project;
		this.project.addObserver(this);

		ImageIcon image = new ImageIcon("images/new-project.png");
		setFrameIcon(image);

		setSize(new Dimension(500, 550));
		setLocation(offset * 25, offset * 25);

		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		add(this.documentsTab);

		offset++;

		setVisible(true);

		addInternalFrameListener(new InternalFrameAdapter() {

			@Override
			public void internalFrameActivated(InternalFrameEvent e) {

				Object[] path = new Object[2];
				path[0] = project.getParent();
				path[1] = project;
			//	TreePath treePath = new TreePath(path);

				//MainFrame.getInstance().getTree().setSelectionPath(treePath);

			}
		});
	}

	public void update(Observable o, Object arg) {

		if (arg instanceof GeRuDokEvent) {

			GeRuDokEvent geRuDokEvent = (GeRuDokEvent) arg;
			int operation = geRuDokEvent.getOperation();

			if (operation == GeRuDokEvent.ADD) {

				Document document = (Document) geRuDokEvent.getObject();
				DocumentViewer documentViewer = new DocumentViewer(document);

				this.documentViewers.add(documentViewer);
				this.documentsTab.add(documentViewer, documentViewer
						.getDocument().toString());

				this.documentsTab.setSelectedIndex(this.documentsTab
						.getComponentCount() - 1);

			} else if (operation == GeRuDokEvent.REMOVE) {
				MutableTreeNode node = (MutableTreeNode) MainFrame
						.getInstance().getTree().getSelectionPath()
						.getLastPathComponent();
				ProjectViewer projectViewer = (ProjectViewer) MainFrame.getInstance().selectInternalFrame(project);

				projectViewer.removeDocumentViewer((Document) node);
			} else if (operation == GeRuDokEvent.rename) {

			
				setTitle(geRuDokEvent.getObject().toString());

			}
			else if(operation == GeRuDokEvent.SHORTCUT){
				//Document document = (Document) geRuDokEvent.getObject();
			//	DocumentViewer documentViewer=MainFrame.getInstance().selectInternalFrame(document.getParent()).getDocumentViewerForDocument(document);
			  //  documentViewer = new DocumentViewer(documentViewer);
	
			//	this.documentViewers.add(documentViewer);
			//	this.documentsTab.add(documentViewer, documentViewer.getDocument().toString());
			//	this.documentsTab.setSelectedIndex(this.documentsTab.getComponentCount() - 1);
				
			}
		}

		/*else {
			String s = (String) arg;
			this.setTitle(MainFrame.getInstance().getResourceBundle()
					.getString("Project")
					+ " " + s);
		}*/

	}

	public JTabbedPane getDocumentsTab() {
		return this.documentsTab;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public DocumentViewer getDocumentViewerForDocument(Document document) {
		DocumentViewer documentViewer = null;
		for (DocumentViewer documentViewerTemp : this.documentViewers) {
			if (documentViewerTemp.getDocument().equals(document)) {
				documentViewer = documentViewerTemp;
				break;
			}
		}
		return documentViewer;
	}

	public DocumentViewer setDocumentTab(TreeNode selectedNode) {
		DocumentViewer documentViewer = null;
		for (int i = 0; i < this.documentsTab.getComponentCount(); i++) {
			documentViewer = (DocumentViewer) this.documentsTab.getComponent(i);
			Document document = documentViewer.getDocument();
			if (document.equals((Document) selectedNode)) {
				this.documentsTab.setSelectedIndex(i);
				break;
			}
		}
		return documentViewer;
	}
	
	public DocumentViewer getSelectedDocumentViewer() {
		DocumentViewer documentViewer = null;
		ProjectViewer projectViewer = (ProjectViewer) MainFrame.getInstance().getDesktopPane().getSelectedFrame();
		documentViewer = (DocumentViewer) projectViewer.getDocumentsTab()
				.getSelectedComponent();

		return documentViewer;
	}
	

	public void removeDocumentViewer(Document document) {
		DocumentViewer docViewer = null;
		for (DocumentViewer documentTemp : this.documentViewers) {
			if (documentTemp.getDocument().equals(document)) {
				docViewer = documentTemp;
				break;
			}
		}
		if (docViewer != null) {
			this.documentsTab.remove(docViewer);
			this.documentViewers.remove(docViewer);
			// update(null, null);
		}

	}

}
