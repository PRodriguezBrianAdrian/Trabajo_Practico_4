package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;

@Component
public class AlumnoCollection {
	private List<Alumno> alumnos;

	public AlumnoCollection() {
	    this.alumnos = new ArrayList<Alumno>();
	    alumnos.add(new Alumno("22334455", "Fernando", "Gómez", "fernando.gomez@gmail.com", "01111112222", "1998-09-09", "Calle Rivadavia 123", "LU5432"));
	    alumnos.add(new Alumno("88776655", "Laura", "Silva", "laura.silva@gmail.com", "01133334444", "2000-10-10", "Avenida de Mayo 456", "LU8764"));
	    alumnos.add(new Alumno("44556677", "Pablo", "Torres", "pablo.torres@gmail.com", "01155556666", "1997-11-11", "Calle Mitre 789", "LU6788"));
	    alumnos.add(new Alumno("77665544", "Mariana", "Hernández", "mariana.hernandez@gmail.com", "01177778888", "2001-12-12", "Avenida San Juan 101", "LU3458"));
	}


	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public List<Alumno> listarAlumnos() {
		return alumnos;
	}

	public Alumno buscarAlumnoPorDni(String dni) {
		for (Alumno alumno : alumnos) {
			if (alumno.getDni().equals(dni)) {
				return alumno;
			}
		}
		return null;
	}

	public void modificarAlumno(Alumno alumnoModificado) {
		Alumno alumnoExistente = buscarAlumnoPorDni(alumnoModificado.getDni());

		if (alumnoExistente != null) {
			if (!alumnoExistente.getDni().equals(alumnoModificado.getDni())) {
				Alumno alumnoConNuevoDni = buscarAlumnoPorDni(alumnoModificado.getDni());
				if (alumnoConNuevoDni != null) {
					throw new IllegalArgumentException("El nuevo DNI ya está en uso.");
				}
			}
			alumnoExistente.setDni(alumnoModificado.getDni());
			alumnoExistente.setNombre(alumnoModificado.getNombre());
			alumnoExistente.setApellido(alumnoModificado.getApellido());
			alumnoExistente.setEmail(alumnoModificado.getEmail());
			alumnoExistente.setTelefono(alumnoModificado.getTelefono());
			alumnoExistente.setFechaNacimiento(alumnoModificado.getFechaNacimiento());
			alumnoExistente.setDomicilio(alumnoModificado.getDomicilio());
			alumnoExistente.setLu(alumnoModificado.getLu());
		}
	}

	public void eliminarAlumno(String dni) {
		Alumno alumnoAEliminar = buscarAlumnoPorDni(dni);
		if (alumnoAEliminar != null) {
			alumnos.remove(alumnoAEliminar);
		}
	}
}