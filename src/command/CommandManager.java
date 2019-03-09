package command;

import java.util.ArrayList;

import mainFrame.MainFrame;

public class CommandManager {

	private ArrayList<AbstractCommand> commands = new ArrayList<AbstractCommand>();

	private int currentCommand = 0;

	public void addCommand(AbstractCommand command) {

		while (currentCommand < commands.size())
			commands.remove(currentCommand);
		commands.add(command);

		// currentCommand++;
		doCommand();
		MainFrame.getInstance().getActionManager().getUndoAction()
				.setEnabled(true);

	}

	public void doCommand() {

		if (currentCommand < commands.size()) {
			commands.get(currentCommand++).doCommand();

			MainFrame.getInstance().getActionManager().getUndoAction()
					.setEnabled(true);

			//System.out.println(currentCommand);
		}
		if (currentCommand == commands.size()) {

			MainFrame.getInstance().getActionManager().getRedoAction()
					.setEnabled(false);
		}
	}

	public void undoCommand() {

		if (currentCommand > 0) {

			MainFrame.getInstance().getActionManager().getRedoAction()
					.setEnabled(true);

			commands.get(--currentCommand).undoCommand();
		
			//System.out.println(currentCommand);
		}
		if (currentCommand == 0) {

			MainFrame.getInstance().getActionManager().getUndoAction()
					.setEnabled(false);
		}
	}

}
