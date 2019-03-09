package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.tree.MutableTreeNode;

import mainFrame.MainFrame;
import model.Project;
import model.TextSlot;
import model.Trash;
import model.Workspace;
import dialogs.TextSlotContentViewer;

@SuppressWarnings("serial")
public class TextSlotViewer extends JPanel implements Observer {
	private TextSlot textSlot;
	JTextArea panCentar = new JTextArea();

	public TextSlotViewer(TextSlot textSlot) {
		super(new BorderLayout(0, 0));

		this.setTextSlot(textSlot);
		this.textSlot.addObserver(this);

		this.panCentar.setEnabled(false);
		this.panCentar.setText(textSlot.getText());

		this.panCentar.addMouseListener(new Klik());

		add(this.panCentar, "Center");

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (this.textSlot.isDesignMode()) {
			Border redline = BorderFactory.createLineBorder(Color.GRAY);
			TitledBorder title = BorderFactory.createTitledBorder(redline,
					this.textSlot.toString());
			title.setTitlePosition(4);
			title.setTitleJustification(2);
			setBorder(title);

		} else {
			setBorder(null);
		}

		this.panCentar.setBackground(Color.WHITE);
		add(this.panCentar);
		validate();
		this.panCentar.setText(((TextSlot) this.textSlot).getText());
	}

	public TextSlot getTextSlot() {
		return textSlot;
	}

	public void setTextSlot(TextSlot textSlot) {
		this.textSlot = textSlot;
	}

	public class Klik extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
		Project project= (Project) textSlot.getParent().getParent().getParent();
		if (!(project.getName().contains("Trash") || project.getName().contains("Kanta") || project.getName().contains("Канта")))
			if (e.getClickCount() == 2) {
					
				TextSlotContentViewer slotContentViewer = new TextSlotContentViewer(
						(TextSlot) TextSlotViewer.this.textSlot);
				slotContentViewer.setVisible(true);
			}

		}

	}
}
