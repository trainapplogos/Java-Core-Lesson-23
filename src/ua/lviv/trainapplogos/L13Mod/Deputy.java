package ua.lviv.trainapplogos.L13Mod;

public class Deputy extends Human {
	private String name;
	private String surname;
	private boolean grafter;
	private int bribesize;
	
	public Deputy() {
		super(0, 0);
		this.name = "";
		this.surname = "";
		this.grafter = false;
	}
	
	public Deputy(String name, String surname, int weight, int height, boolean grafter) {
		super(weight, height);
		this.name = name;
		this.surname = surname;
		this.grafter = grafter;
		System.out.println(" (+) Deputy " + name + " " + surname + " was added successfully to Fraction");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public boolean isGrafter() {
		return grafter;
	}

	public void setGrafter(boolean grafter) {
		this.grafter = grafter;
	}

	public int getBribeSize() {
		return bribesize;
	}

	@Override
	public String toString() {
		return "Deputy [name=" + name + ", surname=" + surname + ", grafter=" + grafter + ", bribesize=" + bribesize + "]";
	}
	
	public void GiveBribe (int bribe) {
		if (!this.grafter) { 
			System.out.println("  The deputy " + name + " " + surname + " doesn't take bribes!") ;
		} else {
			System.out.println("  You offer a bribe of $" + String.valueOf(bribe) + " to " + name + " " + surname + "!");
			
			if (bribe > 5000) {
				System.out.println("  The police will imprison this deputy. Sorry"); 
			} else {
				this.bribesize = bribe;
			}
		}
	}
	
	
}

