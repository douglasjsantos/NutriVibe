package br.com.fiap.nutrivibe.nutrivibe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "TB_SERVICO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Servico {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TB_SERVICO_SEQ"
    )

    @SequenceGenerator(
            name = "TB_SERVICO_SEQ",
            sequenceName = "TB_SERVICO_SEQ",
            allocationSize = 1
    )
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
    private BigDecimal preco;

    @ManyToOne
    private Profissional profissional;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Servico servico = (Servico) object;
        return Objects.equals(id, servico.id) && Objects.equals(descricao, servico.descricao) && Objects.equals(preco, servico.preco) && Objects.equals(profissional, servico.profissional);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, preco, profissional);
    }
}
