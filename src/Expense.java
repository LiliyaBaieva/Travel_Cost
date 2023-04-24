public class Expense {

  private final String name;
  private double cost;
  private final String currency;

  public Expense(String name, double cost, String currency) {
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

  @Override
  public String toString() {
//    getName() + " = " +  getCost() + " (" + getCurrency() + ")";
    return String.format(" %s = %.2f (%s)", getName(), getCost(), getCurrency());
  }
}
