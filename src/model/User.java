/**
 * @Author:Yicun Zeng.
 * @Author:Ryan Wong.
 * @Course:CSC 335.
 * @Instructor:Rick Mercer. 
 * Contains user id, password, and songs user chose today.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7369473985165666025L;

	// user can select up to three song everyday.
	public final static int MAX_PLAYS = 3;
	public final static int MAX_TIME = 1500 * 60;

	private String id;
	private String password;
	LocalDate lastDateQueue;
	private int availableTime;
	private ArrayList<Song> playedToday;

	public User() {
		playedToday = new ArrayList<Song>();
		lastDateQueue = LocalDate.now();
		lastDateQueue = lastDateQueue.minusYears(40);
		availableTime = MAX_TIME;
	}

	public User(String id, String password) {
		this.id = id;
		this.password = password;
		playedToday = new ArrayList<Song>();
		lastDateQueue = LocalDate.now();
		lastDateQueue = lastDateQueue.minusYears(40);
		availableTime = MAX_TIME;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvailableTime() {

		final int MINUTES_IN_AN_HOUR = 60;
		final int SECONDS_IN_A_MINUTE = 60;

		int seconds = availableTime % SECONDS_IN_A_MINUTE;
		int totalMinutes = availableTime / SECONDS_IN_A_MINUTE;
		int minutes = totalMinutes % MINUTES_IN_AN_HOUR;
		int hours = totalMinutes / MINUTES_IN_AN_HOUR;

		return "Total playing time left: " + hours + " hours " + minutes + " minutes " + seconds + " seconds";
	}

	public void addPlayed(Song song) {
		if (canPlay()) {
			playedToday.add(song);
			availableTime -= song.getDuration();
		}
	}

	public boolean canPlay() {
		LocalDate today = LocalDate.now();
		if (!today.equals(lastDateQueue)) {
			lastDateQueue = today;
			playedToday.clear();
		}
		return playedToday.size() < MAX_PLAYS;
	}

	public void pretendTheDateHasChanged() {
		if (canPlay())
			return;
		else {
			lastDateQueue = LocalDate.now().plusDays(1);
		}
	}

	public String getAvailableSong() {
		return id + " can choose " + (3 - playedToday.size()) + " song(s) today";
	}

}
