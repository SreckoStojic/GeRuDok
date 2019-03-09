package serialization;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ProjectFileFilter extends FileFilter{

	@Override
	public boolean accept(File f) {
		// TODO Auto-generated method stub
		return (f.isDirectory() || 
                f.getName().toLowerCase().endsWith(".grd"));
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "GeRuDok Project Files (*.grd)";
	}

}
