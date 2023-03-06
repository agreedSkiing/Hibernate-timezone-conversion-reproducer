package se.agreedskiing.hibernate.timezone.spring.boot.two.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.agreedskiing.hibernate.timezone.spring.boot.two.entities.common.Base;
import se.agreedskiing.hibernate.timezone.spring.boot.two.repositories.custom.TimeCustomRepository;

@Repository
public interface TimeRepository
  extends JpaRepository<Base, Long>, TimeCustomRepository {}
