package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Cons
public class WaterFalls {
    static String input[] = {
            "| a b c d e |",
            "| = === =   |",
            "|         ==|",
            "|   =       |"
    };

    public static void solution(String[] input) {
        char[][] arr = new char[input.length][input[0].length()];
        List<int[]> waters = new ArrayList<>();
        int rowIdx = 0;
        int colIdx = 0;
        for (int i = 0; i < input.length; i++) {
            String s = input[i];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c >= 'a' && c <= 'z') {
                    waters.add(new int[]{rowIdx, colIdx});
                }
                arr[rowIdx][colIdx++] = c;
            }
            colIdx = 0;
            rowIdx++;
        }

        int rowLen = arr.length;
        int colLen = arr[0].length;
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            for (int[] water : waters) {
                int randomVal = random.nextInt(1);
                int row = water[0];
                int col = water[1];
                char curr = arr[row][col];
                //check below
                if (row + 1 < rowLen && arr[row + 1][col] == ' ') {
                    arr[row][col] = ' ';
                    arr[row + 1][col] = curr;
                    water[0] = row + 1;
                    water[1] = col;
                } else {
                    boolean left = true, right = true;
                    if (col == 0 || arr[row][col - 1] != ' ')
                        left = false;
                    if (col == colLen - 1 || arr[row][col + 1] != ' ')
                        right = false;

                    if (randomVal == 1) {
                        if (right) {
                            arr[row][col] = ' ';
                            arr[row][col + 1] = curr;
                            water[0] = row;
                            water[1] = col + 1;
                        } else if (left) {
                            arr[row][col] = ' ';
                            arr[row][col - 1] = curr;
                            water[0] = row;
                            water[1] = col - 1;
                        }
                    } else {
                        if (left) {
                            arr[row][col] = ' ';
                            arr[row][col - 1] = curr;
                            water[0] = row;
                            water[1] = col - 1;
                        } else if (right) {
                            arr[row][col] = ' ';
                            arr[row][col + 1] = curr;
                            water[0] = row;
                            water[1] = col + 1;
                        }
                    }

                }
            }

            for (int a = 0; a < rowLen; a++) {
                for (int b = 0; b < colLen; b++) {
                    System.out.print(arr[a][b]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solution(input);
    }
}
