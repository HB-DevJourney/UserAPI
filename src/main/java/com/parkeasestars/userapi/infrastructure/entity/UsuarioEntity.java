package com.parkeasestars.userapi.infrastructure.entity;

import com.parkeasestars.userapi.infrastructure.entity.enums.UsuarioRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder(toBuilder = true)
@Entity
@Table(name = "usuario")
public class UsuarioEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @Size(min = 3, max = 50)
    @Column(name = "nome")
    private String nome;

    @NotNull @Size(min = 2, max = 50)
    @Column(name = "sobrenome")
    private String sobrenome;

    @NotNull @Email
    @Column(name = "email")
    private String email;

    @NotNull @Size(min = 6)
    @Column(name = "senha")
    private String senha;

    @Pattern(regexp = "^(\\d{10}|\\d{11})$")
    @Column(name = "telefone")
    private String telefone;

    @NotNull @Pattern(regexp = "^(\\d{11}|\\d{14})$")
    @Column(name = "documento")
    private String documento; // Permite CPF, CNPJ

    @Column(name = "role")
    private UsuarioRole role;

}
