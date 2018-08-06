package br.com.contasfacil.serverapi.controller;
import br.com.contasfacil.serverapi.models.request.UsuarioLoginRequestDto;
import br.com.contasfacil.serverapi.models.request.UsuarioRegistroRequestDto;
import br.com.contasfacil.serverapi.models.response.UsuarioLoginResponseDto;
import br.com.contasfacil.serverapi.models.response.UsuarioRegistroResponseDto;
import br.com.contasfacil.serverapi.service.GerenciaUsuarioService;
import br.com.contasfacil.serverapi.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("public/usuario")
@RestController
public class UsuarioController {

    @Autowired
    GerenciaUsuarioService gerenciaUsuarioServiceService;

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioLoginResponseDto login(@RequestBody UsuarioLoginRequestDto dto) {

        return loginService.logar(dto.getEmail(), dto.getSenha());
    }

    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioRegistroResponseDto cadastroUsuario(@RequestBody UsuarioRegistroRequestDto dto){
        return gerenciaUsuarioServiceService.cadastrarUsuario(dto);
    }


}
