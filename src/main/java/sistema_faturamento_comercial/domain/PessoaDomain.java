package sistema_faturamento_comercial.domain;

abstract class PessoaDomain {

	protected Integer id;
	protected String nome;
	protected String documento;

	public PessoaDomain() {
	}

	public PessoaDomain(Integer id, String nome,String documento) {
		super();
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
