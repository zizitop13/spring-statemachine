package ru.zizitop.example.spring.web.model;

public class SimpleMessage {

    private String id;
    private String payload;

    public SimpleMessage(String id){
        this.id = id;
    }


    public SimpleMessage(String id, String payload) {
        this.id = id;
        this.payload = payload;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
