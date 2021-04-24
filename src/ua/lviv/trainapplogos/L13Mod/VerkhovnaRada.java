package ua.lviv.trainapplogos.L13Mod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//public final class VerkhovnaRada {
public class VerkhovnaRada {
	private static VerkhovnaRada instance;
	private ArrayList<Fraction> fractionslist = new ArrayList<Fraction>();
	
	private VerkhovnaRada () {
	}
	
	public static VerkhovnaRada getInstance() {
        if (instance == null) {
            instance = new VerkhovnaRada();
        }
        return instance;
    }
	
	/* Add some Fraction */
	public void addFraction(Fraction fraction) {
		boolean result = (this.fractionslist.add(fraction)) ? true : false; 
		if (result) {
			System.out.println("> The fraction " + fraction.getName() + " was added successfully!");
		} else {
			System.out.println("> Can't add Fraction " + fraction.getName());
		}
	}
	
	/* Add some Fraction by name */
	public void addFractionByName(String fraction) {
		boolean result = (this.fractionslist.add(new Fraction(fraction))) ? true : false; 
		if (result) {
			System.out.println("> The fraction '" + fraction + "' was added successfully!");
		} else {
			System.out.println("> Can't add Fraction " + fraction);
		}
	}
	
	/* Delete some Fraction by name*/
	public void deleteFractionByName(String fraction) {
	/*	Iterator<Fraction> iterator = fractionslist.iterator(); 
		boolean exists = false;
	
		while(iterator.hasNext()) {
			Fraction next = iterator.next(); 
			if (next.getName().equalsIgnoreCase(fraction) ) {
				iterator.remove();
				exists = true;
				System.out.println("> The Fraction '" + next.getName() + "' was deleted!");
			}
		} */
	
		fractionslist = (ArrayList<Fraction>) fractionslist.stream()
				.filter(fr -> !fr.getName().equalsIgnoreCase(fraction))
				.collect(Collectors.toList());
		
	/*		System.out.println("The Fraction '" + fraction + 
				"' doesn't exist! \nCan't delete!"); */
	}
	
	/* Delete some Fraction by index */
	public void deleteFractionByIndex(int index) {
		if (index > 0) {
			fractionslist.remove(index);
			System.out.println("The Fraction'" + fractionslist.get(index).getName() + "' was deleted!");
		}
	}
	
	/* Delete some Fraction */
	/*
	public void deleteFraction(Fraction fraction) {
		Iterator<Fraction> iterator = fractionslist.iterator(); 
		
		while(iterator.hasNext()) {
			Fraction next = iterator.next();  
			if (next.equals(fraction) ) {
				iterator.remove();
				System.out.println("> The Fraction '" + next.getName() + "' was deleted!");
			}
		}
	} */
	
	/* Clear some Fraction */
	public void clearFractionByName(String fraction) {
		/*	Iterator<Fraction> iterator = fractionslist.iterator();
		 
		while(iterator.hasNext()) {
			Fraction next = iterator.next(); 
			if (next.getName().equalsIgnoreCase(fraction) ) {
				next.clearFractionFromDeputies();
				System.out.println("> The Fraction '" + next.getName() + "' was cleared from deputies!");
			}
		} */
		
		Stream<Fraction> filter = fractionslist.stream()
				.filter(fr -> (fr.getName().equalsIgnoreCase(fraction)));
	
		boolean exists = (filter.count() > 0) ? true : false;
		if (exists) {
			filter.findFirst()
				.get()
				.clearFractionFromDeputies();
				
			System.out.println("  Fraction '" + fraction + "' was found and cleared! ");
		} else System.out.println("The Fraction '" + fraction + "' doesn't exist! \nCan't clear the Fraction!"); 

	}
	
	/* Clear some Fraction by index */
	public void clearFractionByIndex(int index) {
		if (index >= 0) {
			fractionslist.get(index).clearFractionFromDeputies();
			System.out.println("> The Fraction '" + 
					fractionslist.get(index).getName() + "' was cleared from deputies!");
		} else {
			System.out.println("Fraction with such number doesn't exist!");
		}
	}
	
	/* Output all Fractions */
	public void outputAllFractions() {
	/*	Iterator<Fraction> iterator = fractionslist.iterator(); 
		int ind = 0;
		
		while(iterator.hasNext()) {
			ind++;
			Fraction next = iterator.next();  
			System.out.println("  " + ind + ") " + next.getName());
		} */	
		
		AtomicInteger ind = new AtomicInteger(0);
		fractionslist.stream()
			.forEach(s -> System.out.println("  " + ind.incrementAndGet() + ") " + s.getName()));	
	}
	
	/* Add deputy to some Fraction */
	public void addDeputyToFraction(Deputy deputy, Fraction fraction) {
		fraction.addDeputy(deputy);
	}
	
	/* Add a deputy to some Fraction by name*/
	public void addDeputyToFractionByName(String fraction) {
		boolean exists = false;
	/*	Iterator<Fraction> iterator = fractionslist.iterator();
		boolean exists = false;while(iterator.hasNext()) {
			Fraction next = iterator.next(); 
			if (next.getName().equalsIgnoreCase(fraction) ) {
				next.addDeputyFromKeyboard();
				exists = true;
			}
		} */
		
		Stream<Fraction> filter = fractionslist.stream().filter(fr -> 
			(fr.getName().equalsIgnoreCase(fraction)));
		
		exists = (filter.count() > 0) ? true : false;
		if (exists) {
			filter.findFirst().get().addDeputyFromKeyboard();
		} else System.out.println("The Fraction '" + fraction + "' doesn't exist! \nCan't add deputy!"); 
	}
	
	
	/* Remove deputy from some Fraction */
	public void removeDeputyFromFraction(Fraction fraction) {
		fraction.removeDeputyByKeyboard(); //(deputy);
	}
	
	
	/* Add a deputy to some Fraction by name*/
	public void removeDeputyFromFractionByKeyboard(String fraction) {
	/*	Iterator<Fraction> iterator = fractionslist.iterator(); 
	
		while(iterator.hasNext()) {
			Fraction next = iterator.next(); 
			if (next.getName().equalsIgnoreCase(fraction) ) {
				next.removeDeputyByKeyboard();
				exists = true;
			}
		} */
		
		Stream<Fraction> filter = fractionslist.stream().filter(fr -> 
		(fr.getName().equalsIgnoreCase(fraction)));
	
		boolean exists = (filter.count() > 0) ? true : false;
		if (exists) {
			filter.findFirst().get().removeDeputyByKeyboard();
		} else System.out.println("The Fraction '" + fraction + "' doesn't exist! \nCan't remove deputy!");
	}
	
	/* Output all grafters of some Fraction */
	public void outputAllGraftersOfFraction(Fraction fraction) {
		fraction.outputAllGraftersOfFraction();
	}
	
	/* Output all grafters of all Fraction */
	public void outputAllGraftersOfAllFraction() {
/*		Iterator<Fraction> iterator = fractionslist.iterator(); 
		
		while(iterator.hasNext()) {
			Fraction next = iterator.next(); 
			next.outputAllGraftersOfFraction();
		} */ 
		
		fractionslist.stream().forEach(f -> f.outputAllGraftersOfFraction());
	}
	
	/* Output all grafters of some Fraction by name*/
	public void outputAllGraftersOfFractionByName(String fraction) {
/*		Iterator<Fraction> iterator = fractionslist.iterator(); 
		
		while(iterator.hasNext()) {
			Fraction next = iterator.next(); 
			if (next.getName().equalsIgnoreCase(fraction) ) {
				next.outputAllGraftersOfFraction();
				return;
			}
		} 	*/
		
		fractionslist.stream().filter(fr -> fr.getName().equalsIgnoreCase(fraction))
		.findFirst()
		.get()
		.outputAllGraftersOfFraction();
	}
	
	/* Output the biggest grafter of some Fraction */
	public void outputBiggestGrafterOfFraction(Fraction fraction) {
		Deputy grafter = fraction.outputBiggestGrafterOfFraction();
		if (grafter.getHeight() != 0) System.out.println("The biggest grafter of this Fraction '" + 
				fraction.getName() + " is " + grafter);
	}
	
	/* Output biggest grafter of some Fraction by name*/
	public Deputy outputBiggestGrafterOfFractionByName(String fraction) {
		Deputy grafter = new Deputy();
	/*	Iterator<Fraction> iterator = fractionslist.iterator(); 
			
		while(iterator.hasNext()) {
			Fraction next = iterator.next(); 
			
			if (next.getName().equalsIgnoreCase(fraction) ) {
				grafter = next.outputBiggestGrafterOfFraction();
				System.out.println("The biggest grafter of this Fraction '" + 
						next.getName() + " is " + grafter);
				return grafter;
			}
		} */
		
		Stream<Fraction> filter = fractionslist.stream().filter(fr -> 
		(fr.getName().equalsIgnoreCase(fraction)));
	
		boolean exists = (filter.count() > 0) ? true : false;
		if (exists) {
			grafter = filter.findFirst().get().outputBiggestGrafterOfFraction();
			System.out.println("The biggest grafter of this Fraction '" + 
					fraction + " is " + grafter);
			return grafter;
		} else System.out.println("The Fraction '" + fraction + "' doesn't exist! \nCan't putput grafters!"); 
		
		return grafter;
	}
	
	/* Output biggest grafter of all Fractions */
	public Deputy outputBiggestGrafterOfAllFractions() {
		Iterator<Fraction> iterator = fractionslist.iterator(); 
		Deputy biggestgrafter = new Deputy();
		Deputy grafter;
		
		
		while(iterator.hasNext()) {
			Fraction next = iterator.next(); 
			
//			grafter = next.outputBiggestGrafterOfFraction();
			grafter = next.GetBiggestGrafterOfFraction();
			if (biggestgrafter.getBribeSize() < grafter.getBribeSize()) {
				biggestgrafter = grafter;
			}
		} 
		
		return biggestgrafter;
	}
	
	
	/* Output all deputies of some Fraction */
	public void outputAllDeputyOfFraction(Fraction fraction) {
		fraction.outputAllDeputiesOfFraction();
	}

	/* Output all deputies of some Fraction by name*/
	public void outputAllDeputyOfFractionByName(String fraction) {
	/*	Iterator<Fraction> iterator = fractionslist.iterator(); 
	
		while(iterator.hasNext()) {
			Fraction next = iterator.next(); 
			if (next.getName().equalsIgnoreCase(fraction) ) {
				next.outputAllDeputiesOfFraction();
				return;
			}
		} */
		
		fractionslist.stream().filter(fr -> fr.getName().equalsIgnoreCase(fraction))
		.findFirst()
		.get()
		.outputAllDeputiesOfFraction();
	}
	
	/* Output all deputies of some Fraction by index*/
	public void outputAllDeputyOfFractionByIndex(int index) {
		fractionslist.get(index).outputAllDeputiesOfFraction();
	}
	
	public void setFractionslist(ArrayList<Fraction> fractionslist) {
		this.fractionslist = fractionslist;
	}

	public ArrayList<Fraction> getFractionslist() {
		return fractionslist;
	}

	@Override
	public String toString() {
		return "VerkhovnaRada [fractionslist=" + fractionslist + "]";
	}

	
	
	
}

