
public class DelitoImputado {

	 private Delito delito;
	    private boolean pendiente;
	    private boolean pagado;
	    private double precioImputado;

	    // Constructor
	    public DelitoImputado(Delito delito, boolean pendiente, boolean pagado, double precioImputado) {
	        this.delito = delito;
	        this.pendiente = pendiente;
	        this.pagado = pagado;
	        this.precioImputado = precioImputado;
	    }

	    // Getters y Setters

	    public Delito getDelito() {
	        return delito;
	    }

	    public void setDelito(Delito delito) {
	        this.delito = delito;
	    }

	    public boolean isPendiente() {
	        return pendiente;
	    }

	    public void setPendiente(boolean pendiente) {
	        this.pendiente = pendiente;
	    }

	    public boolean isPagado() {
	        return pagado;
	    }

	    public void setPagado(boolean pagado) {
	        this.pagado = pagado;
	    }

	    public double getPrecioImputado() {
	        return precioImputado;
	    }

	    public void setPrecioImputado(double precioImputado) {
	        this.precioImputado = precioImputado;
	    }
}
