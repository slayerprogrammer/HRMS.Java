package com.hrms.applicationhrms.dataAccess.abstracts;

import com.hrms.applicationhrms.entities.concretes.Post;
import com.hrms.applicationhrms.entities.enums.PostStatus;
import com.hrms.applicationhrms.entities.dtos.PostListDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostDao extends JpaRepository<Post,Integer>, JpaSpecificationExecutor<Post> {

    @Query("Select new com.hrms.applicationhrms.entities.dtos.PostListDto(p.id,p.description,p.positionCount," +
            "p.lastApplyDate,p.jobPosition.positionName,p.releaseDate,p.employer.companyName,p.city.name,p.wayOfWorking.working,p.workingTime.time,p.status) From Post p where p.id=:postId")
    PostListDto getByPostDetail(int postId);

    @Query("Select new com.hrms.applicationhrms.entities.dtos.PostListDto(p.id,p.description,p.positionCount," +
            "p.lastApplyDate,p.jobPosition.positionName,p.releaseDate,p.employer.companyName,p.city.name,p.wayOfWorking.working,p.workingTime.time,p.status) From Post p")
    List<PostListDto> getAll();

    @Query("Select new com.hrms.applicationhrms.entities.dtos.PostListDto(p.id,p.description,p.positionCount," +
            "p.lastApplyDate,p.jobPosition.positionName,p.releaseDate,p.employer.companyName,p.city.name,p.wayOfWorking.working,p.workingTime.time,p.status) From Post p where p.status=:status")
    List<PostListDto> getByStatus(PostStatus status);


    @Query("Select new com.hrms.applicationhrms.entities.dtos.PostListDto(p.id,p.description,p.positionCount," +
        "p.lastApplyDate,p.jobPosition.positionName,p.releaseDate,p.employer.companyName,p.city.name,p.wayOfWorking.working,p.workingTime.time,p.status) From Post p where p.status=:status order by p.releaseDate desc")
    List<PostListDto> getByStatusOrderByReleaseDate(PostStatus status);

    @Query("Select new com.hrms.applicationhrms.entities.dtos.PostListDto(p.id,p.description,p.positionCount," +
            "p.lastApplyDate,p.jobPosition.positionName,p.releaseDate,p.employer.companyName,p.city.name,p.wayOfWorking.working,p.workingTime.time,p.status) From Post p where p.status=:status and p.id =:id")
    PostListDto getByIdAndStatus(int id,PostStatus status);

    @Query("Select new com.hrms.applicationhrms.entities.dtos.PostListDto(p.id,p.description,p.positionCount," +
            "p.lastApplyDate,p.jobPosition.positionName,p.releaseDate,p.employer.companyName,p.city.name,p.wayOfWorking.working,p.workingTime.time,p.status) From Post p  where p.status=:status and p.employer.id =:employerId")
    List<PostListDto> getAllActivesByCompany(int employerId,PostStatus status);

    @Query("From Post p where p.employer.id=:employerId and p.status=:status")
    List<Post> getAllActivesByEmployerId(int employerId,PostStatus status);


}
