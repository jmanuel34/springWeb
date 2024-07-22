package dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.Curso;


@Repository

public class CursosDaoImpl implements CursosDao {
//	@Autowired
	JdbcTemplate template;
	
	public CursosDaoImpl() {
		super();
	}
	
	public CursosDaoImpl(JdbcTemplate template) {
		super();
		this.template = template;
	}
	
	@Override
	public void save(Curso curso) {
		template.update("Insert into cursos (nombre, tematica, duracion, precio)"
				+ " values(?,?,?,?)",
				curso.getNombre(),
				curso.getTematica(),
				curso.getDuracion(),
				curso.getPrecio()
				);

	}


	@Override
	public List<Curso> findByPrecio(double precio) {
// 		String sql = "Select * from resultados where tematica = ?";
		String sql = "Select * from cursos where precio < ?";
		RowMapper<Curso> mapper = (r,f)->new Curso( r.getInt("codCurso"),
											r.getString("nombre"),
											r.getString("tematica"),
											r.getInt("duracion"),
											r.getDouble("precio")
										);
		return template.query(sql, mapper, precio);
	}

	@Override
	public void eliminar(String nombre) {
		template.update("Delete from cursos where codCurso=?", nombre);

	}

	@Override
	public Curso findByName(String nombre) {
/*
		String sql = "Select * from cursos where nombre= ?";
		RowMapper<Curso> mapper = (r,f)->new Curso( r.getInt("codCurso"),
											r.getString("nombre"),
											r.getString("tematica"),
											r.getInt("duracion"),
											r.getDouble("precio")
										);
		return template.query(sql, mapper, nombre).getFirst();
	//*/
		String sql = "Select * from cursos where nombre= ?";
		try {
			return template.queryForObject(sql, (r,f)->new Curso( r.getInt("codCurso"),
					r.getString("nombre"),
					r.getString("tematica"),
					r.getInt("duracion"),
					r.getDouble("precio")), nombre);
		}catch(EmptyResultDataAccessException ex) {
			return null;
		}
	}



	@Override
	public double averageByTematica(String tematica) {
		String sql = "Select avg(precio) from cursos where tematica=?";
		return template.queryForObject(sql, Double.class, tematica);
	}
	
	

}
