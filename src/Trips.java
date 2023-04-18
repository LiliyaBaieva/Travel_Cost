import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trips {
  public final String CURRENCY = readCurrency();
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
//        - Appart (жильё)
//        - Transfer (расчёт проезда)
//        - LocalTransport (местный транспорт, не обязательный, будем спрашивать )
//        - Food(затраты на еду)
//        - Excursion (затраты на экскурсию)
//        - entertainment(развлечения, не обязательный, будем спрашивать )
    List<Expense> tripList = new ArrayList<>();
    Expense appart = new Expense("Жильё", readAppartCost(), CURRENCY);
    tripList.add(appart);
    Expense Transfer = new Expense("Трансфер", readTransfertCost(), CURRENCY);
    tripList.add(Transfer);

    String answer = readAnswer(br);
    if(answer.equalsIgnoreCase("y")){
      Expense LocalTransport = new Expense("Проезд на местном транспорте",
          readLocalTransportCost(), CURRENCY);
      tripList.add(LocalTransport);
    }
//    Expense Transfer = new Expense("Трансфер", readTransfertCost(), CURRENCY);
//    tripList.add(Transfer);



//    Expense

    Map<String, List> trip = new HashMap<>();
    trip.put(nameOfTrip, tripList);
    return trip;
  }

  public static String readCurrency(){
    String curr = "";
    //TODO печать, считывание, выбор валюты
    return curr;
  }
  private double readAppartCost(){
    // TODO расчитать стоимость жилья на 1 человоека
    return 0.00;
  }
  private double readTransfertCost(){
    // TODO расчитать стоимость жилья на 1 человоека с учётом автобана
    return 0.00;
  }

  private double readLocalTransportCost(){
    // TODO расчитать стоимость жилья на 1 человоека с учётом автобана
    return 0.00;
  }

  private String readAnswer(BufferedReader br) throws IOException{
    System.out.println("""
          Планируете ли Вы пользоваться местным транспортом?
           [y] - да
           [n] - нет
     """);
    String answer = "";
    try {
      answer = br.readLine();
    } catch (IllegalArgumentException e) {
      System.out.println("Не правильный ввод ответа.");
      readAnswer(br);
    }
    return answer;
  }







}
