/**
 * @Author:Yicun Zeng.
 * @Author:Ryan Wong.
 * @Course:CSC 335.
 * @Instructor:Rick Mercer. 
 * Test cases for Song
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Song;

public class SongTest {
	public static String baseDir = System.getProperty("user.dir") + System.getProperty("file.separator") + "songfiles"
			+ System.getProperty("file.separator");
	
	@Test
	public void testGetter() {
		Song a = (new Song("Space Music", "Sun Microsystems", 7, baseDir + "spacemusic.au"));
		assertEquals("Space Music", a.getArtist());
		assertEquals("Sun Microsystems",a.getTitle());
		assertEquals(7,a.getDuration());
		assertEquals(baseDir + "spacemusic.au",a.getAudioFileName());
	}
	
	@Test
	public void testCanPlay(){
		Song b = (new Song("Flute", "Sun Microsytems", 7, baseDir + "flute.aif"));
		assertTrue(b.canPlay());
		b.play();
		b.play();
		assertTrue(b.canPlay());
		b.play();
		assertFalse(b.canPlay());
	}
	
	@Test
	public void testPretendTheDateHasChanged(){
		Song c = (new Song("Blue Ridge Mountain Mist", "Schuckett, Ralph", 39, baseDir + "tada.wav"));
		c.play();
		c.play();
		c.play();
		c.pretendTheDateHasChanged();
		
		c.play();
		assertTrue(c.canPlay());
	}
	

}
