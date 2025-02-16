package com.parkeasestars.userapi.application.service.factory;

import com.parkeasestars.userapi.infrastructure.entity.UsuarioEntity;
import com.parkeasestars.userapi.infrastructure.entity.enums.UsuarioRole;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioFactory {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UsuarioEntity criarUsuarioAdmin (UsuarioEntity usuario) {
        return usuario.toBuilder()
                .senha(encoder.encode(usuario.getSenha()))
                .role(UsuarioRole.ADMIN)
                .build();
    }

    public UsuarioEntity criarUsuarioCliente (UsuarioEntity usuario) {
        return usuario.toBuilder()
                .senha(encoder.encode(usuario.getSenha()))
                .role(UsuarioRole.CLIENTE)
                .build();
    }
}
