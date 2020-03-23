import java.io.*;
import java.util.*;

public class Playlist {
	private ArrayList<Song> songs;
	private String name;
	
	public Playlist(String name, ArrayList<Song> songs) {
		this.name = name;
		this.songs = songs;
	}

	public Playlist(String name) {
		this(name, new ArrayList<Song>());
	}

	public void addSong(Song s) {
		songs.add(s);
	}

	public void removeSong(String title) {
		for(int i = 0; i < songs.size(); i++) {
			if(songs.get(i).title().equals(title)) {
				songs.remove(i);
			}
		}
	}

	public void playlistToFile() {
		try {
			File f = new File("./playlists/" + name + ".txt");
			if(!f.exists()) {
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f);
			for(Song s : songs) {
				fw.write(s + "\n");
			}
			fw.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static Playlist fileToPlaylist(File file) {
		Playlist toReturn = new Playlist(file.getName().substring(0, file.getName().indexOf(".txt")));
		try {
			
			if(file.exists()) {
				Scanner sc = new Scanner(file);
				String line;
				while(sc.hasNextLine()) {
					line = sc.nextLine();
				}
				sc.close();
			}
			return toReturn;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return toReturn;
	}

	public static void main(String[] args) {
		Song s = new Song("hello", 123);
		Song q = new Song("goodbye", 234);
		Song p = new Song("hello again", 345);

		Playlist myPL = new Playlist("sick jams");
		myPL.addSong(s);
		myPL.addSong(q);
		myPL.addSong(p);

		myPL.playlistToFile();
		myPL.addSong(new Song("fart", 456));
		myPL.playlistToFile();
	}
}