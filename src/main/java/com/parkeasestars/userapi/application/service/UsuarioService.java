package com.parkeasestars.userapi.application.service;

import com.parkeasestars.userapi.infrastructure.entity.UsuarioEntity;
import com.parkeasestars.userapi.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioEntity salvarUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

}
