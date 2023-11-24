import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Artist {
    private String artistId;
    private String birthDate;
    private String address;
    private String bio;
    private List<String> occupations;
    private List<String> awards;
    private List<String> musicGenres;

    public Artist() {
        this.occupations = new ArrayList<>();
        this.awards = new ArrayList<>();
        this.musicGenres = new ArrayList<>();
    }

    public boolean addArtist(String artistId, String birthDate, String address, String bio,
                             List<String> occupations, List<String> awards, List<String> musicGenres) {
        // Condition 1: Check Artist ID format
        if (!isValidArtistId(artistId)) {
            return false;
        }

        // Condition 2: Check Birth Date format
        if (!isValidBirthDate(birthDate)) {
            return false;
        }

        // Condition 3: Check Address format
        if (!isValidAddress(address)) {
            return false;
        }

        // Condition 4: Check Bio length
        if (!isValidBioLength(bio)) {
            return false;
        }

        // Condition 5: Check Occupations count
        if (!isValidOccupationsCount(occupations)) {
            return false;
        }

        // Condition 6: Check Awards format and count
        if (!isValidAwards(awards)) {
            return false;
        }

        // Condition 7: Check Music Genres count and conflict
        if (!isValidMusicGenres(musicGenres)) {
            return false;
        }

        // If all conditions are met, add the artist information to the TXT file (or perform any desired action)
        writeToFile(artistId, birthDate, address, bio, occupations, awards, musicGenres);

        return true;
    }


    private boolean isValidArtistId(String id) {
        if (id.length() != 10) {
            return false;
        }

        // Check the first three characters are numbers between 5 to 9
        for (int i = 0; i < 3; i++) {
            char digit = id.charAt(i);
            if (digit < '5' || digit > '9') {
                return false;
            }
        }

        // Check characters 4th to 8th are upper case letters (A - Z)
        for (int i = 3; i < 8; i++) {
            char letter = id.charAt(i);
            if (letter < 'A' || letter > 'Z') {
                return false;
            }
        }

        // Check the last two characters are special characters
        char secondToLastChar = id.charAt(8);
        char lastChar = id.charAt(9);
        if (!isSpecialCharacter(secondToLastChar) || !isSpecialCharacter(lastChar)) {
            return false;
        }

        // All conditions are satisfied
        return true;
    }

    private static boolean isSpecialCharacter(char c) {
        // Define the set of special characters
        String specialCharacters = "!@#$%^&*()_-+=<>?";

        // Check if the character is in the set of special characters
        return specialCharacters.contains(String.valueOf(c));
    }

    private boolean isValidBirthDate(String birthDate) {
        String pattern = "^\\d{2}-\\d{2}-\\d{4}$";
        return birthDate.matches(pattern);
    }

    private boolean isValidAddress(String address) {
        String pattern = "^[^|]+\\|[^|]+\\|[^|]+$";
        return address.matches(pattern);
    }

    private boolean isValidBioLength(String bio) {
        int wordCount = bio.split("\\s+").length;
        return wordCount >= 10 && wordCount <= 30;
    }

    private boolean isValidOccupationsCount(List<String> occupations) {
        return !occupations.isEmpty() && occupations.size() <= 5;
    }

    public static boolean isValidAwards(List<String> s) {
        for (String str : s) {
            // Split the string into components using comma and space
            String[] components = str.split(", ");

            // Check if there are exactly two components
            if (components.length != 2) {
                return false;
            }

            // Check if the first component is a 4-digit year
            if (!isValidYear(components[0])) {
                return false;
            }

            // Check if the second component (title) has 4 to 10 words
            if (!isValidTitle(components[1])) {
                return false;
            }
        }

        // All strings in the list match the required format
        return true;
    }

    // Helper method to check if a string is a valid 4-digit year
    private static boolean isValidYear(String year) {
        return year.matches("^\\d{4}$");
    }

    // Helper method to check if a string (title) has 4 to 10 words
    private static boolean isValidTitle(String title) {
        int wordCount = title.split("\\s+").length;
        return wordCount >= 4 && wordCount <= 10;
    }


    private boolean isValidMusicGenres(List<String> musicGenres) {
        if (musicGenres.size() < 2 || musicGenres.size() > 5) {
            return false;
        }

        int popCount = 0;
        int rockCount = 0;

        for (String genre : musicGenres) {
            if (genre.equalsIgnoreCase("pop")) {
                popCount++;
            } else if (genre.equalsIgnoreCase("rock")) {
                rockCount++;
            }
        }

        return popCount <= 1 && rockCount <= 1;
    }

    private void writeToFile(String artistId, String birthDate, String address, String bio,
                             List<String> occupations, List<String> awards, List<String> musicGenres) {
        // Implement writing to the TXT file or perform any desired action
        // Example: Write the artist information to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("artists.txt", true))) {
            writer.write("Artist ID: " + artistId + "\n");
            writer.write("Birth Date: " + birthDate + "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Bio: " + bio + "\n");

            writer.write("Occupations: ");
            for (String occupation : occupations) {
                writer.write(occupation + ", ");
            }
            writer.write("\n");

            writer.write("Awards: ");
            for (String award : awards) {
                writer.write(award + ", ");
            }
            writer.write("\n");

            writer.write("Music Genres: ");
            for (String genre : musicGenres) {
                writer.write(genre + ", ");
            }
            writer.write("\n");

            writer.write("\n");  // Add a separator for each artist
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean updateArtist(String newArtistId, String newBirthDate, String newAddress, String newBio,
                                List<String> newOccupations, List<String> newAwards, List<String> newMusicGenres) {
        // Condition 1: Check all constraints for updating an artist
        if (!addArtist(newArtistId, newBirthDate, newAddress, newBio, newOccupations, newAwards, newMusicGenres)) {
            return false;
        }

        // Condition 2: If an artist was born before 2000, their occupation cannot be changed.
        int birthYear = Integer.parseInt(newBirthDate.split("-")[2]);
        if (birthYear < 2000 && !newOccupations.equals(this.occupations)) {
            return false;
        }

        // Condition 3: Awards that were given before 2000 cannot be changed.
        for (String newAward : newAwards) {
            int awardYear = Integer.parseInt(newAward.split(",")[0].trim());
            if (awardYear < 2000 && !awards.contains(newAward)) {
                return false;
            }
        }

        // If all conditions are met, update the artist information in the TXT file (or perform any desired action)
        writeToFile(newArtistId, newBirthDate, newAddress, newBio, newOccupations, newAwards, newMusicGenres);

        return true;
    }
}
