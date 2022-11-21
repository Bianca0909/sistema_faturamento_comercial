package sistema_faturamento_comercial.domain;

import java.time.LocalDate;

abstract class PessoaDomain {

	Integer id;
	protected String nome;
	protected LocalDate dataNascimento;
	protected String documento;

	protected PessoaDomain() {
	}

	public PessoaDomain(Integer id, String nome, LocalDate dataNascimento, String documento) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.documento = documento;
	}

	protected Integer getId() {
		return id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected LocalDate getDataNascimento() {
		return dataNascimento;
	}

	protected void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	protected String getDocumento() {
		return documento;
	}

	protected void setDocumento(String documento) {
		this.documento = documento;
	}

}
