import org.junit.*;
import static org.junit.Assert.*;

public class PlacesTest {

  @Test
    public void Places_instantiateMyPlacesObject_true() {
      Places myPlaces = new Places("a", "b", 1, "d");
      assertEquals(true, myPlaces instanceof Places);
    }

  @Test
    public void suggestOtherPlaces_returnsOtherPlaces_String() {
      Places myPlaces = new Places("a", "b", 1, "work");
      assertEquals("Bermuda, Bahamas", myPlaces.suggestOtherPlaces());
    }

}
