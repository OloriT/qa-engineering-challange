package stepdefiniations;

import com.skydove.themovies.LaunchApp;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class AppiumScenario {


    WebDriverWait wait;

    public class AppActivity extends LaunchApp {


        @Given("^i launch the app$")
        public void i_launch_the_app() throws Throwable {
            // assert the mobile app is successfully launched
            Assert.assertTrue(getDriver().findElement(By.xpath("//*[@text='TheMovies']")).isDisplayed());

            throw new PendingException();

        }

        @When("^i click on a movie to view detail screen$")
        public void i_click_on_a_movie_to_view_detail_screen() throws Throwable {

            //verify a user can click on the movie title to proceed to the detailed screen
            getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.TextView")).click();

            throw new PendingException();

        }

        @Then("^i validate i am able to proceed to and view details page of a movie$")
        public void i_validate_i_am_able_to_proceed_to_and_view_details_page_of_a_movie() throws Throwable {
            //verify there is a title and release date on the detailed screen
            String title = getDriver().findElement(By.id("com.skydoves.themovies:id/detail_header_title")).getText();
            String releaseDate = getDriver().findElement(By.id("com.skydoves.themovies:id/detail_header_release")).getText();
            String rating = getDriver().findElement(By.id("com.skydoves.themovies:id/detail_header_star")).getText();
            if (!title.isEmpty() && !releaseDate.isEmpty() && !rating.isEmpty()) {
                System.out.println("Movie Title: " + title);
                System.out.println("Release Date: " + releaseDate);
                System.out.println("Rating: " + rating);
            } else
                System.out.println("Missing Object. Please take a look");

            //verify a user can scroll down the details movie page
            getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Reviews\").instance(0))"));

            //verify the back arrow is functional and can take the user back to the movie screen
            getDriver().findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();

            throw new PendingException();

        }

        @When("^i search for a filter button and enter a search parameter either by year or popularity$")
        public void i_search_for_a_filter_button_and_enter_a_search_parameter_either_by_year_or_popularity() throws Throwable {
            // this test could not be conducted because there is no filter function in the app

            throw new PendingException();

        }

        @Then("^i validate it returns valid search result$")
        public void i_validate_it_returns_valid_search_result() throws Throwable {
            // this test could not be conducted because there is no filter function in the app
            throw new PendingException();
        }

    }

}