/**
 * @Author:Yicun Zeng.
 * @Author:Ryan Wong.
 * @Course:CSC 335.
 * @Instructor:Rick Mercer. 
 * Contains list of this.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class SongCollection extends ArrayList<Song> implements TableModel, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5853950745498478026L;

	public static String baseDir = System.getProperty("user.dir") + System.getProperty("file.separator") + "songfiles"
			+ System.getProperty("file.separator");

	public SongCollection() {
		this.add(new Song("Ralph Schuckett", "Blue Ridge Mountain Mist", 38, baseDir + "BlueRidgeMountainMist.mp3"));
		this.add(new Song("FreePlay Music", "Determined Tumbao", 20, baseDir + "DeterminedTumbao.mp3"));
		this.add(new Song("Sun Microsystems", "Flute", 5, baseDir + "flute.aif"));
		this.add(new Song("Unknown", "Space Music", 6, baseDir + "spacemusic.au"));
		this.add(new Song("FreePlay Music", "Swing Cheese", 15, baseDir + "SwingCheese.mp3"));
		this.add(new Song("Microsoft", "Tada", 2, baseDir + "tada.wav"));
		this.add(new Song("Pierre Langer", "Untameable Fire", 282, baseDir + "UntameableFire.mp3"));
	}
	
	public void recover(SongCollection songs){
		this.clear();
		for(Song song: songs)
			this.add(song);
	}

	@Override
	public int getRowCount() {
		return this.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String[] columnName = {"Artist","Title","Seconds"};
		return columnName[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 0 || columnIndex == 1)
			return String.class;
		else
			return Integer.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Song currentSong = this.get(rowIndex);
		if (columnIndex == 0)
			return currentSong.getArtist();
		else if (columnIndex == 1)
			return currentSong.getTitle();
		else
			return currentSong.getDuration();
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

	}

	@Override
	public void addTableModelListener(TableModelListener l) {

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {

	}
}
