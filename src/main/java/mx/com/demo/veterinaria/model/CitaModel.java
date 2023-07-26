package mx.com.demo.veterinaria.model;

public class CitaModel implements java.io.Serializable {

	private static final long serialVersionUID = 3535389129401128953L;
	
	private String idCita;
	private PropietarioModel propietario;
	private VeterinarioModel veterinario;
	private String fechaCita;
	
	public String getIdCita() {
		return idCita;
	}
	public void setIdCita(String idCita) {
		this.idCita = idCita;
	}
	public PropietarioModel getPropietario() {
		return propietario;
	}
	public void setPropietario(PropietarioModel propietario) {
		this.propietario = propietario;
	}
	public VeterinarioModel getVeterinario() {
		return veterinario;
	}
	public void setVeterinario(VeterinarioModel veterinario) {
		this.veterinario = veterinario;
	}
	public String getFechaCita() {
		return fechaCita;
	}
	public void setFechaCita(String fechaCita) {
		this.fechaCita = fechaCita;
	}

	
	
}
