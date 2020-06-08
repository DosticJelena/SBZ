package backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DRLFileDTO {
    private int lowMin;
    private int lowMax;
    private int mediumMin;
    private int mediumMax;
    private int highMin;
    private int highMax;
}
