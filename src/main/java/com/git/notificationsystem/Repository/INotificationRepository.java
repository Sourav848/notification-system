package com.git.notificationsystem.Repository;

import com.git.notificationsystem.Model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface INotificationRepository extends MongoRepository<Notification, Integer>{

}
