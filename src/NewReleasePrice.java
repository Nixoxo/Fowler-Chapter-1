/**
 * Created on 01/05/16
 * author: nixoxo
 */
public class NewReleasePrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    double getCharge(int daysRented) {
        double result = daysRented * 3;
        return result;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        if (daysRented > 1) {
            return 2;
        }
        return 1;
    }
}
