package model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import observers.GeRuDokEvent;

@SuppressWarnings("serial")
public class Project extends Observable implements MutableTreeNode,
		Serializable {

	private ArrayList<Document> documents = new ArrayList<Document>();
	private String name;
	private Workspace parent;
	private File projectFile;

	public Project(String name, Workspace workspace) {

		this.name = name;
		this.parent = workspace;
	}

	public TreeNode getChildAt(int childIndex) {
		return (TreeNode) this.documents.get(childIndex);
	}

	public int getChildCount() {
		return this.documents.size();
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
		return this.documents.size() == 0;
	}

	public Enumeration<?> children() {
		return null;
	}

	public void insert(MutableTreeNode child, int index) {
		this.documents.add(index, (Document) child);
		Document document = (Document) child;
		GeRuDokEvent geRuDokEvent = new GeRuDokEvent(GeRuDokEvent.ADD, document);
		setChanged();
		notifyObservers(geRuDokEvent);

	}
	public void addDocumentCopy(Document document){
		
		this.documents.add(document);
		GeRuDokEvent geRuDokEvent=new GeRuDokEvent(GeRuDokEvent.SHORTCUT,document);
		setChanged();
		notifyObservers(geRuDokEvent);
	}

	public void remove(int index) {
	}

	public void remove(MutableTreeNode node) {
		this.documents.remove(node);
		Document document = (Document) node;
		GeRuDokEvent geRuDokEvent = new GeRuDokEvent(GeRuDokEvent.REMOVE,
				document);
		setChanged();
		notifyObservers(geRuDokEvent);
	}

	public void changel(Document document) {
		GeRuDokEvent geRuDokEvent = new GeRuDokEvent(GeRuDokEvent.Language,
				document);
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

	public File getProjectFile() {
		return this.projectFile;
	}

	public void setProjectFile(File projectFile) {
		this.projectFile = projectFile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name,MutableTreeNode node) {
		this.name = name;
		GeRuDokEvent geRuDokEvent=new GeRuDokEvent(GeRuDokEvent.rename, node);
		setChanged();
		notifyObservers(geRuDokEvent);
	}

	public ArrayList<Document> getChildren() {
		return this.documents;
	}

	public Document getDocument(int index) {
		return documents.get(index);
	}
	public boolean checkname(String name){
		
		for(Document d :this.documents){
			if (d.toString().equals(name))
				return false;
		}
		return true;
		
	}

}
