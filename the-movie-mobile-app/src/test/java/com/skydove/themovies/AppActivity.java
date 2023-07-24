package com.skydove.themovies;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;


public class AppActivity extends LaunchApp{


    WebDriverWait wait;


    @Test(priority = 0)
    public void movieScreen() {

        //verify a user can click on the movie title to proceed to the detailed screen
        getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.TextView")).click();

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
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();

    }

    @Test(priority = 1)
    public void imageClick() throws InterruptedException {
        //verify the user can click on the movie image to proceed to the detailed screen
        getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[4]/android.widget.ImageView")).click();

        //verify the trailer videos respond to click
        getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.ImageView[1]")).click();
        Thread.sleep(4000);
        getDriver().navigate().back();

        Point source = new Point(769, 309);
        Point target = new Point(752, 2348);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), source.x, source.y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700),
                PointerInput.Origin.viewport(),target.x, target.y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));


    }


    @Test(priority = 2)
    public void navigationButton() {

        //verify a user can navigate from one screen to the other
        //click on tv button
        getDriver().findElement(By.id("com.skydoves.themovies:id/action_two")).click();

        //click on stars button
        getDriver().findElement(By.id("com.skydoves.themovies:id/action_three")).click();

        //verify a user can click on star to see full information about the star
        getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.RelativeLayout")).click();

        //verify the user can go back to all stars page
        getDriver().findElement(By.id("com.skydoves.themovies:id/toolbar_home")).click();

        //verify tge agent can navigate back to the home screen
        getDriver().findElement(By.id("com.skydoves.themovies:id/action_one")).click();

    }

    //There is no filter option on TheMovie app so i could not attempt challenge 2
}