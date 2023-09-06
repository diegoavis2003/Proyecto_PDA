package entity;
public class ChargedCrime { 
	
		private Crime crime;
	    private boolean earring;
	    private boolean paid;
	    private double priceAccused;
	    
	    
		
		
		public ChargedCrime(Crime crime, boolean earring, boolean paid, double priceAccused) {
			super();
			this.crime = crime;
			this.earring = earring;
			this.paid = paid;
			this.priceAccused = priceAccused;
		}
		public ChargedCrime(String codeCrime, String name, String description, double cost, int prisionTime,
				String gravity) {
			// TODO Auto-generated constructor stub
		}
		public Crime getCrime() {
			return crime;
		}
		public void setCrime(Crime crime) {
			this.crime = crime;
		}
		public boolean isEarring() {
			return earring;
		}
		public void setEarring(boolean earring) {
			this.earring = earring;
		}
		public boolean isPaid() {
			return paid;
		}
		public void setPaid(boolean paid) {
			this.paid = paid;
		}
		public double getPriceAccused() {
			return priceAccused;
		}
		public void setPriceAccused(double priceAccused) {
			this.priceAccused = priceAccused;
		}

	 
	  
	    
}
