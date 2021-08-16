package br.gov.al.saude.diarias.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class SituacaoPrestacaoDeContas implements Serializable {

	private static final long serialVersionUID = 6464454988575947161L;

	private int codigo;
	
	private String descricao;
	
	/**
	 * Atributo utilizado para auditar a a��o que o usu�rio
	 * realizou no sistema
	 */
	private int codUsuario;
	
	private String setor;
	
	private Timestamp dat;
		
	public static final int AGUARDANDO_PRESTACAO_DE_CONTAS = 1;
	
	public static final int AGUARDANDO_CONFIRMACAO_DE_PRESTACAO = 2;
	
	public static final int PRESTACAO_DE_CONTAS_CONFIRMADA = 3;
	
	public SituacaoPrestacaoDeContas() {
	}

	public SituacaoPrestacaoDeContas(int codigo, int codUsuario) {
		this.codigo = codigo;
		this.dat = new Timestamp(new java.util.Date().getTime());
		this.codUsuario = codUsuario;
	}
	
	public SituacaoPrestacaoDeContas(int codigo) {
		this.codigo = codigo;
		this.dat = new Timestamp(new java.util.Date().getTime());
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setDat(Timestamp dat) {
		this.dat = dat;
	}

	public Timestamp getDat() {
		return dat;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final SituacaoPrestacaoDeContas other = (SituacaoPrestacaoDeContas) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
}