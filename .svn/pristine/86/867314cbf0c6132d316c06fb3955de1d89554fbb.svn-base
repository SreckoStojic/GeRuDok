package actions;

import java.awt.event.ActionEvent;

import mainFrame.MainFrame;
import model.ElementsSelection;
import model.GraphSlot;

@SuppressWarnings("serial")
public class EditCopyAction extends AbstractGerudokActions {
	private GraphSlot slot;

	public EditCopyAction(GraphSlot slot) {
		putValue(SHORT_DESCRIPTION, MainFrame.getInstance().getResourceBundle()
				.getString("miCopy"));
		putValue(NAME,
				MainFrame.getInstance().getResourceBundle().getString("miCopy"));
		putValue(SMALL_ICON, loadIcon("images/copy.png"));
		this.slot = slot;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (slot.getSelectionModel().getSelectionListSize() > 0) {
			ElementsSelection contents = new ElementsSelection(slot
					.getSelectionModel().getSelectionList());
			MainFrame.getInstance().getClipboard()
					.setContents(contents, MainFrame.getInstance());
			slot.getSelectionModel().removeAllFromSelectionList();
			EditPasteAction.setLastOperation(0);
			EditPasteAction.setSource(slot);

		}

	}

}
