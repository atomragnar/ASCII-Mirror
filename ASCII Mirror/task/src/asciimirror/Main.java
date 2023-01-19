package asciimirror;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String inFilePath = readFilePath();

        File file = new File(inFilePath);

        if (file.exists()) {
            List<String> animal = FileUtils.readFile(inFilePath);
            if (animal != null) {
                FileUtils.printList(animal);
            }
        } else {
            System.out.println("File not found!");
        }


    }

    public static String readFilePath() {
        System.out.println("Input the file path:");
        return scanner.nextLine();
    }


}

/*



char[][] asciiForm = new char[][] {
                // 1    2    3    4    5    6    7    8    9    10   11   12   13   14   15   16   17   18   19   20   21   22   23  24   25   26   27  28
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '_', '_', '_', '_', '_', '_', '_', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '<', '.', 'h', 'e', 'l', 'l', 'o', '.', '>'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '-', '-', '-', '-', '-', '-', '-', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '^', '_', '_', '^', '.', '.', '.', '/', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '_', '_', '_', '_', '_', '_', '_', '/', '(', 'o', 'o', ')', '.', '.', '/', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'/', '\\', '/', '(', '.', '.', '.', '.', '.', '.', '.', '/', '(', '_', '_', ')', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '|', '.', 'w', '-', '-', '-', '-', '|', '|', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '|', '|', '.', '.', '.', '.', '.', '|', '|', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };

char[][] answeringAsciiForm = new char[][] {
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '^', '_', '_', '^'},
                {'.', '.', '.', '.', '_', '_', '_', '_', '_', '_', '_', '/', '(', 'o', 'o', ')'},
                {'/', '\\', '/', '(', '.', '.', '.', '.', '.', '.', '.', '/', '(', '_', '_', ')'},
                {'.', '.', '.', '|', '.', 'w', '-', '-', '-', '-', '|', '|', '.', '.', '.', '.'},
                {'.', '.', '.', '|', '|', '.', '.', '.', '.', '.', '|', '|', '.', '.', '.', '.'}
        };


System.out.println("This is not a file path. Moo :)");
        int rows = this.asciiForm.length;
        int cols = this.asciiForm[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (this.asciiForm[i][j] == '.') {
                    System.out.print(" ");
                } else {
                    System.out.print(this.asciiForm[i][j]);
                }
            }
            if (i != rows - 1) {
                System.out.println();
            }
        }

 System.out.println(input);
        int rows = this.asciiForm.length;
        int cols = this.asciiForm[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (this.asciiForm[i][j] == '.') {
                    System.out.print(" ");
                } else {
                    System.out.print(this.asciiForm[i][j]);
                }
            }
            if (i != rows - 1) {
                System.out.println();
            }
        }



*/