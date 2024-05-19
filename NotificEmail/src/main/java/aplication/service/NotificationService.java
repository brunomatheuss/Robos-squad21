package aplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import aplication.model.Notification;
import aplication.repository.NotificationRepository;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final EmailService emailService;
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    public NotificationService(NotificationRepository notificationRepository, EmailService emailService) {
        this.notificationRepository = notificationRepository;
        this.emailService = emailService;
    }

    @Transactional
    public List<Notification> createNotification(List<Notification> notifications) {
        List<Notification> savedNotifications = notificationRepository.saveAll(notifications);

        for (Notification savedNotification : savedNotifications) {
            try {
                String to = savedNotification.getResponsavel();
                String subject = "Nova Notificação: " + savedNotification.getEvento();
                String text = "Olá,\n\nUma nova notificação foi criada:\n\n" +
                        "Responsável: " + savedNotification.getResponsavel() + "\n" +
                        "Meio De Notificação: " + savedNotification.getMeioDeNotificacao() + "\n" +
                        "Evento: " + savedNotification.getEvento() + "\n" +
                        "Mensagem: " + savedNotification.getMensagem() + "\n" +
                        "Dados do Registro De Execução: " + savedNotification.getDadosDoRegistroDeExecucao() + "\n" +
                        "Atenciosamente,\nEquipe X";

                emailService.sendNotificationEmail(to, subject, text);
            } catch (Exception e) {
                logger.error("Failed to send email for notification id: " + savedNotification.getId(), e);
                
            }
        }

        return savedNotifications;
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
}