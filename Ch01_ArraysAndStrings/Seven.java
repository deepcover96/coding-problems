import java.util.*;

class Seven {
	public static void main(String[] args) {
    int[][] matrix;

    matrix = createMatrix(1);
    rotate(matrix);
    matrix = createMatrix(2);
    rotate(matrix);
    matrix = createMatrix(3);
    rotate(matrix);
    matrix = createMatrix(4);
    rotate(matrix);
    matrix = createMatrix(5);
    rotate(matrix);
    matrix = createMatrix(6);
    rotate(matrix);
    matrix = createMatrix(7);
    rotate(matrix);
    matrix = createMatrix(8);
    rotate(matrix);
    matrix = createMatrix(9);
    rotate(matrix);
    matrix = createMatrix(10);
    rotate(matrix);
	}

	// Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the
  // image is 4 bytes, write a method to rotate the image by 90 degrees.  Can you do this
  // in place?
  public static boolean rotate(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length != matrix.length) return false;

    int begin = 0;
    int end = matrix[0].length - 1;
    int i = 0;
    int temp = 0;

    while (begin < end) {
      for (int x = begin; x < end; x++) {

        // save top
        temp = matrix[x][begin];

        // left -> top
        matrix[x][begin] = matrix[begin][end - i];

        // bottom -> left
        matrix[begin][end - i] = matrix[end - i][end];

        // right -> bottom
        matrix[end - i][end] = matrix[end][begin + i];

        // top -> right
        matrix[end][begin + i] = temp;
        i += 1;
      }

      begin += 1; // start index increment
      end -= 1;   // end index increment
      i = 0;
    }

    // print results
    printMatrix(matrix);
    return true;
  }

  private static void printMatrix(int[][] matrix) {
    int n = matrix[0].length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[i][j]);
      }
      System.out.println();
    }
    System.out.println();
  }

  public static int[][] createMatrix(int size) {
    System.out.println("============> Size: " + size);
    // create matrix
    int[][] matrix = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        matrix[i][j] = i;
        System.out.print(i);
      }
      System.out.println();
    }
    System.out.println();

    return matrix;
  }

}
