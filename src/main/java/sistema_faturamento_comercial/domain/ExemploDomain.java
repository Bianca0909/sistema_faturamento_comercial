package sistema_faturamento_comercial.domain;

import java.util.Date;

public class ExemploDomain {

	private Integer id;
	private String nome;
	private Date data;
	public ExemploDomain(Integer id, String nome) {
		super();
		this.nome = nome;
		this.id = id;
	}

	public ExemploDomain() {
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

}
