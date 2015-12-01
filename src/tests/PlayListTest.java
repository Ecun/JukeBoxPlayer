/**
 * @Author:Yicun Zeng.
 * @Author:Ryan Wong.
 * @Course:CSC 335.
 * @Instructor:Rick Mercer. 
 * Test cases for PlayList
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.PlayList;
import model.Song;

public class PlayListTest {
	
	public static String baseDir = System.getProperty("user.dir") + System.getProperty("file.separator") + "songfiles"
			+ System.getProperty("file.separator");

	@Test
	public void testLimitOfSongsEachDay() {
		PlayList list = new PlayList();
		Song song = new Song("FreePlay Music", "Determined Tumbao", 20, baseDir + "DeterminedTumbao.mp3");
		list.queueSong(song);
		list.queueSong(song);
		list.queueSong(song);
		assertEquals(3, list.size());
		list.queueSong(song);
		assertEquals(3, list.size());
	}
	
	@Test
	public void testIsEmpty(){
		PlayList list = new PlayList();
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testPlay(){
		PlayList list = new PlayList();
		Song song = new Song("FreePlay Music", "Determined Tumbao", 20, baseDir + "DeterminedTumbao.mp3");
		list.queueSong(song);
		assertEquals(baseDir + "DeterminedTumbao.mp3", list.play());
	}

}
