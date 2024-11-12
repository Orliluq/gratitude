package api.gratitude.repository;

import api.gratitude.model.GratitudeMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GratitudeMessageRepository extends JpaRepository<GratitudeMessage, Long> {
}