package gui;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import mainFrame.MainFrame;

@SuppressWarnings("serial")
public class ToolBar extends JToolBar {

	public ToolBar(){
		super(SwingConstants.HORIZONTAL);
		
		//project
		
		add(MainFrame.getInstance().getActionManager().getNewProject());
		add(MainFrame.getInstance().getActionManager().getNewDocument());
		add(MainFrame.getInstance().getActionManager().getNewPage());
		add(MainFrame.getInstance().getActionManager().getGraphicSlot());
		add(MainFrame.getInstance().getActionManager().getTextSlot());

		addSeparator();
		
		//save, open
			
		add(MainFrame.getInstance().getActionManager().getSaveproject());
		add(MainFrame.getInstance().getActionManager().getOpenproject());
		
		addSeparator();
		
		//edit
		
		add(MainFrame.getInstance().getActionManager().getDeleteItem());
		add(MainFrame.getInstance().getActionManager().getRename());
		
		addSeparator();
		
		//window
		
		add(MainFrame.getInstance().getActionManager().getCascade());
		add(MainFrame.getInstance().getActionManager().getTileHor());
		add(MainFrame.getInstance().getActionManager().getTileVer());
		add(MainFrame.getInstance().getActionManager().getGridView());
		
		
		addSeparator();
		//help
		
		add(MainFrame.getInstance().getActionManager().getAbout());
		
		
		setFloatable(true);
	}
}
