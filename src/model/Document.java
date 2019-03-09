package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import observers.GeRuDokEvent;

@SuppressWarnings("serial")
public class Document extends Observable implements MutableTreeNode, Serializable {
	private Project parent;
	private ArrayList<Page> pages = new ArrayList<Page>();
	private ArrayList<Document>shortcuts = new ArrayList<Document>();
	private String name;

	public void setName(String name, MutableTreeNode child) {
		this.name = name;
		Document document =(Document)child;
		GeRuDokEvent reName = new GeRuDokEvent(GeRuDokEvent.rename , document); 
		setChanged();
		notifyObservers(reName);
	}

	public Document(Project parent, String name) {
		this.name = name;
		this.parent = parent;

	}
	public Document(Document document){
		this.name=document.name;
		this.parent=document.parent;
	}

	public TreeNode getChildAt(int childIndex) {
		return (TreeNode) this.pages.get(childIndex);
	}
	public Document getDocumentAt(int i){
		return this.shortcuts.get(i);
	}
	public void addCopyinList(Document document){
		this.shortcuts.add(document);
	}

	public int getChildCount() {
		return this.pages.size();
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
		return this.pages.size() == 0;
	}

	public Enumeration<?> children() {
		return null;
	}

	public void insert(MutableTreeNode child, int index) {
		this.pages.add(index, (Page) child);
		setChanged();
	    notifyObservers(child);

	}

	public void remove(int index) {
	}

	public void remove(MutableTreeNode node) {
		this.pages.remove(node);
		setChanged();
		notifyObservers();

	}
	public void changel(Page page) {
		GeRuDokEvent geRuDokEvent = new GeRuDokEvent(GeRuDokEvent.Language,
				page);
		setChanged();
		notifyObservers(geRuDokEvent);

	}
	public void setNamePage(String name,MutableTreeNode node){
		Page page = (Page) node;
		page.setName(name, node);
		GeRuDokEvent geRuDokEvent=new GeRuDokEvent(GeRuDokEvent.rename, node);
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
	
	 public ArrayList<Page> getChildren()
	  {
	    return this.pages;
	  }

	 public Page getPage(int index) {
			return pages.get(index);
		}
	 public boolean checkname(String name){
		
			for(Page page :this.pages){
				if (page.toString().equals(name))
					return false;
			}
			return true;
			
		}
}
