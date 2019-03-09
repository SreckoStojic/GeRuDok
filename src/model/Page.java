package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import observers.GeRuDokEvent;

@SuppressWarnings("serial")
public class Page extends Observable implements MutableTreeNode, Serializable {
	private Document parent;
	private String name;
	private ArrayList<MutableTreeNode> slots = new ArrayList<MutableTreeNode>();

	public Page(Document parent, String name) {
		this.parent = parent;
		this.name = name;

	}

	public TreeNode getChildAt(int childIndex) {
		return (TreeNode) this.slots.get(childIndex);
	}

	public void setName(String name, MutableTreeNode node) {
		if (node instanceof GraphSlot) {
			GraphSlot graSlot = (GraphSlot) node;
			graSlot.setName(name);
			GeRuDokEvent geRuDokEvent = new GeRuDokEvent(GeRuDokEvent.rename,
					node);
			setChanged();
			notifyObservers(geRuDokEvent);
		}
		else	if (node instanceof TextSlot) {
			TextSlot textSlot = (TextSlot) node;
			textSlot.setName(name);
			GeRuDokEvent geRuDokEvent = new GeRuDokEvent(GeRuDokEvent.rename,
					node);
			setChanged();
			notifyObservers(geRuDokEvent);
		}
		else {
			this.name=name;
		}
	}

	public int getChildCount() {
		return this.slots.size();
	}

	public TreeNode getParent() {
		return this.parent;
	}

	public int getIndex(TreeNode node) {
		return 0;
	}

	public boolean getAllowsChildren() {
		return true;
	}

	public boolean isLeaf() {
		return this.slots.size() == 0;
	}

	public Enumeration<?> children() {
		return null;
	}

	public void insert(MutableTreeNode child, int index) {
		this.slots.add(index, child);
		setChanged();
		notifyObservers(child);

	}

	public void remove(int index) {
		this.slots.remove(index);

	}

	public void remove(MutableTreeNode node) {
		this.slots.remove(node);
		setChanged();
		notifyObservers();

	}

	public void changelTextSlot(TextSlot textSlot) {
		GeRuDokEvent geRuDokEvent = new GeRuDokEvent(GeRuDokEvent.Language,
				textSlot);
		setChanged();
		notifyObservers(geRuDokEvent);

	}

	public void changelGraphSlot(GraphSlot graphSlot) {
		GeRuDokEvent geRuDokEvent = new GeRuDokEvent(GeRuDokEvent.Language,
				graphSlot);
		setChanged();
		notifyObservers(geRuDokEvent);

	}

	public void setUserObject(Object object) {
	}

	public void removeFromParent() {
	}

	public void setParent(MutableTreeNode newParent) {
	}

	public String toString() {
		return this.name;
	}

	public Page getMe() {
		return this;
	}

	public ArrayList<MutableTreeNode> getChildren() {
		return this.slots;
	}

	public TextSlot getTextSlot(int index) {
		return (TextSlot) slots.get(index);
	}

	public GraphSlot getGraphSlot(int index) {
		return (GraphSlot) slots.get(index);
	}
	public boolean checkname(String name){
		
		for(MutableTreeNode gs :this.slots){
			if (gs.toString().equals(name))
				return false;
		}
		return true;
		
	}

}
