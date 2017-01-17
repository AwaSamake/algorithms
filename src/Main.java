public class Main {

    public static void main(String[] args) {
        QS01Arrays test = new QS01Arrays();
        int[][] matrix = new int[][] {
                {1,2,3,4,0},
                {1,2,3,4,5},
                {1,2,3,4,5},
                {1,0,3,4,5},
                {1,2,3,4,5},
                {1,2,3,4,5},
                {1,2,3,4,5}
        };

        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        test.zeroMatrix(matrix);
        System.out.println();
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }


}

/**
 *
 *
 char[][] image = new char[][] {
 {'a','b','c','d','e'},
 {'f','g','h','i','j'},
 {'k','l','m','n','o'},
 {'p','q','r','s','t'},
 {'u','v','w','x','y'}};

 System.out.println();
 for (char[] line : image) {
 for (char pixel : line) {
 System.out.print(pixel + " ");
 }
 System.out.println();
 }

 char[][] newImage = test.rotate(image);
 System.out.println();

 for (char[] line : newImage) {
 for (char pixel : line) {
 System.out.print(pixel + " ");
 }
 System.out.println();
 }


 */
