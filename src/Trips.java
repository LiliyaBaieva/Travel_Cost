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

  private static List<Map> parseALLTrip() throws IOException {
    File tripsFile = new File("res/Trips.txt");
    if (!tripsFile.exists()) {
      System.out.println("Файл не найден. Или Вы не создали ещё не одной поездки.");
      GoTravel.runMenu();
    }

    BufferedReader br = new BufferedReader(new FileReader("res/Trips.txt"));
    List<Map> allTrips = new ArrayList<>();
    for(String line = br.readLine(); line != null; line = br.readLine()){
      Map<String, List> trip = parseTrip(line);
      allTrips.add(trip);
    }
    return allTrips;
  }

  private static Map<String, List>  parseTrip(String line){
    Map<String, List> oneTrip = new HashMap<>();
    List<Expense> expenses = new ArrayList<>();

    int lastSep = line.indexOf(SEP);
    String nameOfTrip = line.substring(0, lastSep);
    line = line.substring(lastSep + 1);

    for(lastSep = line.indexOf(SEP); lastSep < line.length(); ++lastSep){
      Expense expense = parseExpenses();
      expenses.add(expense);
    }

    oneTrip.put(nameOfTrip, expenses);

    return oneTrip;
  }

  private static Expense  parseExpenses(){

    return null;
  }

}

