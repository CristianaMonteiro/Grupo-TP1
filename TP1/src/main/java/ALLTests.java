import Models.Bike;
import Models.Deposit;
import Models.Lock;
import Models.User;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        BikeRentalSystem.class,
        User.class,
        Deposit.class,
        Lock.class,
        Bike.class
})



public class ALLTests {
}
