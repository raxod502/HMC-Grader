import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Random;

import org.junit.Test;

public class IceCreamTest {

  @Test
  public void testComparingIceCream() {
    IceCream chocolateChip1 = new IceCream(IceCream.BaseFlavor.VANILLA);
    chocolateChip1.addMixIn("chocolate chips");
    IceCream chocolateChip2 = new IceCream(IceCream.BaseFlavor.VANILLA);
    chocolateChip2.addMixIn("chocolate chips");
    assertEquals(chocolateChip1, chocolateChip2);
  }

  @Test
  public void testAddingToHashTable() {
    HashSet<IceCream> awesomeFlavors = new HashSet<IceCream>();
    // Make 10,000 IceCreams and add them to a HashSet
    for (int i = 0; i < 10000; i++) {
      IceCream iceCreamI = new IceCream(IceCream.BaseFlavor.VANILLA);

      // Use a helper method provided in the test file to get a mixIn
      iceCreamI.addMixIn(getRandomMixIn());

      awesomeFlavors.add(iceCreamI);
    }
    assertTrue(awesomeFlavors.size() <= 6);
    // System.out.println(awesomeFlavors.size());
  }

  public static String getRandomMixIn() {
    Random randNumGen = new Random();
    String[] possibleMixIns = { "chcolate chips", "caramel",
        "cookie dough", "fudge", "mint" };
    return possibleMixIns[randNumGen.nextInt(possibleMixIns.length)];
  }

}