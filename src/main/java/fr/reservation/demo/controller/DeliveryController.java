package fr.reservation.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import fr.reservation.demo.dto.ReservationRequest;
import fr.reservation.demo.model.DeliveryMode;
import fr.reservation.demo.model.Reservation;
import fr.reservation.demo.model.TimeSlot;
import fr.reservation.demo.service.DeliveryService;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @GetMapping("/modes")
    public DeliveryMode[] getDeliveryModes() {
        return DeliveryMode.values();
    }

    @GetMapping("/timeslots")
    public List<TimeSlot> getAvailableTimeSlots(@RequestParam DeliveryMode mode) {
        return deliveryService.getAvailableTimeSlots(mode);
    }

    @PostMapping("/book")
    public Reservation bookTimeSlot(@RequestBody ReservationRequest request) {
        return deliveryService.bookTimeSlot(request);
    }
}
