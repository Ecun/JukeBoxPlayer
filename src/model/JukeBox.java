/**
 * @Author:Yicun Zeng.
 * @Author:Ryan Wong.
 * @Course:CSC 335.
 * @Instructor:Rick Mercer. 
 * Initialize user and Playlist to play songs.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import songplayer.EndOfSongEvent;
import songplayer.EndOfSongListener;
import songplayer.SongPlayer;

public class JukeBox extends Observable{

	public static String baseDir = System.getProperty("user.dir") + System.getProperty("file.separator") + "songfiles"
			+ System.getProperty("file.separator");

	private String id;
	private UserCollection userList;
	private PlayList list = new PlayList();

	public JukeBox() {
		userList = new UserCollection();
	}

	public void setCurrentUserID(String id) {
		this.id = id;
	}

	public User getCurrentUser() {
		return userList.get(id);
	}

	public UserCollection getUserList() {
		return userList;
	}

	public PlayList getPlayList() {
		return list;
	}

	public void setPlayList(ArrayList<Song> readObject) {
		for (Song song : readObject)
			list.add(song);
	}

	public void setUserList(HashMap<String, User> readObject) {
		userList.clear();
		for (Map.Entry<String, User> entry : readObject.entrySet()) {
			userList.put(entry.getKey(), entry.getValue());
		}
	}

	public boolean validate(String id, String password) {
		if (!userList.containsKey(id))
			return false;
		else
			return userList.validateStudent(id, password);
	}

	public boolean userCanPlay() {
		return getCurrentUser().canPlay();
	}

	public boolean addSong(Song song) {
		return list.queueSong(song);
	}

	public void play() {
		SongPlayer.playFile(new SongWaiter(), list.play());
	}

	private class SongWaiter implements EndOfSongListener {

		public void songFinishedPlaying(EndOfSongEvent eosEvent) {
			list.remove(0);
			setChanged();
			notifyObservers();
			if (!list.isEmpty()) {
				SongPlayer.playFile(new SongWaiter(), list.play());
			}
		}
	}

}
