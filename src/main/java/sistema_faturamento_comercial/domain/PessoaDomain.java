package sistema_faturamento_comercial.domain;

import java.time.LocalDate;

abstract class PessoaDomain {

	Integer id;
	protected String nome;
	protected String documento;

	protected PessoaDomain() {
	}

	public PessoaDomain(Integer id, String nome, String documento) {
		this.id = id;
		this.nome = nome;
		this.documento = documento;
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	

}
