package com.parkeasestars.userapi.application.usecase;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import com.parkeasestars.userapi.infrastructure.exception.InvalidUsuarioDataException;
import org.springframework.stereotype.Component;

@Component
public class UsuarioValidacaoUtil {

    private UsuarioValidacaoUtil() {}

    public static void verificarCampoObrigatorio(String campo, String nomeCampo) {
        if (campo == null || campo.trim().isEmpty()) {
            throw new InvalidUsuarioDataException(nomeCampo + " é obrigatorio.");
        }
    }

    public static void verificarDocumento(String documento) {

        if (documento == null) {
            throw new InvalidUsuarioDataException("Documento é obrigatório.");
        }

        if (documento.length() != 11 && documento.length() != 14) {
            throw new InvalidUsuarioDataException("Documento inválido. Deve ser CPF (11 dígitos) ou CNPJ (14 dígitos).");
        }

        try {
            CPFValidator cpfValidador = new CPFValidator();
            CNPJValidator cnpjValidador = new CNPJValidator();

            if (documento.length() == 11) {
                cpfValidador.assertValid(documento);
            } else if (documento.length() == 14) {
                cnpjValidador.assertValid(documento);
            }

        } catch (InvalidStateException e) {
            if (documento.length() == 11) {
                throw new InvalidUsuarioDataException("CPF inválido.");
            }
            throw new InvalidUsuarioDataException("CNPJ inválido.");
        } catch (Exception e) {
            throw new InvalidUsuarioDataException("Erro ao validar documento: " + e.getMessage());
        }
    }

}
