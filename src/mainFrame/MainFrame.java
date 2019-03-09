package mainFrame;

import gui.MenuBar;
import gui.StatusBar;
import gui.ToolBar;
import gui.TreeWithListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import model.Document;
import model.Project;
import model.Trash;
import model.Workspace;
import views.ProjectViewer;
import views.TreeRendered;
import views.WorkspaceViewer;
import actions.ActionManager;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ClipboardOwner {

	private static MainFrame instance = null;
	private TreeWithListener tree;
	private TreeWithListener trash;
	private JDesktopPane desktopPane;
	// private CommandManager commandManager;
	private ActionManager actionManager;
	public static String LOOKANDFEEL = "Nimbus";
	public static String THEME = "Ocean";
	private MenuBar menubar;
	private ResourceBundle resourceBundle;
	private Workspace workspace;
	private Trash trashModel;
	private StatusBar statusBar;
	private Clipboard clipboard = new Clipboard("Gerudok clipboard");
	private ArrayList<Document> listOfDocumet = new ArrayList<Document>();

	private MainFrame() {

	}

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
			instance.initialise();
		}

		return instance;
	}

	public void initialise() {

		Locale.setDefault(new Locale("en", "US"));
		resourceBundle = ResourceBundle.getBundle("language.MessageResources",
				Locale.getDefault());

		UIManager
				.put("OptionPane.noButtonText", resourceBundle.getString("no"));
		UIManager.put("OptionPane.yesButtonText",
				resourceBundle.getString("yes"));
		UIManager.put("OptionPane.okButtonText",
				resourceBundle.getString("okAbout"));
		UIManager.put("OptionPane.messageDialogTitle",
				resourceBundle.getString("miMessage"));

		setSize(1100, 700);

		setTitle(MainFrame.getInstance().getResourceBundle()
				.getString("titleName"));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		

		actionManager = new ActionManager();

		Workspace workspace = new Workspace();
		Trash trash = new Trash();
		this.setTrashModel(trash);
		WorkspaceViewer workspaceViewer = new WorkspaceViewer(workspace);

		this.setWorkspace(workspace);

		this.tree = new TreeWithListener(workspace);
		this.trash = new TreeWithListener(trash);

		this.desktopPane = new JDesktopPane();
		this.desktopPane = workspaceViewer;

		JScrollPane scrollPaneTree = new JScrollPane(this.tree);
		JScrollPane scrollPaneTrash = new JScrollPane(this.trash);

		this.tree.setCellRenderer(new TreeRendered());
		this.trash.setCellRenderer(new TreeRendered());

		TreePath path = (TreePath) new TreePath(tree.getModel().getRoot());
		TreePath path1 = (TreePath) new TreePath(this.trash.getModel()
				.getRoot());

		tree.setSelectionPath(path);
		this.trash.setSelectionPath(path1);

		initLookAndFeel();

		JPanel panLeft = new JPanel(new BorderLayout());

		panLeft.setPreferredSize(new Dimension(200, 100));
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				scrollPaneTree, scrollPaneTrash);
		split.setOneTouchExpandable(true);
		split.setDividerLocation(380);
		panLeft.add(split);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				panLeft, desktopPane);

		JPanel panBottom = new JPanel();

		panBottom.setLayout(new BorderLayout());
		panBottom.setPreferredSize(new Dimension(100, 20));
		panBottom.setBackground(Color.LIGHT_GRAY);

		add(splitPane, BorderLayout.CENTER);
		add(panBottom, BorderLayout.SOUTH);

		MenuBar menu = new MenuBar();
		this.menubar = menu;

		setJMenuBar(menu);

		ToolBar toolbar = new ToolBar();
		toolbar.setBackground(Color.LIGHT_GRAY);
		add(toolbar, BorderLayout.NORTH);

		statusBar = new StatusBar();
		add(statusBar, "South");

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				if (JOptionPane.showConfirmDialog(
						MainFrame.getInstance(),
						MainFrame.getInstance().getResourceBundle()
								.getString("miExitQuestion"),
						MainFrame.getInstance().getResourceBundle()
								.getString("confirmExit"),
						JOptionPane.YES_NO_OPTION) == 0) {
					e.getWindow().dispose();
				}
			}

		});

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

	}

	public static void initLookAndFeel() {

		if (LOOKANDFEEL != null) {
			if (LOOKANDFEEL.equals("Metal")) {

				UIManager.getCrossPlatformLookAndFeelClassName();

			}

			else if (LOOKANDFEEL.equals("Nimbus")) {
				try {

					for (LookAndFeelInfo info : UIManager
							.getInstalledLookAndFeels()) {

						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
				} catch (Exception e) {

				}
			}

			else {
				System.err
						.println("Unexpected value of LOOKANDFEEL specified: "
								+ LOOKANDFEEL);
				UIManager.getCrossPlatformLookAndFeelClassName();
			}

		}

		MainFrame.getInstance().getDesktopPane().updateUI();
		((DefaultTreeModel) MainFrame.getInstance().getTree().getModel())
				.reload();

	}

	public void changeLanguage() {

		resourceBundle = ResourceBundle.getBundle("language.MessageResources",
				Locale.getDefault());
		this.menubar.changeText();

		statusBar.getLangStatusBar().setText(
				MainFrame.getInstance().getResourceBundle()
						.getString("langStatusBar"));
		statusBar.getMilos().setText(
				MainFrame.getInstance().getResourceBundle().getString("milos"));
		statusBar.getSrecko()
				.setText(
						MainFrame.getInstance().getResourceBundle()
								.getString("srecko"));
		setTitle(MainFrame.getInstance().getResourceBundle()
				.getString("titleName"));
		UIManager.put("OptionPane.yesButtonText",
				resourceBundle.getString("yes"));
		UIManager.put("OptionPane.okButtonText",
				resourceBundle.getString("okAbout"));
		UIManager
				.put("OptionPane.noButtonText", resourceBundle.getString("no"));
		UIManager.put("OptionPane.messageDialogTitle",
				resourceBundle.getString("miMessage"));

		actionManager.getDeleteFromTrashAction().putValue("Name",
				resourceBundle.getString("miDelete"));
		actionManager.getDeleteFromTrashAction().putValue("ShortDescription",
				resourceBundle.getString("miDelete"));

		actionManager.getRestoreAction().putValue("Name",
				resourceBundle.getString("restore"));
		actionManager.getRestoreAction().putValue("ShortDescription",
				resourceBundle.getString("restore"));

		actionManager.getEmptyTrashAction().putValue("Name",
				resourceBundle.getString("emptyTrash"));
		actionManager.getEmptyTrashAction().putValue("ShortDescription",
				resourceBundle.getString("emptyTrash"));

		MainFrame.getInstance().getTree().updateUI();

	}

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public void setResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
	}

	public MenuBar getMenubar() {
		return menubar;
	}

	public void setMenubar(MenuBar menubar) {
		this.menubar = menubar;
	}

	public Workspace getWorkspace() {
		return workspace;
	}

	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
	}

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public void setDesktopPane(JDesktopPane desktopPane) {
		this.desktopPane = desktopPane;
	}

	public TreeWithListener getTree() {
		return tree;
	}

	/*
	 * public CommandManager getCommandManager() { return this.commandManager; }
	 */

	public ActionManager getActionManager() {
		return actionManager;
	}

	public void setActionManager(ActionManager actionmanager) {
		this.actionManager = actionmanager;
	}

	public Clipboard getClipboard() {
		return clipboard;
	}

	public void setClipboard(Clipboard clipboard) {
		this.clipboard = clipboard;
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub
		System.out.println("lostOwnership");

	}

	public ArrayList<Document> getListOfDocumet() {
		return listOfDocumet;
	}

	public void setListOfDocumet(ArrayList<Document> listOfDocumet) {
		this.listOfDocumet = listOfDocumet;
	}

	public ProjectViewer selectInternalFrame(TreeNode Node) {
		ProjectViewer projectViewer = null;

		JInternalFrame[] frames = MainFrame.getInstance().getDesktopPane()
				.getAllFrames();
		for (int i = 0; i < frames.length; i++) {
			projectViewer = (ProjectViewer) frames[i];
			Project project = projectViewer.getProject();
			if (project.equals((Project) Node)) {
				try {
					if (!frames[i].isVisible()) {

						frames[i].setVisible(true);
					}
					frames[i].setSelected(true);
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		return projectViewer;
	}

	public TreeWithListener getTrash() {
		return trash;
	}

	public void setTrash(TreeWithListener trash) {
		this.trash = trash;
	}

	public Trash getTrashModel() {
		return trashModel;
	}

	public void setTrashModel(Trash trashModel) {
		this.trashModel = trashModel;
	}

}
