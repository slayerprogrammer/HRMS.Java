package com.hrms.applicationhrms.business.abstracts;

import com.hrms.applicationhrms.core.utilities.results.DataResult;
import com.hrms.applicationhrms.core.utilities.results.Result;
import com.hrms.applicationhrms.entities.concretes.Post;
import com.hrms.applicationhrms.entities.dtos.PostByFilterDto;
import com.hrms.applicationhrms.entities.dtos.PostListDto;

import java.util.List;

public interface PostService {

    DataResult<List<PostListDto>> getFilter(PostByFilterDto postByFilterDto,int pageNumber);
    DataResult<List<PostListDto>> getAll();
    DataResult<Post> getById(int postId);
    DataResult<PostListDto> getByPostDetail(int postId);
    DataResult<List<PostListDto>> getAllActives();
    DataResult<List<PostListDto>> getAllActivesByDate();
    DataResult<PostListDto> getActivesByDate(int postId);
    DataResult<List<PostListDto>> getAllPassive();
    DataResult<List<PostListDto>> getAllRejections();
    DataResult<List<PostListDto>> getAllWaitingApproval();
    DataResult<List<PostListDto>> getAllExpired();
    DataResult<List<PostListDto>> getAllActivesByCompany(int employerId);
    DataResult<List<Post>> getAllActivesByEmployerId(int employerId);
    DataResult<PostListDto> add(Post post);
    Result update(Post entity);
    Result delete(Post entity);

}
