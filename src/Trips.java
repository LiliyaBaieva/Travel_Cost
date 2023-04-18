import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trips {
  public final String CURRENCY = readCurrency();
//  public Carrency(){
//    String CURRENCY = readCurrency();
//  }
  private enum currencyList{
    USD,
    EUR,
    GBP, // Британский Фунт
    CHF, // Швейцарский Франк
    JPY, // Японская Йена
    UAH
  }

  // TODO Созданеи поездок (из статей расходов Expense)
  public Map<String, List> createTrip() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//    - Trips (Созданеи поездок из названия и списка статей расходов Expense)

    System.out.println("Введите название поездки: ");
    String nameOfTrip = br.readLine();

    System.out.println("Сколько дней Вы планируете отдыхать: ");
    int days;
    do{
    days = Integer.parseInt(br.readLine());
    } while (days <= 0);


    System.out.println("Сколько Вас будет человек: ");
    int numberPeople;
    do{
      numberPeople = Integer.parseInt(br.readLine());
    }while(numberPeople <= 0);

    List<Expense> tripList = new ArrayList<>();

    //Appart (жильё)
    Expense appart = new Expense("Жильё", appartCost(), CURRENCY);
    tripList.add(appart);

    // Transfer (расчёт проезда)
    Expense Transfer = new Expense("Трансфер", transferCost(), CURRENCY);
    tripList.add(Transfer);

    // LocalTransport (местный транспорт)
    System.out.println("Планируете ли Вы пользоваться местным транспортом?");
    String answer = readAnswer(br);
    if(answer.equalsIgnoreCase("y")){
      Expense LocalTransport = new Expense("Проезд на местном транспорте",
          localTransportCost(), CURRENCY);
      tripList.add(LocalTransport);
    }

    // Food(затраты на еду)
    Expense food  = new Expense("Питание", foodCost(), CURRENCY);
    tripList.add(food);

    // Excursion (затраты на экскурсию)
    // entertainment(развлечения, не обязательный, будем спрашивать )

    Map<String, List> trip = new HashMap<>();
    trip.put(nameOfTrip, tripList);
    return trip;
  }

  public static String readCurrency(){
    String curr = "";
    //TODO печать, считывание, выбор валюты
    return curr;
  }
  private double appartCost(){

    // TODO расчитать стоимость жилья на 1 человоека
    return 0.00;
  }
  private double transferCost(){
    // TODO расчитать стоимость проезда 1 человоека с учётом автобана
    return 0.00;
  }

  private double localTransportCost(){
    // TODO расчитать стоимость местного транспорта
    return 0.00;
  }

  private String readAnswer(BufferedReader br) throws IOException{
    System.out.println("[y] - да\n[n] - нет");
    String answer = "";
    try {
      answer = br.readLine();
    } catch (IllegalArgumentException e) {
      System.out.println("Не правильный ввод ответа.");
      readAnswer(br);
    }
    return answer;
  }

  public static void editTrip(){
    // TODO
    //  1. Какую трип хотим отредактировать
    //  2. Какую строчку из списка (листа)
    //  3. изменить / удалить (изменить можем только деньги)
    //  4. через свитч-кейс вызывает соответсвующую статье расходов функцию
  }







}
