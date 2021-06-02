package com.hrms.applicationhrms.business.abstracts;

import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.entities.concretes.Post;
import com.hrms.applicationhrms.entities.dtos.PostDto;
import com.hrms.applicationhrms.entities.dtos.PostListDto;

import java.util.List;

public interface PostService {

    DataResult<List<Post>> getAll();
    DataResult<List<PostListDto>> getAllActives();
    DataResult<List<PostListDto>> getAllActivesByDate();
    DataResult<List<PostListDto>> getAllPassive();
    DataResult<List<PostListDto>> getAllRejections();
    DataResult<List<PostListDto>> getAllWaitingApproval();
    DataResult<List<PostListDto>> getAllExpired();
    DataResult<List<PostListDto>> getAllActivesByCompany(int employerId);
    DataResult<Post> getById(int id);
    Result add(Post post);
    Result update(Post entity);
    Result delete(Post entity);

}
