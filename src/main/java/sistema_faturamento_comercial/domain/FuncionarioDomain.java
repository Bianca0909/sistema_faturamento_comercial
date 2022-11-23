package sistema_faturamento_comercial.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FuncionarioDomain extends PessoaDomain {

	private String pis;
	private BigDecimal salario;
	private String funcao;

	public FuncionarioDomain() {
	}

	public FuncionarioDomain(Integer id, String nome, LocalDate dataNascimento, String documento, String pis,
			BigDecimal salario, String funcao) {
		super(id, nome, documento);
		this.pis = pis;
		this.salario = salario;
		this.funcao = funcao;

	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
}
