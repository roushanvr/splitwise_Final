package com.example.splitwise.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserResponseDto {
    private String name;
    private String uname;
    //Lets not return password -> sensitive info
    private ResponseStatus responseStatus;
    private String message;
}
