/**
 * Represents a movie's title, release year, runtime, and genre
 */
public class Movie {

  /** instance variables */
  private String title; // movie title
  private int year; //  release years
  private int runtime; //  runtimes
  private String genre; //  movie genres

  /** Constructor */
  public Movie(String title, int year, int runtime, String genre) {
    this.title = title;
    this.year = year;
    this.runtime = runtime;
    this.genre = genre;
    
  }

  /** Accessor Method for year */
  public String getTitle() {
    return title;
  }
  
  /** Accessor Method for year */
  public int getYear() {
    return year;
  }
  
  /** Accessor Method for runtime */
  public int getRuntime() {
    return runtime;
  }

   /** Accessor Method for genre */
  public String getGenre() {
    return genre;
  }
  
  /** toString Method override */
  public String toString() {
    return title + " - \n" + "Release year: " + year + "\n Runtime: " + runtime + " minutes \n" + "Genre: " + genre;
  }

  /*
   * Returns a 1D array of Movie objects using the data from the specified text files
   */
  public static Movie[] createMovies(String titleFile, String yearFile, String runtimeFile, String genreFile) {
    // four 1D arrays created from the txt files
    String[] titleData = FileReader.toStringArray(titleFile);
    int[] yearData = FileReader.toIntArray(yearFile);
    int[] runtimeData = FileReader.toIntArray(runtimeFile);
    String[] genreData = FileReader.toStringArray(genreFile);
    // two new 1D arrays of data
    double[] squareRoots = new double[titleData.length];
    Movie[] moviesData = new Movie[titleData.length];

    for (int index = 0; index < moviesData.length; index++) {
      moviesData[index] = new Movie(titleData[index], yearData[index], runtimeData[index], genreData[index]);
    }

    return moviesData;
  }
  
}