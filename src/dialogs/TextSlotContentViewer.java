package dialogs;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import mainFrame.MainFrame;
import model.TextSlot;

@SuppressWarnings("serial")
public class TextSlotContentViewer extends JDialog implements Observer  {
	private TextSlot slot;
	private JTextArea area = new JTextArea();

	public TextSlotContentViewer(TextSlot slot) {
		this.slot = slot;
        slot.addObserver(this);
		setTitle(slot.toString());
		setSize(new Dimension(400, 400));
		setLocationRelativeTo(MainFrame.getInstance());
		setModal(true);

		this.area.setLineWrap(true);
		this.area.setText(slot.getText());
		
		JScrollPane scp = new JScrollPane(this.area);
		add(scp, "Center");

		addWindowListener(new WindowController());
	
		

	}
	public void update(Observable o, Object arg) {
		repaint();
	}

	

	class WindowController extends WindowAdapter {

		public void windowClosing(WindowEvent e) {
			String text = TextSlotContentViewer.this.area.getText();
			TextSlotContentViewer.this.slot.setText(text);  // setText metoda poziva se u modelu TextSlot
		}
	}

}
