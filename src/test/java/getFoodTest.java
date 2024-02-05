import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class getFoodTest {
    private final String EXEPTIONMESSAGE = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
    private final List<String> GRASSFOOD = List.of("Трава", "Различные растения");
    private final List<String> MEATFOOD = List.of("Животные", "Птицы", "Рыба");
    private final String animalKind;
    public getFoodTest(String animalKind)
    {
        this.animalKind = animalKind;
    }
    @Parameterized.Parameters
    public static String[] animalKind() {
        return new String[]{"Травоядное", "Хищник", "Млекопитающее"};
    }
    @Test
    public void getFoodMethodTest()
    {
        try {
            Animal animal = new Animal();
            if (animalKind.equals("Травоядное")) {
                assertEquals(animal.getFood(animalKind),GRASSFOOD);
            } else                                   //Тут нет смысла делать ещё 1-у проверку, потому что если значение не будет являеться "Травоядное" или "Хищник", то сразу же после конструктора мы провалимся в эксепшен.
            { assertEquals(animal.getFood(animalKind),MEATFOOD);}
        }
        catch (Exception e){assertEquals(e.getMessage(),EXEPTIONMESSAGE);}
    }
}


