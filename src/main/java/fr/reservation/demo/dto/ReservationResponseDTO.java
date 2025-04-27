package fr.reservation.demo.dto;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.hateoas.RepresentationModel;

import fr.reservation.demo.model.DeliveryMode;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ReservationResponseDTO extends RepresentationModel<ReservationResponseDTO> {
	private Long id;
	private String customerId;
	private DeliveryMode deliveryMode;
	private LocalDate reservationDate;
	private String status;
	private String deliveryAddress;
	private TimeSlotDTO timeSlot;
	private LocalTime startTime;
	private LocalTime endTime;

	public boolean isConfirmed() {
		return "CONFIRMED".equalsIgnoreCase(status);
	}

	public boolean isCancellable() {
		return isConfirmed() && reservationDate.isAfter(LocalDate.now().plusDays(1));
	}
	public Long getId() {
		return id;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private Long id;
		private String customerId;
		private DeliveryMode deliveryMode;
		private LocalDate reservationDate;
		private String status;
		private String deliveryAddress;
		private TimeSlotDTO timeSlot;
		private LocalTime startTime;
		private LocalTime endTime;

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder customerId(String customerId) {
			this.customerId = customerId;
			return this;
		}

		public Builder deliveryMode(DeliveryMode deliveryMode) {
			this.deliveryMode = deliveryMode;
			return this;
		}

		public Builder reservationDate(LocalDate reservationDate) {
			this.reservationDate = reservationDate;
			return this;
		}

		public Builder status(String status) {
			this.status = status;
			return this;
		}

		public Builder deliveryAddress(String deliveryAddress) {
			this.deliveryAddress = deliveryAddress;
			return this;
		}

		public Builder timeSlot(TimeSlotDTO timeSlot) {
			this.timeSlot = timeSlot;
			return this;
		}

		public Builder startTime(LocalTime startTime) {
			this.startTime = startTime;
			return this;
		}

		public Builder endTime(LocalTime endTime) {
			this.endTime = endTime;
			return this;
		}

		public ReservationResponseDTO build() {
			ReservationResponseDTO dto = new ReservationResponseDTO();
			dto.id = this.id;
			dto.customerId = this.customerId;
			dto.deliveryMode = this.deliveryMode;
			dto.reservationDate = this.reservationDate;
			dto.status = this.status;
			dto.deliveryAddress = this.deliveryAddress;
			dto.timeSlot = this.timeSlot;
			dto.startTime = this.startTime;
			dto.endTime = this.endTime;
			return dto;
		}
	}

}