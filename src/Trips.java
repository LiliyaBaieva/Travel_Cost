import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trips {
  public final static char SEP = '/';

  //TODO  подменю чтоб посмотреть поездки
  public static void lookTrip(){

    //     - Вывести все поездки {номер, название стоимость общая, и за одного человека}
    //    - Посмотреть одну поездку:
    //        Вывести список поездок на экран
    //    и выбрать, которая интересует
    //    - в главное меню
  }

  // TODO
  public static void editTrip(){
    //  1. Какую трип хотим отредактировать
    //  2. Какую строчку из списка (листа)
    //  3. изменить / удалить (изменить можем только деньги)
    //  4. через свитч-кейс вызывает соответсвующую статье расходов функцию
  }

  //TODO удаление записи
  public static void deleteTrip(){
  }

  //TODO здесь будем сравнивать поездки
  public static void compareTrip(){
    // 1. выводить на экран printAllTrip()
    // 2. спрашивать какие поездки мы хотим сравнить и по какому показателю или всю
    //     список статей расходов с номерами
    // printComparableTrip(trip1, trip2, parameter)
  }

  // TODO
  private static void printAllTrips(){}

  // TODO
  private static void printTrip(){}

  private static Map<String, List> parseALLTrip() throws IOException {
    File tripsFile = new File("res/Trips.txt");
    if (!tripsFile.exists()) {
      System.out.println("Файл не найден. Или Вы не создали ещё не одной поездки.");
      GoTravel.runMenu();
    }

    BufferedReader br = new BufferedReader(new FileReader("res/Trips.txt"));
    Map<String, List> allTrips = new HashMap<>();
    for(String line = br.readLine(); line != null; line = br.readLine()){
      int firstSep = line.indexOf(SEP);
      String nameOfTrip = line.substring(0, firstSep);
      String lineForList = line.substring(firstSep + 1);
      List<Expense> expenses = parseTripList(lineForList);

       allTrips.put(nameOfTrip, expenses);
    }
    return allTrips;
  }

  private static List<Expense>  parseTripList(String lineForList){
    List<Expense> expenses = new ArrayList<>();

    for(int i = 0; lineForList.length() > 0; ++i){
      int lastSep = lineForList.indexOf(SEP); // находим разделитель
      String lineForeExp = lineForList.substring(0, lastSep); //вырезаем кусок, кот отправим на конструктор
      Expense expense = parseExpenses(lineForeExp);  // преобразуем кусок строки в констуктор
      expenses.add(expense); // добавляем конструктор
      lineForList = lineForList.substring(lastSep + 1); // вырезаем обработаный кусок сначала строки
    }

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

