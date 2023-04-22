import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import org.junit.jupiter.api.Test;

// arrange
// act
// assert
public class TripCreatorTests {

  @Test
  public void goByCar() throws IOException {
    // arrange
    int numberPeople = 4;
    String answerLine = "y";
    boolean answer = true;
    double distance = 1200;
    double fuelСonsumption = 9;
    double fuelCost = 1.8;
    double autobahn = 60;
    double expected = ((fuelСonsumption / 100 * fuelCost) * distance * 2 + autobahn) / numberPeople;

    // act
    double actual = TripCreator.transferCalc();
    // assert
    assertEquals(expected, actual);
  }

}
