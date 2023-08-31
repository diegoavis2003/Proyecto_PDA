import java.util.List;

public class Ciudadano {

	
	    private String fechaNacimiento;
	    private String nombre;
	    private String empleo;
	    private String dni;
	    private List<Delito> delitosImputados;
	    private boolean vivo;
	    private boolean buscado;
	    private double altura;
	    private double peso;
	    private String sexo;

	    // Constructor
	    public Ciudadano(String fechaNacimiento, String nombre, String empleo, String dni, List<Delito> delitosImputados,
	                     boolean vivo, boolean buscado, double altura, double peso, String sexo) {
	        this.fechaNacimiento = fechaNacimiento;
	        this.nombre = nombre;
	        this.empleo = empleo;
	        this.dni = dni;
	        this.delitosImputados = delitosImputados;
	        this.vivo = vivo;
	        this.buscado = buscado;
	        this.altura = altura;
	        this.peso = peso;
	        this.sexo = sexo;
	    }

	    // Getters y Setters

	    public String getFechaNacimiento() {
	        return fechaNacimiento;
	    }

	    public void setFechaNacimiento(String fechaNacimiento) {
	        this.fechaNacimiento = fechaNacimiento;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getEmpleo() {
	        return empleo;
	    }

	    public void setEmpleo(String empleo) {
	        this.empleo = empleo;
	    }

	    public String getDni() {
	        return dni;
	    }

	    public void setDni(String dni) {
	        this.dni = dni;
	    }

	    public List<Delito> getDelitosImputados() {
	        return delitosImputados;
	    }

	    public void setDelitosImputados(List<Delito> delitosImputados) {
	        this.delitosImputados = delitosImputados;
	    }

	    public boolean isVivo() {
	        return vivo;
	    }

	    public void setVivo(boolean vivo) {
	        this.vivo = vivo;
	    }

	    public boolean isBuscado() {
	        return buscado;
	    }

	    public void setBuscado(boolean buscado) {
	        this.buscado = buscado;
	    }

	    public double getAltura() {
	        return altura;
	    }

	    public void setAltura(double altura) {
	        this.altura = altura;
	    }

	    public double getPeso() {
	        return peso;
	    }

	    public void setPeso(double peso) {
	        this.peso = peso;
	    }

	    public String getSexo() {
	        return sexo;
	    }

	    public void setSexo(String sexo) {
	        this.sexo = sexo;
	    }
	}
	
