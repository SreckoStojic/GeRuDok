package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;
import javax.swing.tree.MutableTreeNode;

import mainFrame.MainFrame;
import model.Page;
import model.TextSlot;
import views.DocumentViewer;
import views.PageViewer;
import views.ProjectViewer;
import views.TextSlotViewer;

@SuppressWarnings("serial")
public class NewTextSlot extends AbstractGerudokActions  {
	public NewTextSlot() {
		putValue("SmallIcon", loadIcon("images/text-slot.png"));
		putValue("Name", "New TextSlot");
		putValue("ShortDescription", "New TextSlot");
		putValue(ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (MainFrame.getInstance().getTree().getSelectionPath()
				.getLastPathComponent() != null) {
			MutableTreeNode node = (MutableTreeNode) MainFrame.getInstance()
					.getTree().getSelectionPath().getLastPathComponent();
			ProjectViewer projectViewer = (ProjectViewer) MainFrame.getInstance().getDesktopPane().getSelectedFrame();

			if ((node instanceof Page)) {
				Page page = (Page) node;
				String name = MainFrame.getInstance().getResourceBundle()
						.getString("TextSlot");
				TextSlot textslot = new TextSlot(page, name + " "
						+ (node.getChildCount() + 1));
				node.insert(textslot, (node.getChildCount()));

				TextSlotViewer textSLotviewer = new TextSlotViewer(textslot);
				DocumentViewer documentViewer = projectViewer.getSelectedDocumentViewer();
				PageViewer pageViewer = (PageViewer) documentViewer
						.getPageViewerForPage(page);
				pageViewer.addTextViewer(textSLotviewer);

				MainFrame.getInstance().getTree().updateUI();
			}
		}
	}

}
