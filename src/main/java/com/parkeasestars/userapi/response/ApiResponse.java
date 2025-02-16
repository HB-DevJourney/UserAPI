package com.parkeasestars.userapi.response;

public record ApiResponse<T>(String mensagem, T dados ) {

    public static <T> ApiResponse<T> sucesso(T dados) {
        return new ApiResponse<>("Operação realizada com sucesso", dados);
    }

}
