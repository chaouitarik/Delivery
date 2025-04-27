package fr.reservation.demo.dto;

import fr.reservation.demo.model.DeliveryMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.ToString;


@ToString
public class ReservationRequestDTO {
    @NotNull(message = "L'ID du créneau ne peut pas être nul")
    private Long timeSlotId;
    
    @NotBlank(message = "L'ID client ne peut pas être vide")
    @Size(min = 5, max = 50, message = "L'ID client doit contenir entre 5 et 50 caractères")
    private String customerId;
    
    @NotBlank(message = "L'adresse de livraison ne peut pas être vide")
    private String deliveryAddress;
    
    @NotNull(message = "Le mode de livraison ne peut pas être nul")
    private DeliveryMode deliveryMode;

    public Long getTimeSlotId() {
        return timeSlotId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public DeliveryMode getDeliveryMode() {
        return deliveryMode;
    }


    public void setTimeSlotId(@NotNull(message = "L'ID du créneau ne peut pas être nul") Long timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public void setCustomerId(@NotBlank(message = "L'ID client ne peut pas être vide") @Size(min = 5, max = 50, message = "L'ID client doit contenir entre 5 et 50 caractères") String customerId) {
        this.customerId = customerId;
    }

    public void setDeliveryAddress(@NotBlank(message = "L'adresse de livraison ne peut pas être vide") String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setDeliveryMode(@NotNull(message = "Le mode de livraison ne peut pas être nul") DeliveryMode deliveryMode) {
        this.deliveryMode = deliveryMode;
    }
}