import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created on 01/05/16
 * author: nixoxo
 */
public class CustomerTest {

    private Customer customer;
    private final String someCustomerName = "SomeCustomer";

    @Before
    public void setUp() throws Exception {
        customer = new Customer(someCustomerName);
    }

    @Test
    public void addRental() throws Exception {
        Movie newmovie = new Movie("some movie", 1336);
        Rental rental = new Rental(newmovie, 3);
        customer.addRental(rental);
        assertThat(customer.getRentals().size(), is(1));
    }

    @Test
    public void getName() throws Exception {
        assertThat(customer.getName(), is(someCustomerName));
    }

    private String createTableRow(String title, int days, double amount) {
        return String.format("\t%s\t\t%d\t%.1f\n", title, days, amount);
    }

    @Test
    public void statement() throws Exception {
        String newReleaseTitle = "new release movie";
        int newReleaseRented = 10;
        Movie newRelaseMovie = new Movie(newReleaseTitle, Movie.NEW_RELEASE);
        String childrensTitle = "children movie";
        int childrensRented = 5;
        Movie childrensMovie = new Movie(childrensTitle, Movie.CHILDRENS);
        String regularTitle = "regular movie";
        int regularRented = 3;
        Movie regularMovie = new Movie(regularTitle, Movie.REGULAR);


        Rental newReleaseRental = new Rental(newRelaseMovie, newReleaseRented);
        Rental childrensRental = new Rental(childrensMovie, childrensRented);
        Rental regularRental = new Rental(regularMovie, regularRented);

        customer.addRental(newReleaseRental);
        customer.addRental(childrensRental);
        customer.addRental(regularRental);

        double totalAmount = 38.0;
        int renterpoints = 4;
        String statement = String.format("Rental Record for %s\n" +
                "\tTitle\t\tDays\tAmount\n" +
                createTableRow(newReleaseTitle, newReleaseRented, 30.0) +
                createTableRow(childrensTitle, childrensRented, 4.5) +
                createTableRow(regularTitle, regularRented, 3.5) +
                "Amount owed is %.1f\n" +
                "You earned %s frequent renter points", someCustomerName, totalAmount, renterpoints);
        assertThat(statement, is(customer.statement()));
    }
}
