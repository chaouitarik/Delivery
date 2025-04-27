package fr.reservation.demo.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.reservation.demo.model.DeliveryMode;
import fr.reservation.demo.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	@Query("SELECT DISTINCT r.deliveryMode FROM Reservation r WHERE r.status = 'ACTIVE'")
	List<DeliveryMode> findActiveDeliveryModes();

	Page<Reservation> findAll(Pageable pageable);

	Page<Reservation> findByDeliveryMode(DeliveryMode deliveryMode, Pageable pageable);

	List<Reservation> findByCustomerIdOrderByReservationDateDesc(String customerId);

	@Query("SELECT r FROM Reservation r WHERE r.reservationDate BETWEEN :start AND :end")
	List<Reservation> findBetweenDates(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

	@Query("SELECT r FROM Reservation r WHERE r.timeSlot.id = :timeSlotId")
	List<Reservation> findByTimeSlotId(@Param("timeSlotId") Long timeSlotId);

	@Query("SELECT COUNT(r) = 0 FROM Reservation r WHERE r.timeSlot.id = :timeSlotId")
	boolean isTimeSlotAvailable(@Param("timeSlotId") Long timeSlotId);

	@Query("SELECT r.deliveryMode, COUNT(r) FROM Reservation r GROUP BY r.deliveryMode")
	List<Object[]> countByDeliveryMode();

	@Query("SELECT r FROM Reservation r JOIN FETCH r.timeSlot WHERE r.id = :id")
	Reservation findWithTimeSlot(@Param("id") Long id);
	
	
    @EntityGraph(attributePaths = {"timeSlot"})
    Optional<Reservation> findWithTimeSlotById(Long id);
   

}
