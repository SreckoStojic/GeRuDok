package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import model.GraphSlot;
import elements.Element;

@SuppressWarnings("serial")
public class SelectState extends State {


	private GraphSlot graphSlot;
//	private ArrayList<Element> elements;

	public SelectState(GraphSlot graphSlot) {
		this.graphSlot = graphSlot;

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mousePressed(e);
		 if (!e.isControlDown()) {
		      this.graphSlot.getSelectionModel().removeAllFromSelectionList();
		    }
		    Point position = e.getPoint();
		    if (e.getButton() == 1)
		    {
		      int elementInMotion = this.graphSlot.getElementAtPosition(position);
		      if (elementInMotion != -1)
		      {
		        Element element = this.graphSlot.getElementAt(elementInMotion);
		        if (this.graphSlot.getSelectionModel().isElementSelected(element)) {
		          this.graphSlot.getSelectionModel().removeFromSelectionList(element);
		        } else {
		          this.graphSlot.getSelectionModel().addToSelectionList(element);
		        }
		      }
		    }
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		// super.mouseDragged(e);
		 this.graphSlot.startLassoState();
	}

}
