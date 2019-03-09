package elements;

import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;

import model.GraphSlot;

@SuppressWarnings("serial")
public class CircleElement  extends Element
{
	  public CircleElement(String name,GraphSlot parent, Point position, Dimension dimension, Stroke stroke, Paint paint)
	  {
	    super(name,parent, position, dimension, stroke, paint);
	    
	    this.shape = new Ellipse2D.Double(position.getX(), position.getY(), 
	      dimension.getWidth(), dimension.getHeight());
	  }
	   public CircleElement(CircleElement circle) {
		// TODO Auto-generated constructor stub
		  super(circle);
		  this.shape=new Ellipse2D.Double(position.getX(), position.getY(), 
			      dimension.getWidth(), dimension.getHeight());
		  
	}

	@Override
	public Element clone() {
		// TODO Auto-generated method stub
		return new CircleElement(this);
	}

	

}
