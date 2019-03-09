package views;


import java.awt.Component;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.Document;
import model.GraphSlot;
import model.Page;
import model.Project;
import model.TextSlot;
import model.Trash;
import model.Workspace;
import elements.CircleElement;
import elements.RectangleElement;

@SuppressWarnings("serial")
public class TreeRendered extends DefaultTreeCellRenderer {
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean sel, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
				row, hasFocus);
		if ((value instanceof Workspace)) {
			setIcon(loadIcon("images/workspace.png"));
		}
		  else if(value instanceof Trash){
			setIcon(loadIcon("images/trash.png"));
		}
		  else if ((value instanceof Project)) {
			setIcon(loadIcon("images/new-project.png"));
		} else if ((value instanceof Document)) {
			setIcon(loadIcon("images/new-document.png"));
		} else if ((value instanceof Page)) {
			setIcon(loadIcon("images/new-page.png"));
		} else if ((value instanceof TextSlot)) {
			setIcon(loadIcon("images/text-slot.png"));
		} else if ((value instanceof GraphSlot)) {
			setIcon(loadIcon("images/graphic-slot.png"));
		} else if ((value instanceof CircleElement))
			setIcon(loadIcon("images/circle1.png"));
		else if ((value instanceof RectangleElement))
			setIcon(loadIcon("images/rectangle1.png"));
		
		

		return this;

	}
	
	public Icon loadIcon(String fileName)
	  {
	    URL imageURL = getClass().getClassLoader().getResource(fileName);
	    Icon icon = null;

	    if (imageURL != null)
	      icon = new ImageIcon(imageURL);
	    else {
	      System.err.println("Resource not found: " + fileName);
	    }

	    return icon;
	  }
}
