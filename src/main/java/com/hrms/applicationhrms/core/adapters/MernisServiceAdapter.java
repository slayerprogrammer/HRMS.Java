package com.hrms.applicationhrms.core.adapters;

import com.hrms.applicationhrms.entities.dtos.JobSeekerForRegisterDto;
import com.hrms.applicationhrms.services.mernis.BMTKPSPublicSoap;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements JobSeekerCheckService {

    BMTKPSPublicSoap client = new BMTKPSPublicSoap();

    @Override
    public boolean checkIfRealPerson(JobSeekerForRegisterDto jobSeeker) {
        try {
            return client.TCKimlikNoDogrula(
                    Long.parseLong(jobSeeker.getIdentityNumber()),
                    jobSeeker.getFirstName().toUpperCase(),
                    jobSeeker.getLastName().toUpperCase(),
                    Integer.parseInt(jobSeeker.getBirthYear()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
