package eban;

import java.io.*;
import java.util.*;

/**
 * 1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
 *
 * 2.   Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.
 *
 * 4.   Занести стихотворение в список. Провести сортировку по возрастанию длин строк.
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        // ************* №1 ************* //
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("C://Users//alexg//IdeaProjects//collection-optional-task-1-2-4//src//main//txtFile//lines.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> strings = new ArrayList<>();
        String line = bufferedReader != null ? bufferedReader.readLine() : null;

        while (line != null){
            strings.add(line);
            line = bufferedReader.readLine();
        }

        Objects.requireNonNull(bufferedReader).close();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C://Users//alexg//IdeaProjects//collection-optional-task-1-2-4//src//main//txtFile//reversLines.txt"));

        for (int i = strings.size() - 1; i >= 0; i--) {
            bufferedWriter.write(strings.get(i));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        // ************* №2 ************* //

        System.out.print("Enter number: ");
        BufferedReader readerNumber = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(readerNumber.readLine());
        readerNumber.close();
        System.out.print("\n");

        Stack<Integer> numberInStack = new Stack<>();
        while(number % 10 != 0){
            numberInStack.push(number % 10);
            number /= 10;
        }

        int reverseNumber = 0;
        for (int numeral: numberInStack)
            reverseNumber = reverseNumber*10 + numeral;

        System.out.println("reverse number: " + reverseNumber);

        // ************* №3 ************* //

        BufferedReader readerPoem = null;
        try {
            readerPoem = new BufferedReader(new FileReader("C://Users//alexg//IdeaProjects//collection-optional-task-1-2-4//src//main//txtFile//poem.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> poem = new ArrayList<>();
        String linePoem = readerPoem != null ? readerPoem.readLine() : null;

        while(linePoem != null) {
            poem.add(linePoem); linePoem = readerPoem.readLine();
        }

        Objects.requireNonNull(readerPoem).close();

        poem.sort(Collections.reverseOrder((lht,rht)->lht.length()-rht.length()));

        BufferedWriter writerPoem = new BufferedWriter(new FileWriter("C://Users//alexg//IdeaProjects//collection-optional-task-1-2-4//src//main//txtFile//sortPoemByLengthLine.txt"));

        for (String string : poem) {
            writerPoem.write(string);
            writerPoem.newLine();
        }

        writerPoem.close();
    }
}
