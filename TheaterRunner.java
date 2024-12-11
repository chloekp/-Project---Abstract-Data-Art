
// Landon Lee and Chloe Pun

import org.code.theater.*;

public class TheaterRunner {
  public static void main(String[] args) {

   // Instantiates a DataScene object using data from text files to play in the Theater
    DataScene scene = new DataScene("title.txt", "year.txt", "runtime.txt", "genre.txt");

    // Draws the different images using new 1D arrays
    int[] results = scene.countGenreByYear(2009);
    scene.drawGenreByYear(2009, results);
    
    int[] genreDataTotal = scene.countGenreTotal("Comedy");
    scene.drawGenreTotal(genreDataTotal, "Comedy");

    scene.longestRuntime();

    // Play the DataScene in the theater
    Theater.playScenes(scene);

    
    
  }
}