package model;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

import elements.Element;

public class ElementsSelection implements Transferable, ClipboardOwner {
	public static DataFlavor elementFlavor;
	private DataFlavor[] supportedFlavors = { elementFlavor };
	public ArrayList<Element> elements = new ArrayList<Element>();

	public ElementsSelection(ArrayList<Element> elements) {
		for (Element element : elements) {
			if (!this.elements.contains(element)) {
				this.elements.add(element);
			}
		}
		System.out.println("Velicina clipboard array-a = "
				+ this.elements.size());
		try {
			elementFlavor = new DataFlavor(
					Class.forName("java.util.ArrayList"), "Elements");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub
		System.out.println("Element Selection lost clipboard ownership.");

	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		// TODO Auto-generated method stub
		  return this.supportedFlavors;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		// TODO Auto-generated method stub
		  return flavor.equals(elementFlavor);
	}

	@Override
	public Object getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException {
		if (flavor.equals(elementFlavor)) {
			return this.elements;
		}
		throw new UnsupportedFlavorException(elementFlavor);
		// TODO Auto-generated method stub
	}

}
