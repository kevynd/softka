package com.softka.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ResponseDto<T> {
    private T data;
    private String messages;

    public ResponseDto() {
    }

    public ResponseDto(T data) {
        this(data, new HashSet());
    }

    public ResponseDto(T data, HashSet hashSet) {
    }

    public void addMessage(String message) {
        this.messages = message;
    }
    
}
