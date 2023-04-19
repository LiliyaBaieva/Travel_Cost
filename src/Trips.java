import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Trips {
  public final static char SEP = '/';
  public static String currency;
  public static int days;
  public static int numberPeople;

  public static void addTrip () throws IOException{
    File trips = new File("res/trips.txt");
    FileWriter fileWriter = new FileWriter("res/trips.txt");
    if(!trips.exists()){
      trips.createNewFile();
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Введите название поездки: ");
    String nameOfTrip = br.readLine();
    System.out.println("Сколько дней Вы планируете отдыхать: ");
    do{
      days = Integer.parseInt(br.readLine());
    } while (days <= 0);
    System.out.println("Сколько Вас будет человек: ");
    do{
      numberPeople = Integer.parseInt(br.readLine());
    }while(numberPeople <= 0);
    System.out.print("Введите валюту, в которой будет производится расчёт: ");
    currency = br.readLine().toLowerCase();

    List<Expense> trip = createTrip();

    String allExpenses = "";
    for (Expense expense : trip) {
      allExpenses = allExpenses + SEP + expense.toString();
    }

    String total = String.format(nameOfTrip + SEP + allExpenses);

    fileWriter.write(String.valueOf(total));
    fileWriter.close();
  }

  public static List<Expense> createTrip() throws IOException {
    List<Expense> tripList = new ArrayList<>();

    Expense appart = new Expense("Жильё", appartCost(), currency);
//    appart.toString();
    tripList.add(appart);

    Expense Transfer = new Expense("Трансфер", transferCost(), currency);
    tripList.add(Transfer);

    System.out.println("Планируете ли Вы пользоваться местным транспортом?");
    boolean answer = readAnswer();
    if(answer){
      Expense LocalTransport = new Expense("Проезд на местном транспорте",
          localTransportCost(), currency);
      tripList.add(LocalTransport);
    }

    Expense food  = new Expense("Питание", foodCost(), currency);
    tripList.add(food);

    Expense excursion  = new Expense("Экскурсии", excursionCost(), currency);
    tripList.add(excursion);

    System.out.println("Планируете ли дополнительные затраты на развлечения?");
    boolean answer2 = readAnswer();
    if(answer2){
      Expense entertainment  = new Expense("Развлечения", entertainmentCost(), currency);
      tripList.add(entertainment);
    }

    return tripList;
  }

//  public static String readCurrency(){
//    String curr = "";
//    //TODO печать, считывание, выбор валюты
//    return curr;
//  }
  private static double appartCost() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    double cost = 0.00;
    System.out.println("Вам известна стоимость проживания в сутки за 1 человека?");
    boolean answer = readAnswer();
    if(answer){
      System.out.println("Введите стоимость проживания в сутки за 1 человека?");
      double oneDay = Double.parseDouble(br.readLine());
      cost = oneDay * days;
    } else{
      System.out.print("Введите стоимость жилья в сутки: ");
      cost = Double.parseDouble(br.readLine()) / numberPeople * days;
    }
    return cost;
  }
  private static double transferCost() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    double cost = 0.00;
    System.out.println("Вы будете ехать машиной?");
    boolean answer = readAnswer();
    if(answer){
      if (numberPeople > 5){
        System.out.println("Колоичеством больше 5 человек нельзя перемещаться на автомобиле.");
      }
    } else{
      System.out.println("Введите стоимость билета в одну сторону: ");
      cost = Double.parseDouble(br.readLine()) * 2;
    }

    // TODO расчитать стоимость проезда 1 человоека с учётом автобана
    return cost;
  }

  // TODO расчитать стоимость местного транспорта
  private static double localTransportCost(){

    return 0.00;
  }

  // TODO расчитать стоимость питания на 1 человоека
  private static double foodCost(){
    return 0.00;
  }

  // TODO расчитать стоимость экскурсии на 1 человоека
  private static double excursionCost(){
    return 0.00;
  }

  // TODO расчитать стоимость развлечения на 1 человоека
  private static double entertainmentCost(){
    return 0.00;
  }

  private  static boolean readAnswer() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("[y] - да\n[n] - нет");
    String answerLine = br.readLine();
    if(answerLine.equalsIgnoreCase("n")){
      return false;
    } else if (!answerLine.equalsIgnoreCase("y")) {
      System.out.println("Не правильный ввод ответа.");
      readAnswer();
    }
      return true;
  }


  // TODO
  public static void editTrip(){
    //  1. Какую трип хотим отредактировать
    //  2. Какую строчку из списка (листа)
    //  3. изменить / удалить (изменить можем только деньги)
    //  4. через свитч-кейс вызывает соответсвующую статье расходов функцию
  }







}
