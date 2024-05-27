package br.com.fiap.nutrivibe.nutrivibe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "TB_PROFISSIONAL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Profissional {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TB_PROFISSIONAL_SEQ"
    )

    @SequenceGenerator(
            name = "TB_PROFISSIONAL_SEQ",
            sequenceName = "TB_PROFISSIONAL_SEQ",
            allocationSize = 1
    )
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String especialidade;

    @Column(name = "preco_plano_anual")
    private BigDecimal precoPlanoAnual;

    @Column(name = "preco_plano_mensal")
    private BigDecimal precoPlanoMensal;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Profissional that = (Profissional) object;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(especialidade, that.especialidade) && Objects.equals(precoPlanoAnual, that.precoPlanoAnual) && Objects.equals(precoPlanoMensal, that.precoPlanoMensal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, especialidade, precoPlanoAnual, precoPlanoMensal);
    }
}
