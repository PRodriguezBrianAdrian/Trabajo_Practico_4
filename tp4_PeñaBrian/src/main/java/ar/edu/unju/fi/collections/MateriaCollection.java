package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.model.Docente;

@Component
public class MateriaCollection {
	private List<Materia> materias = new ArrayList<>();
	private DocenteCollection docenteCollection;

	public MateriaCollection(DocenteCollection docenteCollection) {
		this.docenteCollection = docenteCollection;
		List<Docente> docentes = docenteCollection.getDocentes();
		materias.add(new Materia("FDS001", "Derecho Constitucional", "Abogacía", "60 horas", "Presencial", docentes.get(0)));
		materias.add(new Materia("FDS002", "Derecho Penal", "Abogacía", "60 horas", "Presencial", docentes.get(1)));
		materias.add(new Materia("FDS003", "Trabajo Social Comunitario", "Licenciatura en Trabajo Social", "60 horas", "Presencial", docentes.get(2)));
		materias.add(new Materia("FDS004", "Teoría Sociológica", "Licenciatura en Sociología", "60 horas", "Virtual", docentes.get(3)));
		materias.add(new Materia("FDS005", "Política Comparada", "Licenciatura en Ciencia Política", "60 horas", "Presencial", docentes.get(0)));
		materias.add(new Materia("FDS006", "Relaciones Internacionales", "Licenciatura en Relaciones Internacionales", "45 horas", "Presencial", docentes.get(1)));
		materias.add(new Materia("FDS007", "Comunicación y Sociedad", "Licenciatura en Comunicación Social", "45 horas", "Presencial", docentes.get(2)));
		materias.add(new Materia("FDS008", "Antropología Cultural", "Licenciatura en Antropología", "45 horas", "Presencial", docentes.get(3)));
		materias.add(new Materia("FDS009", "Derecho Administrativo", "Tecnicatura Universitaria en Gestión Jurídica", "45 horas", "Presencial", docentes.get(0)));
		materias.add(new Materia("FDS010", "Resolución de Conflictos", "Tecnicatura Universitaria en Resolución de Conflictos", "45 horas", "Presencial", docentes.get(1)));

	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public List<Materia> listarMaterias() {
		return materias;
	}

	public Materia buscarMateriaPorCodigo(String codigo) {
		for (Materia materia : materias) {
			if (materia.getCodigo().equals(codigo)) {
				return materia;
			}
		}
		return null;
	}

	public void modificarMateria(Materia materiaModificada) {
		Materia materiaExistente = buscarMateriaPorCodigo(materiaModificada.getCodigo());
		if (materiaExistente != null) {
			materiaExistente.setCodigo(materiaModificada.getCodigo());
			materiaExistente.setNombre(materiaModificada.getNombre());
			materiaExistente.setDocente(materiaModificada.getDocente());
			materiaExistente.setCurso(materiaModificada.getCurso());
			materiaExistente.setCantidadHoras(materiaModificada.getCantidadHoras());
			materiaExistente.setModalidad(materiaModificada.getModalidad());
		}
	}

	public void eliminarMateria(String codigo) {
		Materia materia = buscarMateriaPorCodigo(codigo);
		if (materia != null) {
			materias.remove(materia);
		}
	}

	public void guardarMateria(Materia materia) {
		materias.add(materia);
	}

	public DocenteCollection getDocenteCollection() {
		return docenteCollection;
	}

	public void setDocenteCollection(DocenteCollection docenteCollection) {
		this.docenteCollection = docenteCollection;
	}

}