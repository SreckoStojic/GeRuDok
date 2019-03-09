package state;

import java.io.Serializable;

import model.GraphSlot;

@SuppressWarnings("serial")
public class StateManager implements Serializable {
	private State currentState;
	private CircleState circleState;
	private RectangleState rectangleState;
	private SelectState selectState;
	private LassoState lasoState;

	public StateManager(GraphSlot slot) {
		this.selectState = new SelectState(slot);
		this.lasoState=new LassoState(slot);
		this.circleState = new CircleState(slot);
		this.rectangleState = new RectangleState(slot);
		this.currentState = new SelectState(slot);	

	}

	public void setCircleState() {
		this.currentState = this.circleState;
	}

	public void setRectangleState() {
		this.currentState = this.rectangleState;
	}

	public SelectState getSelectState() {
		return selectState;
	}

	public State getCurrentState() {
		return this.currentState;
	}

	public void setSelectState() {
		this.currentState = this.selectState;
	}
	public void setLassoState(){
		this.currentState = this.lasoState;
	
	}
	

}
