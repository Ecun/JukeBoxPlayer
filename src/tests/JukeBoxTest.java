/**
 * @Author:Yicun Zeng.
 * @Author:Ryan Wong.
 * @Course:CSC 335.
 * @Instructor:Rick Mercer. 
 * Test cases for JukeBox
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.JukeBox;
import model.Song;

public class JukeBoxTest {
	public static String baseDir = System.getProperty("user.dir") + System.getProperty("file.separator") + "songfiles"
			+ System.getProperty("file.separator");

	Song a = (new Song("Space Music", "Sun Microsytems", 7, baseDir + "spacemusic.au"));
	Song b = (new Song("Flute", "Sun Microsytems", 7, baseDir + "flute.aif"));
	Song c = (new Song("Blue Ridge Mountain Mist", "Schuckett, Ralph", 39, baseDir + "tada.wav"));

	@Test
	public void testValidate() {
		JukeBox box = new JukeBox();
		assertTrue(box.validate("Chris", "1"));
		assertFalse(box.validate("CHRis", "1"));
		assertFalse(box.validate("Chris", "2"));
	}

	@Test
	public void testPlay() {
		JukeBox box = new JukeBox();
		box.addSong(a);
		box.addSong(b);
		box.addSong(c);
		box.play();
	}
}
