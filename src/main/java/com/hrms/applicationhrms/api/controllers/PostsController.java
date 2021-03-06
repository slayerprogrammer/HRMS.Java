package com.hrms.applicationhrms.api.controllers;

import com.hrms.applicationhrms.business.abstracts.PostService;
import com.hrms.applicationhrms.entities.dtos.PostByFilterDto;
import com.hrms.applicationhrms.entities.dtos.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/posts")
public class PostsController {

    private PostService postService;

    @Autowired
    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody PostDto postDto) {
        var result = postService.add(postDto.toNewModel());
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getfilter")
    public ResponseEntity getfilter(PostByFilterDto postByFilterDto){
        var result = postService.getFilter(postByFilterDto);
        if (result.isSuccess()){
            return ResponseEntity.ok
                    (result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getall")
    public ResponseEntity getAll(){
        var result = postService.getAll();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllIsActive")
    public ResponseEntity getAllActives(){
        var result = postService.getAllActives();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllActivesByDate")
    public ResponseEntity getAllActivesByDate(){
        var result = postService.getAllActivesByDate();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getActivesByDate")
    public ResponseEntity getActivesByDate(@RequestParam int postId){
        var result = postService.getActivesByDate(postId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllIsPassive")
    public ResponseEntity getAllIsPassive(){
        var result = postService.getAllPassive();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllIsRejected")
    public ResponseEntity getAllIsRejected(){
        var result = postService.getAllRejections();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllIsWaitingApproval")
    public ResponseEntity getAllIsWaitingApproval(){
        var result = postService.getAllWaitingApproval();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllIsExpired")
    public ResponseEntity getAllIsExpired(){
        var result = postService.getAllExpired();
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getAllActivesByCompany")
    public ResponseEntity getAllActivesByCompany(int employerId){
        var result = postService.getAllActivesByCompany(employerId);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }


}
