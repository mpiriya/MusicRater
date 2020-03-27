package src.com.MusicRater.logic;

import java.io.*;
import java.util.*;
import com.opencsv.*;

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
			CSVWriter cw = new CSVWriter(fw);
			List<String[]> data = new ArrayList<String[]>();
			for(Song s : songs) {
				data.add(s.toStringArray());
			}
			cw.writeAll(data);
			cw.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static Playlist fileToPlaylist(File file) {
		Playlist toReturn = new Playlist(file.getName().substring(0, file.getName().indexOf(".csv")));
		try {
			if(file.exists()) {
				FileReader fr = new FileReader(file);
				CSVReader csvReader = new CSVReader(fr);
				String[] nextLine;
				while((nextLine = csvReader.readNext()) != null) {
					Song toAdd = new Song(nextLine[0], nextLine[1]);
					System.out.print(nextLine[0]);
					try {
						toAdd.setrating(Integer.parseInt(nextLine[2]));
					} catch (Exception e) {
						
					}
					toReturn.addSong(toAdd);
				}
				System.out.println();
				csvReader.close();
			}
			return toReturn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toReturn;
	}

	public String toString() {
		String toReturn = "";
		for(Song s : songs) {
			toReturn += s.toString() + "\n";
		}
		return toReturn;
	}

	public static void main(String[] args) {
		Playlist pl = Playlist.fileToPlaylist(new File("playlists/MattyPslaps.csv"));
	}
}