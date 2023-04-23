import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GoTravel {
  public static void runMenu() throws IOException {

    for(int i = 0; i < menu().size(); ++i)
      System.out.println("[" + (i + 1) + "] " + menu().get(i));
    int choice = readChoice();
    switch (choice) {
      case 1 -> TripCreator.addTrip();
      case 2 -> Trip.printTrip();
      case 3 -> Trip.editTrip();
      case 4 -> aboutApp();
      case 5 -> bye();
    }



  }

  private static List<String> menu() {
    List<String> menu = new ArrayList<>();
    menu.add("Создать поездку"); //1
    menu.add("Посмотреть поездку");  //2
    menu.add("Внести изминения в поездку");
    menu.add("О програме");
    menu.add("Выйти из программы"); //7
    return menu;
  }


  private static int readChoice() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //  Считываем выбор меню от пользователя

    System.out.println("-----------------------------");
    System.out.print("    Сделайте Ваш выбор: ");
    int readedChoice = 0;
    try{
      readedChoice = Integer.parseInt(br.readLine());
    } catch (IllegalArgumentException e){
      System.out.println("Не правильный ввод: \"" + e + "\"");
      runMenu();
    }
    if(readedChoice > 5){
      System.out.println("Введите от 1 до 5");
      runMenu();
    }
    System.out.println();
    return readedChoice;
  }

  private static void aboutApp() throws IOException{
    System.out.println("""
                        >> TRAVEL COST <<
        Эта программа была создана человеком, который обожает путишествовать.
        Cозданна для быстрого расчёта поездки и для оптимизации Ваших расходов.
        """);
    runMenu();
  }
  private static void bye(){
    System.out.println("""
             Желаем хорошего путишествия!
                      Досвидания!
          """);
  }


}
