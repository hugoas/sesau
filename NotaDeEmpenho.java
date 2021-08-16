package br.gov.al.saude.diarias.model;

import java.util.LinkedList;
import java.util.List;

import br.gov.al.saude.rh.model.Servidor;

public class NotaDeEmpenho {

	private int codigo;
	private List<Solicitacao> solicitacaoList;
	private Servidor servidor;
	private String processo;
	private Float valor;

	private Float calculaValor() {
		// TODO Auto-generated method stub
		Float total = 0F;
		for (Solicitacao solicitacao : solicitacaoList)
			total += solicitacao.getValorTotal();

		return total;
	}

	public NotaDeEmpenho(List<Solicitacao> solicitacaoList, Servidor servidor,
			String processo) {
		this.solicitacaoList = solicitacaoList;
		this.servidor = servidor;
		this.processo = processo;
	}

	public NotaDeEmpenho() {
		this.solicitacaoList = new LinkedList<Solicitacao>();
	}

	public List<Solicitacao> getSolicitacaoList() {
		return solicitacaoList;
	}

	public void setSolicitacaoList(List<Solicitacao> solicitacaoList) {
		this.solicitacaoList = solicitacaoList;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public void adicionaSolicitacao(Solicitacao sol) {
		solicitacaoList.add(sol);
	}

	public String getProcesso() {
		return processo;
	}

	public void setProcesso(String processo) {
		this.processo = processo;
	}

	public Float getValor() {
		if (valor == null)
			this.valor = calculaValor();
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final NotaDeEmpenho other = (NotaDeEmpenho) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

}
