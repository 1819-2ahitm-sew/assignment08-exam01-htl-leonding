package at.htl.exam01.compress;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class StringCompress {

    private static final String FILE_NAME = "sample.txt";

    /**
     * Main-Methode, hier wird das StringCompress-Objekt erstellt
     * und die Methoden des Objekts werden aufgerufen
     *
     * @param args
     */
    public static void main(String[] args) {
        StringCompress sc = new StringCompress();
        String[] text = sc.readFromFile(FILE_NAME);
        sc.print(text);
    }


    /**
     * Sämtliche Zeilen werden aus der Textdatei eingelesen
     * zB 5A
     * Nun wird in das String-Array AAAAA geschrieben
     * <p>
     * Bsp Testdatei
     * 5A
     * 3B
     * 4C
     * <p>
     * ergibt eine String-Array mit 3 Elementen
     * AAAAA
     * BBB
     * CCCC
     *
     * @param fileName
     * @return String-Array mit dem entpacktem Text
     */
    public String[] readFromFile(String fileName) {

        String[] lines = new String[getNoOfLines(fileName)];
        int lineNo = 0;

        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            int numberInt = 0;
            String numberStr = "";
            // Hole eine Zeile
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                char letter = line.charAt(0);
                // Parse die Zahl aus der Zeile
                for (int i = 1; i < line.length(); i++) {
                    numberStr += line.charAt(i);
                    numberInt = Integer.parseInt(numberStr);
                }
                numberStr = "";
                // Schreibe die Zahl in einen String
                String newLine = "";
                for (int i = 0; i < numberInt; i++) {
                    newLine = newLine + letter;
                }
                lines[lineNo] = newLine;
                lineNo++;
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }

        return lines;
    }


    /**
     * Der Inhalt des String-Arrays wird zeilenweise auf der Console ausgegeben
     *
     * @param lines String-Array
     */
    public void print(String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
    }

    /**
     * Die Anzahl der Zeilen der übergebenen Textdatei wird bestimmt
     *
     * @param fileName
     * @return Anzahl der Zeilen in der Textdatei
     */
    public int getNoOfLines(String fileName) {

        int counter = 0;
        try (Scanner scanner = new Scanner(new FileReader(fileName))) {

            while (scanner.hasNextLine()) {
                scanner.nextLine();
                counter++;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return counter;
    }
}
