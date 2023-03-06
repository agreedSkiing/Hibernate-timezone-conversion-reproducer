package se.agreedskiing.hibernate.timezone.spring.boot.three.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.agreedskiing.hibernate.timezone.spring.boot.three.entities.common.Base;
import se.agreedskiing.hibernate.timezone.spring.boot.three.repositories.custom.TimeCustomRepository;

@Repository
public interface TimeRepository
  extends JpaRepository<Base, Long>, TimeCustomRepository {}
