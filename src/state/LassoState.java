package state;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import model.GraphSlot;

@SuppressWarnings("serial")
public class LassoState extends State {
	Rectangle2D rect = new Rectangle2D.Double();
	private GraphSlot slot;

	public LassoState(GraphSlot slot) {
		this.slot = slot;
	}

	public void mouseDragged(MouseEvent e) {

		Point2D mousePos = e.getPoint();
		if (!e.isControlDown()) {
			this.slot.getSelectionModel().removeAllFromSelectionList();
		}
		double width = mousePos.getX()
				- this.slot.getSelectionModel().getLastPosition().getX();
		double height = mousePos.getY()
				- this.slot.getSelectionModel().getLastPosition().getY();
		if ((width < 0.0D) && (height < 0.0D)) {
			this.rect.setRect(mousePos.getX(), mousePos.getY(),
					Math.abs(width), Math.abs(height));
		} else if ((width < 0.0D) && (height >= 0.0D)) {
			this.rect.setRect(mousePos.getX(), this.slot.getSelectionModel()
					.getLastPosition().getY(), Math.abs(width),
					Math.abs(height));
		} else if ((width > 0.0D) && (height < 0.0D)) {
			this.rect.setRect(this.slot.getSelectionModel().getLastPosition()
							.getX(), mousePos.getY(), Math.abs(width),
							Math.abs(height));
		} else {
			this.rect.setRect(this.slot.getSelectionModel().getLastPosition()
					.getX(), this.slot.getSelectionModel().getLastPosition()
					.getY(), Math.abs(width), Math.abs(height));
		}
		this.slot.getSelectionModel().setSelectionRectangle(this.rect);
		this.slot.getSelectionModel().selectElements(this.rect,
				this.slot.getElements());
	}

	public void mouseReleased(MouseEvent e) {
		this.slot.getSelectionModel().setSelectionRectangle(
				new Rectangle2D.Double(0.0D, 0.0D, 0.0D, 0.0D));
		this.slot.startSelectState();
		//int i=this.slot.getSelectionModel().getSelectionListSize();
		//System.out.println(i);
	}

}
