package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;
import javax.swing.tree.DefaultTreeModel;

import mainFrame.MainFrame;
import model.Project;
import model.Workspace;

@SuppressWarnings("serial")
public class NewProject extends AbstractGerudokActions  {

	public NewProject() {
		putValue("SmallIcon", loadIcon("images/new-project.png"));
		putValue("Name", "New project");
		putValue("ShortDescription", "New project");
		putValue(ACCELERATOR_KEY,
				KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Workspace workspace = (Workspace) MainFrame.getInstance().getTree()
				.getModel().getRoot();
		String name = MainFrame.getInstance().getResourceBundle()
				.getString("Project");
		Project project = new Project(name + " "
				+ (workspace.getChildCount() + 1), workspace);
		workspace.insert(project, workspace.getChildCount());

		((DefaultTreeModel) MainFrame.getInstance().getTree().getModel())
				.reload();

	}

}
