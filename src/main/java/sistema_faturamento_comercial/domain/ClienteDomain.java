package sistema_faturamento_comercial.domain;

import java.sql.Date;

public class ClienteDomain {
	Integer id;
	String nome;
	String email;
	String documento;
	Date dataNascimento;

	public ClienteDomain() {

	}

	public ClienteDomain(Integer id, String nome, String email, String documento, Date dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.documento = documento;
		this.dataNascimento = dataNascimento;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
