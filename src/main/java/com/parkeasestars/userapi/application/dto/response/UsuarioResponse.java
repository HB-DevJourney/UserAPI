package com.parkeasestars.userapi.application.dto.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parkeasestars.userapi.infrastructure.entity.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {

    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private String documento;
    private String role;

    public static UsuarioResponse toEntity(UsuarioEntity entity) {
        UsuarioResponse response = new UsuarioResponse();
        response.setNome(entity.getNome());
        response.setSobrenome(entity.getSobrenome());
        response.setEmail(entity.getEmail());
        response.setTelefone(entity.getTelefone());
        response.setDocumento(entity.getDocumento());
        response.setRole(entity.getRole().toString());
        return response;
    }
}
