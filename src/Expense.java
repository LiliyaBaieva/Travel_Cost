import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Expense {

  private String name;
  private double cost;
  private String currency;
  public Expense(String name, double cost, String currency){
    this.name = name;
    this.cost = cost;
    this.currency = currency;
  }

  public String getName() {
    return name;
  }

  public double getCost() {
    return cost;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }


  public static Expense expenseCreator() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Введите название расхода: ");
    String name = br.readLine();
    System.out.println("Введите сумму расход: ");
    double cost = Double.parseDouble(br.readLine());
    String currency  = br.readLine();                // использование ввода валюты
    return new Expense(name, cost, currency);
  }



}
