package com.hrms.applicationhrms.entities.dtos;

import com.hrms.applicationhrms.core.entities.abstracts.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForLoginDto implements Dto {

    private String email;
    private String password;

}
