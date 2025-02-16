package com.parkeasestars.userapi.controller;

import com.parkeasestars.userapi.application.dto.request.UsuarioRequest;
import com.parkeasestars.userapi.application.dto.response.UsuarioResponse;
import com.parkeasestars.userapi.application.service.UsuarioService;
import com.parkeasestars.userapi.application.usecase.UsuarioUseCase;
import com.parkeasestars.userapi.infrastructure.entity.UsuarioEntity;
import com.parkeasestars.userapi.response.ApiError;
import com.parkeasestars.userapi.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private final UsuarioUseCase usuarioUseCase;


    @PostMapping("/cadastro")
    public ResponseEntity<ApiResponse<UsuarioResponse>> criarUsuario(@RequestBody @Valid UsuarioRequest request) {
        UsuarioEntity entity = usuarioUseCase.criarUsuarioCliente(request);
        UsuarioResponse response = UsuarioResponse.toEntity(entity);
        ApiResponse<UsuarioResponse> apiResponse = ApiResponse.sucesso(response);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

}
