package hw3.reader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Написать текстовый ридер с плавным движением текста вниз. Текст читается из файла. Стоп от ентер.
 * public void read()
 */
public class TextReader {
    private static final int stringOnTheSheet = 20;
    private String nameFile;
    private int CurrentPage;
    private int pageCount;
    private ArrayList<String> listText;

    public TextReader(String nameFile) {
        this.nameFile = nameFile;
        this.CurrentPage = 0;
        this.pageCount = 0;
        this.listText = new ArrayList<String>();
    }

    private void readFile() throws Exception {

        FileReader fr = new FileReader(nameFile);
        Scanner scan = new Scanner(fr);

        while (scan.hasNextLine())
            listText.add(scan.nextLine());

        scan.close();
        fr.close();

        pageCount = listText.size() / stringOnTheSheet + 1;

    }

    private void printPage(int nextPage) {
        int tempPage = CurrentPage + nextPage;
        if ((tempPage > 0) && (tempPage <= pageCount)) {

            int start = stringOnTheSheet * tempPage - stringOnTheSheet;
            int finish = Math.min(stringOnTheSheet * tempPage, listText.size());

            for (int i = start; i < finish; i++)
                System.out.println(listText.get(i));

            CurrentPage = tempPage;

            System.out.println("***************Страница " + CurrentPage + " из " + pageCount + "***************");
        }
    }

    public void viewFile() throws Exception {

        if (listText.isEmpty())
            readFile();

        boolean nextStep = true; // Условие выхода из цикла
        Scanner in = new Scanner(System.in); // Объявление потока ввода
        do {
            // Ввод операции
            System.out.println("Выберите операцию:");
            if (CurrentPage != pageCount)
                System.out.print("enter - следующая страница\t");
            System.out.print("b - предыдущая страница\t");
            System.out.print("q - выход\t");
            System.out.println();
            String operation = in.nextLine();

            // Обработка операции

            if (operation.equals("b"))
                printPage(-1);
            else if (operation.equals("q"))
                nextStep = false;
            else
                printPage(1);
        } while (nextStep);
        in.close();
    }


    public static void main(String[] args)  throws Exception  {

        TextReader text1 = new TextReader("pom.xml");

        text1.viewFile();

    }

}
