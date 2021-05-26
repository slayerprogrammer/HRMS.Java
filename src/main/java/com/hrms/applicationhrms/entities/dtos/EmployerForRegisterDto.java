package com.hrms.applicationhrms.entities.dtos;

import com.hrms.applicationhrms.core.entities.abstracts.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerForRegisterDto implements Dto {

    private String companyName;
    private String website;
    private String phoneNumber;
    private String email;
    private String password;
    private String passwordConfirm;

}
