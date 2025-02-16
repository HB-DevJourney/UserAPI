package com.parkeasestars.userapi.application.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-12T21:57:41-0300",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioRequestDTO usuarioEntityToUsuarioRequestDTO(UsuarioEntity usuarioEntity) {
        if ( usuarioEntity == null ) {
            return null;
        }

        UsuarioRequestDTO.UsuarioRequestDTOBuilder usuarioRequestDTO = UsuarioRequestDTO.builder();

        usuarioRequestDTO.nome( usuarioEntity.getNome() );
        usuarioRequestDTO.email( usuarioEntity.getEmail() );
        usuarioRequestDTO.senha( usuarioEntity.getSenha() );
        usuarioRequestDTO.cpf( usuarioEntity.getCpf() );
        usuarioRequestDTO.telefone( usuarioEntity.getTelefone() );
        usuarioRequestDTO.role( usuarioEntity.getRole() );

        return usuarioRequestDTO.build();
    }

    @Override
    public UsuarioEntity usuarioRequestDTOToUsuarioEntity(UsuarioRequestDTO usuarioRequestDTO) {
        if ( usuarioRequestDTO == null ) {
            return null;
        }

        UsuarioEntity.UsuarioEntityBuilder usuarioEntity = UsuarioEntity.builder();

        usuarioEntity.nome( usuarioRequestDTO.getNome() );
        usuarioEntity.email( usuarioRequestDTO.getEmail() );
        usuarioEntity.senha( usuarioRequestDTO.getSenha() );
        usuarioEntity.cpf( usuarioRequestDTO.getCpf() );
        usuarioEntity.telefone( usuarioRequestDTO.getTelefone() );
        usuarioEntity.role( usuarioRequestDTO.getRole() );

        return usuarioEntity.build();
    }

    @Override
    public UsuarioResponseDTO usuarioEntityToUsuarioResponseDTO(UsuarioEntity usuarioEntity) {
        if ( usuarioEntity == null ) {
            return null;
        }

        UsuarioResponseDTO.UsuarioResponseDTOBuilder usuarioResponseDTO = UsuarioResponseDTO.builder();

        usuarioResponseDTO.nome( usuarioEntity.getNome() );
        usuarioResponseDTO.email( usuarioEntity.getEmail() );

        return usuarioResponseDTO.build();
    }

    @Override
    public UsuarioEntity usuarioResponseDTOToUsuarioEntity(UsuarioResponseDTO usuarioResponseDTO) {
        if ( usuarioResponseDTO == null ) {
            return null;
        }

        UsuarioEntity.UsuarioEntityBuilder usuarioEntity = UsuarioEntity.builder();

        usuarioEntity.nome( usuarioResponseDTO.getNome() );
        usuarioEntity.email( usuarioResponseDTO.getEmail() );

        return usuarioEntity.build();
    }
}
