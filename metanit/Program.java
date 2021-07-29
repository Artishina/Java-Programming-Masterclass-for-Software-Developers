package metanit;

import java.io.FileReader;
import java.io.IOException;

public class Program {

    public static void main(String[] args) {

        try (FileReader reader = new FileReader("C:/Users/artiv/Downloads/1.txt")) {
            // читаем посимвольно
            int c;
            while ((c = reader.read()) != -1) {

                System.out.print((char) c);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

}
