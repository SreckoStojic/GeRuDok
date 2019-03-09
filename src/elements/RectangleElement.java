package elements;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;

import model.GraphSlot;

@SuppressWarnings("serial")
public class RectangleElement extends Element {
	public RectangleElement(String name, GraphSlot parent, Point position,
			Dimension dimension, Stroke stroke, Paint paint) {
		super(name, parent, position, dimension, stroke, paint);

		this.shape = new Rectangle2D.Double(position.getX(), position.getY(),
				dimension.getWidth(), dimension.getHeight());
	}

	public RectangleElement(RectangleElement rec) {
		// TODO Auto-generated constructor stub
		   super(rec);
		   this.shape = new Rectangle2D.Double(position.getX(), position.getY(),
					dimension.getWidth(), dimension.getHeight());
		  
	}

	@Override
	public Element clone() {
		// TODO Auto-generated method stub
		return new RectangleElement(this);
	}

}
