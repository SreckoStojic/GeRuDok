package observers;

import java.io.Serializable;

@SuppressWarnings("serial")
public class GeRuDokEvent implements Serializable {

	public static final int ADD = 0;
	public static final int REMOVE = 1;
	public static final int OPEN = 2;
	public static final int Language = 3;
	public static final int rename = 4;
	public static final int PASTE = 5;
    public static final int SHORTCUT = 6;
    public static final int TRASH = 7;
    public static final int TRASHCLEAR = 8;
    public static final int TRASHDELETE = 9;
    public static final int RESTORE = 10;
	private int operation;
	private Object object;

	public GeRuDokEvent(int operation, Object object) {
		super();
		this.operation = operation;
		this.object = object;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}
