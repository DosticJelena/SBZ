package backend;

import backend.kie.util.KnowledgeSessionHelper;
import backend.model.Recipe;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class RecipeRulesTest {

    KieSession kSession = null;
    static KieContainer kieContainer;

    @BeforeClass
    public static void beforeClass(){
        kieContainer = KnowledgeSessionHelper.createRuleBase();
    }

    @Test
    public void lowPopularityRecipeTest(){
        kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "test-session");
        Recipe testR = new Recipe();
        testR.setTimesEaten(2);
        kSession.insert(testR);
        int fired = kSession.fireAllRules();

        assertThat(1,is(fired));
        assertThat(testR.getPopularity(),is(Recipe.Popularity.LOW));
    }

    @Test
    public void mediumPopularityRecipeTest(){
        kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "test-session");
        Recipe testR = new Recipe();
        testR.setTimesEaten(4);
        kSession.insert(testR);
        int fired = kSession.fireAllRules();

        assertThat(1,is(fired));
        assertThat(testR.getPopularity(),is(Recipe.Popularity.MEDIUM));
    }

    @Test
    public void highPopularityRecipeTest(){
        kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "test-session");
        Recipe testR = new Recipe();
        testR.setTimesEaten(7);
        kSession.insert(testR);
        int fired = kSession.fireAllRules();

        assertThat(1,is(fired));
        assertThat(testR.getPopularity(),is(Recipe.Popularity.HIGH));
    }

    @Test
    public void timesViewedTest(){
        kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "test-session");
        kSession.getAgenda().getAgendaGroup("recipeSearchResults").setFocus();
        Recipe testR = new Recipe();
        long tv = 3;
        testR.setTimesViewed(tv);
        kSession.insert(testR);
        int fired = kSession.fireAllRules();

        assertThat(1,is(fired));
        assertThat(testR.getTimesViewed(),is(tv+1));
    }

}
