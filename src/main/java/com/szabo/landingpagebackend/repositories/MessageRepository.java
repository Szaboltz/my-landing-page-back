package com.szabo.landingpagebackend.repositories;

import com.szabo.landingpagebackend.modals.MessageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageModel, Integer> {

}
