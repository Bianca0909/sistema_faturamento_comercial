package sistema_faturamento_comercial.domain;

import java.time.LocalDate;

public class ClienteDomain extends PessoaDomain {

	String email;
    LocalDate dataNascimento;
    
	public ClienteDomain() {

	}

	public ClienteDomain(Integer id, String nome, String email, String documento, LocalDate dataNascimento) {
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
