package br.com.apisibre2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="oracao")
public class OracaoModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_p;
    private String nome;    
    private String email;
    private String msg;
    
    public OracaoModel() {
		// TODO Auto-generated constructor stub
	}

	public OracaoModel(Long id_p, String nome, String email, String msg) {
		super();
		this.id_p = id_p;
		this.nome = nome;
		this.email = email;		
		this.msg = msg;
	}

	public Long getId_p() {
		return id_p;
	}

	public void setId_p(Long id_p) {
		this.id_p = id_p;
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_p == null) ? 0 : id_p.hashCode());
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
		OracaoModel other = (OracaoModel) obj;
		if (id_p == null) {
			if (other.id_p != null)
				return false;
		} else if (!id_p.equals(other.id_p))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OracaoModel [id_p=" + id_p + ", nome=" + nome + ", email=" + email + ", msg=" + msg + "]";
	}

	
}