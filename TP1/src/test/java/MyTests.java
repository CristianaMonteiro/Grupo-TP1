import Exceptions.UserAlreadyExists;
import Exceptions.UserDoesNotExists;
import Models.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;



public class MyTests {
    private BikeRentalSystem user;

    @BeforeEach
    public void setUp() throws UserAlreadyExists {


        user = new BikeRentalSystem(1);
        user.registerUser(30, "andre", 1);

    }
    @Test
public void getName(){
        User person = new User(11, "andre",11);
        String ResName = person.getName();
        assertEquals("andre", ResName);

    }
@Test
    public void IDUser(){
        User id = new User(2,"andre",23);

           assertEquals(id.getIDUser(), 2);

          // assertEquals(id.getIDUser(), -6);   //   Teste com valores negativos!
}


    @Test
    public void getBicycleTestUserInvalido() throws UserAlreadyExists, UserDoesNotExists {


        BikeRentalSystem user = new BikeRentalSystem(1);

        user.registerUser(2,"andre",1);


        Assertions.assertThrows(UserDoesNotExists.class, () -> user.getBicycle(1, 1, 1));
        Assertions.assertThrows(UserDoesNotExists.class, () -> user.getBicycle(1, 0, 1));
        Assertions.assertThrows(UserDoesNotExists.class, () -> user.getBicycle(1, -1, 1));



    }
    @Test
    public void criarDoisComMesmoID() {

        User id = new User(30,"andre",1);
        Assertions.assertThrows(UserAlreadyExists.class, () -> user.registerUser(30, "andre", 1));

        //assertEquals(id.getIDUser(), 2);

    }




}
