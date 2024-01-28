package com.example.splitwise.Commands;

import com.example.splitwise.Controllers.UserController;
import com.example.splitwise.Dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserCommand implements Command{
    private UserController userController;
    @Autowired
    public GetUserCommand(UserController userController){
        this.userController=userController;
    }
    @Override
    public boolean canExecute(String input) {
        if(!input.startsWith("get-user")){
           return false;
        }
        if(input.split(" ").length!=2){
            return false;
        }
        return true;
    }

    @Override
    public void execute(String input) {
        //make dtos and call controller
        String[] parts=input.split(" ");
        GetUserRequestDto requestDto=new GetUserRequestDto();

        requestDto.setUserId(Long.parseLong(parts[1]));

        //UserController userController=new UserController();
        GetUserResponseDto responseDto=userController.getUser(Long.parseLong(parts[1]));

        if(responseDto.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            System.out.println(" Name = " +responseDto.getName());
            System.out.println(" UName = " +responseDto.getUname());
        }
        else{
            System.out.println(" user retrieval failed with message "+ responseDto.getMessage());
        }
    }
}
