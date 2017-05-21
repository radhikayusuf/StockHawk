package com.udacity.stockhawk;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.stockhawk.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.udacity.stockhawk.TestUtil.withRecyclerView;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;

/**
 * Created by Radhika Yusuf on 21/05/17.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityClickMenu {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void onClickMenu(){
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()));

        onView(withId(R.id.action_change_units)).perform(click());
//        onData(TestUtil.withRecyclerView(R.id.recycler_view)
//                .atPositionOnView(1, R.id.change))
//                .check(matches(withText(containsString("$"))));
        onView(withRecyclerView(R.id.recycler_view).atPositionOnView(0, R.id.symbol))
                .check(matches(withText("AAPL")));
    }


    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }
}
