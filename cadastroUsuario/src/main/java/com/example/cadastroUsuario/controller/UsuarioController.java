package com.example.cadastroUsuario.controller;

import com.example.cadastroUsuario.models.Usuario;
import com.example.cadastroUsuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController
{
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrarUser(@RequestBody Usuario usuario)
    {
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok("Usuario criado com sucesso");
    }

    @GetMapping
    public List<Usuario> usuariosCadastrados()
    {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> encontrarUserId(@PathVariable Long id)
    {
        Optional<Usuario> usuario = usuarioService.buscarUsuarioId(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario)
    {
        usuarioService.atualizarUsuario(id, usuario);
        return ResponseEntity.ok("Usuario Atualizado com sucesso!");
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<String> deletarUserId(@PathVariable Long id)
    {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.ok("Usuario deletado com sucesso!");
    }
}
