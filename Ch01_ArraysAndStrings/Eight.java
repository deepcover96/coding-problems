import java.util.*;

class Eight {
	public static void main(String[] args) {
    int[][] matrix;
    int n = 1;
    int m = 1;

    matrix = createMatrix(n, m);
    matrix[0][0] = 0;
    printMatrix(matrix, n, m);
    zero(matrix, n, m);

    n = 5;
    m = 9;
    matrix = createMatrix(n, m);
    matrix[3][2] = 0;
    matrix[2][7] = 0;
    printMatrix(matrix, n, m);
    zero(matrix, n, m);

    n = 9;
    m = 9;
    matrix = createMatrix(n, m);
    matrix[3][2] = 0;
    matrix[8][7] = 0;
    printMatrix(matrix, n, m);
    zero(matrix, n, m);

	}

	// Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0,
  // the entire row and column is set to 0.
  public static boolean zero(int[][] matrix, int n, int m) {

    // first check all cells for 0
    // record zeros for the columns at the top header
    // record zeros for the rows on the left
    for (int j = 0; j < m; j++) {
      for (int i = 0; i < n; i++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    //go through all the columns and zeroize the ones with zero at the header
    for (int i = 0; i < n; i++) {
      if (matrix[i][0] == 0) {
        for (int j = 0; j < m; j++) {
          matrix[i][j] = 0;
        }
      }
    }

    //go through all the rows and zeroize the ones with zero
    for (int j = 0; j < m; j++) {
      if (matrix[0][j] == 0) {
        for (int i = 0; i < n; i++) {
          matrix[i][j] = 0;
        }
      }
    }

    // print results
    printMatrix(matrix, n, m);
    return true;
  }

  private static void printMatrix(int[][] matrix, int n, int m) {

    for (int j = 0; j < m; j++) {
      for (int i = 0; i < n; i++) {
        System.out.print(matrix[i][j]);
      }
      System.out.println();
    }
    System.out.println();
  }

  public static int[][] createMatrix(int n, int m) {
    System.out.println("============> Size: " + n + "x" + m);
    // create matrix
    int[][] matrix = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        matrix[i][j] = i + 1;
      }
    }

    printMatrix(matrix, n, m);

    return matrix;
  }

}
