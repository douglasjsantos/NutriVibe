package br.com.fiap.nutrivibe.nutrivibe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity(name = "TB_FEEDBACK")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TB_FEEDBACK_SEQ"
    )

    @SequenceGenerator(
            name = "TB_FEEDBACK_SEQ",
            sequenceName = "TB_FEEDBACK_SEQ",
            allocationSize = 1
    )
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comentario;

    @ManyToOne
    private Agendamento agendamento;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Feedback feedback = (Feedback) object;
        return Objects.equals(id, feedback.id) && Objects.equals(comentario, feedback.comentario) && Objects.equals(agendamento, feedback.agendamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comentario, agendamento);
    }
}
