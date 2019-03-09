package actions;

import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.GraphSlot;

@SuppressWarnings("serial")
public class CircleStateAction extends AbstractGerudokActions {
	private GraphSlot slot;

	public CircleStateAction(GraphSlot slot) {
		this.slot = slot;
		putValue("SmallIcon", loadIcon("images/circle1.png"));
		putValue("Name", "Circle element");
		putValue("ShortDescription", "Circle element");
	}

	public void actionPerformed(ActionEvent e) {
		this.slot.startCircleState();
	}

	public Icon loadIcon(String fileName) {
		URL imageURL = getClass().getClassLoader().getResource(fileName);
		Icon icon = null;
		if (imageURL != null) {
			icon = new ImageIcon(imageURL);
		} else {
			System.err.println("Resource not found: " + fileName);
		}
		return icon;
	}

}
