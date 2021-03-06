package actions;

import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;

import mainFrame.MainFrame;
import model.ElementsSelection;
import model.GraphSlot;

@SuppressWarnings("serial")
public class EditPasteAction extends AbstractGerudokActions {
	private GraphSlot slot;
	public static final int COPY = 0;
	public static final int CUT = 1;
	private static int LastOperation = -1;
	private static GraphSlot Source = null;

	public EditPasteAction(GraphSlot slot) {
		putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle()
				.getString("miPaste"));
		putValue(NAME,
				MainFrame.getInstance().getResourceBundle()
						.getString("miPaste"));
		putValue(SMALL_ICON, loadIcon("images/paste.png"));
		this.slot = slot;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Transferable clipboardContent = MainFrame.getInstance().getClipboard().getContents(MainFrame.getInstance());
		if ((clipboardContent != null) && (clipboardContent.isDataFlavorSupported(ElementsSelection.elementFlavor))){
		      this.slot.paste();
		    //  this.slot.getSelectionModel().update();
		      this.slot.getSelectionModel().removeAllFromSelectionList();
		    
		      MainFrame.getInstance().getTree().updateUI();
		      SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
		}
	}

	public static int getLastOperation() {
		return LastOperation;
	}

	public static void setLastOperation(int lastOperation) {
		LastOperation = lastOperation;
	}

	public static GraphSlot getSource() {
		return Source;
	}

	public static void setSource(GraphSlot source) {
		Source = source;
	}
}
