/**
 * @Author:Yicun Zeng.
 * @Author:Ryan Wong.
 * @Course:CSC 335.
 * @Instructor:Rick Mercer. 
 * Test cases for User
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Song;
import model.User;

public class UserTest {
	public static String baseDir = System.getProperty("user.dir") + System.getProperty("file.separator") + "songfiles"
			+ System.getProperty("file.separator");

	@Test
	public void testIDSetterAndGetter() {
		User user = new User();
		user.setId("Chris");
		assertEquals("Chris", user.getId());
	}

	@Test
	public void testPasswordSetterAndGetter() {
		User user = new User();
		user.setPassword("1");
		assertEquals("1", user.getPassword());
	}

	@Test
	public void testCanPlay() {
		User user = new User();
		Song song = new Song("Space Music", "Sun Microsystems", 7, baseDir + "spacemusic.au");
		user.addPlayed(song);
		user.addPlayed(song);
		assertTrue(user.canPlay());
		
		user.addPlayed(song);
		assertFalse(user.canPlay());
	}
	
	@Test
	public void testCanPlayNewDay(){
		User user = new User();
		Song song = new Song("Space Music", "Sun Microsystems", 7, baseDir + "spacemusic.au");
		user.addPlayed(song);
		user.addPlayed(song);
		user.addPlayed(song);
		
		user.pretendTheDateHasChanged();
		user.canPlay();
	}
	
	@Test
	public void testGetAvailableTime(){
		User user = new User();
		Song song = new Song("Space Music", "Sun Microsystems", 7, baseDir + "spacemusic.au");
		assertEquals("25 hours 0 minutes 0 seconds", user.getAvailableTime());
		
		user.addPlayed(song);
		assertEquals("24 hours 59 minutes 53 seconds", user.getAvailableTime());
	}

}
