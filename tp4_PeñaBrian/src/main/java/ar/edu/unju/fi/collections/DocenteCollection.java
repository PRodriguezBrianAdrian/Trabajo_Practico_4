package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Docente;

@Component
public class DocenteCollection {
	private List<Docente> docentes = new ArrayList<>();

	public DocenteCollection() {
	    this.docentes = new ArrayList<Docente>();
	    docentes.add(new Docente("L11223", "Laura", "Méndez", "laura.mendez@gmail.com", "+54 381512334"));
	    docentes.add(new Docente("L33445", "Pedro", "Ramírez", "pedro.ramirez@gmail.com", "+54 3815445566"));
	    docentes.add(new Docente("L55667", "Elena", "Martínez", "elena.martinez@gmail.com", "+543815566778"));
	    docentes.add(new Docente("L77889", "David", "López", "david.lopez@gmail.com", "+54381543254"));
	}


	public List<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}

	public List<Docente> listarDocentes() {
		return docentes;
	}

	public Docente buscarDocentePorLegajo(String legajo) {
		for (Docente docente : docentes) {
			if (docente.getLegajo().equals(legajo)) {
				return docente;
			}
		}
		return null;
	}

	public void modificarDocente(Docente docenteModificado) {
		Docente docenteExistente = buscarDocentePorLegajo(docenteModificado.getLegajo());
		if (docenteExistente != null) {
			docenteExistente.setLegajo(docenteModificado.getLegajo());
			docenteExistente.setNombre(docenteModificado.getNombre());
			docenteExistente.setEmail(docenteModificado.getEmail());
			docenteExistente.setApellido(docenteModificado.getApellido());
			docenteExistente.setTelefono(docenteModificado.getTelefono());
		}
	}

	public void eliminarDocente(String legajo) {
		docentes.remove(buscarDocentePorLegajo(legajo));
	}

	public void guardarDocente(Docente docente) {
		docentes.add(docente);
	}

}