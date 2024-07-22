package entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table (name="cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCurso;
	private String nombre;
	private int duracion;
	private LocalDate fechaInicio;
	private double precio;
	@ManyToMany()
	@JoinTable(name = "matriculas",
		joinColumns= @JoinColumn(name="usuario", referencedColumnName="usuario"),
		inverseJoinColumns=@JoinColumn(name="idCurso", referencedColumnName = "idCurso"))
		
	private List<Alumno> alumnos;

	public Curso() {}

	public Curso(int idCurso, String nombre, int duracion, LocalDate fechaInicio, double precio) {
		super();
		this.idCurso = idCurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.fechaInicio = fechaInicio;
		this.precio = precio;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
}
