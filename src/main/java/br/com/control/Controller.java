package br.com.control;

import br.com.beans.Usuario;
import br.com.repository.UsuarioRepositorio;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class Controller {

//    @RequestMapping(value = "/teste", method = RequestMethod.GET)
//    public @ResponseBody
//    String teste(){
//        return "ok";
//    }

    // Ações
    @Autowired
    private UsuarioRepositorio acoes;

    // Listar usuarios
    @RequestMapping(value = "/listartodos", method = RequestMethod.GET)
    public @ResponseBody
    List<Usuario> listar() {
        return acoes.findAll();
    }

    // Cadastrar usuarios
    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public @ResponseBody
    Usuario cadastrar(@RequestBody Usuario usuario) {
        return acoes.save(usuario);
    }

    // Pegar usuario por id
    @RequestMapping(value = "/listarusuario/{id}", method = RequestMethod.GET)
    public @ResponseBody Usuario listarUsuario(@PathVariable int id){
        return acoes.findById(id);
    }

}