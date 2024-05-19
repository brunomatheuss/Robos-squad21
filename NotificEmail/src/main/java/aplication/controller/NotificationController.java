package aplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import aplication.model.Notification;
import aplication.service.NotificationService;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("email")
public class NotificationController {

    private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

    private NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public List<Notification> createNotifications(@RequestBody List<Notification> notifications) {
        logger.info("Recebida solicitação para criar novas notificações: {}", notifications);
        List<Notification> createdNotifications = notificationService.createNotification(notifications);
        logger.info("Notificações criadas com sucesso: {}", createdNotifications);
        return createdNotifications;
    }
    

    @GetMapping
    public List<Notification> getAllNotifications() {
        logger.info("Recebida solicitação para obter todas as notificações");
        List<Notification> notifications = notificationService.getAllNotifications();
        logger.info("Notificações recuperadas com sucesso: {}", notifications);
        return notifications;
    }
    
    @PostMapping("create-example")
    public List<Notification> createExampleNotification() {
        Notification notification = new Notification();
        notification.setResponsavel("robo@example.com");
        notification.setMeioDeNotificacao("email");
        notification.setEvento("Em Execucao");
        notification.setMensagem("Esta é a primeira notificação de teste");
        notification.setDadosDoRegistroDeExecucao("nome: ,horario: ");

     
        List<Notification> notifications = new ArrayList<>();
        notifications.add(notification);

        
        return notificationService.createNotification(notifications);
    }
}