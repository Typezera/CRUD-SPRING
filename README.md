# CRUD-SPRING

API RESTful para gerenciamento de usuários em uma aplicação de cadastro, utilizando Spring Boot, JPA, Banco de dados utilizado foi o MySQL.

## Tecnologias:
- Spring Boot
- Java 21
- MySQL
- JPA

## Como utilizar:
1- Acessando a URL: http://localhost:8080/usuario/cadastro <- Será possivel o cadastro de um novo usuário.
2- Acessando a URL: http://localhost:8080/usuario <- A aplicação irá buscar todos os usuários cadastrados.
3- Acessando a URL: http://localhost:8080/usuario/{id} <- A aplicação irá exibir um usuário em específico.
4- Acessando a URL: http://localhost:8080/usuario/atualizar/{id} <- Será possível atualizar um usuário.
5- Acessando a URL: http://localhost:8080/usuario/remover/{id} <- Será possível remover um usuário do banco de dados.

##Explicando como que funciona:
1- Método post ele é acessado através do controlador UsuarioController que para ter acesso ao mesmo se deve utilizar o /usuario,
sabendo disso para acessar o metodo post e criar os primeiros cadastros é necessário usar a url /usuario/cadastro chegando nesta etapa,
é muito importante passar o ResquetBody do usuário em questão, logo após informar todos os campos o usuarioService chama o metodo salvarUsuario(usuario) <- passando todos os dados para ele,
desta forma já é salvo dentro do bando de dados. (O metodo salvarUsuario dentro dele é chamado o usuarioRepository.save, pois nele foi herdado o JpaRepository<Usuario, Long>).

2- Método Get é acessado atráves do mesmo controlador porém a única diferença é que neste caso é apenas fazer a ação de GET, que o mesmo irá trazer todos os usários criados dentro do banco.

3- Existe o Método Get para buscar um usuário em específico, ele apenas recebe um ID que é capturado por um @PathVariable e o mesmo retorna um ResponseEntity<Usuario> já que iremos retornar um usuário em específico.

4- O PUT é acessado atráves do /usuario/atualizar/{id} <- se passa um usuário que a pessoa quer atualizar, se usa um @PathVariable id, e existe @RequestBody que recebe as novas informaçãoes que se quer atualizar.

5- O DELETE é acessado atráves do /remover/{id} <- se passa o id do usuário que se pretende remover, ele também utiliza um ResponseEntity<String> já que retorna uma string...

Em resumo dentro de todos os metodos, chamam uma instancia de UsuarioService que é feita atráves de uma injeção de dependência, dentro do controlador para que desta forma ele apenas tenha a responsabilidade de direcionar as requisições,
e quem vai lidar com as operação do banco será o service junto com o Repository.
