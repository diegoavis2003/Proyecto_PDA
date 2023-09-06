package entity;
import java.util.List;

public class Citizen { 
	
	    private String dateBirth;
	    private String name;
	    private String employment;
	    private String dni;
	    private List<Crime> chargedCrime;
	    private boolean alive;
	    private boolean search;
	    private double height;
	    private double weight;
	    private String gender;
	    
	    
		public Citizen() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Citizen(String dateBirth, String name, String employment, String dni, List<Crime> chargedCrime,
				boolean alive, boolean search, double height, double weight, String gender) {
			super();
			this.dateBirth = dateBirth;
			this.name = name;
			this.employment = employment;
			this.dni = dni;
			this.chargedCrime = chargedCrime;
			this.alive = alive;
			this.search = search;
			this.height = height;
			this.weight = weight;
			this.gender = gender;
		}


		public String getDateBirth() {
			return dateBirth;
		}


		public void setDateBirth(String dateBirth) {
			this.dateBirth = dateBirth;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getEmployment() {
			return employment;
		}


		public void setEmployment(String employment) {
			this.employment = employment;
		}


		public String getDni() {
			return dni;
		}


		public void setDni(String dni) {
			this.dni = dni;
		}


		public List<Crime> getChargedCrime() {
			return chargedCrime;
		}


		public void setChargedCrime(List<Crime> chargedCrime) {
			this.chargedCrime = chargedCrime;
		}


		public boolean isAlive() {
			return alive;
		}


		public void setAlive(boolean alive) {
			this.alive = alive;
		}


		public boolean isSearch() {
			return search;
		}


		public void setSearch(boolean search) {
			this.search = search;
		}


		public double getHeight() {
			return height;
		}


		public void setHeight(double height) {
			this.height = height;
		}


		public double getWeight() {
			return weight;
		}


		public void setWeight(double weight) {
			this.weight = weight;
		}


		public String getGender() {
			return gender;
		}


		public void setGender(String gender) {
			this.gender = gender;
		}


		public void setVivo(boolean b) {
			// TODO Auto-generated method stub
			
		}


		public boolean isBuscado() {
			// TODO Auto-generated method stub
			return false;
		}


		public void setBuscado(boolean b) {
			// TODO Auto-generated method stub
			
		}


		public List<Citizen> getDelitosImputados() {
			// TODO Auto-generated method stub
			return null;
		}


		public void setDeceased(boolean b) {
			// TODO Auto-generated method stub
			
		}


		public boolean isCriminal() {
			// TODO Auto-generated method stub
			return false;
		}


		public String getGravedad() {
			// TODO Auto-generated method stub
			return null;
		}


		public void addCrime(Crime crime) {
			// TODO Auto-generated method stub
			
		}


		public void setMissing(boolean b) {
			// TODO Auto-generated method stub
			
		}


		public void setWanted(boolean b) {
			// TODO Auto-generated method stub
			
		}


		public List<Crime> getCrimes() {
			// TODO Auto-generated method stub
			return null;
		}


	
	    
}
	  

	  
	  
	   

	
