package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import elements.CircleElement;
import elements.RectangleElement;
import mainFrame.MainFrame;
import model.Document;
import model.GraphSlot;
import model.Page;
import model.Project;
import model.TextSlot;
import model.Trash;
import model.Workspace;
import views.ProjectViewer;
import actions.ActionManager;

@SuppressWarnings("serial")
public class TreeWithListener extends JTree implements TreeSelectionListener {
	private ActionManager actionManager;

	public TreeWithListener(Workspace workspace) {
		super(workspace);
		addTreeSelectionListener(this);
		addMouseListener(new TreeMouseAdapter());

	}

	public TreeWithListener(Trash trash) {
		super(trash);
		addTreeSelectionListener(this);
		addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				JTree tree = (JTree) e.getSource();
				TreePath path = tree.getPathForLocation(e.getX(), e.getY());
				if (path == null) {
					return;
				}
				tree.setSelectionPath(path);

				MutableTreeNode obj = (MutableTreeNode) path.getLastPathComponent();
				if (e.isPopupTrigger()) {
					JPopupMenu popupMenu = new JPopupMenu();
					if (obj instanceof Trash){
						if (MainFrame.getInstance().getTrashModel().getChildCount() != 0){
							popupMenu.add(MainFrame.getInstance().getActionManager().getEmptyTrashAction());
							MainFrame.getInstance().getActionManager().getEmptyTrashAction().setEnabled(true);
					        
						}
						else {
							popupMenu.add(MainFrame.getInstance().getActionManager().getEmptyTrashAction());
							MainFrame.getInstance().getActionManager().getEmptyTrashAction().setEnabled(false);
							
						}
					}
					if (obj instanceof Project){
					  popupMenu.add(MainFrame.getInstance().getActionManager().getRestoreAction());
					  popupMenu.add(MainFrame.getInstance().getActionManager().getDeleteFromTrashAction());
					}
					
					popupMenu.show(tree, e.getX(), e.getY());
				
				}
				
			}
			
		});
	}
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		this.actionManager = MainFrame.getInstance().getActionManager();
		JTree tree = (JTree) e.getSource();
		boolean isTrash = MainFrame.getInstance().getTrash() == tree;

		if (e.getNewLeadSelectionPath() != null) {
			TreeNode node = (TreeNode) e.getNewLeadSelectionPath()
					.getLastPathComponent();
			if (node instanceof Workspace){
				if(!isTrash){
				enable();
				disable(-1);
			   }
				else trashDisable();
			}
			
			if (node instanceof Project) {
				MainFrame.getInstance().selectInternalFrame(node);
				if (!isTrash){
				enable();
				disable(0);
				}
				else trashDisable();
			
			} else if (node instanceof Document) {
				ProjectViewer projectViewer = MainFrame.getInstance()
						.selectInternalFrame(node.getParent());
				projectViewer.setDocumentTab(node);
				if (!isTrash){
				enable();
			    disable(1);
				}
				else trashDisable();
			 

			} else if (node instanceof Page) {
				TreeNode nodep = node.getParent().getParent();
				ProjectViewer projectViewer = MainFrame.getInstance()
						.selectInternalFrame(nodep);
				projectViewer.setDocumentTab(node.getParent());
				MainFrame.getInstance().selectInternalFrame(nodep);
				if(!isTrash){
				enable();
			    disable(2);
				}
				else trashDisable();
			    
			   
			
			} else if (node instanceof TextSlot) {
				TreeNode nodep = node.getParent().getParent().getParent();
				ProjectViewer projectViewer = MainFrame.getInstance()
						.selectInternalFrame(nodep);
				projectViewer.setDocumentTab(node.getParent().getParent());
				MainFrame.getInstance().selectInternalFrame(nodep);
				if (!isTrash){
				enable();
			    disable(3);
				}
				else trashDisable();


			} else if (node instanceof GraphSlot) {
				TreeNode nodep = node.getParent().getParent().getParent();
				ProjectViewer projectViewer = MainFrame.getInstance()
						.selectInternalFrame(nodep);
				projectViewer.setDocumentTab(node.getParent().getParent());
				MainFrame.getInstance().selectInternalFrame(nodep);
				if (!isTrash){
				enable();
			    disable(4);
				}
				else trashDisable();


			}
			else if (node instanceof CircleElement){
				TreeNode nodep = node.getParent().getParent().getParent().getParent();
				ProjectViewer projectViewer = MainFrame.getInstance()
						.selectInternalFrame(nodep);
				projectViewer.setDocumentTab(node.getParent().getParent().getParent());
				MainFrame.getInstance().selectInternalFrame(nodep);
				
			}
			else if (node instanceof RectangleElement){
				TreeNode nodep = node.getParent().getParent().getParent().getParent();
				ProjectViewer projectViewer = MainFrame.getInstance()
						.selectInternalFrame(nodep);
				projectViewer.setDocumentTab(node.getParent().getParent().getParent());
				MainFrame.getInstance().selectInternalFrame(nodep);
			}

		}
	
	}

	public void refresh() {
		SwingUtilities.updateComponentTreeUI(this);
	}

	public ActionManager getActionManager() {
		return actionManager;
	}

	public void setActionManager(ActionManager actionManager) {
		this.actionManager = actionManager;
	}



	public void enable() {
		actionManager.getNewProject().setEnabled(true);
		actionManager.getNewDocument().setEnabled(true);
		actionManager.getNewPage().setEnabled(true);
		actionManager.getGraphicSlot().setEnabled(true);
		actionManager.getTextSlot().setEnabled(true);
		actionManager.getSaveproject().setEnabled(true);
		actionManager.getDeleteItem().setEnabled(true);
		actionManager.getRename().setEnabled(true);
		

	}
	public void disable(int i){
		
		if (i == -1){		
			actionManager.getNewDocument().setEnabled(false);	
			actionManager.getNewPage().setEnabled(false);
			actionManager.getGraphicSlot().setEnabled(false);
			actionManager.getTextSlot().setEnabled(false); 
			actionManager.getRename().setEnabled(false);
			actionManager.getDeleteItem().setEnabled(false);
			actionManager.getSaveproject().setEnabled(false);
			actionManager.getCascade().setEnabled(false);
			actionManager.getTileHor().setEnabled(false);
			actionManager.getTileVer().setEnabled(false);
			actionManager.getGridView().setEnabled(false);
			if (MainFrame.getInstance().getWorkspace().getChildCount()>0){
			actionManager.getCascade().setEnabled(true);
			actionManager.getTileHor().setEnabled(true);
			actionManager.getTileVer().setEnabled(true);
			actionManager.getGridView().setEnabled(true);
			}
			
			
		}
		if (i == 0){		
			actionManager.getNewProject().setEnabled(false);	
			actionManager.getNewPage().setEnabled(false);
			actionManager.getGraphicSlot().setEnabled(false);
			actionManager.getTextSlot().setEnabled(false);
			actionManager.getCascade().setEnabled(true);
			actionManager.getTileHor().setEnabled(true);
			actionManager.getTileVer().setEnabled(true);
			actionManager.getGridView().setEnabled(true);
		}
		if (i == 1){
			actionManager.getNewProject().setEnabled(false);	
			actionManager.getNewDocument().setEnabled(false);
			actionManager.getGraphicSlot().setEnabled(false);
			actionManager.getTextSlot().setEnabled(false);
			actionManager.getCascade().setEnabled(true);
			actionManager.getTileHor().setEnabled(true);
			actionManager.getTileVer().setEnabled(true);
			actionManager.getGridView().setEnabled(true);
			
		}
		if (i == 2){
			actionManager.getNewProject().setEnabled(false);
			actionManager.getNewDocument().setEnabled(false);
			actionManager.getNewPage().setEnabled(false);
			actionManager.getCascade().setEnabled(true);
			actionManager.getTileHor().setEnabled(true);
			actionManager.getTileVer().setEnabled(true);
			actionManager.getGridView().setEnabled(true);
			
		}
		if (i==3 || i==4){
			actionManager.getNewProject().setEnabled(false);	
			actionManager.getNewPage().setEnabled(false);
			actionManager.getGraphicSlot().setEnabled(false);
			actionManager.getTextSlot().setEnabled(false);
			actionManager.getNewDocument().setEnabled(false);
			actionManager.getCascade().setEnabled(true);
			actionManager.getTileHor().setEnabled(true);
			actionManager.getTileVer().setEnabled(true);
			actionManager.getGridView().setEnabled(true);
			
			
		}
	
		
	}
	public void trashDisable(){
		actionManager.getNewProject().setEnabled(false);
		actionManager.getNewDocument().setEnabled(false);
		actionManager.getNewPage().setEnabled(false);
		actionManager.getGraphicSlot().setEnabled(false);
		actionManager.getTextSlot().setEnabled(false);
		actionManager.getSaveproject().setEnabled(false);
		actionManager.getDeleteItem().setEnabled(false);
		actionManager.getRename().setEnabled(false);
	}

}
