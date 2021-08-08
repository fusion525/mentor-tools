package mentortools.trainingclass;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class TrainingClassService {

    private ModelMapper modelMapper;
    private ObjectMapper objectMapper;
    private TrainingClassRepository trainingClassRepository;

    public TrainingClassService(ModelMapper modelMapper, ObjectMapper objectMapper, TrainingClassRepository trainingClassRepository) {
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
        this.trainingClassRepository = trainingClassRepository;
    }

    public List<TrainingClassDTO> listAllTrainingClasses() {
        Type targetListType = new TypeToken<List<TrainingClassDTO>>(){}.getType();

        return modelMapper.map(trainingClassRepository.findAll(),targetListType);
    }

    public TrainingClassDTO getTrainingClassById(long id) {
        return modelMapper.map(trainingClassRepository.getById(id),TrainingClassDTO.class);
    }

    public TrainingClassDTO createTrainingClass(CreateTrainingClassCommand command) {
        TrainingClass trainingClass = new TrainingClass(command.getName(),command.getStartTime(),command.getEndTime());

        trainingClassRepository.save(trainingClass);

        return modelMapper.map(trainingClass,TrainingClassDTO.class);
    }

    public TrainingClassDTO modifyTrainingClass(ModifyTrainingClassCommand command) {
        TrainingClass trainingClassToModify = trainingClassRepository.getById(command.getId());

        trainingClassToModify.setName(command.getName());
        trainingClassToModify.setStartTime(command.getStartTime());
        trainingClassToModify.setEndTime(command.getEndTime());

        trainingClassRepository.save(trainingClassToModify);

        return modelMapper.map(trainingClassToModify,TrainingClassDTO.class);
    }


    public void deleteTrainingClassById(DeleteTrainingClassCommand command) {
        trainingClassRepository.deleteById(command.getId());
    }
}
