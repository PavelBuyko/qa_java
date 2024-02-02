import com.example.Animal;
import com.example.Feline;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class FelineTest {
    @Mock
    Animal animal = new Feline();
    @Test
    public void testEatMeat()
    {Feline feline = new Feline();
        MockitoAnnotations.openMocks(this);
        try {
            when(animal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            assertEquals(List.of("Животные", "Птицы", "Рыба"),feline.eatMeat());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetFamily()
    {
        Feline feline = new Feline();
        assertEquals(feline.getFamily(),"Кошачьи");
    }
    @Test
    public void testGetKittens()
    {
        Feline feline = new Feline();
        assertEquals(feline.getKittens(),1);
    }

    @Test
    public void testGetKittensWithIntData()
    {
        Feline feline = new Feline();
        assertEquals(feline.getKittens(1),1);
    }

}
