import org.code.theater.*;
import org.code.media.*;

/**
 * Represents a Scene to be played in the Theater using data from
 * a chosen dataset
 */
public class DataScene extends Scene {

  // empty lists for title, year, runtime, genre
  private String[] titles;
   private int[] years;
    private int[] runtimes;
    private String[] genres;
    // two new 1D arrays of data
    private double[] squareRoots;
    private int[] moviesData;
  
/*
   * Returns a 1D array of Movie objects using the data from the specified text files
   */
  
public DataScene(String titleFile, String yearFile, String runtimeFile, String genreFile) {
    // four 1D arrays created from the txt files
    titles = FileReader.toStringArray(titleFile);
    years = FileReader.toIntArray(yearFile);
    runtimes = FileReader.toIntArray(runtimeFile);
    genres = FileReader.toStringArray(genreFile);
    // two new 1D arrays of data
    squareRoots = new double[titles.length];
    moviesData = new int[titles.length];

    
  }

  /*
   * Returns a 1D array containing the number of each genre movie that was in the top 100 on IMDB for a specified year
   */
  public int[] countGenreByYear(int year) {
  int[] counts = new int[4];
  for (int i = 0; i < titles.length; i++){
    if (years[i]==year) {
            String genreName = genres[i];
            if (genreName.equalsIgnoreCase("Drama")) {
                counts[0]++;
                
            } else if (genreName.equalsIgnoreCase("Crime")) {
                counts[1]++;
               
            } else if (genreName.equalsIgnoreCase("Comedy")) {
                counts[2]++;
                
            } else {
                counts[3]++;
            }
        }
    }
  return counts;
}
  
/*
* counts the total number of times a specified genre appears in the genre txt file and returns a 1D array containing that number
*/
   public int[] countGenreTotal(String genres) {
  int[] count = new int[1];
  for (int i = 0; i < titles.length; i++){
    if (titles[i].equals(genres)) {
            count[0]++;
        }
    }
  return count;
}
  /*
  * finds the movie with the longest runtime
  */
  
  public void longestRuntime(){
  drawText("The movie with the longest runtime is:", 50, 100);
  playSound("dun-dun-dun.wav");
  pause(3.5);
  for(int i = 0; i< titles.length; i++){
boolean isOnceUponaTimeinAmerica = false;
 if (Math.abs(runtimes[i]) < runtimes[5]) {
            isOnceUponaTimeinAmerica = false;
        } else if (Math.abs(runtimes[i]) > runtimes[5]) {
            isOnceUponaTimeinAmerica = false;
        } else {
            isOnceUponaTimeinAmerica = true;
        }
 
      drawText("Once Upon a Time in America", 136, 185);
  }

  pause(3.5);
    clear("white");
}

/*
   * Draws the results of countGenreByYear in the scene
   */
  public void drawGenreByYear(int year, int[] results) {
    String[] colors = {"red", "orange", "yellow", "green", "blue"};
    playSound("Kids-Cheering---Sound-Effect-(HD).wav");
    drawText("Common genres of the best movies in " + year, 13, 40);
    drawText("Drama", 70, 107);
    drawText("Crime", 70, 145);
    drawText("Comedy", 70, 185);
    drawText("Other", 70, 230);
    
    int yLocation = 90;
    
    for (int index = 0; index < results.length; index++) {
      int randomIndex = (int)(Math.random() * colors.length);
      setFillColor(colors[randomIndex]);
      
      drawRectangle(0, yLocation, results[index] * 20, 25);
      pause(0.2);
      yLocation += 40;
      
    }
    pause(7.0);
    clear("white");
  }

  /*
  * Draws the results of countGenreTotal in the scene
  */
  public void drawGenreTotal(int[] genreDataTotal, String genres) {
    String[] colors = {"red", "orange", "yellow", "green", "blue"};
    playSound("dun-dun-dun.wav");
    drawText("Number of " + genres + " movies in the top 100 IMBD movies", 11, 40);
    int yLocation = 90;
    
    // length of the line indicates the number of movies in that genre
    for (int index = 0; index < genreDataTotal.length; index++) {
      int randomIndex = (int)(Math.random() * colors.length);
      setFillColor(colors[randomIndex]);
      
      drawEllipse(100, yLocation, genreDataTotal[index] * 100, 100);
      pause(0.2);
      yLocation += 40; 
    }
    pause(6.0);
    clear("white");
  }
}