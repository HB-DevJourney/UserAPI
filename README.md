# **User Service - Microserviço de Usuários**  

## **Descrição**  
O **User Service** é um microsserviço responsável pelo gerenciamento de usuários no sistema de estacionamento. Ele oferece funcionalidades como cadastro, autenticação, gerenciamento de permissões e auditoria de acessos.  

---

## **Tecnologias Utilizadas**  
- **Java 21**  
- **Spring 3.4.X**  
- **Builder Pattern** (para construção de objetos)  
- **UseCase** (para gerenciar a lógica de negócio)  
- **Factory Method** (para criação de usuários)  

---

## **Arquitetura**  
O projeto segue uma arquitetura **baseada em camadas**, com foco na separação de responsabilidades e modularidade. A estrutura de pastas é organizada da seguinte forma:  

### **Estrutura de Pastas**  
```plaintext
└───src
    ├───main
    │   ├───java
    │   │   └───com
    │   │       └───parkeasestars
    │   │           └───userapi
    │   │               │   UserApiApplication.java
    │   │               │
    │   │               ├───adapter
    │   │               ├───application
    │   │               │   ├───dto
    │   │               │   │   ├───Mapper
    │   │               │   │   │       UsuarioMapper.java
    │   │               │   │   │
    │   │               │   │   ├───request
    │   │               │   │   │       LoginRequest.java
    │   │               │   │   │       UsuarioRequest.java
    │   │               │   │   │
    │   │               │   │   └───response
    │   │               │   │           AuthResponse.java
    │   │               │   │           UsuarioResponse.java
    │   │               │   │
    │   │               │   ├───service
    │   │               │   │   │   UsuarioService.java
    │   │               │   │   │
    │   │               │   │   └───factory
    │   │               │   │           UsuarioFactory.java
    │   │               │   │
    │   │               │   └───usecase
    │   │               │       └───usuario
    │   │               │               UsuarioUseCase.java
    │   │               │               UsuarioValidacao.java
    │   │               │
    │   │               ├───controller
    │   │               │   └───v1
    │   │               │           AuthController.java
    │   │               │           UsuarioController.java
    │   │               │
    │   │               ├───infrastructure
    │   │               │   ├───entity
    │   │               │   │   │   UsuarioEntity.java
    │   │               │   │   │
    │   │               │   │   └───enums
    │   │               │   │           UsuarioRole.java
    │   │               │   │
    │   │               │   ├───exception
    │   │               │   │       ConflictException.java
    │   │               │   │       GlobalHandlerException.java
    │   │               │   │       InvalidUsuarioDataException.java
    │   │               │   │       MethodArgumentNotValidException.java
    │   │               │   │       TokenNaoEncontradoException.java
    │   │               │   │       UnauthorizedException.java
    │   │               │   │       UsuarioNaoEncontradoException.java
    │   │               │   │
    │   │               │   ├───repository
    │   │               │   │       UsuarioRepository.java
    │   │               │   │
    │   │               │   └───security
    │   │               │       ├───config
    │   │               │       │       CorsConfig.java
    │   │               │       │       JwtConfig.java
    │   │               │       │       SecurityConfig.java
    │   │               │       │
    │   │               │       ├───filter
    │   │               │       │       JwtRequestFilter.java
    │   │               │       │
    │   │               │       ├───service
    │   │               │       │       UserDetailsServiceImpl.java
    │   │               │       │
    │   │               │       └───util
    │   │               │               JwtUtil.java
    │   │               │
    │   │               └───shared
    │   │                       ApiError.java
    │   │                       ApiResponse.java
    │   │
    │   └───resources
    │           application-prod.properties
    │           application-test.properties
    │           application.properties
    │
    └───test
        └───java
            └───com
                └───parkeasestars
                    └───userapi
```

## **Funcionalidades**  
- Cadastro de usuários (padrão: **CLIENTE**).  
- Autenticação e autorização via **JWT**.  
- Gerenciamento de perfis de acesso (**Roles & Permissões**).  
- Aprovação manual de novos **ADMINs**.  
- Log de auditoria de acessos.  

---

## **Perfis de Usuários**  
| **Role**      | **Descrição**                              |  
|---------------|--------------------------------------------|  
| **CLIENTE**   | Padrão para novos usuários; pode fazer reservas. |  
| **FUNCIONARIO** | Pode gerenciar vagas e verificar reservas. |  
| **ADMIN**     | Acesso total; aprova usuários e gerencia tudo.   |  

---

## **Status do Projeto**  
- **Em desenvolvimento:** O microsserviço ainda não está finalizado.  
- **Testes:** Ainda não implementados.  
- **Dockerização:** Não será realizada no momento.  

---

## **Próximos Passos**  
- Finalizar a implementação dos endpoints.  
- Adicionar testes automatizados.  
- Implementar integração contínua (CI/CD).  

---

## **Desenvolvido por**  
**HB-DevJourney** 🚀  
