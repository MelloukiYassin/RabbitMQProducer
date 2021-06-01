package org.rabbitmq.training1.repositories;

import org.rabbitmq.training1.entities.Scholar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScholarRepository extends JpaRepository<Scholar, Long> {
}
