package com.example.Email.Reply.Generator.Backend.dto;

import lombok.Data;

@Data
public class EmailRequest {
    private String emailContent;
    private String tone;
}
