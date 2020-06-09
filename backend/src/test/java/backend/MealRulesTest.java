package backend;

import backend.kie.util.KnowledgeSessionHelper;
import backend.model.Meal;
import backend.model.Recipe;
import backend.model.UserModel;
import org.drools.core.base.RuleNameMatchesAgendaFilter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
public class MealRulesTest {

    KieSession kSession = null;
    static KieContainer kieContainer;

    @BeforeClass
    public static void beforeClass(){
        kieContainer = KnowledgeSessionHelper.createRuleBase();
    }

    @Test
    public void mealTimeTest(){
        kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "test-session");
        kSession.getAgenda().getAgendaGroup("eatenMeals").setFocus();
        kSession.setGlobal("maxTimesEaten", 24.0);
        Meal testMeal = new Meal();

        Recipe testR = new Recipe();
        UserModel testUser = new UserModel();

        testR.setTimesEaten(1);
        testR.setName("testName");
        testMeal.setRecipe(testR);

        testMeal.setUser(testUser);

        testMeal.setMealTime(null);
        kSession.insert(testMeal);
        int fired = kSession.fireAllRules();

        assertNotNull(testMeal.getMealTime());
    }

    @Test
    public void recipeEatenCounterTest(){
        kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "test-session");
        kSession.getAgenda().getAgendaGroup("eatenMeals").setFocus();
        kSession.setGlobal("maxTimesEaten", 24.0);
        Meal testMeal = new Meal();

        Recipe testR = new Recipe();
        UserModel testUser = new UserModel();

        long te = 4;

        testR.setTimesEaten(te);
        testR.setName("testName");
        testMeal.setRecipe(testR);

        testMeal.setUser(testUser);

        testMeal.setMealTime(null);
        kSession.insert(testMeal);
        int fired = kSession.fireAllRules();

        assertThat(testMeal.getRecipe().getTimesEaten(), is(te+1));
    }

    @Test
    public void calculateRatingTest(){
        kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "test-session");
        kSession.getAgenda().getAgendaGroup("eatenMeals").setFocus();

        double maxTimesEaten = 10;

        kSession.setGlobal("maxTimesEaten", maxTimesEaten);
        Meal testMeal = new Meal();

        Recipe testR = new Recipe();
        UserModel testUser = new UserModel();

        long te = 4;

        testR.setTimesEaten(te);
        testR.setName("testName");
        testMeal.setRecipe(testR);

        testMeal.setUser(testUser);

        testMeal.setMealTime(null);
        kSession.insert(testMeal);
        int fired = kSession.fireAllRules();

        assertThat(testMeal.getRecipe().getRating(), is((te+1)/maxTimesEaten));
    }

    @Test
    public void updateAllRatingsTest(){
        kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "test-session");
        kSession.getAgenda().getAgendaGroup("popularRecipe").setFocus();
        double maxTimesEaten = 10.0;
        kSession.setGlobal("maxTimesEaten", maxTimesEaten);

        Recipe testR = new Recipe();
        long te = 4;

        testR.setTimesEaten(te);
        testR.setName("testName");
        kSession.insert(testR);
        int fired = kSession.fireAllRules();

        assertThat(testR.getRating(), is((te)/maxTimesEaten));
    }

}
