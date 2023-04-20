import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Trip {
  public final static char SEP = '/';

  // TODO
  public static void editTrip(){
    //  1. Какую трип хотим отредактировать
    //  2. Какую строчку из списка (листа)
    //  3. изменить / удалить (изменить можем только деньги)
    //  4. через свитч-кейс вызывает соответсвующую статье расходов функцию
  }

  // TODO
  public static void printTrip() throws IOException {
    String name = getTripName();
    for (int i = 0; i < name.length()+4; ++i){
      System.out.print("*");
    }
    System.out.println("\n| " + name + " |");
    for (int i = 0; i < name.length()+4; ++i){
      System.out.print("*");
    }
    System.out.println();

    List<Expense> tripList = parseTripList();
    for( int i = 0; i < tripList.size(); ++i){
      Expense expense = tripList.get(i);
      if(i == tripList.size() - 1){
        System.out.println("=============================================================");
        System.out.println(expense);
      } else {
        System.out.println("_____________________________________________________________");
        System.out.printf("[ %d ] %s \n", i,  expense);
      }
    }

    System.out.println();

    GoTravel.runMenu();
  }

  // TODO читаем имя поездки
  private static String getTripName() throws IOException{
    File tripsFile = new File("res/Trips.txt");
    if (!tripsFile.exists()) {
      System.out.println("Файл не найден. Или Вы не создали ещё не одной поездки.");
      GoTravel.runMenu();
    }
    BufferedReader br = new BufferedReader(new FileReader("res/Trips.txt"));

    String line = br.readLine();
    int sep = line.indexOf(SEP);
    String name = line.substring(0, sep);
    return name;
  }

  public static List<Expense> parseTripList() throws IOException {
    File tripsFile = new File("res/Trips.txt");
    if (!tripsFile.exists()) {
      System.out.println("Файл не найден. Или Вы не создали ещё не одной поездки.");
      GoTravel.runMenu();
    }
    BufferedReader br = new BufferedReader(new FileReader("res/Trips.txt"));

    String line = br.readLine();
      // обрезаем строку минус имя
    String lineForList = line.substring(getTripName().length() + 1);
    List<Expense> expenses = new ArrayList<>();
    while (lineForList.length() != 0){
      int lastSep = lineForList.indexOf(SEP); // находим разделитель
      String lineForeExp = lineForList.substring(0, lastSep); //вырезаем кусок, кот отправим на конструктор
      Expense expense = parseExpenses(lineForeExp);  // преобразуем кусок строки в констуктор
      expenses.add(expense); // добавляем конструктор
      lineForList = lineForList.substring(lastSep + 1); // вырезаем обработаный кусок сначала строки
    }
    br.close();
    return expenses;
  }

  // кусок строки преобразуем в конструктор
  private static Expense  parseExpenses(String lineForeExp){
    char sep = ';';
    int firstSep = lineForeExp.indexOf(sep);
    int secondSep = lineForeExp.indexOf(sep, firstSep + 1);

    String name = lineForeExp.substring(0, firstSep);
    double cost = Double.parseDouble(lineForeExp.substring(firstSep + 1, secondSep));
    String currency = lineForeExp.substring(secondSep + 1);
    Expense expense = new Expense(name, cost, currency);
    return expense;
  }

}

