import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CatTest {
    Feline feline = new Feline();
    @Mock
    Predator predator;

    @Test
    public void testGetSound()
    {
        Cat cat = new Cat(feline);
        assertEquals(cat.getSound(),"Мяу");
    }
    @Test
    public void testGetFood()
    {
        MockitoAnnotations.openMocks(this);
        try {
            Cat cat = new Cat(feline);
            when(predator.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            assertEquals(List.of("Животные", "Птицы", "Рыба"),cat.getFood());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
