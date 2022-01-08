package com.example.mail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface MailRepository extends JpaRepository<Mail, Integer> {
public List<Mail> findByFromMail(String id);
public List<Mail> findByToMail(String id);
}
