package fr.reservation.demo.kafka;


import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import fr.reservation.demo.dto.ReservationRequestDTO;

@Service
public class ReservationProducer {

    private final KafkaTemplate<String, ReservationRequestDTO> kafkaTemplate;
    private static final String TOPIC = "delivery-topic";

    public ReservationProducer(KafkaTemplate<String, ReservationRequestDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendReservationEvent(ReservationRequestDTO reservationRequestDTO) {
        kafkaTemplate.send(TOPIC, reservationRequestDTO);
    }
}
