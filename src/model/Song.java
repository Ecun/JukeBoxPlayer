/**
 * @Author:Yicun Zeng.
 * @Author:Ryan Wong.
 * @Course:CSC 335.
 * @Instructor:Rick Mercer. 
 * Contains title, artist, file name, duration time, and how many time the song has played.
 */
package model;

import java.io.Serializable;
/**
 * This class is a small part of Rick Mercer's Cashless Jukebox System.
 * 
 * This Song type keeps the song title and file name of its audio file.
 * It also has instance variables and methods to allow users to prevent
 * any Song object from being played more than twice a day.
 *  
 * @author Rick Mercer && Yicun Zeng
 */
import java.time.LocalDate;

public class Song implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2666723803836250763L;

	// No Song should play more than three times a day.
	public final static int MAX_PLAYS = 3;

	// Instance Variables
	private String title;
	private String artist;
	private String fileName;
	private int durationTime;
	private int playsToday;
	LocalDate lastDatePlayed;

	/**
	 * Construct an object to match the audio file and pretend this song has not
	 * been played in like 40 years
	 * 
	 * @param title
	 *            The title of the song
	 * @param fileName
	 *            The name of the file that stores the audio, usually ending
	 *            with the files extension mp3
	 */
	public Song(final String artist, final String title, final int duration, final String fileName) {
		this.artist = artist;
		this.title = title;
		this.durationTime = duration;
		this.fileName = fileName;
		playsToday = 0;
		// Initially set the data played to 40 years ago
		lastDatePlayed = LocalDate.now();
		// LocaDate must be immutable, minusYears return a new object
		lastDatePlayed = lastDatePlayed.minusYears(40);
	}

	/**
	 * A getter
	 * 
	 * @return The artist of this Song
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * A getter
	 * 
	 * @return The title of this Song
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * A getter
	 * 
	 * @return The title of this Song
	 */
	public int getDuration() {
		return durationTime;
	}

	/**
	 * A getter
	 * 
	 * @return The name of the file that stores the audio
	 */
	public String getAudioFileName() {
		return fileName;
	}

	/**
	 * Provide information about this Song reaching its daily play limit
	 * 
	 * @return True if this Song has not reached its daily limit
	 */
	public boolean canPlay() {
		LocalDate today = LocalDate.now();
		if (!today.equals(lastDatePlayed)) {
			lastDatePlayed = today;
			playsToday = 0;
		}

		return playsToday < MAX_PLAYS;
	}

	/**
	 * Record that the song has just played today. Programmers using this class
	 * are responsible to use canPlay and play responsibly. Other objects can be
	 * used to adhere to the daily play limit of any song in the Jukebox system.
	 */
	public void play() {
		if (canPlay())
		playsToday++;
	}

	/**
	 * A method added purely to test if a Song that has reached its daily limit
	 * could be played tomorrow at the same time. It is package protected for
	 * testing purposes. This means this method is not accessible outside of it
	 * package, even if it is in the same project.
	 */
	public void pretendTheDateHasChanged() {
		if (playsToday < 3)
			return;
		else {
			lastDatePlayed = LocalDate.now().plusDays(1);
		}
	}
	
	@Override
	public String toString(){
		int minutes = durationTime/60;
		int seconds = durationTime%60;
		return minutes + ":" + seconds + " "+ title + " by "+ artist;
	}
}
