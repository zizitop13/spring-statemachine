package ru.zizitop.example.spring.service;



public interface MessageService {

     boolean request(String id, String payload);

     boolean isAnswered(String id);

     boolean response(String requestId, String payload);
}
