package br.com.fiap.nutrivibe.nutrivibe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "TB_AGENDAMENTO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TB_AGENDAMENTO_SEQ"
    )

    @SequenceGenerator(
            name = "TB_AGENDAMENTO_SEQ",
            sequenceName = "TB_AGENDAMENTO_SEQ",
            allocationSize = 1
    )
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Servico servico;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Agendamento that = (Agendamento) object;
        return Objects.equals(id, that.id) && Objects.equals(dataHora, that.dataHora) && Objects.equals(usuario, that.usuario) && Objects.equals(servico, that.servico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataHora, usuario, servico);
    }
}
