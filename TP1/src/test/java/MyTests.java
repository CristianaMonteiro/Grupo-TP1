
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
    public void getName() {
        User person = new User(11, "andre", 11);
        String ResName = person.getName();
        assertEquals("andre", ResName);
        //assertEquals("NULL", ResName);  //    Teste com input -> NUll
    }

    @Test
    public void IDUser() {
        User id = new User(2, "andre", 23);

        assertEquals(id.getIDUser(), 2);

        // assertEquals(id.getIDUser(), -6);   //   Teste com valores negativos!
    }
    @Test
    public void verificaSeExisteID() {

        User id = new User(30, "andre", 1);
        Assertions.assertThrows(UserAlreadyExists.class, () -> user.registerUser(30, "andre", 1));

    }
    @Test
    public void VerifyActiveUser() throws UserAlreadyExists {
                            //verifica quantos utilizadores estao ativos

        int rentalFee = 5;

        BikeRentalSystem user = new BikeRentalSystem(rentalFee);
        user.registerUser(1, "andre", 1);
        user.registerUser(2, "cristiana", 2);
        user.registerUser(3, "nando", 3);

        Assertions.assertEquals(3, user.getUsers().size());

    }

        @Test
    public void getBicycleTestAllHypo() throws UserAlreadyExists, UserDoesNotExists {

        BikeRentalSystem user = new BikeRentalSystem(1);

        user.registerUser(2, "andre", 1);

            //Verificar se o User com id 2 existe e possui um rental program
            Assertions.assertThrows(UserAlreadyExists.class, () ->user.registerUser(2,"andre",1));

            //Não devem funcionar os testes abaixo, pois passamos IDUsers que nao estao atribuidos
            Assertions.assertThrows(UserDoesNotExists.class, () -> user.getBicycle(1, 0, 1));
            Assertions.assertThrows(UserDoesNotExists.class, () -> user.getBicycle(1, 1, 1));
            Assertions.assertThrows(UserDoesNotExists.class, () -> user.getBicycle(1, -1, 1));

        }

    @Test
    public void verifyCredit() throws UserAlreadyExists {

        int idUser = 1;
        int rentalFee = 1;
        BikeRentalSystem user = new BikeRentalSystem(rentalFee);
        user.registerUser(idUser, "andre", 1);
        user.addCredit(idUser, 10);

        Assertions.assertTrue(user.verifyCredit(idUser));
    }



}
