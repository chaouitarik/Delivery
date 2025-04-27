package fr.reservation.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationRequest {
    private Long timeSlotId;
    private String customerId;
}