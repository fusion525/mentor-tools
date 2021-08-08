package mentortools.trainingclass;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainingclasses")
public class TrainingClassController {

    private TrainingClassService trainingClassService;

    public TrainingClassController(TrainingClassService trainingClassService) {
        this.trainingClassService = trainingClassService;
    }

    @GetMapping
    public List<TrainingClassDTO> listAllTrainingClasses() {
        return trainingClassService.listAllTrainingClasses();
    }

    @GetMapping("/{id}")
    public TrainingClassDTO getTrainingClassById(@PathVariable(name = "id") long id) {
        return trainingClassService.getTrainingClassById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrainingClassDTO createTrainingClass(@RequestBody CreateTrainingClassCommand command) {
        return trainingClassService.createTrainingClass(command);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TrainingClassDTO modifyTrainingClass(@RequestBody ModifyTrainingClassCommand command) {
        return trainingClassService.modifyTrainingClass(command);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainingClassById(@RequestBody DeleteTrainingClassCommand command) {
        trainingClassService.deleteTrainingClassById(command);
    }
}
