package com.hrms.applicationhrms.entities.dtos;

import com.hrms.applicationhrms.entities.enums.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostListDto {

    private int id;
    private String description;
    private int positionCount;
    private Date lastApplyDate;
    private String positionName;
    private Date releaseDate;
    private String companyName;
    private String cityName;
    private String wayOfWorking;
    private String workingTime;
    private PostStatus status;


}
