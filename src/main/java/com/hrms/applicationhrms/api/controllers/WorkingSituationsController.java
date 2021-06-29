import com.hrms.applicationhrms.api.controllers;

import com.hrms.applicationhrms.business.abstracts.WorkingSituationService;
import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.entities.concretes.Gender;
import com.hrms.applicationhrms.entities.concretes.WorkingSituation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/workingSituations")
public class WorkingSituationsController {

    private WorkingSituationService workingSituationService;

    @Autowired
    public WorkingSituationsController(WorkingSituationService workingSituationService) {
        this.workingSituationService = workingSituationService;
    }

    @GetMapping("/getall")
    public DataResult<List<WorkingSituation>> getAll(){
        return this.workingSituationService.getAll();
    }

}
