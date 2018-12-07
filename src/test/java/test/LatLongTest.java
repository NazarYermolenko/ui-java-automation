package test;

import data.Place;
import io.github.sskorol.core.DataSupplier;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.latlong.LatlongPage;
import utils.ExcelDataReader;
import utils.PropertyReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Feature("Latitude and longitude test")
public class LatLongTest extends TestRunner {
    private LatlongPage latlongPage;
    private static final String DATA_PROPERTY = "places.data.xlsx";

    @DataSupplier()
    public List<Place> placesDataProvider() {
        List<List<String>> data = ExcelDataReader.getDataFromExcelFile(PropertyReader.getProperty(DATA_PROPERTY));

        return data.stream()
                .map(strings ->
                        new Place(strings.get(0), strings.get(1), strings.get(2)))
                .collect(Collectors.toCollection(ArrayList::new));
    }


    @Description("Latitude and longitude test")
    @Test(dataProvider = "placesDataProvider")
    public void latlongTest(Place place) {

        latlongPage = new LatlongPage().open().searchForPlace(place.getPlace());

        String resultLongitude = latlongPage.getLongitude();
        softAssert.assertEquals(place.getLongitude(), resultLongitude);

        String resultLatitude = latlongPage.getLatitude();
        softAssert.assertEquals(place.getLatitude(), resultLatitude);

        softAssert.assertAll();
    }
}

