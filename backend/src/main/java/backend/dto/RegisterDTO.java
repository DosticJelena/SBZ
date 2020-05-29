package backend.dto;

import backend.model.Allergen;
import backend.model.Macronutrients;
import backend.model.UserModel;
import backend.model.enumeration.Gender;
import backend.model.enumeration.WeightGoal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String age;
    private String weight;
    private String height;
    private String gender;
    private String weightGoal;

    public UserModel mapToModel(){
        UserModel user = new UserModel();
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setAge(Integer.valueOf(age));
        user.setWeight(Double.valueOf(weight));
        user.setHeight(Double.valueOf(height));
        user.setCaloriesThreshold(0);
        Macronutrients macros = new Macronutrients();
        macros.setCarbs(0);
        macros.setProtein(0);
        macros.setFat(0);
        user.setMacros(macros);

        if (gender.equals("0")) {
            user.setGender(Gender.FEMALE);
        } else {
            user.setGender(Gender.MALE);
        }

        if (weightGoal.equals("0")) {
            user.setWeightGoal(WeightGoal.LOSE);
        } else if (weightGoal.equals("1")){
            user.setWeightGoal(WeightGoal.MAINTAIN);
        } else {
            user.setWeightGoal(WeightGoal.GAIN);
        }

        return user;
    }

}