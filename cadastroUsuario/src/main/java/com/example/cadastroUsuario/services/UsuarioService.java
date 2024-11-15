package com.example.cadastroUsuario.services;

import com.example.cadastroUsuario.models.Usuario;
import com.example.cadastroUsuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService
{
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario)
    {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarUsuarioId(Long id)
    {
        return usuarioRepository.findById(id);
    }

    public List<Usuario> listarTodos()
    {
        return usuarioRepository.findAll();
    }

    public void deletarUsuario(Long Id)
    {
         usuarioRepository.deleteById(Id);
    }

    public Usuario atualizarUsuario(Long id, Usuario cadastro)
    {
        if(usuarioRepository.existsById(id))
        {
            cadastro.setId(id);
            return usuarioRepository.save(cadastro);
        }
        return null;
    }
}
