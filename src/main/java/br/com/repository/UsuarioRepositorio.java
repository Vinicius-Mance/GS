package br.com.repository;

import java.util.List;

import br.com.beans.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer>{

    //Listar todos os ususarios
    List<Usuario> findAll();

    //Pesquisar por id
    Usuario findById (int id);

    //Remover por código
    void delete(Usuario usuario);

    //Cadastrar/Alterar aluno
    <UsuarioMod extends Usuario> UsuarioMod save(UsuarioMod usuario);
}

