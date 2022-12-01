package sistema_faturamento_comercial.domain;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

public class ProdutoDomain {

	private Integer id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private Integer quantidade;
	private Integer marcaId;
	private Integer categoriaId;

	public ProdutoDomain() {

	}

	public ProdutoDomain(Integer id, String nome, String descricao, BigDecimal preco, Integer quantidade,
			Integer marcaId, Integer categoriaId) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
		this.marcaId = marcaId;
		this.categoriaId = categoriaId;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(Integer marcaId) {
		this.marcaId = marcaId;
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	@Override
	public String toString() {
		return this.getNome() + "- R$" + this.getPreco() + "Qtde:  " + " " + this.getQuantidade();
	}

	public void decrementaQuantidade(ProdutoDomain produto, Integer quantidadeVendida) {
		Integer quantidadeAtual;

		if (quantidadeVendida <= produto.getQuantidade()) {
			quantidadeAtual = produto.getQuantidade() - quantidadeVendida;
			produto.setQuantidade(quantidadeAtual);
		} else {
			JOptionPane.showMessageDialog(null, "A quantidade vendida não pode ser maior que a quantidade em estoque");
		}
	}

	public void acrescentaQuantidade(ProdutoDomain produto, Integer quantidadeVendida) {
		Integer quantidadeAtual;

		quantidadeAtual = produto.getQuantidade() + quantidadeVendida;
		produto.setQuantidade(quantidadeAtual);

	}
}
