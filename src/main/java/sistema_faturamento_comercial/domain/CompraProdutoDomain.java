package sistema_faturamento_comercial.domain;

import java.math.BigDecimal;

public class CompraProdutoDomain {

	private Integer id;
	private Integer produtoId;
	private Integer compraId;
	private Integer quantidade;
	private BigDecimal total;

	public CompraProdutoDomain() {

	}

	public CompraProdutoDomain(Integer id,  Integer compraId, Integer produtoId,
			Integer quantidade, BigDecimal total) {
		this.id = id;
		this.produtoId = produtoId;
		this.compraId = compraId;
		this.quantidade = quantidade;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getCompraId() {
		return compraId;
	}

	public void setCompraId(Integer compraId) {
		this.compraId = compraId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal retornaTotal(ProdutoDomain produto, Integer quantidade) {
		BigDecimal valorTotal = produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
		total = valorTotal;
		return total;
		
	}
}
