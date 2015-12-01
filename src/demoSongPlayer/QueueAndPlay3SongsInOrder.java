/**
 * @Author:Yicun Zeng.
 * @Author:Ryan Wong.
 * @Course:CSC 335.
 * @Instructor:Rick Mercer. 
 * Initialize JukeBox to play songs.
 */
package demoSongPlayer;

import model.JukeBox;
import model.Song;

public class QueueAndPlay3SongsInOrder {
	public static String baseDir = System.getProperty("user.dir") + System.getProperty("file.separator") + "songfiles"
			+ System.getProperty("file.separator");

	public static void main(String[] args) {
		// Assign the responsibility of queuing Songs and playing them in order,
		// and not overlapping
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JukeBox box = new JukeBox();
				Song a = (new Song("Space Music", "Sun Microsytems", 7, baseDir + "spacemusic.au"));
				Song b = (new Song("Flute", "Sun Microsytems", 7, baseDir + "flute.aif"));
				Song c = (new Song("Blue Ridge Mountain Mist", "Schuckett, Ralph", 39, baseDir + "tada.wav"));
				box.addSong(a);
				box.addSong(b);
				box.addSong(c);
				box.play();
			}
		});
	}
}
