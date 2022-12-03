package sistema_faturamento_comercial.domain;

import java.time.LocalDate;

public class CompraDomain {

	private Integer id;
	private Integer clienteId;
	private Integer enderecoId;
	private LocalDate dataCompra;
	private String formaPagamento;

	public CompraDomain() {

	}

	public CompraDomain(Integer id, LocalDate dataCompra, String formaPagamento, Integer clienteId,
			Integer enderecoId) {
		this.id = id;
		this.clienteId = clienteId;
		this.enderecoId = enderecoId;
		this.dataCompra = dataCompra;
		this.formaPagamento = formaPagamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public Integer getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Integer enderecoId) {
		this.enderecoId = enderecoId;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@Override
	public String toString() {
		return this.id + " " + this.dataCompra;
	}

}
