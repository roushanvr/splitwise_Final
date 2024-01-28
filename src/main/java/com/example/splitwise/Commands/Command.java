package com.example.splitwise.Commands;
//command sits between client and controller
//client should delegate responsibility of calling controllers to command object
public interface Command {
    boolean canExecute(String input);
    void execute(String input);
}
