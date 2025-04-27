package fr.reservation.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.reservation.demo.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
