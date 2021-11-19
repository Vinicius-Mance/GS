package br.com.control;

import br.com.beans.Usuario;
import br.com.repository.UsuarioRepositorio;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class Controller {

    // Ações
    @Autowired
    private UsuarioRepositorio acoes;

    // Listar usuarios
    @RequestMapping(value = "/listartodos", method = RequestMethod.GET)
    public @ResponseBody
    List<Usuario> listar() {
        return acoes.findAll();
    }

    // Apagar usuário por id
    @RequestMapping(value = "/apagar/{id}", method = RequestMethod.GET)
    public @ResponseBody void apagarUsuario(@PathVariable int id){
        acoes.delete(acoes.findById(id));
    }


    // Cadastrar/alterar usuarios
    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public @ResponseBody
    Usuario cadastrar(@RequestBody Usuario usuario) {
        return acoes.save(usuario);
    }

    // Pegar usuario por id
    @Cacheable("/listar/{id}")
    @RequestMapping(value = "/listar/{id}", method = RequestMethod.GET)
    public @ResponseBody Usuario listarUsuario(@PathVariable int id){
        return acoes.findById(id);
    }

    @CacheEvict(value="limpar")
    @RequestMapping(value = "/limpar", method = RequestMethod.GET)
    public @ResponseBody void limparCache(){

    }
}