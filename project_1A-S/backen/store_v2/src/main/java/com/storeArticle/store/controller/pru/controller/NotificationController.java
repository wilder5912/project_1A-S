package com.storeArticle.store.controller.pru.controller;

import com.storeArticle.store.controller.pru.model.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

/*
@Controller
@RestController
@RequestMapping(value="/articleDetail")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
* */
@Controller
@RestController
@RequestMapping(value="/pru")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate template;

    private Notifications notifications = new Notifications(0);

    //@GetMapping("/notify")
    @GetMapping(value = "/notify")
    public Notifications getNotification() {

        notifications.increment();

        template.convertAndSend("/topic/notification2", notifications);

        return notifications;
    }
}
