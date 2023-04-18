import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Trips {
  public static String currency;
  public static int days;
  public static int numberPeople;

  // TODO Созданеи поездок (из статей расходов Expense)
  public static Map<String, List> createTrip() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//    - Trips (Созданеи поездок из названия и списка статей расходов Expense)

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

    List<Expense> tripList = new ArrayList<>();

    //Appart (жильё)
    Expense appart = new Expense("Жильё", appartCost(), currency);
    tripList.add(appart);

    // Transfer (расчёт проезда)
    Expense Transfer = new Expense("Трансфер", transferCost(), currency);
    tripList.add(Transfer);

    // LocalTransport (местный транспорт)
    System.out.println("Планируете ли Вы пользоваться местным транспортом?");
    boolean answer = readAnswer();
    if(answer){
      Expense LocalTransport = new Expense("Проезд на местном транспорте",
          localTransportCost(), currency);
      tripList.add(LocalTransport);
    }

    // Food(затраты на еду)
    Expense food  = new Expense("Питание", foodCost(), currency);
    tripList.add(food);

    // Excursion (затраты на экскурсию)
    Expense excursion  = new Expense("Экскурсии", excursionCost(), currency);
    tripList.add(excursion);


    // entertainment(развлечения, не обязательный, будем спрашивать )
    System.out.println("Планируете ли дополнительные затраты на развлечения?");
    boolean answer2 = readAnswer();
    if(answer2){
      Expense entertainment  = new Expense("Развлечения", entertainmentCost(), currency);
    }

    Map<String, List> trip = new HashMap<>();
    trip.put(nameOfTrip, tripList);
    return trip;
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
      cost = Double.parseDouble(br.readLine()) * days;
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

  private static double localTransportCost(){
    // TODO расчитать стоимость местного транспорта
    return 0.00;
  }
  private static double foodCost(){
    // TODO расчитать стоимость жилья на 1 человоека
    return 0.00;
  }
  private static double excursionCost(){
    // TODO расчитать стоимость питания на 1 человоека
    return 0.00;
  }
  private static double entertainmentCost(){
    // TODO расчитать стоимость развлечения на 1 человоека
    return 0.00;
  }

  private  static boolean readAnswer() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("[y] - да\n[n] - нет");
//    boolean answer;
    String answerLine = br.readLine();
    if(answerLine.equalsIgnoreCase("n")){
      return false;
    } else if (!answerLine.equalsIgnoreCase("y")) {
      System.out.println("Не правильный ввод ответа.");
      readAnswer();
    }
      return true;
  }



  public static void editTrip(){
    // TODO
    //  1. Какую трип хотим отредактировать
    //  2. Какую строчку из списка (листа)
    //  3. изменить / удалить (изменить можем только деньги)
    //  4. через свитч-кейс вызывает соответсвующую статье расходов функцию
  }







}
