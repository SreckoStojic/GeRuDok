package command;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Point2D;

import mainFrame.MainFrame;
import model.GraphSlot;
import elements.CircleElement;
import elements.Element;
import elements.RectangleElement;

public class AddDeviceCommand extends AbstractCommand {

	private GraphSlot graphSlot;
	private Point2D lastPosition;
	private Element element;
	private int deviceType;

	public AddDeviceCommand(GraphSlot graphSlot, Point2D lastPosition,
			int deviceType) {
		this.graphSlot = graphSlot;
		this.lastPosition = lastPosition;
		this.deviceType = deviceType;
	}

	@Override
	public void doCommand() {

		if (deviceType == 1) {
			String name=MainFrame.getInstance().getResourceBundle().getString("Circle");
			element = new CircleElement(name+ " " + (graphSlot.getChildCount()+1),
					this.graphSlot, (Point) lastPosition,
					new Dimension(50, 50), new BasicStroke(2.0F), Color.WHITE);

		} else if (deviceType == 2) {
			String name=MainFrame.getInstance().getResourceBundle().getString("Rectangle");
			element = new RectangleElement(name+ " "
					+ (graphSlot.getChildCount()+1), this.graphSlot,
					(Point) lastPosition, new Dimension(75, 50),
					new BasicStroke(2.0F), Color.WHITE);
		}
		graphSlot.addElement(element);
		this.graphSlot.getSelectionModel().removeAllFromSelectionList();
		MainFrame.getInstance().getTree().updateUI();
		//System.out.println("Vracen");

	}

	@Override
	public void undoCommand() {

		graphSlot.removeElement(element);
		this.graphSlot.getSelectionModel().removeAllFromSelectionList();
		MainFrame.getInstance().getTree().updateUI();
		//System.out.println("Obrisan");
	}

	
}
