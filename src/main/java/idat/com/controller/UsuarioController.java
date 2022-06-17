package idat.com.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import idat.com.dto.request.Login;
import idat.com.dto.request.UsuarioRegistro;
import idat.com.dto.response.Token;
import idat.com.seguridad.JwtUtil;
import idat.com.seguridad.UserDetailService;
import idat.com.service.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/v1/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	private JwtUtil util;

	@Autowired
	private UserDetailService service;
	
	@Autowired 
	UsuarioServiceImpl serv;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@RequestMapping(path = "/crearToken", method = RequestMethod.POST)
	public ResponseEntity<?> crearToken(@RequestBody Login login){
		
		UserDetails detail = service.loadUserByUsername(login.getUsuario());
		
		return ResponseEntity.ok(new Token(util.generateToken(detail.getUsername())));
	}
	
	


	@RequestMapping(path = "/registrar", method = RequestMethod.POST)
	public ResponseEntity<Object> registrar(@RequestBody UsuarioRegistro usuario){
		
		Map<String, Object> errors = new LinkedHashMap<>();
		Map<String, Object> exito = new LinkedHashMap<>();
	try {
		
		String passwd = encoder.encode(usuario.getPassword());
		usuario.setPassword(passwd);
		serv.registrar(usuario);
		exito.put("message", "Usuario registrado exitosamente");
		return new ResponseEntity<>(exito,HttpStatus.CREATED);
		
	}catch (Exception e) {
		// TODO: handle exception
		errors.put("message", "Error al Registrar");
		return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
	}
		
	
	}
}
