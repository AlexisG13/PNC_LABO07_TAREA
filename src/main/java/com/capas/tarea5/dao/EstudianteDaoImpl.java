package com.capas.tarea5.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.capas.tarea5.domain.Estudiante;

@Repository
public class EstudianteDaoImpl implements EstudianteDAO{

	@PersistenceContext(unitName = "capas")
	private EntityManager entityManager;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.Estudiante");
		Query query = entityManager.createNativeQuery(sb.toString(), Estudiante.class);
		List<Estudiante> resulset = query.getResultList();
		return resulset;
	}

	@Transactional
	@Override
	public void insert(Estudiante estudiante) throws DataAccessException {
		entityManager.persist(estudiante);
	}
	
	@Override
	@Transactional
	public void delete(Integer codigoEstudiante) throws DataAccessException {
		Estudiante estudiante = entityManager.find(Estudiante.class, codigoEstudiante);
		entityManager.remove(estudiante);
	}

}
