import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionHasManeTest {
    private final String EXEPTIONMESSAGE = "Используйте допустимые значения пола животного - самец или самка";
private final String sex;
public LionHasManeTest(String sex)
{
    this.sex = sex;
}
    @Parameterized.Parameters
    public static String[] getSex() {
        return new String[]{"Самец", "Самка", "Вертолёт"};
    }
    @Test
    public void constructLionTest()
    {
        try {
            Lion lion = new Lion(sex);
            if (sex.equals("Самец")) {
                assertTrue(lion.doesHaveMane());
            } else                                   //Тут нет смысла делать ещё 1-у проверку , потому что если значение не будет является "Самец" или "Самка", то сразу же после конструктора мы провалимся в эксепшен.
            { assertFalse(lion.doesHaveMane());}
        }
        catch (Exception e){assertEquals(e.getMessage(),EXEPTIONMESSAGE);}
    }
  }