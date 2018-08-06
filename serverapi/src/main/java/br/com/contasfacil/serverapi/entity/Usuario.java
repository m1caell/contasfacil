package br.com.contasfacil.serverapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @Column(name = "IDUSUARIO", precision = 11, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    @Column(name = "SOBRENOME", length = 50, nullable = false)
    private String sobrenome;

    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;

    @Column(name = "SENHA", length = 128, nullable = false)
    private String senha;

}
