package com.parkeasestars.userapi.application.usecase;

import com.parkeasestars.userapi.application.dto.request.UsuarioRequest;
import com.parkeasestars.userapi.application.service.UsuarioService;
import com.parkeasestars.userapi.application.service.factory.UsuarioFactory;
import com.parkeasestars.userapi.infrastructure.entity.UsuarioEntity;
import com.parkeasestars.userapi.infrastructure.exception.ConflictException;
import com.parkeasestars.userapi.infrastructure.exception.InvalidUsuarioDataException;
import com.parkeasestars.userapi.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Service
public class UsuarioUseCase {

    private final UsuarioFactory usuarioFactory;
    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;

    public UsuarioEntity criarUsuarioCliente(UsuarioRequest usuarioRequest) {
        validarUsuario(usuarioRequest);
        UsuarioEntity usuario = usuarioFactory.criarUsuarioCliente(usuarioRequest.toUsuarioEntity());
        return usuarioService.salvarUsuario(usuario);
    }

    private void validarUsuario(UsuarioRequest usuario) {
        Optional.ofNullable(usuario)
                .orElseThrow(() -> new InvalidUsuarioDataException("Usuário não pode ser nulo."));

        Map<String, Runnable> validacoes = new HashMap<>();
        validacoes.put("nome",
                () -> {UsuarioValidacaoUtil.verificarCampoObrigatorio(usuario.getNome(), "Nome do usuário");});
        validacoes.put("sobrenome",
                () -> {UsuarioValidacaoUtil.verificarCampoObrigatorio(usuario.getSobrenome(), "Sobrenome do usuário");});
        validacoes.put("email",
                () -> {UsuarioValidacaoUtil.verificarCampoObrigatorio(usuario.getEmail(), "Email do usuário");});
        validacoes.put("senha",
                () -> {UsuarioValidacaoUtil.verificarCampoObrigatorio(usuario.getSenha(), "Senha do usuário");});
        validacoes.put("telefone",
                () -> {UsuarioValidacaoUtil.verificarCampoObrigatorio(usuario.getTelefone(), "Telefone do usuário");});
        validacoes.put("documento",
                () -> {UsuarioValidacaoUtil.verificarDocumento(usuario.getDocumento());});

        validacoes.values().forEach(Runnable::run);

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new ConflictException("O email já está cadastrado.");
        }

        if (usuarioRepository.existsByDocumento(usuario.getDocumento())) {
            throw new ConflictException("Documento já esta cadastrado.");
        }
    }


}

