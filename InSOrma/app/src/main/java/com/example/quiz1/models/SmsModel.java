package com.example.quiz1.models;

public class SmsModel {
    public String from;
    public String message;

    public SmsModel(String _from, String _message){
        this.from = _from;
        this.message = _message;
    }
}
