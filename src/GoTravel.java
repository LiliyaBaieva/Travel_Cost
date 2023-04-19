import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GoTravel {
  public static void runMenu() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for(int i = 0; i < menu().size(); ++i){
      System.out.println("[" + (i + 1) + "]" + menu().get(i));
    }
    int choice = readChoice();
    switch (choice) {
      case 1 -> Trips.addTrip();
      case 2 -> lookTrip();
      case 3 -> editTrip();
      case 4 -> deleteTrip();
      case 5 -> compareTrip();
      case 6 -> aboutApp();
      case 7 -> bye();
    }



  }

  private static List<String> menu() {
    List<String> menu = new ArrayList<>();
    menu.add("Добавить поездку"); //1
    menu.add("Посмотреть поездки");  //2
    menu.add("Внести изминения в поездку");
    menu.add("Удалить поездку");
    menu.add("Сравнить поездки");
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
      menu();
    }
    System.out.println();
    return readedChoice;
  }

  private static void aboutApp() throws IOException{
    System.out.println("""
                        >> TRAVEL COST <<
        Эта программа была создана человеком, который обожает путишествовать.
        Cозданна для быстрого расчёта поездки и для оптимизации Ваших расходов.
        
        Это приложение поможет Вам сделать оптимальный выбор
                  между несколькими вариантами.
        """);
    runMenu();
  }
  private static void bye(){
    System.out.println("""
             Желаем хорошего путишествия!
                      Досвидания!
          """);
  }

  //TODO  1
  // подменю чтоб посмотреть поездки
  private static void lookTrip(){

    //     - Вывести все поездки {номер, название стоимость общая, и за одного человека}
    //    - Посмотреть одну поездку:
    //        Вывести список поездок на экран
    //    и выбрать, которая интересует
    //    - в главное меню
  }

  //TODO удаление записи
  private static void deleteTrip(){
  }

  // TODO редактирование поездки
  private static void editTrip(){
    // через класс "expense"
  }


  //TODO здесь будем сравнивать поездки
  private static void compareTrip(){
    // 1. выводить на экран printAllTrip()
    // 2. спрашивать какие поездки мы хотим сравнить и по какому показателю или всю
    //     список статей расходов с номерами
    // printComparableTrip(trip1, trip2, parameter)
  }


}
