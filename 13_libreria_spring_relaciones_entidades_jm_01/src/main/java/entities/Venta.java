package entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table(name="ventas")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVenta;
	@ManyToOne()
	@JoinColumn(name= "idCliente", referencedColumnName = "idCliente")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name= "isbn", referencedColumnName = "idCliente")
	private Libro libro;

// Suprimir con las nuevas clases de fecha. Solo util para antes de Java 8 con java.util.date
//	@Temporal(TemporalType.TIMESTAMP) 
	private LocalDateTime fecha;
	
	public Venta() {}

	public Venta(int idVenta, Cliente cliente, Libro libro, LocalDateTime fecha) {
		super();
		this.idVenta = idVenta;
		this.cliente = cliente;
		this.libro = libro;
		this.fecha = fecha;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
}
