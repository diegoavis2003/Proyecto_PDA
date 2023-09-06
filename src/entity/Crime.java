package entity;

public class Crime {

	 private String codeCrime;
	 	private boolean paidCrime;
	    private String name;
	    private String description;
	    private double cost;
	    private int prisionTime;
	    private String gravity;
	    
	    
		public Crime() {
			super();
			// TODO Auto-generated constructor stub
			
			
		}
		public Crime(String codeCrime, boolean paidCrime, String name, String description, double cost,
				int prisionTime, String gravity) {
			super();
			this.codeCrime = codeCrime;
			this.paidCrime = paidCrime;
			this.name = name;
			this.description = description;
			this.cost = cost;
			this.prisionTime = prisionTime;
			this.gravity = gravity;
		}
		
		
		public String getCodeCrime() {
			return codeCrime;
		}
		public void setCodeCrime(String codeCrime) {
			this.codeCrime = codeCrime;
		}
		public boolean isPaidCrime() {
			return paidCrime;
		}
		public void setPaidCrime(boolean paidCrime) {
			this.paidCrime = paidCrime;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public double getCost() {
			return cost;
		}
		public void setCost(double cost) {
			this.cost = cost;
		}
		public int getPrisionTime() {
			return prisionTime;
		}
		public void setPrisionTime(int prisionTime) {
			this.prisionTime = prisionTime;
		}
		public String getGravity() {
			return gravity;
		}
		public void setGravity(String gravity) {
			this.gravity = gravity;
		}
		public Object getCodigoDelito() {
			// TODO Auto-generated method stub
			return null;
		}
		public int getTiempoPrision() {
			// TODO Auto-generated method stub
			return 0;
		}
			    
	    


}
