package backend;

import backend.kie.util.KnowledgeSessionHelper;
import backend.model.Macronutrients;
import backend.model.Meal;
import backend.model.Recipe;
import backend.model.UserModel;
import backend.model.enumeration.Gender;
import backend.model.enumeration.WeightGoal;
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
public class UserRulesTest {

    KieSession kSession = null;
    static KieContainer kieContainer;

    @BeforeClass
    public static void beforeClass(){
        kieContainer = KnowledgeSessionHelper.createRuleBase();
    }

    @Test
    public void femaleLoseTest(){
        kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "test-session");
        kSession.getAgenda().getAgendaGroup("calorieCalculator").setFocus();

        UserModel testUser = new UserModel();
        testUser.setWeightGoal(WeightGoal.LOSE);
        testUser.setGender(Gender.FEMALE);

        double weight = 55;
        double height = 160;
        int age = 25;

        testUser.setWeight(weight);
        testUser.setHeight(height);
        testUser.setAge(age);
        testUser.setMacros(new Macronutrients());

        kSession.insert(testUser);
        int fired = kSession.fireAllRules();

        assertThat(testUser.getCaloriesThreshold(), is((655 + 9.6 * weight + 1.8 * height - 4.7 * age)*1.5 -200));
    }

    @Test
    public void femaleMaintainTest(){
        kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "test-session");
        kSession.getAgenda().getAgendaGroup("calorieCalculator").setFocus();

        UserModel testUser = new UserModel();
        testUser.setWeightGoal(WeightGoal.MAINTAIN);
        testUser.setGender(Gender.FEMALE);

        double weight = 55;
        double height = 160;
        int age = 25;

        testUser.setWeight(weight);
        testUser.setHeight(height);
        testUser.setAge(age);
        testUser.setMacros(new Macronutrients());

        kSession.insert(testUser);
        int fired = kSession.fireAllRules();

        assertThat(testUser.getCaloriesThreshold(), is((655 + 9.6 * weight + 1.8 * height - 4.7 * age)*1.5));
    }

    @Test
    public void femaleGainTest(){
        kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "test-session");
        kSession.getAgenda().getAgendaGroup("calorieCalculator").setFocus();

        UserModel testUser = new UserModel();
        testUser.setWeightGoal(WeightGoal.GAIN);
        testUser.setGender(Gender.FEMALE);

        double weight = 55;
        double height = 160;
        int age = 25;

        testUser.setWeight(weight);
        testUser.setHeight(height);
        testUser.setAge(age);
        testUser.setMacros(new Macronutrients());

        kSession.insert(testUser);
        int fired = kSession.fireAllRules();

        assertThat(testUser.getCaloriesThreshold(), is((655 + 9.6 * weight + 1.8 * height - 4.7 * age)*1.5 +200));
    }

    //---------------------------------- MALE --------------------------------------------

    @Test
    public void maleLoseTest(){
        kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "test-session");
        kSession.getAgenda().getAgendaGroup("calorieCalculator").setFocus();

        UserModel testUser = new UserModel();
        testUser.setWeightGoal(WeightGoal.LOSE);
        testUser.setGender(Gender.MALE);

        double weight = 75;
        double height = 175;
        int age = 25;

        testUser.setWeight(weight);
        testUser.setHeight(height);
        testUser.setAge(age);
        testUser.setMacros(new Macronutrients());

        kSession.insert(testUser);
        int fired = kSession.fireAllRules();

        assertThat(testUser.getCaloriesThreshold(), is((66 + 13.7 * weight + 5 * height - 6.8 * age)*1.25 - 200));
    }

    @Test
    public void maleMaintainTest(){
        kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "test-session");
        kSession.getAgenda().getAgendaGroup("calorieCalculator").setFocus();

        UserModel testUser = new UserModel();
        testUser.setWeightGoal(WeightGoal.MAINTAIN);
        testUser.setGender(Gender.MALE);

        double weight = 75;
        double height = 175;
        int age = 25;

        testUser.setWeight(weight);
        testUser.setHeight(height);
        testUser.setAge(age);
        testUser.setMacros(new Macronutrients());

        kSession.insert(testUser);
        int fired = kSession.fireAllRules();

        assertThat(testUser.getCaloriesThreshold(), is((66 + 13.7 * weight + 5 * height - 6.8 * age)*1.25));
    }

    @Test
    public void maleGainTest(){
        kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "test-session");
        kSession.getAgenda().getAgendaGroup("calorieCalculator").setFocus();

        UserModel testUser = new UserModel();
        testUser.setWeightGoal(WeightGoal.GAIN);
        testUser.setGender(Gender.MALE);

        double weight = 75;
        double height = 175;
        int age = 25;

        testUser.setWeight(weight);
        testUser.setHeight(height);
        testUser.setAge(age);
        testUser.setMacros(new Macronutrients());

        kSession.insert(testUser);
        int fired = kSession.fireAllRules();

        assertThat(testUser.getCaloriesThreshold(), is((66 + 13.7 * weight + 5 * height - 6.8 * age)*1.25 + 200));
    }


}
