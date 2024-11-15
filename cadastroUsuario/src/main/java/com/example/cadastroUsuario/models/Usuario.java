package com.example.cadastroUsuario.models;


import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public String email;
    public String senha;
    public String cpf;

    public void setId(Long id)
    {
         this.id = id;
    }

}
