package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import mainFrame.MainFrame;
import model.Document;
import model.Page;
import observers.GeRuDokEvent;

@SuppressWarnings("serial")
public class DocumentViewer extends JPanel implements Observer {
	private ArrayList<PageViewer> pageViewers = new ArrayList<PageViewer>();
	private ArrayList<DocumentViewer>shortcuts = new ArrayList<DocumentViewer>();
	private Document document;

	JPanel panCentar = new JPanel();

	public DocumentViewer(Document aDocument) {
		super(new BorderLayout());
		this.document = aDocument;
		this.document.addObserver(this);
		this.panCentar.setBackground(Color.BLACK);
		JScrollPane sc = new JScrollPane(this.panCentar, 20, 30);
		add(sc);
	}
	public DocumentViewer(DocumentViewer documentViewer){
		super(new BorderLayout());
		this.document=documentViewer.document;
		this.document.addObserver(documentViewer);
		this.panCentar.setBackground(Color.BLACK);
		JScrollPane sc = new JScrollPane(this.panCentar, 20, 30);
		add(sc);
		
	}

	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	public void addCopyViewer(DocumentViewer documentViewer){
		this.shortcuts.add(documentViewer);
	}
	public DocumentViewer getDocumentCopy(int i){
		return this.shortcuts.get(i);
	}

	@Override
	public void update(Observable o, Object arg) {

		if (arg == null) {

			this.panCentar.removeAll();

			this.panCentar.setLayout(new BoxLayout(panCentar, BoxLayout.Y_AXIS));
			for (PageViewer pageViewer : this.pageViewers) {
				pageViewer.setPreferredSize(new Dimension(200, 200));

				this.panCentar.add(pageViewer, "align center");
			}
			validate();
			repaint();
			for (PageViewer pageViewer : this.pageViewers) {
				pageViewer.update(null, null);
			}
		}
		else if (arg instanceof GeRuDokEvent ) {

			GeRuDokEvent ger = (GeRuDokEvent) arg;
			int operation = ger.getOperation();
			if (operation == GeRuDokEvent.rename) {
				if (!(ger.getObject() instanceof Page)) {
					ProjectViewer pw = (ProjectViewer) MainFrame.getInstance().getDesktopPane().getSelectedFrame();
					pw.getDocumentsTab().setTitleAt(pw.getDocumentsTab().getSelectedIndex(),document.toString());

				}
				else {
					Page page=(Page)ger.getObject();
					for (PageViewer pw : this.pageViewers){
						if (page == pw.getPage()){
							TitledBorder title = BorderFactory.createTitledBorder(page.toString());
							title.setTitlePosition(4);
							pw.setBorder(title);
							
						}
					}
				}
			}
		}

	}

	public void addPageViewer(PageViewer pageViewer) {
		this.pageViewers.add(pageViewer);
		update(null, null);

	}

	public PageViewer getPageViewerForPage(Page page) {
		PageViewer pageViewer = null;
		for (PageViewer pageViewerTemp : this.pageViewers) {
			if (pageViewerTemp.getPage().equals(page)) {
				pageViewer = pageViewerTemp;
				break;
			}
		}
		return pageViewer;
	}

	public void removePageViewerForPage(Page page) {
		PageViewer pageViewer = null;
		for (PageViewer pageViewerTemp : this.pageViewers) {
			if (pageViewerTemp.getPage().equals(page)) {
				pageViewer = pageViewerTemp;
				break;
			}
		}
		if (pageViewer != null) {
			this.pageViewers.remove(pageViewer);
			update(null, null);
		}
	}

}
