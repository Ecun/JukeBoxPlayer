/**
 * @Author:Yicun Zeng.
 * @Author:Ryan Wong.
 * @Course:CSC 335.
 * @Instructor:Rick Mercer. 
 * Stores songs that user chose and provide song info to JukeBox.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayList extends ArrayList<Song> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4956936819766622330L;

	public boolean queueSong(Song song) {
		if (song.canPlay()) {
			song.play();
			return this.add(song);
		}
		else 
			return false;
	}

	public String play() {
		return this.get(0).getAudioFileName();
	}
}
