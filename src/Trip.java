import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Trip {
  public final static char SEP = '/';

  public static void printTrip() throws IOException {
    String name = getTripName();
    int numberOfPeople = getNumberOfPeople();
    for (int i = 0; i < name.length()+6; ++i){
      System.out.print("=");
    }
    System.out.println("\n|| " + name.toUpperCase() + " ||");
    for (int i = 0; i < name.length()+6; ++i){
      System.out.print("=");
    }
    System.out.println();

    List<Expense> tripList = parseTripList();
    for( int i = 0; i < tripList.size(); ++i){
      Expense expense = tripList.get(i);
      if(i == tripList.size() - 1){
        System.out.println("=============================================================");
        double costOnePerson = tripList.get(tripList.size() - 1).getCost();
        String currency = tripList.get(tripList.size() - 1).getCurrency();
        double cosAllpeople = costOnePerson * numberOfPeople;
        System.out.printf("Сумма Вашей поездки составит:  на 1 человека = %.2f (%s)\n", costOnePerson, currency);
        System.out.printf("                               на компанию   = %.2f (%s)\n",cosAllpeople, currency);

      } else {
        System.out.println("_____________________________________________________________");
        System.out.printf("[ %d ] %s \n", i + 1,  expense);
      }
    }


    System.out.println();

    GoTravel.runMenu();
  }

  // TODO
  public static void editTrip() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Выберите статью расходов, которую Вы хотите отредактировать : ");
    System.out.println("_______________________________________________________________");
    List<Expense> tripList = parseTripList();
    for(int i = 0; i < tripList.size() -1; ++i){
      System.out.printf("[%d] %s\n", i + 1, tripList.get(i).getName());
    }
    System.out.println();
    System.out.println("Сделайте Ваш выбор: ");

//    System.out.printf("Вы хотите в \"%s\" изменить - %.f ",tripList.get(choiseForEdit() -1).getName() ,tripList.get(choiseForEdit() -1).getCost() );
    int choise = choiseForEdit();
    double newCost = costCalc(choise);
    tripList.get(choise -1).setCost(newCost);

   System.out.println("Результат Ваших изминений");
   System.out.println("_________________________");
   printTrip();

   // TODO перезапистаь в файл

  }

  public static int choiseForEdit() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int choise = 0;
    try{
      do {
        choise = Integer.parseInt(br.readLine());
      } while (!(choise > 0 && choise <= 6));
//      choise = Integer.parseInt(br.readLine());
    } catch (NumberFormatException e){
      System.out.println("Не правильный ввод.");
      editTrip();
    }
    return choise;
  }

  public static double costCalc (int choise) throws IOException {
    double cost = 0.00;
//    int choise = choiseForEdit();
    switch (choise){
      case 1 -> cost = TripCreator.appartCalc();
      case 2 -> cost = TripCreator.transferCalc();
      case 3 -> cost = TripCreator.localTransportCalc();
      case 4 -> cost = TripCreator.foodCalc();
      case 5 -> cost = TripCreator.excursionCalc();
      case 6 -> cost = TripCreator.entertainmentCalk();
    }
    return cost;
  }

  private static String getTripName() throws IOException{
    File tripsFile = new File("res/Trips.txt");
    if (!tripsFile.exists()) {
      System.out.println("Файл не найден. Или Вы не создали ещё не одной поездки.");
      GoTravel.runMenu();
    }
    BufferedReader br = new BufferedReader(new FileReader("res/Trips.txt"));

    String line = br.readLine();
    int sep = line.indexOf(";");
    String name = line.substring(0, sep);
    return name;
  }

  private static int getNumberOfPeople() throws IOException{
    File tripsFile = new File("res/Trips.txt");
    if (!tripsFile.exists()) {
      System.out.println("Файл не найден. Или Вы не создали ещё не одной поездки.");
      GoTravel.runMenu();
    }
    BufferedReader br = new BufferedReader(new FileReader("res/Trips.txt"));

    String line = br.readLine();
    int sepLeft = line.indexOf(";");
    int sepRight = line.indexOf(SEP);
    int NumberOfPeople = Integer.parseInt(line.substring(sepLeft + 1, sepRight));
    return NumberOfPeople;
  }

  public static List<Expense> parseTripList() throws IOException {
    File tripsFile = new File("res/Trips.txt");
    if (!tripsFile.exists()) {
      System.out.println("Файл не найден. Или Вы не создали ещё не одной поездки.");
      GoTravel.runMenu();
    }
    BufferedReader br = new BufferedReader(new FileReader("res/Trips.txt"));

    String line = br.readLine();
    int firstSep = line.indexOf(SEP);

    String lineForList = line.substring(firstSep + 1);
    List<Expense> expenses = new ArrayList<>();
    while (lineForList.length() != 0){
      int lastSep = lineForList.indexOf(SEP);
      String lineForeExp = lineForList.substring(0, lastSep);
      Expense expense = parseExpenses(lineForeExp);
      expenses.add(expense);
      lineForList = lineForList.substring(lastSep + 1);
    }
    br.close();
    return expenses;
  }


  private static Expense  parseExpenses(String lineForeExp){
    char sep = ';';
    int firstSep = lineForeExp.indexOf(sep);
    int secondSep = lineForeExp.indexOf(sep, firstSep + 1);

    String name = lineForeExp.substring(0, firstSep);

    String costString = lineForeExp.substring(firstSep + 1, secondSep);
    double cost = 0.00;
    if(costString.contains(",")){
      String newcostToString = costString.replace(',', '.');
      cost = Double.parseDouble(newcostToString);
    } else {
      cost = Double.parseDouble(costString);
    }

    String currency = lineForeExp.substring(secondSep + 1);
    Expense expense = new Expense(name, cost, currency);
    return expense;
  }

}

