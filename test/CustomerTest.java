import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.rmi.server.ExportException;

import static org.hamcrest.CoreMatchers.*;

/**
 * Created on 01/05/16
 * author: nixoxo
 */
public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() throws Exception{
        customer = new Customer("SomeCustomer");
    }

    @Test
    public void addRental() throws Exception{
        Movie newmovie = new Movie("some movie", 1336);
        Rental rental = new Rental(newmovie, 3);
        customer.addRental(rental);
        Assert.assertThat(customer.getRentals().size(), is(1));
    }
}
