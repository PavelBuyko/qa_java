import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class LionTest {
    private final String sex = "Самец";

    @Mock
    Feline feline = new Feline();
    @Test
    public void testGetKittens()
    {
        try {
            Lion lion = new Lion(sex);
            assertEquals(lion.getKittens(feline),1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testGetFood()
    {
        MockitoAnnotations.openMocks(this);
        try {
            Lion lion = new Lion(sex);
            when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            assertEquals(List.of("Животные", "Птицы", "Рыба"),lion.getFood(feline));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
