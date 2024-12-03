import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String pathName = "outFile/";
        String nameFile = "enteredDataFile.txt";
        programAppendsFile(pathName, nameFile);
    }

       /*Необходимо написать программу, которая дописывает файл.
        Программа предлагает записать данные фразой "Вводите данные для записи".
        После того, как введены данные в консоль (необходимо использовать класс Scanner для ввода данных в консоль),
        программа предлагает дополнить информацию фразой «Введите что-нибудь еще» и данные можно дописать.
        Вся работа по заполнению файла ведется в бесконечном цикле.
        Если пользователь введет 0, программа завершается строкой «Файл создан».
        */

    public static void programAppendsFile(String pathName, String nameFile) throws IOException {

        Scanner console = new Scanner(System.in);
        System.out.println("Вводите данные для записи");
        String enteredData = console.nextLine();
        File path = new File(pathName);
        if (!path.exists()) path.mkdir();
        File file = new File(pathName, nameFile);
        FileWriter writer = new FileWriter(file, true);
        writer.write(enteredData);

        while (true) {
            System.out.println("Введите что-нибудь еще");
            writer.write(enteredData);
            enteredData = console.nextLine();
            if (enteredData.equals("0")) {
                System.out.println("Файл создан");
                writer.close();
                return;
            }
        }
    }
}
