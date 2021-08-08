package mentortools.trainingclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModifyTrainingClassCommand {

    private Long id;
    @NotBlank
    private String name;
    private LocalDate startTime;
    private LocalDate endTime;

    public ModifyTrainingClassCommand(String name, LocalDate startTime, LocalDate endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
