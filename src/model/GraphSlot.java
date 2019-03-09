package model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import observers.GeRuDokEvent;
import state.StateManager;
import command.CommandManager;
import elements.Element;

@SuppressWarnings("serial")
public class GraphSlot extends Observable implements MutableTreeNode,
		Serializable {

	private String name;
	private Page parent;
	private ArrayList<Element> elements = new ArrayList<Element>();
	private  transient StateManager stateManager;
	private boolean designMode = false;
	private GraphSlotSelectionModel selectionModel;
	private transient CommandManager commandManager = new CommandManager();

	public GraphSlot(Page parent, String name) {
		this.parent = parent;
		this.name = name;
		this.stateManager = new StateManager(this);
		this.selectionModel=new GraphSlotSelectionModel();

	}

	public TreeNode getChildAt(int childIndex) {
		return (TreeNode) this.elements.get(childIndex);
	}

	public int getChildCount() {
		return this.elements.size();
	}

	public TreeNode getParent() {
		return this.parent;
	}

	public int getIndex(TreeNode node) {
		return this.elements.indexOf(node);
	}

	public boolean getAllowsChildren() {
		return true;
	}

	public boolean isLeaf() {
		return this.elements.size() == 0;
	}

	public Enumeration<?> children() {
		return null;
	}

	public void insert(MutableTreeNode child, int index) {
		this.elements.add(index, (Element) child);
		setChanged();
		notifyObservers();
	}

	public void addElement(Element element) {
		elements.add(element);
		setChanged();
		notifyObservers();

	}

	public void removeElement(Element element) {
		ArrayList<Element> Pom = new ArrayList<>();
		Pom.addAll(elements);
		for (Element e : Pom) {
			if (e.getName().equals(element.getName()))
				elements.remove(e);
		}
		setChanged();
		notifyObservers();

	}

	public void addElementDelete(Element element, ArrayList<Element> Pom) {
		for (Element e : Pom) {
			if (e.getName().equals(element.getName()))
				elements.add(element);
		}

		setChanged();
		notifyObservers();

	}

	public void removeElementDelete(Element element) {
		ArrayList<Element> Pom = new ArrayList<>();
		Pom.addAll(elements);
		for (Element e : Pom) {
			if (e.getPosition().equals(element.getPosition()))
				elements.remove(e);
		}
		setChanged();
		notifyObservers();

	}

	public void remove(int index) {
	}

	public void remove(MutableTreeNode node) {
		this.elements.remove(node);
		setChanged();
		notifyObservers();
	}

	public void setUserObject(Object object) {
	}

	public void removeFromParent() {
	}

	public void setParent(MutableTreeNode newParent) {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return this.name;
	}

	public void startCircleState() {
		this.stateManager.setCircleState();
	}

	public void startRectangleState() {
		this.stateManager.setRectangleState();
	}

	public void startSelectState() {
		this.stateManager.setSelectState();
	}

	public void startLassoState() {
		this.stateManager.setLassoState();
	}

	public StateManager getStateManager() {
		return this.stateManager;
	}

	public boolean isDesignMode() {
		return designMode;
	}

	public void setDesignMode(boolean designMode) {
		this.designMode = designMode;
		setChanged();
		notifyObservers();

	}

	public ArrayList<Element> getElements() {
		return elements;
	}

	public Element getElementAt(int i) {
		return (Element) this.elements.get(i);
	}

	public GraphSlotSelectionModel getSelectionModel() {
		return selectionModel;
	}

	public int getElementAtPosition(Point point) {
		for (int i = getChildCount() - 1; i >= 0; i--) {
			Element element = (Element) getChildAt(i);
			if (element.isElementAt(point)) {
				return i;
			}
		}
		return -1;
	}

	public boolean checkname(String name) {

		for (MutableTreeNode p : this.elements) {
			if (p.toString().equals(name))
				return false;
		}
		return true;

	}

	public void deleteElement(ArrayList<Element> elements) {
		GeRuDokEvent ger = new GeRuDokEvent(GeRuDokEvent.REMOVE, elements);
		this.elements.removeAll(elements);
		setChanged();
		this.selectionModel.deleteElement(ger);
		notifyObservers();
	}

	public CommandManager getCommandManager() {
		return commandManager;
	}

	public void setCommandManager(CommandManager commandManager) {
		this.commandManager = commandManager;
	}

	private Object readResolve() {
		commandManager = new CommandManager();
		stateManager = new StateManager(this);
		return this;
	}
	public void paste(){
		GeRuDokEvent geRuDokEvent = new GeRuDokEvent(GeRuDokEvent.PASTE,elements);
		setChanged();
		notifyObservers(geRuDokEvent);
		
	}
	public void update(){
		setChanged();
		notifyObservers();
	}
	public void removeCopy(Element copies){
		ArrayList<Element> Pom = new ArrayList<>();
		Pom.addAll(elements);
		for (Element e : Pom) {
			if (e.getPosition().equals(copies.getPosition()))
				elements.remove(e);
		}
		setChanged();
		notifyObservers();
		
	}

	
}
