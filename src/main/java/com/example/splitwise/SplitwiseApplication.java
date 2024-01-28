package com.example.splitwise;

import com.example.splitwise.Commands.CommandRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {
    private CommandRegistry commandRegistry;
    @Autowired
    public SplitwiseApplication(CommandRegistry commandRegistry){
        this.commandRegistry=commandRegistry;
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }

    //create-user <name> <Uname> <pwd>
    //get-user <user-id>
    //settle-group <group-name>

    // for these 3 requests we have to make 6 dto.


    @Override
    public void run(String... args) throws Exception {
        Scanner sc=new Scanner(System.in);
        while(true){
            String input=sc.nextLine();
            if(input.equals("quit")){
                break;
            }
            else {
                commandRegistry.process(input);
            }
        }
    }
}

