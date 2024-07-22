package entities;

@Entity
@Table(name="resultados")
public class Resultado {
	@Id
	@GeneratedValue(strategy= GenerationType. IDENTITY)
	private int idResultado;
	private String url;
	private String tematica;
	private String descripcion;
	
	public Resultado() {}

	public Resultado(int idResultado, String url, String tematica, String descripcion) {
		super();
		this.idResultado = idResultado;
		this.url = url;
		this.tematica = tematica;
		this.descripcion = descripcion;
	}

	public int getIdResultado() {
		return idResultado;
	}

	public void setIdResultado(int idResultado) {
		this.idResultado = idResultado;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
