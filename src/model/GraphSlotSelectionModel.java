package model;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import observers.GeRuDokEvent;
import elements.Element;

@SuppressWarnings("serial")
public class GraphSlotSelectionModel extends Observable implements Serializable {
	private ArrayList<Element> selectionList = new ArrayList<Element>();
	private Point2D lastPosition = null;
	private Rectangle2D selectionRectangle = new Rectangle2D.Double();

	public void addToSelectionList(Element element) {
		this.selectionList.add(element);
		setChanged();
		notifyObservers();
	}

	public void addToSelectionList(ArrayList<Element> list) {
		this.selectionList.addAll(list);
		setChanged();
		notifyObservers();
	}

	public int getSelectionListSize() {
		return this.selectionList.size();
	}

	public Element getElementFromSelectionListAt(int index) {
		return (Element) this.selectionList.get(index);
	}

	public int getIndexByObject(Element element) {
		return this.selectionList.indexOf(element);
	}

	public void removeFromSelectionList(Element element) {
		this.selectionList.remove(element);
		setChanged();
		notifyObservers();
	}

	public void removeAllFromSelectionList() {
		this.selectionList.clear();
		setChanged();
		notifyObservers();
	}

	public ArrayList<Element> getSelectionList() {
		return this.selectionList;
	}

	public Iterator<Element> getSelectionListIterator() {
		return this.selectionList.iterator();
	}

	public boolean isElementSelected(Element element) {
		return this.selectionList.contains(element);
	}

	public Point2D getLastPosition() {
		return this.lastPosition;
	}

	public void setLastPosition(Point2D lastPosition) {
		this.lastPosition = lastPosition;
	}

	public Rectangle2D getSelectionRectangle() {
		return this.selectionRectangle;
	}

	public void setSelectionRectangle(Rectangle2D selectionRectangle) {
		this.selectionRectangle = selectionRectangle;
		setChanged();
		notifyObservers();
	}

	public void selectElements(Rectangle2D rec,
			ArrayList<Element> elements) {
		Iterator<Element> it = elements.iterator();
		while (it.hasNext()) {
			Element element = (Element) it.next();
			if ((rec.intersects(element.getPosition().getX(), element
					.getPosition().getY(), element.getDimension().getWidth(),
					element.getDimension().getHeight()))
					&& (!isElementSelected(element))) {
				this.selectionList.add(element);
			}
		}
		setChanged();
		notifyObservers();
	}
	public void deleteElement(GeRuDokEvent ger){
		setChanged();
		notifyObservers(ger);
	}
	public void update(){
		setChanged();
		notifyObservers();
	}

}
