package fr.reservation.demo.assembler;

import fr.reservation.demo.controller.DeliveryController;
import fr.reservation.demo.dto.ReservationResponseDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ReservationResponseModelAssembler implements RepresentationModelAssembler<ReservationResponseDTO, EntityModel<ReservationResponseDTO>> {

    @Override
    public EntityModel<ReservationResponseDTO> toModel(ReservationResponseDTO reservationResponseDTO) {
        return EntityModel.of(reservationResponseDTO,
                linkTo(methodOn(DeliveryController.class).getReservation(reservationResponseDTO.getId())).withSelfRel(),
                linkTo(methodOn(DeliveryController.class).getAllDeliveryModes()).withRel("available-modes")
        );
    }
}
