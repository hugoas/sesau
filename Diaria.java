import java.io.Serializable;

public class Diaria implements Serializable {

	private static final long serialVersionUID = -6208382928715118833L;
	
	private TipoViagem tipoViagem;
	
	private Categoria categoria;
	
	private float valor;

	public Diaria() {
	}

	public Diaria(TipoViagem tipoViagem, Categoria categoria) {
		this.tipoViagem = tipoViagem;
		this.categoria = categoria;
	}

	public TipoViagem getTipoViagem() {
		return tipoViagem;
	}

	public void setTipoViagem(TipoViagem tipoViagem) {
		this.tipoViagem = tipoViagem;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}
