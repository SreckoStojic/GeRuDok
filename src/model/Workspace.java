package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import mainFrame.MainFrame;
import observers.GeRuDokEvent;

@SuppressWarnings("serial")
public class Workspace extends Observable implements MutableTreeNode, Serializable {
	private ArrayList<Project> projects = new ArrayList<Project>();
	private String name;
	
	public void setName(String name,MutableTreeNode node) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public TreeNode getChildAt(int childIndex) {
		return (TreeNode) this.projects.get(childIndex);
	}

	public int getChildCount() {
		return this.projects.size();
	}

	public TreeNode getParent() {
		return null;
	}

	public int getIndex(TreeNode node) {
		return 0;
	}

	public boolean getAllowsChildren() {
		return true;
	}

	public boolean isLeaf() {
		return false;
	}

	public Enumeration<?> children() {
		return null;
	}

	public void insert(MutableTreeNode child, int index) {
		this.projects.add(index, (Project) child);
		Project project=(Project)child;
		GeRuDokEvent geRuDokEvent=new GeRuDokEvent(GeRuDokEvent.ADD, project);
		setChanged();
		notifyObservers(geRuDokEvent);
	}

	public void remove(int index) {
	}

	public void remove(MutableTreeNode node) {
		this.projects.remove(node);
		Project project=(Project)node;
		GeRuDokEvent geRuDokEvent=new GeRuDokEvent(GeRuDokEvent.REMOVE, project);
		setChanged();
		notifyObservers(geRuDokEvent);
		
	}

	public void openProject(MutableTreeNode child, int index){
		this.projects.add(index, (Project) child);
		GeRuDokEvent geRuDokEvent=new GeRuDokEvent(GeRuDokEvent.OPEN, child);
		setChanged();
		notifyObservers(geRuDokEvent);
	}
		
	public void changel(GeRuDokEvent ger){
		GeRuDokEvent geRuDokEvent=(GeRuDokEvent) ger;
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
		return MainFrame.getInstance().getResourceBundle().getString("Workspace");
	}
	public boolean checkname(String name){
		for(Project p :this.projects){
			if (p.toString().equals(name))
				return false;
		}
		return true;
		
	}
	
	
	

	
}
