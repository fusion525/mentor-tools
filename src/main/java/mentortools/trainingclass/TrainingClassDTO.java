package mentortools.trainingclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrainingClassDTO {

    private Long id;
    private String name;
    private LocalDate startTime;
    private LocalDate endTime;

}
