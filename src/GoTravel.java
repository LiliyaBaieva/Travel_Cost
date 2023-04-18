import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GoTravel {
  public static void goTravel() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int choice = menu();

    switch (choice) {
      case 1 -> createTrip();
      case 2 -> lookTrip();
      case 3 -> editTrip();
      case 4 -> deleteTrip();
      case 5 -> compareTrip();
      case 6 -> aboutApp();
      case 7 -> bye();
    }
  }

  private static int menu() throws IOException {
    List<String> menu = new ArrayList<>();
    menu.add("Добавить поездку"); //1
    menu.add("Посмотреть поездки");  //2
    menu.add("Внести изминения в поездку");
    menu.add("Удалить поездку");
    menu.add("Сравнить поездки");
    menu.add("О програме");
    menu.add("Выйти из программы"); //7

    for(int i = 0; i < menu.size(); ++i){
      System.out.println("[" + (i + 1) + "]" + menu.get(i));
    }

    int choice = readChoice();
    
  return choice;
  }
  
  private static int readChoice() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//                      [3]Внести изминения в поездку
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
        
        Это приложение поможет Ваам сделать оптимальный выбор
                  между несколькими вариантами.
        """);
    menu();
  }
  private static void bye(){
    System.out.println("""
             Желаем хорошего путишествия!
                      Досвидания!
          """);
  }

  private static void createTrip(){
    // TODO лист trip из классов "expense"
  }

  private static void lookTrip(){
    //TODO подменю чтоб посмотреть поездки

    //     - Вывести все поездки {номер, название стоимость общая, и за одного человека}
    //    - Посмотреть одну поездку:
    //        Вывести список поездок на экран
    //    и выбрать, которая интересует
    //    - в главное меню
  }

  private static void editTrip(){
    // TODO редактирование поездки
    // через класс "expense"
  }

  private static void deleteTrip(){
    //TODO удаление записи
  }

  private static void compareTrip(){
    //TODO здесь будем сравнивать поездки
    // 1. выводить на экран printAllTrip()
    // 2. спрашивать какие поездки мы хотим сравнить и по какому показателю или всю
    // printComparableTrip(trip1, trip2, parameter)
  }


}
