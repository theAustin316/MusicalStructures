package com.example.vivek.musicalstructures;

// {@link Music} represents the songs which user wants to listen.
// It contains resource IDs for the musicName, albumName, artistName
public class Music {

    // String resource ID for the musicName
    private int musicName = NO_TEXT_PROVIDED;

    // Image resource Id for albumImage
    private int albumImage;

    // String resource ID for the artistName
    private int artistName;

    // Constant value that represents no string was provided for this music
    private static final int NO_TEXT_PROVIDED = -1;

    //Create a new Music object.

    // @param Music is the string resource ID for the song
    // @param Artist is the string resource Id for the artist of the song
    // @param Image is the resource ID for the albumArt file associated with this song

    public Music(int Music, int Artist, int Image) {
        musicName = Music;
        artistName = Artist;
        albumImage = Image;
    }

    // @param Artist is the string resource Id for the artist of the song
    // @param Image is the resource ID for the albumArt file associated with this song
    public Music(int Artist, int Image) {
        artistName = Artist;
        albumImage = Image;
    }

    // get String Resource ID for musicName
    public int getMusicName() {
        return musicName;
    }

    // get String resource ID for artistName
    public int getArtistName() {
        return artistName;
    }

    // get Image resource ID for albumImage
    public int getAlbumImage() {
        return albumImage;
    }

    // returns whether there is a song name associated in listView
    public boolean hasSongName() {
        return musicName != NO_TEXT_PROVIDED;
    }
}