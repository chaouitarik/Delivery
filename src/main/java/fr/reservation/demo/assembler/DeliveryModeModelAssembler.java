package fr.reservation.demo.assembler;


import fr.reservation.demo.controller.DeliveryController;
import fr.reservation.demo.model.DeliveryMode;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class DeliveryModeModelAssembler implements RepresentationModelAssembler<DeliveryMode, EntityModel<DeliveryMode>> {

    @Override
    public EntityModel<DeliveryMode> toModel(DeliveryMode deliveryMode) {
        return EntityModel.of(deliveryMode,
                linkTo(methodOn(DeliveryController.class).getAllDeliveryModes()).withRel("all-modes"),
                linkTo(methodOn(DeliveryController.class).getAvailableTimeSlots(deliveryMode, null, null)).withRel("slots"),
                linkTo(methodOn(DeliveryController.class).getAllDeliveryModes()).withSelfRel()
        );
    }
}
