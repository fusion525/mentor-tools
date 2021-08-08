package mentortools.trainingclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrainingClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "training_name", length = 255)
    private String name;
    @Column(name = "training_start_time")
    private LocalDate startTime;
    @Column(name = "training_end_time")
    private LocalDate endTime;

    public TrainingClass(String name, LocalDate startTime, LocalDate endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
