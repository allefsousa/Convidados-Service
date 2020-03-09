package com.developer.allef.convidados.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class StandardError implements Serializable {
    public  int status;
    public String msg;
    public long timeStamp;

    public StandardError(int value, String message, long currentTimeMillis) {
        status = value;
        msg = message;
        timeStamp = currentTimeMillis;
    }
}
