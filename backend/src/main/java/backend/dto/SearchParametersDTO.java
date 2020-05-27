package backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchParametersDTO {
    private List<String> ingredients;
    private List<String> allergens;
    private String location;
    private boolean showSemiValid;

}
