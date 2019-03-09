package command;

import java.util.ArrayList;
import java.util.Iterator;

import model.GraphSlot;
import model.GraphSlotSelectionModel;
import elements.Element;

public class DeleteComand extends AbstractCommand {
	private GraphSlot slot;
	private GraphSlotSelectionModel graphSlotSelectionModel;
	private boolean first;
	private ArrayList<Element> deletedElements;

	public DeleteComand(GraphSlot slot) {
		this.deletedElements = new ArrayList<Element>();
		this.slot = slot;
		this.graphSlotSelectionModel = slot.getSelectionModel();
		this.first=true;
	}

	@Override
	public void doCommand() {
		// TODO Auto-generated method stub

		if (this.first) {
			
			for (Element e : this.graphSlotSelectionModel.getSelectionList()){
				deletedElements.add(e);
			}
			//this.graphSlotSelectionModel.removeAllFromSelectionList();
			this.first = false;
		} else {
			for (Element e : this.deletedElements) {
				
				this.slot.removeElementDelete(e);
				this.graphSlotSelectionModel.removeFromSelectionList(e);
				
			}
		}

	}

	@Override
	public void undoCommand() {
		// TODO Auto-generated method stub
		Iterator<Element> it = this.deletedElements.iterator();
		while (it.hasNext()) {
			Element element = (Element) it.next();
			this.slot.addElementDelete(element,deletedElements);
			this.graphSlotSelectionModel.addToSelectionList(element);
		}
	}

}
