package com.example.demo.common;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Response {
    private int code;
    private String message;
}
