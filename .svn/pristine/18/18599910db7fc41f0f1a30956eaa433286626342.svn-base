package actions;

import model.GraphSlot;

public class ActionManager {
	private GraphSlot slot;
	private Undo undoAction;
	private Redo redoAction;
	private NewProject newProject;
	private NewDocument newDocument;
	private NewPage newPage;
	private NewGraphicSlot graphicSlot;
	private NewTextSlot textSlot;
	private SaveProject saveproject;
	private OpenProject openproject;
	private DeleteItem deleteItem;
	private CascadeHor cascade;
	private TileHor tileHor;
	private TileVer tileVer;
	private AboutDialogAction about;
	private RenameAction rename;
	private ExitAction exit;
	private DeleteElementAction deleteElementAction;
	private EditCopyAction editCopyAction;
	private EditCutAction editCutAction;
	private EditPasteAction editPasteAction;
	private CircleStateAction circleStateAction;
	private RectangleStateAction rectangleStateAction;
	private SelectStateAction selectStateAction;
	private GridView gridView;
	private CopyDocumentAction copyDocumentAction;
	private PasteDocumentAction pasteDocumentAction;
	private EmptyTrashAction emptyTrashAction;
	private RestoreAction restoreAction;
	private DeleteFromTrashAction deleteFromTrashAction;
	
	public ActionManager(){
		initialiseActions();
	}
	
	public void initialiseActions() {
		undoAction = new Undo(slot);
		redoAction = new Redo(slot);
		
		editCopyAction = new EditCopyAction(slot);
		editCutAction = new EditCutAction(slot);
		editPasteAction = new EditPasteAction(slot);
		
		newProject = new NewProject();
		
		
		newDocument = new NewDocument();
		newDocument.setEnabled(false);
		
		newPage = new NewPage();
		newPage.setEnabled(false);
		
		graphicSlot= new NewGraphicSlot();
		graphicSlot.setEnabled(false);
		
		textSlot=new NewTextSlot();
		textSlot.setEnabled(false);
		
		saveproject=new SaveProject();
		saveproject.setEnabled(false);
		openproject = new OpenProject();
		deleteItem = new DeleteItem();
		deleteItem.setEnabled(false);
	
		cascade = new CascadeHor();
		cascade.setEnabled(false);
		tileHor = new TileHor();
		tileHor.setEnabled(false);
		tileVer = new TileVer();
		tileVer.setEnabled(false);
		gridView = new GridView();
		gridView.setEnabled(false);
		about = new AboutDialogAction();
		
		exit = new ExitAction();
		rename = new RenameAction();
		copyDocumentAction = new CopyDocumentAction();
		pasteDocumentAction = new PasteDocumentAction();
		emptyTrashAction = new EmptyTrashAction();
		restoreAction = new RestoreAction();
		deleteFromTrashAction = new DeleteFromTrashAction();
	
	}

	public RestoreAction getRestoreAction() {
		return restoreAction;
	}

	public void setRestoreAction(RestoreAction restoreAction) {
		this.restoreAction = restoreAction;
	}

	public GridView getGridView() {
		return gridView;
	}

	public void setGridView(GridView gridView) {
		this.gridView = gridView;
	}

	public RenameAction getRename() {
		return rename;
	}

	public void setRename(RenameAction rename) {
		this.rename = rename;
	}

	public AboutDialogAction getAbout() {
		return about;
	}

	public void setAbout(AboutDialogAction about) {
		this.about = about;
	}

	public CascadeHor getCascade() {
		return cascade;
	}

	public void setCascade(CascadeHor cascade) {
		this.cascade = cascade;
	}

	public TileHor getTileHor() {
		return tileHor;
	}

	public void setTileHor(TileHor tileHor) {
		this.tileHor = tileHor;
	}

	public TileVer getTileVer() {
		return tileVer;
	}

	public void setTileVer(TileVer tileVer) {
		this.tileVer = tileVer;
	}

	public Undo getUndoAction() {
		return undoAction;
	}

	public void setUndoAction(Undo undoAction) {
		this.undoAction = undoAction;
	}

	public Redo getRedoAction() {
		return redoAction;
	}

	public void setRedoAction(Redo redoAction) {
		this.redoAction = redoAction;
	}

	public NewProject getNewProject() {
		return newProject;
	}

	public void setNewProject(NewProject newProject) {
		this.newProject = newProject;
	}

	public NewDocument getNewDocument() {
		return newDocument;
	}

	public void setNewDocument(NewDocument newDocument) {
		this.newDocument = newDocument;
	}

	public NewPage getNewPage() {
		return newPage;
	}

	public void setNewPage(NewPage newPage) {
		this.newPage = newPage;
	}

	public NewGraphicSlot getGraphicSlot() {
		return graphicSlot;
	}

	public void setGraphicSlot(NewGraphicSlot graphicSlot) {
		this.graphicSlot = graphicSlot;
	}

	public NewTextSlot getTextSlot() {
		return textSlot;
	}

	public void setTextSlot(NewTextSlot textSlot) {
		this.textSlot = textSlot;
	}

	public SaveProject getSaveproject() {
		return saveproject;
	}

	public void setSaveproject(SaveProject saveproject) {
		this.saveproject = saveproject;
	}

	public OpenProject getOpenproject() {
		return openproject;
	}

	public void setOpenproject(OpenProject openproject) {
		this.openproject = openproject;
	}


	public DeleteItem getDeleteItem() {
		return deleteItem;
	}

	public void setDeleteItem(DeleteItem deleteItem) {
		this.deleteItem = deleteItem;
	}
	public GraphSlot getSlot() {
		return slot;
	}

	public void setSlot(GraphSlot slot) {
		this.slot = slot;
	}

	public ExitAction getExit() {
		return exit;
	}

	public void setExit(ExitAction exit) {
		this.exit = exit;
	}

	public DeleteElementAction getDeleteElementAction() {
		return deleteElementAction;
	}

	public void setDeleteElementAction(DeleteElementAction deleteElementAction) {
		this.deleteElementAction = deleteElementAction;
	}

	public EditCopyAction getEditCopyAction() {
		return editCopyAction;
	}

	public void setEditCopyAction(EditCopyAction editCopyAction) {
		this.editCopyAction = editCopyAction;
	}

	public EditCutAction getEditCutAction() {
		return editCutAction;
	}

	public void setEditCutAction(EditCutAction editCutAction) {
		this.editCutAction = editCutAction;
	}

	public EditPasteAction getEditPasteAction() {
		return editPasteAction;
	}

	public void setEditPasteAction(EditPasteAction editPasteAction) {
		this.editPasteAction = editPasteAction;
	}

	public CircleStateAction getCircleStateAction() {
		return circleStateAction;
	}

	public void setCircleStateAction(CircleStateAction circleStateAction) {
		this.circleStateAction = circleStateAction;
	}

	public SelectStateAction getSelectStateAction() {
		return selectStateAction;
	}

	public void setSelectStateAction(SelectStateAction selectStateAction) {
		this.selectStateAction = selectStateAction;
	}

	public RectangleStateAction getRectangleStateAction() {
		return rectangleStateAction;
	}

	public void setRectangleStateAction(RectangleStateAction rectangleStateAction) {
		this.rectangleStateAction = rectangleStateAction;
	}

	public CopyDocumentAction getCopyDocumentAction() {
		return copyDocumentAction;
	}

	public void setCopyDocumentAction(CopyDocumentAction copyDocumentAction) {
		this.copyDocumentAction = copyDocumentAction;
	}

	public PasteDocumentAction getPasteDocumentAction() {
		return pasteDocumentAction;
	}

	public void setPasteDocumentAction(PasteDocumentAction pasteDocumentAction) {
		this.pasteDocumentAction = pasteDocumentAction;
	}

	public EmptyTrashAction getEmptyTrashAction() {
		return emptyTrashAction;
	}

	public void setEmptyTrashAction(EmptyTrashAction emptyTrashAction) {
		this.emptyTrashAction = emptyTrashAction;
	}

	public DeleteFromTrashAction getDeleteFromTrashAction() {
		return deleteFromTrashAction;
	}

	public void setDeleteFromTrashAction(DeleteFromTrashAction deleteFromTrashAction) {
		this.deleteFromTrashAction = deleteFromTrashAction;
	}

	

	
}
