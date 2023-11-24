import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArtistTest {
    @Test
    public void testArtistId() {
        Artist artist = new Artist();
        assertTrue(artist.addArtist("578MMRRR_%", "06-11-1980", "Delhi|Victoria|Australia", "Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio", List.of("Singer", "Songwriter"),
                List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical")));
        Artist artist1 = new Artist();
        assertFalse(artist1.addArtist("378MMRRR_%", "06-11-1980", "Delhi|Victoria|Australia", "Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio", List.of("Singer", "Songwriter"),
                List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical"))
        );

    }

    @Test
    public void testArtistBirthDate() {
        Artist artist = new Artist();
        assertTrue(artist.addArtist("578MMRRR_%", "06-11-1980", "Delhi|Victoria|Australia", "Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio", List.of("Singer", "Songwriter"), List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical")));
        Artist artist1 = new Artist();
        assertFalse(artist1.addArtist("578MMRRR_%", "16th Jan, 2022", "Delhi|Victoria|Australia", "Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio", List.of("Singer", "Songwriter"), List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical"))
        );
    }

    @Test
    public void testArtistAddress() {
        Artist artist = new Artist();
        assertTrue(artist.addArtist("578MMRRR_%", "06-11-1980", "Delhi|Victoria|Australia", "Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio", List.of("Singer", "Songwriter"), List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical")));
        Artist artist1 = new Artist();
        assertFalse(artist1.addArtist("578MMRRR_%", "06-11-1980", "Delhi ", "Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio", List.of("Singer", "Songwriter"), List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical"))
        );
    }

    @Test
    public void testArtistBio() {
        Artist artist = new Artist();
        assertTrue(artist.addArtist("578MMRRR_%", "06-11-1980", "Delhi|Victoria|Australia", "Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio", List.of("Singer", "Songwriter"), List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical")));
        Artist artist1 = new Artist();
        assertFalse(artist1.addArtist("578MMRRR_%", "06-11-1980", "Delhi|Victoria|Australia ", "Bio ", List.of("Singer", "Songwriter"), List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical"))
        );
    }

    @Test
    public void testArtistOccupations() {
        Artist artist = new Artist();
        assertTrue(artist.addArtist("578MMRRR_%", "06-11-1980", "Delhi|Victoria|Australia", "Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio", List.of("Singer", "Songwriter"), List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical")));
        Artist artist1 = new Artist();
        assertFalse(artist1.addArtist("578MMRRR_%", "06-11-1980", "Delhi|Victoria|Australia ", "Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio ", List.of("Singer", "Songwriter", "Songwriter", "Songwriter", "Songwriter", "Songwriter"), List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical"))
        );
    }

    @Test
    public void testArtistAwards() {
        Artist artist = new Artist();
        assertTrue(artist.addArtist("578MMRRR_%", "06-11-1980", "Delhi|Victoria|Australia", "Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio", List.of("Singer", "Songwriter"), List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical")));
        Artist artist1 = new Artist();
        assertFalse(artist1.addArtist("578MMRRR_%", "06-11-1980", "Delhi|Victoria|Australia ", "Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio ", List.of("Singer", "Songwriter"), List.of("2022, Best Song Written  For Visual Media For Visual Media For Visual Media For Visual Media"), List.of("Pop", "Classical"))
        );
    }

    @Test
    public void testArtistMusicGenres() {
        Artist artist = new Artist();
        assertTrue(artist.addArtist("578MMRRR_%", "06-11-1980", "Delhi|Victoria|Australia", "Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio", List.of("Singer", "Songwriter"), List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical")));
        Artist artist1 = new Artist();
        assertFalse(artist1.addArtist("578MMRRR_%", "06-11-1980", "Delhi|Victoria|Australia ", "Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio Bio ", List.of("Singer", "Songwriter"), List.of("2022, Best Song Written For Visual Media"), List.of("Pop", "Classical", "Classical", "Classical", "Classical", "Classical", "Classical", "Classical"))
        );
    }
}
