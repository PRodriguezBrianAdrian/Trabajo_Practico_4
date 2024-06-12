package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;

@Component
public class CarreraCollection {
	private List<Carrera> carreras = new ArrayList<>();

	public CarreraCollection() {
		this.carreras = new ArrayList<Carrera>();
		carreras.add(new Carrera("FDS001", "Abogacía", "6", "ACTIVO"));
		carreras.add(new Carrera("FDS002", "Licenciatura en Trabajo Social", "5", "ACTIVO"));
		carreras.add(new Carrera("FDS003", "Licenciatura en Sociología", "5", "ACTIVO"));
		carreras.add(new Carrera("FDS004", "Licenciatura en Ciencia Política", "5", "ACTIVO"));
		carreras.add(new Carrera("FDS005", "Licenciatura en Relaciones Internacionales", "5", "ACTIVO"));
		carreras.add(new Carrera("FDS006", "Licenciatura en Comunicación Social", "5", "ACTIVO"));
		carreras.add(new Carrera("FDS007", "Licenciatura en Antropología", "5", "ACTIVO"));
		carreras.add(new Carrera("FDS008", "Tecnicatura Universitaria en Gestión Jurídica", "3", "ACTIVO"));
		carreras.add(new Carrera("FDS009", "Tecnicatura Universitaria en Resolución de Conflictos", "3", "ACTIVO"));
		carreras.add(new Carrera("FDS010", "Tecnicatura Universitaria en Comunicación Institucional", "3", "ACTIVO"));

	}

	public List<Carrera> getCarreras() {
		return carreras;
	}

	public void setCarreras(List<Carrera> carreras) {
		this.carreras = carreras;
	}

	public List<Carrera> listarCarreras() {
		return carreras;
	}

	public Carrera buscarCarreraPorCodigo(String codigo) {
		for (Carrera carrera : carreras) {
			if (carrera.getCodigo().equals(codigo)) {
				return carrera;
			}
		}
		return null;
	}

	public void modificarCarrera(Carrera carreraModificada) {
		Carrera carreraExistente = buscarCarreraPorCodigo(carreraModificada.getCodigo());
		if (carreraExistente != null) {
			carreraExistente.setCodigo(carreraModificada.getCodigo());
			carreraExistente.setNombre(carreraModificada.getNombre());
			carreraExistente.setCantidadAnios(carreraModificada.getCantidadAnios());
			carreraExistente.setEstado(carreraModificada.getEstado());
		}
	}

	public void eliminarCarrera(String codigo) {
		Carrera carreraAEliminar = buscarCarreraPorCodigo(codigo);
		if (carreraAEliminar != null) {
			carreras.remove(carreraAEliminar);
		}
	}
}