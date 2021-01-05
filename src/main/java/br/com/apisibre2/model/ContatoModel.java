package br.com.apisibre2.model;

import javax.persistence.*;

@Entity
@Table(name = "contato")	
public class ContatoModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_c;
    private String nome;    
    private String email;
    private String assuntoMsg;
    private String conteudoMsg;
    
    public ContatoModel() {
		// TODO Auto-generated constructor stub
	}

	public ContatoModel(Long id_c, String nome, String email, String assuntoMsg, String conteudoMsg) {
		super();
		this.id_c = id_c;
		this.nome = nome;
		this.email = email;
		this.assuntoMsg = assuntoMsg;
		this.conteudoMsg = conteudoMsg;
	}

	public Long getId_c() {
		return id_c;
	}

	public void setId_c(Long id_c) {
		this.id_c = id_c;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAssuntoMsg() {
		return assuntoMsg;
	}

	public void setAssuntoMsg(String assuntoMsg) {
		this.assuntoMsg = assuntoMsg;
	}

	public String getConteudoMsg() {
		return conteudoMsg;
	}

	public void setConteudoMsg(String conteudoMsg) {
		this.conteudoMsg = conteudoMsg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_c == null) ? 0 : id_c.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContatoModel other = (ContatoModel) obj;
		if (id_c == null) {
			if (other.id_c != null)
				return false;
		} else if (!id_c.equals(other.id_c))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ContatoModel [id_c=" + id_c + ", nome=" + nome + ", email=" + email + ", assuntoMsg=" + assuntoMsg
				+ ", conteudoMsg=" + conteudoMsg + "]";
	}	
    
    
}
