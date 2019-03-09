package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import mainFrame.MainFrame;
import model.GraphSlot;
import command.AddDeviceCommand;

@SuppressWarnings("serial")
public class CircleState extends State {
	private GraphSlot slot;

	public CircleState(GraphSlot slot) {
		this.slot = slot;
	}

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 1) {
			Point position = e.getPoint();
			/*
			 * String name = "Circle " + (this.slot.getChildCount() + 1); Point
			 * position = e.getPoint(); Dimension dimension = new Dimension(50,
			 * 50); BasicStroke stroke = new BasicStroke(2.0F); Paint paint =
			 * Color.WHITE; CircleElement krug = new CircleElement(name, slot,
			 * position, dimension, stroke, paint); this.slot.insert(krug,
			 * this.slot.getChildCount());
			 */

			slot.getCommandManager().addCommand(
					new AddDeviceCommand(slot, position, 1));

			MainFrame.getInstance().getTree().updateUI();

		}
	}
}
