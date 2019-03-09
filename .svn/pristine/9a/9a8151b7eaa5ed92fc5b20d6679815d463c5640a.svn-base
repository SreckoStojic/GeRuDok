package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import model.GraphSlot;
import model.Project;
import dialogs.GraphSlotContentViewer;
import elements.Element;
import gui.SlotToolbar;

@SuppressWarnings("serial")
public class GraphSlotViewer extends JPanel implements Observer {
	private GraphSlot graphSlot;
	private GraphSlotContentViewer slotContentViewer;

	public GraphSlotViewer(GraphSlot graphSlot) {
		super(new BorderLayout());

		this.setGraphSlot(graphSlot);
		this.graphSlot.addObserver(this);

		TitledBorder title = BorderFactory.createTitledBorder(graphSlot
				.toString());
		title.setTitlePosition(4);
		setBorder(title);
		setBackground(Color.WHITE);
		this.slotContentViewer = new GraphSlotContentViewer(
				(GraphSlot) GraphSlotViewer.this.graphSlot);

		GraphSlotViewerFramework slotViewerFramework = new GraphSlotViewerFramework();
		slotViewerFramework.setBackground(Color.WHITE);
		add(slotViewerFramework, "Center");
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					// GraphSlotViewer.this.graphSlot.setDesignMode(true);
					Project project= (Project) graphSlot.getParent().getParent().getParent();
					if ((project.getName().contains("Trash") || project.getName().contains("Kanta") || project.getName().contains("Канта"))){
						SlotToolbar slotToolbar = slotContentViewer.getSlotToolbar();
						slotContentViewer.remove(slotToolbar);
						GraphSlotViewer.this.graphSlot.getStateManager().setSelectState();
						slotContentViewer.setVisible(true);
					}
					
					else{	
					slotContentViewer.getSlotToolbar().init();
					slotContentViewer.setVisible(true);
					}
				}

			}
			
		});

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		repaint();
	}

	public GraphSlot getGraphSlot() {
		return graphSlot;
	}

	public void setGraphSlot(GraphSlot graphSlot) {
		this.graphSlot = graphSlot;
	}

	class GraphSlotViewerFramework extends JPanel {
		GraphSlotViewerFramework() {
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			Graphics2D g2 = (Graphics2D) g;
			for (int i = 0; i < GraphSlotViewer.this.graphSlot.getChildCount(); i++) {
				Element element = (Element) GraphSlotViewer.this.graphSlot
						.getChildAt(i);
				g2.setColor(Color.BLACK);

				g2.setStroke(element.getStroke());
				g2.draw(element.getShape());
				g2.setPaint(element.getPaint());
				g2.fill(element.getShape());
			}
		}
	}

}
