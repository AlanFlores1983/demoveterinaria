package mx.com.demo.veterinaria.model;

public class PacienteModel implements java.io.Serializable {

	private static final long serialVersionUID = 3535389129401128953L;

	private String idPaciente;
	private String nombrePaciente;
	private String tipoPaciente;
	private String fechaNacimiento;
	private String telefono;
	
	public String getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getNombrePaciente() {
		return nombrePaciente;
	}
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
	public String getTipoPaciente() {
		return tipoPaciente;
	}
	public void setTipoPaciente(String tipoPaciente) {
		this.tipoPaciente = tipoPaciente;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
}
