package fr.reservation.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import fr.reservation.demo.model.DeliveryMode;
import fr.reservation.demo.model.TimeSlot;

import java.util.List;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
    List<TimeSlot> findByDeliveryModeAndAvailableIsTrue(DeliveryMode deliveryMode);
}
