package actions;

import java.awt.event.ActionEvent;

import model.GraphSlot;

@SuppressWarnings("serial")
public class SelectStateAction extends AbstractGerudokActions {
	private GraphSlot slot;

	public SelectStateAction(GraphSlot slot) {
		this.slot = slot;

		putValue("SmallIcon", loadIcon("images/select1.png"));
		putValue("Name", "Select element");
		putValue("ShortDescription", "Select element");

	}

	public void actionPerformed(ActionEvent e) {
		this.slot.startSelectState();
		//System.out.println("Select state action");

	}

}
