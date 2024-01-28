package com.example.splitwise.Controllers;

import com.example.splitwise.Dtos.*;
import com.example.splitwise.Dtos.ResponseStatus;
import com.example.splitwise.Models.User;
import com.example.splitwise.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    //Here we will have two methods

    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }
@PostMapping("/user/create")
    public CreateUserResponseDto createUser(@RequestBody() CreateUserRequestDto requestDto){
       CreateUserResponseDto responseDto=new CreateUserResponseDto();
       try{
           User savedUser=userService.createUser(requestDto.getName(), requestDto.getUname(),requestDto.getPwd());
           responseDto.setMessage("user created successfully");
           responseDto.setResponseStatus(ResponseStatus.SUCCESS);
           responseDto.setUserId(savedUser.getId());
       }
        catch(Exception ex){
           responseDto.setMessage(ex.getMessage());
           responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
       return responseDto;
    }
@GetMapping("/user/get")
    public GetUserResponseDto getUser(@RequestParam()Long userId){
        GetUserResponseDto responseDto=new GetUserResponseDto();
        try{
            User user=userService.getUser(userId);
            responseDto.setMessage("user found successfully");
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);

            responseDto.setName(user.getName());
            responseDto.setUname(user.getUname());
        }
        catch(Exception ex){
            responseDto.setMessage(ex.getMessage());
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
