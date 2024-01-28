package com.example.splitwise.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserResponseDto {
    private Long userId;//we should return user id
    private ResponseStatus responseStatus;
    private String message;
}
