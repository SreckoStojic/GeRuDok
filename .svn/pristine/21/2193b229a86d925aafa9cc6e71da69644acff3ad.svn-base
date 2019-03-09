package elements;

import java.awt.BasicStroke;
import java.awt.Shape;
import java.awt.Stroke;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class StrokeAdapter implements Stroke, Serializable {

	private Stroke stroke;

	public StrokeAdapter(Stroke stroke) {
		this.stroke = stroke;
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		if ((this.stroke instanceof BasicStroke)) {
			BasicStroke s = (BasicStroke) this.stroke;
			out.writeFloat(s.getLineWidth());
			out.writeInt(s.getEndCap());
			out.writeInt(s.getLineJoin());
			out.writeFloat(s.getMiterLimit());
			out.writeObject(s.getDashArray());
			out.writeFloat(s.getDashPhase());
		}
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		this.stroke = new BasicStroke(in.readFloat(), in.readInt(),
				in.readInt(), in.readFloat(), (float[]) in.readObject(),
				in.readFloat());
	}

	@Override
	public Shape createStrokedShape(Shape p) {
		// TODO Auto-generated method stub
		return this.stroke.createStrokedShape(p);
	}

	public Stroke getStroke() {
		return this.stroke;
	}

}
