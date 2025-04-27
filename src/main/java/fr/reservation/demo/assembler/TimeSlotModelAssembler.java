package fr.reservation.demo.assembler;

import fr.reservation.demo.controller.DeliveryController;
import fr.reservation.demo.dto.TimeSlotDTO;
import fr.reservation.demo.dto.ReservationRequestDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class TimeSlotModelAssembler implements RepresentationModelAssembler<TimeSlotDTO, EntityModel<TimeSlotDTO>> {

    @Override
    public EntityModel<TimeSlotDTO> toModel(TimeSlotDTO timeSlotDTO) {
        return EntityModel.of(timeSlotDTO,
                linkTo(methodOn(DeliveryController.class).createReservation(new ReservationRequestDTO())).withRel("reserve-slot")
        );
    }
}
