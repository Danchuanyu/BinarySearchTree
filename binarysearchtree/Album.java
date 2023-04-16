public class Album implements Comparable<Album>, T {
    private int id;
    private String[] artists;
    private String title;
    private int numSongs;

    public Album(int id, String[] strings, String title, int numSongs) {
        this.id = id;
        this.artists = strings;
        this.title = title;
        this.numSongs = numSongs;
    }

    public Album(int id2, String string, String[] strings, int numSongs2) {
    }

    public int getId() {
        return id;
    }

    public String[] getArtists() {
        return artists;
    }

    public String getTitle() {
        return title;
    }

    public int getNumSongs() {
        return numSongs;
    }

    public String toString() {
        return "ID: " + id + " -- " + "[" + String.join(", ", artists) + "]" + " -- " + numSongs + " songs";
    }

    public int compareTo(T data) {
        return Integer.compare(numSongs, T.numSongs);
    }

    public Album getNext() {
        return null;
    }

    @Override
    public int compareTo(Album o) {
       
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
