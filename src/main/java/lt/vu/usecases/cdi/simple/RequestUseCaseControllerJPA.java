package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Course;
import lt.vu.entities.Darbuotojas;
import lt.vu.entities.Student;
import lt.vu.entities.Suniukas;
import lt.vu.usecases.cdi.dao.CourseDAO;
import lt.vu.usecases.cdi.dao.DarbuotojasDAO;
import lt.vu.usecases.cdi.dao.StudentDAO;
import lt.vu.usecases.cdi.dao.SuniukasDAO;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class RequestUseCaseControllerJPA {

    @Getter
    private Suniukas suo = new Suniukas();
    @Getter
    private Darbuotojas darb = new Darbuotojas();

    @Inject
    private SuniukasDAO suoDAO;
    @Inject
    private DarbuotojasDAO darbDAO;

    @Transactional
    public void sukurkSuniukaDarbuotoja() {
        suo.getDarbuotojasList().add(darb);
        darb.getSuniukasList().add(suo);
        suoDAO.create(suo);
        darbDAO.create(darb);
        log.info("Maybe OK...");
    }

    public List<Suniukas> getAllSuniukas() { return suoDAO.getAllSuniukas();
    }
}
