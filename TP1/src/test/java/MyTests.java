import Models.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MyTests {

    @Test
public void getName(){
        User person = new User(11, "andre",11);

        String ResName = person.getName();
        assertEquals("andre", ResName);
    }





}
