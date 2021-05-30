package com.hrms.applicationhrms.dataAccess.abstracts;

import com.hrms.applicationhrms.entities.concretes.Post;
import com.hrms.applicationhrms.entities.concretes.PostStatus;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostDao extends JpaRepository<Post,Integer> {

    List<Post> getByStatus(PostStatus postStatus);
    List<Post> getByStatus(PostStatus postStatus, Sort sort);
    @Query("From Post where employer.id=:employerId and status =:status")
    List<Post> getAllActivesByCompany(int employerId,PostStatus status);


}
