
public class Delito {

	 private String codigoDelito;
	 	private boolean pagadoDelito;
	    private String nombre;
	    private String descripcion;
	    private double costo;
	    private int tiempoPrision;
	    private String gravedad;

	    // Constructor
	    public Delito(String codigoDelito, boolean pagado, String nombre, String descripcion, double costo,
				int tiempoPrision, String gravedad) {
			super();
			this.codigoDelito = codigoDelito;
			this.pagadoDelito = pagado;
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.costo = costo;
			this.tiempoPrision = tiempoPrision;
			this.gravedad = gravedad;
		}

		public String getCodigoDelito() {
			return codigoDelito;
		}

		public void setCodigoDelito(String codigoDelito) {
			this.codigoDelito = codigoDelito;
		}

		public boolean isPagado() {
			return pagadoDelito;
		}

		public void setPagado(boolean pagado) {
			this.pagadoDelito = pagado;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public double getCosto() {
			return costo;
		}

		public void setCosto(double costo) {
			this.costo = costo;
		}

		public int getTiempoPrision() {
			return tiempoPrision;
		}

		public void setTiempoPrision(int tiempoPrision) {
			this.tiempoPrision = tiempoPrision;
		}

		public String getGravedad() {
			return gravedad;
		}

		public void setGravedad(String gravedad) {
			this.gravedad = gravedad;
		}

	  


}
