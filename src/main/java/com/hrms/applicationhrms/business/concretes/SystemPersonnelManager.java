package com.hrms.applicationhrms.business.concretes;

import com.hrms.applicationhrms.business.abstracts.*;
import com.hrms.applicationhrms.business.constants.Messages;
import com.hrms.applicationhrms.core.utilities.results.*;
import com.hrms.applicationhrms.dataAccess.abstracts.SystemPersonnelDao;
import com.hrms.applicationhrms.entities.concretes.Employer;
import com.hrms.applicationhrms.entities.concretes.EmployerProfileUpdate;
import com.hrms.applicationhrms.entities.concretes.Post;
import com.hrms.applicationhrms.entities.dtos.PostListDto;
import com.hrms.applicationhrms.entities.enums.EmployerStatus;
import com.hrms.applicationhrms.entities.enums.PostStatus;
import com.hrms.applicationhrms.entities.concretes.SystemPersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemPersonnelManager implements SystemPersonnelService {

    private SystemPersonnelDao systemPersonnelDao;
    private EmployerService employerService;
    private EmployerProfileUpdateService employerProfileUpdateService;
    private PostService postService;

    @Autowired
    public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao,EmployerService employerService,
                                  PostService postService,EmployerProfileUpdateService employerProfileUpdateService) {
        this.systemPersonnelDao = systemPersonnelDao;
        this.employerService = employerService;
        this.postService = postService;
        this.employerProfileUpdateService = employerProfileUpdateService;
    }

    @Override
    public DataResult<List<SystemPersonnel>> getAll() {
        return null;
    }

    @Override
    public DataResult<SystemPersonnel> getById(int id) {
        return new SuccessDataResult<>(this.systemPersonnelDao.findById(id).get());
    }

    @Override
    public DataResult<SystemPersonnel> add(SystemPersonnel entity) {
        return null;
    }

    @Override
    public DataResult<SystemPersonnel> update(SystemPersonnel entity) {
        this.systemPersonnelDao.save(entity);
        return new SuccessDataResult<>(entity);
    }

    @Override
    public DataResult<SystemPersonnel> delete(SystemPersonnel entity) {
        return null;
    }

    @Override
    public DataResult<Employer> activeEmployerRegistration(int employerId) {
        var employer = this.employerService.getById(employerId).getData();
        employer.setStatus(EmployerStatus.values()[2]);
        var result = this.employerService.update(employer);
        if(!result.isSuccess()) {
            return new ErrorDataResult<>(Messages.approvedEmployerError(employer.getCompanyName()));
        }
        return new SuccessDataResult<>(employer,Messages.approvedEmployer(employer.getCompanyName()));
    }

    @Override
    public DataResult<Employer> employerProfileUpdateAccept(int employerId) {
        var result = this.employerProfileUpdateService.getByEmployerId(employerId).getData();
        var employer = this.employerService.getById(employerId).getData();
        employer.setEmail(result.getEmail());
        employer.setCompanyName(result.getCompanyName());
        employer.setDescription(result.getDescription());
        employer.setPhoneNumber(result.getPhoneNumber());
        employer.setWebSite(result.getWebSite());
        this.employerService.update(employer);
        this.employerProfileUpdateService.delete(result);
        return new SuccessDataResult<>(employer);
    }

    @Override
    public DataResult<EmployerProfileUpdate> employerProfileUpdateReject(int employerId) {
        var result = this.employerProfileUpdateService.getByEmployerId(employerId).getData();
        this.employerProfileUpdateService.delete(result);
        return new SuccessDataResult<>(result);
    }

    @Override
    public DataResult<Employer> rejectEmployerRegistration(int employerId) {
        var employer = this.employerService.getById(employerId).getData();
        employer.setStatus(EmployerStatus.values()[1]);
        var result = this.employerService.update(employer);
        if(!result.isSuccess()) {
            return new ErrorDataResult<>(Messages.rejectEmployerError(employer.getCompanyName()));
        }
        return new SuccessDataResult<>(employer,Messages.rejectEmployer(employer.getCompanyName()));
    }

    @Override
    public DataResult<Employer> passiveEmployerRegistration(int employerId) {
        var employer = this.employerService.getById(employerId).getData();
        employer.setStatus(EmployerStatus.values()[3]);
        this.employerService.update(employer);
        List<Post> posts = this.postService.getAllActivesByEmployerId(employerId).getData();
        for (Post post:posts) {
            post.setStatus(PostStatus.values()[3]);
            this.postService.update(post);
        }
        return new SuccessDataResult<>(employer,Messages.passiveEmployer(employer.getCompanyName()));
    }

    @Override
    public DataResult<PostListDto> activePost(int postId) {
        var post = this.postService.getById(postId).getData();
        post.setStatus(PostStatus.values()[2]);
        var result = this.postService.update(post);
        if(!result.isSuccess()) {
            return new ErrorDataResult<>(Messages.activePostError());
        }
        PostListDto dto = postService.getByPostDetail(postId).getData();
        return new SuccessDataResult<>(dto,Messages.activatedPost());
    }

    @Override
    public DataResult<PostListDto> passivePost(int postId) {
        var post = this.postService.getById(postId).getData();
        post.setStatus(PostStatus.values()[3]);
        var result = this.postService.update(post);
        if(!result.isSuccess()) {
            return new ErrorDataResult<>(Messages.passivePostError());
        }
        PostListDto dto = postService.getByPostDetail(postId).getData();
        return new SuccessDataResult<>(dto,Messages.passivePost());
    }

    @Override
    public DataResult<PostListDto> rejectPost(int postId) {
        var post = this.postService.getById(postId).getData();
        post.setStatus(PostStatus.values()[1]);
        var result = this.postService.update(post);
        if(!result.isSuccess()) {
            return new ErrorDataResult<>(Messages.rejectPostError());
        }
        PostListDto dto = postService.getByPostDetail(postId).getData();
        return new SuccessDataResult<>(dto,Messages.rejectPost());
    }
}
