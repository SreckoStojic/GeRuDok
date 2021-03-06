package model;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

@SuppressWarnings("serial")
public class TextSlot extends Observable implements MutableTreeNode, Serializable {
	private String name;
	private Page parent;
	private String text;
	private boolean designMode;

	public TextSlot(Page parent, String name) {
		this.name = name;
		this.parent = parent;
		this.designMode = true;

	}

	public TreeNode getChildAt(int childIndex) {
		return null;
	}

	public int getChildCount() {
		return 0;
	}

	public TreeNode getParent() {
		return this.parent;
	}

	public int getIndex(TreeNode node) {
		return -1;
	}

	public boolean getAllowsChildren() {
		return false;
	}

	public boolean isLeaf() {
		return true;
	}

	public Enumeration<?> children() {
		return null;
	}

	public void insert(MutableTreeNode child, int index) {
	}

	public void remove(int index) {
	}

	public void remove(MutableTreeNode node) {
	}

	public void setUserObject(Object object) {
	}

	public void removeFromParent() {
	}

	public void setParent(MutableTreeNode newParent) {
	}

	public String getText() {
		return this.text;
		
	}

	public void setText(String text) {
		this.text = text;
		setChanged();
		notifyObservers();

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

	public boolean isDesignMode() {
		return this.designMode;
	}

	public void setDesignMode(boolean designMode) {
		this.designMode = designMode;
		setChanged();
		notifyObservers();
	}
	
	

}
