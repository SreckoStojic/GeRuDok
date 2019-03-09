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
public class Trash extends Observable implements MutableTreeNode, Serializable {
	private ArrayList<Project> projects = new ArrayList<Project>();
	private String name="TRASH";
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}

	
	@Override
	public TreeNode getChildAt(int childIndex) {
		return (TreeNode) this.projects.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return this.projects.size();
	}

	@Override
	public TreeNode getParent() {

		return null;
	}

	@Override
	public int getIndex(TreeNode node) {
		return 0;
	}

	@Override
	public boolean getAllowsChildren() {
		
		return true;
	}

	@Override
	public boolean isLeaf() {
		
		return false;
	}

	@Override
	public Enumeration<?> children() {
	
		return null;
	}

	@Override
	public void insert(MutableTreeNode child, int index) {
		Project p=(Project) child;
		p.setName(p.toString()+ " (" + MainFrame.getInstance().getResourceBundle().getString("trash") + ")", p);
		this.projects.add(index, (Project) child);
		Project project=(Project)child;
		GeRuDokEvent geRuDokEvent=new GeRuDokEvent(GeRuDokEvent.TRASH, project);
		setChanged();
		notifyObservers(geRuDokEvent);
		
	}

	@Override
	public void remove(int index) {
	
		
	}

	@Override
	public void remove(MutableTreeNode node) {
		this.projects.remove(node);
		GeRuDokEvent geRuDokEvent = new GeRuDokEvent(GeRuDokEvent.TRASHDELETE, node);
		setChanged();
		notifyObservers(geRuDokEvent);
		
	}

	@Override
	public void setUserObject(Object object) {
		
		
	}

	@Override
	public void removeFromParent() {
	
		
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		
		
	}

	public String getName() {
		return name;
	}
	
	public void emptyTrash(){
		this.projects.clear();
		GeRuDokEvent gerudokEvent = new GeRuDokEvent(GeRuDokEvent.TRASHCLEAR, MainFrame.getInstance().getTrashModel());
		setChanged();
		notifyObservers(gerudokEvent);
		
	}


	public void restore(MutableTreeNode node) {
		// TODO Auto-generated method stub
		Workspace workspace = MainFrame.getInstance().getWorkspace();
		Project p = (Project) node;
		String s[] = p.getName().split("[(]");
		p.setName(s[0], p);
		this.projects.remove(node);
		workspace.insert(p, workspace.getChildCount());
		GeRuDokEvent geRuDokEvent = new GeRuDokEvent(GeRuDokEvent.RESTORE, p);
		setChanged();
		notifyObservers(geRuDokEvent);
		
	}


}
