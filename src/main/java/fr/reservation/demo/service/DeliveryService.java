package fr.reservation.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.reservation.demo.dto.ReservationRequest;
import fr.reservation.demo.model.DeliveryMode;
import fr.reservation.demo.model.Reservation;
import fr.reservation.demo.model.TimeSlot;
import fr.reservation.demo.repository.ReservationRepository;
import fr.reservation.demo.repository.TimeSlotRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryService {

	private final TimeSlotRepository timeSlotRepository;
	private final ReservationRepository bookingRepository;

	public List<TimeSlot> getAvailableTimeSlots(DeliveryMode deliveryMode) {
		return timeSlotRepository.findByDeliveryModeAndAvailableIsTrue(deliveryMode);
	}

	@Transactional
	public Reservation bookTimeSlot(ReservationRequest request) {
		TimeSlot timeSlot = timeSlotRepository.findById(request.getTimeSlotId())
				.orElseThrow(() -> new IllegalArgumentException("TimeSlot not found"));

		if (!timeSlot.isAvailable()) {
			throw new IllegalStateException("TimeSlot is already booked");
		}

		timeSlot.setAvailable(false);
		timeSlotRepository.save(timeSlot);

		Reservation booking = new Reservation();
		booking.setCustomerId(request.getCustomerId());
		booking.setTimeSlot(timeSlot);

		return bookingRepository.save(booking);
	}
}