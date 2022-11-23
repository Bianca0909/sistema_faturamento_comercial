package sistema_faturamento_comercial.domain;

import java.time.LocalDate;

public class ClienteDomain extends PessoaDomain {

	private String email;
	private LocalDate dataNascimento;

	public ClienteDomain() {

	}

	public ClienteDomain(Integer id, String nome, String email, String documento, LocalDate dataNascimento) {
		super(id, nome, documento);
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
