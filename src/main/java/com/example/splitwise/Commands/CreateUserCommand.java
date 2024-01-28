package com.example.splitwise.Commands;

import com.example.splitwise.Controllers.UserController;
import com.example.splitwise.Dtos.CreateUserRequestDto;
import com.example.splitwise.Dtos.CreateUserResponseDto;
import com.example.splitwise.Dtos.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommand implements Command{
    private UserController userController;
    @Autowired
    public CreateUserCommand(UserController userController){
        this.userController=userController;
    }
    @Override
    public boolean canExecute(String input) {
        if(!input.startsWith("create-user")){
           return false;
        }
        if(input.split(" ").length!=4){
            return false;
        }
        return true;
    }

    @Override
    public void execute(String input) {
        //make dtos and call controller
       String[] parts=input.split(" ");
       CreateUserRequestDto requestDto=new CreateUserRequestDto();

       requestDto.setName(parts[1]);
       requestDto.setUname(parts[2]);
       requestDto.setPwd(parts[3]);

       // UserController userController=new UserController();
        CreateUserResponseDto responseDto=userController.createUser(requestDto);

        if(responseDto.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            System.out.println(" user created Successfully with id " + responseDto.getUserId());
        }
        else{
            System.out.println(" user creation failed with message "+ responseDto.getMessage());
        }
    }
}
