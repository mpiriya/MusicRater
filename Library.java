import java.util.ArrayList;

public class Library {
	private ArrayList<Song> songs;

	public Library() {
		songs = new ArrayList<Song>();
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

	public ArrayList<Song> searchByKeyword(String key) {
		ArrayList<Song> toret = new ArrayList<Song>();
		
		for(int i = 0; i < songs.size(); i++) {
			Song atIndex = songs.get(i);

			if(atIndex.title().indexOf(key) != -1) {
				toret.add(atIndex);
			} else if(!atIndex.title().equals("(unknown)") && 
					atIndex.title().indexOf(key) != -1) {
				toret.add(atIndex);
			} else if(!atIndex.album().equals("(unknown)") &&
					atIndex.album().indexOf(key) != -1) {
				toret.add(atIndex);
			}
		}
		
		return toret;
	}
}