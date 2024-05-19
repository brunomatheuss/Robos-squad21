package aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aplication.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
}