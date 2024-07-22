package dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
@Repository
public class CursosDaoImpl implements CursosDao {
	// Es un objeto JPA. Por eso necesita esta anotación. No se inyecta por constructor
	@PersistenceContext
	EntityManager eManager;

	@Transactional
	@Override
	public void save(Curso curso) {
		eManager.persist(curso);
	}

	@Override
	public List<Curso> findByPrecioMax(double precioMax) {
		String jpql="select c from Curso c where c.precio<?1";
		TypedQuery<Curso> query=eManager.createQuery(jpql, Curso.class);
		query.setParameter(1, precioMax);
		return query.getResultList();
	}
	@Transactional
	@Override
	public void deleteCurso(String nombre) {
		String jpql="delete from Curso c where c.nombre=?1";
		Query query=eManager.createQuery(jpql);
		query.setParameter(1, nombre);
		query.executeUpdate();
		
	}

	@Override
	public List<Curso> findByName(String nombre) {
		String jpql="select c from Curso c where c.nombre=?1";
		TypedQuery<Curso> query=eManager.createQuery(jpql, Curso.class);
		query.setParameter(1, nombre);
		return query.getResultList();
	}

}
