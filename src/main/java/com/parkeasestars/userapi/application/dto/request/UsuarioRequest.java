package com.parkeasestars.userapi.application.dto.request;

import com.parkeasestars.userapi.infrastructure.entity.UsuarioEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Sobrenome é obrigatório")
    private String sobrenome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Formato de email inválido")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    private String senha;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    @NotBlank(message = "Documento é obrigatório")
    @Pattern(regexp = "\\d{11}|\\d{14}", message = "Documento deve ser CPF (11 dígitos) ou CNPJ (14 dígitos)")
    private String documento;

    public UsuarioEntity toUsuarioEntity() {
        return UsuarioEntity.builder()
                .nome(this.nome)
                .sobrenome(this.sobrenome)
                .email(this.email)
                .senha(this.senha) // Senha será criptografada na Factory
                .telefone(this.telefone)
                .documento(this.documento)
                .build();
    }
}
