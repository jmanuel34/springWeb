package model;

public class Curso {
	private int CodCurso;
	private String nombre;
	private String tematica;
	private int duracion;
	private double precio;
	
	public Curso() {
		super();
	}

	public Curso(int codCurso, String nombre, String tematica, int duracion, double precio) {
		super();
		CodCurso = codCurso;
		this.nombre = nombre;
		this.tematica = tematica;
		this.duracion = duracion;
		this.precio = precio;
	}

	public int getCodCurso() {
		return CodCurso;
	}

	public void setCodCurso(int codCurso) {
		CodCurso = codCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
}
