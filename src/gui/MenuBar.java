package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import mainFrame.MainFrame;
import actions.ActionManager;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	JMenu project, edit, window, settings, help, Language, miLookAndFeel;
	JMenuItem miCascadeHorizontally, miTileHorizontally, miTileVertically,miAbout, jmaS;
	JCheckBoxMenuItem mniSrpskiLatinica, mniEngleski, mniSrpskiCirilica;
	ActionManager actionManager;
	

	public MenuBar() {

	    project = new JMenu(MainFrame.getInstance().getResourceBundle().getString("mbProject"));
		project.setMnemonic('P');

		project.add(MainFrame.getInstance().getActionManager().getNewProject());
		project.add(MainFrame.getInstance().getActionManager().getNewDocument());
		project.add(MainFrame.getInstance().getActionManager().getNewPage());
		
		project.addSeparator();

		project.add(MainFrame.getInstance().getActionManager().getGraphicSlot());
		project.add(MainFrame.getInstance().getActionManager().getTextSlot());
		
		project.addSeparator();

		project.add(MainFrame.getInstance().getActionManager().getSaveproject());
		project.add(MainFrame.getInstance().getActionManager().getOpenproject());

		project.addSeparator();
		
		project.add(MainFrame.getInstance().getActionManager().getExit());
		// edit

	    edit = new JMenu(MainFrame.getInstance().getResourceBundle().getString("mbEdit"));
		edit.setMnemonic(KeyEvent.VK_E);

		edit.add(MainFrame.getInstance().getActionManager().getDeleteItem());
		edit.add(MainFrame.getInstance().getActionManager().getRename());
		

		// window

		window = new JMenu(MainFrame.getInstance().getResourceBundle().getString("mbWindow"));
		window.setMnemonic(KeyEvent.VK_W);

		window.add(MainFrame.getInstance().getActionManager().getCascade());
		window.add(MainFrame.getInstance().getActionManager().getTileHor());
		window.add(MainFrame.getInstance().getActionManager().getTileVer());
		window.add(MainFrame.getInstance().getActionManager().getGridView());

	    settings = new JMenu(MainFrame.getInstance().getResourceBundle().getString("mbSettings"));
		settings.setMnemonic(KeyEvent.VK_S);

	    miLookAndFeel = new JMenu(MainFrame.getInstance().getResourceBundle().getString("miLooknFeel"));
		miLookAndFeel.setMnemonic('l');

		jmaS = new JMenuItem(MainFrame.getInstance().getResourceBundle().getString("miNimbus"));
		jmaS.setIcon(new ImageIcon(getClass().getResource("/images/looknfeel-icon.png")));
		jmaS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				MainFrame.LOOKANDFEEL = "Nimbus";
				MainFrame.initLookAndFeel();

			}
		});

		miLookAndFeel.add(jmaS);

		miLookAndFeel.setIcon(new ImageIcon(getClass().getResource("/images/looknfeel-icon.png")));

		settings.add(miLookAndFeel);

	    Language = new JMenu(MainFrame.getInstance().getResourceBundle().getString("mbLanguage"));
		Language.setMnemonic(KeyEvent.VK_L);
		
		
		mniEngleski = new JCheckBoxMenuItem("English");
		mniEngleski.setSelected(true);
		mniEngleski.setIcon(new ImageIcon(getClass().getResource("/images/eng-flag.png")));
		mniEngleski.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Locale.setDefault(new Locale("en", "US"));
				 MainFrame.getInstance().changeLanguage();
			}
		});
		Language.add(mniEngleski);

		mniSrpskiLatinica = new JCheckBoxMenuItem("Serbian - Latinic");
		mniSrpskiLatinica.setIcon(new ImageIcon(getClass().getResource("/images/Serbia-Flag-icon.png")));
		mniSrpskiLatinica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Locale.setDefault(new Locale("sr", "RS", "#Latn"));
				MainFrame.getInstance().changeLanguage();

			}
		});
		Language.add(mniSrpskiLatinica);
		
		mniSrpskiCirilica = new JCheckBoxMenuItem("Serbian - Cyrillic");
		mniSrpskiCirilica.setIcon(new ImageIcon(getClass().getResource("/images/Serbia-Flag-icon.png")));
		mniSrpskiCirilica.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Locale.setDefault(new Locale("sr", "RS"));
				MainFrame.getInstance().changeLanguage();

			}
		});
		Language.add(mniSrpskiCirilica);

	
		ButtonGroup bg = new ButtonGroup();
		bg.add(mniEngleski);
		bg.add(mniSrpskiLatinica);
		bg.add(mniSrpskiCirilica);
		

	    help = new JMenu(MainFrame.getInstance().getResourceBundle().getString("mbHelp"));
		help.setMnemonic(KeyEvent.VK_H);

		help.add(MainFrame.getInstance().getActionManager().getAbout());
	

		add(project);
		add(edit);
		add(window);
		add(settings);
		add(Language);
		add(help);
	}
	public void changeText(){
		project.setText(MainFrame.getInstance().getResourceBundle().getString("mbProject"));
	    edit.setText(MainFrame.getInstance().getResourceBundle().getString("mbEdit"));
		window.setText(MainFrame.getInstance().getResourceBundle().getString("mbWindow"));
		settings.setText(MainFrame.getInstance().getResourceBundle().getString("mbSettings")); //promena imena za MenuBar
		Language.setText(MainFrame.getInstance().getResourceBundle().getString("mbLanguage"));
	    help.setText(MainFrame.getInstance().getResourceBundle().getString("mbHelp"));
	    miLookAndFeel.setText(MainFrame.getInstance().getResourceBundle().getString("miLooknFeel"));
	    mniEngleski.setText(MainFrame.getInstance().getResourceBundle().getString("miEnglish"));
	    mniSrpskiLatinica.setText(MainFrame.getInstance().getResourceBundle().getString("miSerbian"));
	    mniSrpskiCirilica.setText(MainFrame.getInstance().getResourceBundle().getString("miSerbianCyrillic"));
	    jmaS.setText(MainFrame.getInstance().getResourceBundle().getString("miNimbus"));
	    
	 
	    
	    
		ResourceBundle resourceBundle=MainFrame.getInstance().getResourceBundle();
	
		this.actionManager=MainFrame.getInstance().getActionManager();   // Promena imena za Menu Iteme
		actionManager.getNewProject().putValue("Name",resourceBundle.getString("miNewProject") );
		actionManager.getNewProject().putValue("ShortDescription",resourceBundle.getString("miNewProject") );
	
		actionManager.getNewDocument().putValue("Name",resourceBundle.getString("miNewDocument") );
		actionManager.getNewDocument().putValue("ShortDescription",resourceBundle.getString("miNewDocument") );
		
		actionManager.getNewPage().putValue("Name",resourceBundle.getString("miNewPage") );
		actionManager.getNewPage().putValue("ShortDescription",resourceBundle.getString("miNewPage") );
		
		actionManager.getGraphicSlot().putValue("Name",resourceBundle.getString("miNewGS") );
		actionManager.getGraphicSlot().putValue("ShortDescription",resourceBundle.getString("miNewGS") );
		
		actionManager.getTextSlot().putValue("Name",resourceBundle.getString("miNewTS") );
		actionManager.getTextSlot().putValue("ShortDescription",resourceBundle.getString("miNewTS") );
		
		actionManager.getSaveproject().putValue("Name",resourceBundle.getString("miSaveProject") );
		actionManager.getSaveproject().putValue("ShortDescription",resourceBundle.getString("miSaveProject") );
		
		actionManager.getOpenproject().putValue("Name",resourceBundle.getString("miOpenProject") );
		actionManager.getOpenproject().putValue("ShortDescription",resourceBundle.getString("miOpenProject") );
		
		actionManager.getExit().putValue("Name",resourceBundle.getString("miExit") );
		actionManager.getExit().putValue("ShortDescription",resourceBundle.getString("miExit") );
		
		actionManager.getDeleteItem().putValue("Name", resourceBundle.getString("miDelete"));
		actionManager.getDeleteItem().putValue("ShortDescription", resourceBundle.getString("miDelete"));
		
		actionManager.getCascade().putValue("Name", resourceBundle.getString("miCHorizontaly"));
		actionManager.getCascade().putValue("ShortDescription", resourceBundle.getString("miCHorizontaly"));
		
		actionManager.getTileHor().putValue("Name", resourceBundle.getString("miTileH"));
		actionManager.getTileHor().putValue("ShortDescription", resourceBundle.getString("miTileH"));

		actionManager.getTileVer().putValue("Name", resourceBundle.getString("miTileV"));
		actionManager.getTileVer().putValue("ShortDescription", resourceBundle.getString("miTileV"));
		
		actionManager.getAbout().putValue("Name", resourceBundle.getString("miAbout"));
		actionManager.getAbout().putValue("ShortDescription", resourceBundle.getString("miAbout"));
		
		actionManager.getRename().putValue("Name", resourceBundle.getString("miRename"));
		actionManager.getRename().putValue("ShortDescription", resourceBundle.getString("miRename"));
		
		actionManager.getGridView().putValue("Name", resourceBundle.getString("miGridView"));
		actionManager.getGridView().putValue("ShortDescription", resourceBundle.getString("miGridView"));
	
		
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
		
		
		
		
		
		
	}

}
