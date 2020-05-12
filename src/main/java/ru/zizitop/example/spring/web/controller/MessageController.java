package ru.zizitop.example.spring.web.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zizitop.example.spring.service.MessageService;


@RestController
@SuppressWarnings("unused")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }


    @RequestMapping(path = "/request")
    public boolean request(final String id, final String payload) {
          return messageService.request(id, payload); 
    }

    @RequestMapping(path = "/answered")
    public boolean answered(final String id) {
        return messageService.isAnswered(id);
    }

    @RequestMapping(path = "/response")
    public boolean response(final String requestId, final String payload) {
        return messageService.response(requestId, payload);
    }

}
