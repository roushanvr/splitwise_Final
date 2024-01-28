package com.example.splitwise.Commands;

import com.example.splitwise.Controllers.GroupController;
import com.example.splitwise.Controllers.UserController;
import com.example.splitwise.Dtos.*;
import com.example.splitwise.Models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SettleGroupCommand implements Command{
    private GroupController groupController;
    @Autowired
    public SettleGroupCommand(GroupController groupController){
        this.groupController=groupController;
    }
    @Override
    public boolean canExecute(String input) {
        if(!input.startsWith("settle-user")){
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

       SettleGroupRequestDto requestDto=new SettleGroupRequestDto();
       requestDto.setGroupName(parts[1]);

        //GroupController groupController=new GroupController();
        SettleGroupResponseDto responseDto=groupController.settleGroup(requestDto);

        if(responseDto.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            List<Transaction> transactions=responseDto.getTransactions();
            for(Transaction t: transactions){
                System.out.println(t);
            }
        }
        else{
            System.out.println(" Group settlement failed with message "+ responseDto.getMessage());
        }
    }
}
