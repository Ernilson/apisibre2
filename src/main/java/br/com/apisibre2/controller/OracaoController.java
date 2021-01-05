package br.com.apisibre2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.apisibre2.model.OracaoModel;
import br.com.apisibre2.serviceImpl.OracaoServiceImpl;


@RestController
public class OracaoController {

	
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private OracaoServiceImpl service;

	@GetMapping("/oracao")
	public List<OracaoModel> findAll() {
		return service.listAll();
	}

	/*
	@GetMapping(path = "/{id}")
	public ResponseEntity<OracaoModel> listaPorId(@PathVariable(name = "id") Long id) {
		OracaoModel cad = service.getId(id);
		return ResponseEntity.ok(cad);
	}
	*/

	@PostMapping("/oracao")
	public ResponseEntity savaOracao(@RequestBody OracaoModel cad) {
		this.service.saveOrUpdate(cad);
		sendMail();
		return ResponseEntity.ok("Ok");
	}
/*
	@PutMapping(path = "/{id}")
	public ResponseEntity<Boolean> cadastra(@PathVariable(name = "id") Long id, @RequestBody OracaoModel cm,
			BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return null;
		}
		cm.setId_p(id);
		boolean cad = service.alterar(cm);
		return ResponseEntity.ok(cad);
	}
	*/

	@RequestMapping(path = "/email-envia", method = RequestMethod.GET)
	public String sendMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setText("Alguem fez um pedido de oração pelo site! Glória a Deus sempre!");
		message.setTo("eb656c3f0f-5d2a1a@inbox.mailtrap.io");
		message.setFrom("eb656c3f0f-5d2a1a@inbox.mailtrap.io");
		try {
			mailSender.send(message);
			return "Email enviado com sucesso!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao enviar email.";
		}
	}
}
