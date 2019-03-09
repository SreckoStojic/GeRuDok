package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

import mainFrame.MainFrame;
import model.Document;
import model.GraphSlot;
import model.Page;
import model.Project;
import model.TextSlot;
import model.Workspace;
import elements.CircleElement;
import elements.RectangleElement;

class TreeMouseAdapter extends MouseAdapter {

	public TreeMouseAdapter() {
	}

	private void myPopupEvent(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		JTree tree = (JTree) e.getSource();
		TreePath path = tree.getPathForLocation(x, y);
		if (path == null) {
			return;
		}
		tree.setSelectionPath(path);

		MutableTreeNode obj = (MutableTreeNode) path.getLastPathComponent();
		JPopupMenu popup = new JPopupMenu();
		if ((obj instanceof Workspace)) {
			popup.add(MainFrame.getInstance().getActionManager()
					.getNewProject());

		} else if ((obj instanceof Project)) {
			popup.add(MainFrame.getInstance().getActionManager().getPasteDocumentAction());
			popup.addSeparator();
			popup.add(MainFrame.getInstance().getActionManager()
					.getNewDocument());
			popup.addSeparator();
			popup.add(MainFrame.getInstance().getActionManager()
					.getDeleteItem());
			popup.add(MainFrame.getInstance().getActionManager().getRename());
			popup.addSeparator();
			popup.add(MainFrame.getInstance().getActionManager().getSaveproject());

		} else if ((obj instanceof Document)) {
			popup.add(MainFrame.getInstance().getActionManager().getCopyDocumentAction());
			popup.add(MainFrame.getInstance().getActionManager()
					.getNewPage());
			popup.addSeparator();
			popup.add(MainFrame.getInstance().getActionManager()
					.getDeleteItem());
			popup.add(MainFrame.getInstance().getActionManager().getRename());

		} else if ((obj instanceof Page)) {
			popup.add(MainFrame.getInstance().getActionManager()
					.getGraphicSlot());
			popup.add(MainFrame.getInstance().getActionManager()
					.getTextSlot());
			popup.addSeparator();
			popup.add(MainFrame.getInstance().getActionManager()
					.getDeleteItem());
			popup.add(MainFrame.getInstance().getActionManager().getRename());

		} else if (obj instanceof TextSlot) {
			popup.add(MainFrame.getInstance().getActionManager()
					.getDeleteItem());
			popup.add(MainFrame.getInstance().getActionManager().getRename());

		} else if (obj instanceof GraphSlot) {
			popup.add(MainFrame.getInstance().getActionManager()
					.getDeleteItem());
			popup.add(MainFrame.getInstance().getActionManager().getRename());

		} else if (obj instanceof CircleElement) {
			popup.add(MainFrame.getInstance().getActionManager()
					.getDeleteItem());
			popup.add(MainFrame.getInstance().getActionManager().getRename());

		} else if (obj instanceof RectangleElement) {
			popup.add(MainFrame.getInstance().getActionManager()
					.getDeleteItem());
			popup.add(MainFrame.getInstance().getActionManager().getRename());
		}

		popup.show(tree, x, y);

	}

	public void mouseReleased(MouseEvent e) {
		if (e.isPopupTrigger()) {
			myPopupEvent(e);

		}
	}

}