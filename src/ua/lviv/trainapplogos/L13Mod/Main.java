package ua.lviv.trainapplogos.L13Mod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		VerkhovnaRada verkhovnaRada = VerkhovnaRada.getInstance();
		ArrayList<Fraction> fractionslist = new ArrayList<Fraction>();
		fractionslist = verkhovnaRada.getFractionslist();
		int choosenfraction = -1;
		
		
		//Form the Base of Fractions and deputies
		verkhovnaRada.addFractionByName("Fraction of grafters");
		verkhovnaRada.addFractionByName("Fraction of storytellers");
		verkhovnaRada.addFractionByName("Fraction of sleepy");
		
		//Set deputies list of 0 Fraction
		ArrayList<Deputy> list = new ArrayList<Deputy>();
		list = fractionslist.get(0).getDeputiesList();
		System.out.println("\n> Filling list of Fraction '" + fractionslist.get(0).getName() + "':");
		
		list.add(new Deputy("Ivan", "Kentavr", 22, 33, true));
		list.add(new Deputy("Ruslan", "Markiv", 44, 55, true));
		list.get(1).GiveBribe(4980);
		list.add(new Deputy("Andrij", "Sadovushkin", 33, 44, true)); //2
		list.get(2).GiveBribe(4000);
		list.add(new Deputy("Igor", "Shmigor", 11, 332, true)); //3
		list.get(3).GiveBribe(4500);
		
		//Set deputies list of 1 Fraction
		list = fractionslist.get(1).getDeputiesList();
		System.out.println("\n> Filling list of Fraction '" + fractionslist.get(1).getName() + "':");
		
		list.add(new Deputy("Taras", "Bambas", 22, 33, false));
		list.add(new Deputy("Oleh", "Mulan", 42, 24, true));
		list.add(new Deputy("Andrew", "Gomez", 24, 53, false));
		list.add(new Deputy("Roman", "Padavan", 35, 63, true)); //3
		list.get(3).GiveBribe(3500);
		
		//Set deputies list of 1 Fraction
		list = fractionslist.get(2).getDeputiesList();
		System.out.println("\n> Filling list of Fraction '" + fractionslist.get(2).getName() + "':");
		
		list.add(new Deputy("Volodymyr", "Golka", 34, 53, true)); //0
		list.get(0).GiveBribe(8000);
		
		list.add(new Deputy("Andy", "Shmendi", 34, 164, true));
		list.add(new Deputy("Johny", "Cash", 54, 534, false)); //2
		list.get(2).GiveBribe(8000);
		list.add(new Deputy("Trevor", "Martin", 84, 234, true)); //3
		list.get(3).GiveBribe(250);
		list.add(new Deputy("Misko", "Krutyk", 93, 54, false));
		
		//----------------------------------------------------------
		
		
		System.out.println("\n---[Initial list of Fractions]---");
		verkhovnaRada.outputAllFractions();
		System.out.println("---------------------------------");
		
		while (true) {
			System.out.println("\n-----------------------[menu]-----------------------");
			System.out.println("> Enter:");
			System.out.println("  0: To choose Default Fraction");
			System.out.println("  1: To add Fraction");
			System.out.println("  2: To delete some Fraction"); //entered or selected
			System.out.println("  3: To show list of Fractions");
			System.out.println("  4: To clear some Fraction"); //entered or selected
			System.out.println("  5: To show all deputies in Fraction"); //
			System.out.println("  6: To add a deputy to Fraction");
			System.out.println("  7: To remove the deputy from Fraction");
			System.out.println("  8: To show the list of all grafters of Fraction");
			System.out.println("  9: To show the biggest grafter");
			System.out.println("----------------------------------------------------");
			
			if (choosenfraction >= 0) {
				System.out.println("[--- Choosen Fraction is '" + 
						fractionslist.get(choosenfraction).getName() + "' ---]");
				System.out.println("--------------------------------------------------------");
			}
			
			Scanner sc = new Scanner(System.in).useDelimiter("\n");
			
			String res = sc.nextLine();
			switch (res) {
				case "0":
					System.out.println("\n---[List of Fractions]---");
					verkhovnaRada.outputAllFractions();
					System.out.println();
					
					System.out.println("\n> Choose Fraction by number:");
					choosenfraction = Integer.valueOf(sc.nextLine()) - 1;
					System.out.println("[--- Choosen Fraction is '" + 
							fractionslist.get(choosenfraction).getName() + "' ---]");
					
					break;
				case "1":
					System.out.println("> Enter name of Fraction to add: ");
					res = sc.nextLine();
					if (res.length() > 0) verkhovnaRada.addFractionByName(res);
					break;
				case "2":
					System.out.println("> Choose Fraction to delete:");
					System.out.println("  - 1: Delete by name");
					System.out.println("  - 2: Delete by number");
					if (choosenfraction >= 0) { 
						System.out.println("  - 3: Delete choosen Fraction '" 
									+ fractionslist.get(choosenfraction).getName() + "'");
					}
					
					switch (sc.nextLine()) {
						case "1":
							System.out.println("> Enter name of Fraction to delete:");
							res = sc.nextLine();
							try {
								if (res.length() > 0) verkhovnaRada.deleteFractionByName(res); 
							} catch (NoSuchElementException e) {
								System.out.println("The Fraction '" + res +  "' doesn't exist! \nCan't delete!");
							}
							
							
							break;
						case "2":
							System.out.println("> Enter number of Fraction to delete:");
							int subres = Integer.valueOf(sc.nextLine());
							if ((subres >= 1) && (subres < fractionslist.size())) {
								fractionslist.remove(subres - 1);
								System.out.println("The Fraction '" + 
								fractionslist.get(subres - 1).getName() + "' was deleted!");
							} else System.out.println("Fraction with number " + subres + " doesn't exist!");
							break;
						case "3":
							if (choosenfraction >= 0) { 
								fractionslist.remove(choosenfraction);
								System.out.println("The shoosen Fraction '" + 
										fractionslist.get(choosenfraction).getName() + "' was deleted!");
							}
							break;
					}
					break;
				case "3":
					System.out.println("\n---[List of Fractions]---");
					verkhovnaRada.outputAllFractions();
					break;
				case "4":
					System.out.println("\n---[List of Fractions]---");
					verkhovnaRada.outputAllFractions();
					System.out.println();
					
					System.out.println("> Choose Fraction to clear from deputies:");
					System.out.println("  - 1: Clear by name");
					System.out.println("  - 2: Clear by number");
					if (choosenfraction >= 0) { 
						System.out.println("  - 3: Clear choosen Fraction '" 
									+ fractionslist.get(choosenfraction).getName() + "'");
					}
					
					switch (sc.nextLine()) {
					case "1":
						System.out.println("> Enter name of Fraction to clear:");
						res = sc.nextLine();
						try {
							if (res.length() > 0) verkhovnaRada.clearFractionByName(res); 
						} catch (NoSuchElementException e) {
							System.out.println("Fraction with name '" + res + "' doesn't exist!");
						}
						
						break;
					case "2":
						System.out.println("> Enter number of Fraction to clear:");
						int resindex = Integer.valueOf(sc.nextLine()) - 1;
						if ((resindex >= 0) && (resindex < fractionslist.size())) {
							fractionslist.get(resindex).clearFractionFromDeputies();
							System.out.println("The Fraction '" + 
							fractionslist.get(resindex).getName() + "' was cleared!");
						} else System.out.println("Fraction with number " + (resindex + 1) + " doesn't exist!");
						break;
					case "3":
						if (choosenfraction >= 0) { 
							fractionslist.remove(choosenfraction);
							System.out.println("The shoosen Fraction '" + 
									fractionslist.get(choosenfraction).getName() + "' was deleted!");
						}
						break;
					}
					
					
					break;
				case "5":
					System.out.println();
					System.out.println("\n---[List of Fractions]---");
					verkhovnaRada.outputAllFractions();
					System.out.println();
					
					System.out.println("> Choose Fraction to show up list of deputies:");
					System.out.println("  - 1: Show by name");
					System.out.println("  - 2: Show by number");
					if (choosenfraction >= 0) { 
						System.out.println("  - 3: Show up in choosen Fraction '" 
									+ fractionslist.get(choosenfraction).getName() + "'");
					}
					
					res = sc.nextLine();
					
					switch (res) {
					case "1":
						System.out.println("> Enter name of Fraction to show up:");
						res = sc.nextLine();
						if (res.length() > 0) verkhovnaRada.outputAllDeputyOfFractionByName(res); 
						break;
					case "2":
						System.out.println("> Enter number of Fraction to show up:");
						int resindex = Integer.valueOf(sc.nextLine()) - 1;
						if ((resindex >= 0) && (resindex < fractionslist.size())) {
							verkhovnaRada.outputAllDeputyOfFractionByIndex(resindex);
						} else System.out.println("Fraction with number " + (resindex + 1) + " doesn't exist!");
						break;
					case "3": 
						System.out.println("List of deputies of choosen Fraction:");
						Fraction choosenfr = fractionslist.get(choosenfraction);
						if (choosenfr.getDeputiesList().size() > 0) {
							choosenfr.outputAllDeputiesOfFraction();
						} else System.out.println("The Fration is empty!");
					}
					break;
				case "6":
					System.out.println("\n---[List of Fractions]---");
					verkhovnaRada.outputAllFractions();
					System.out.println();
					
					System.out.println("> Choose Fraction to add deputies:");
					System.out.println("  - 1: Choose by name");
					System.out.println("  - 2: Choose by number");
					if (choosenfraction >= 0) { 
						System.out.println("  - 3: Choosen Fraction '" 
									+ fractionslist.get(choosenfraction).getName() + "'");
					}
					
					switch (sc.nextLine()) { 
					case "1":
						System.out.println("> Enter name of Fraction to add deputies:");
						res = sc.nextLine();
						if (res.length() > 0) verkhovnaRada.addDeputyToFractionByName(res); 
						break;
					case "2":
						System.out.println("> Enter number of Fraction to add deputies:");
						int resindex = Integer.valueOf(sc.nextLine()) - 1;
						if ((resindex >= 0) && (resindex < fractionslist.size())) {
							fractionslist.get(resindex).addDeputyFromKeyboard();
						} else System.out.println("Fraction with number " + (resindex + 1) + " doesn't exist!");
						break;
					case "3": 
						System.out.println("Add deputy to choosen Fraction:");
						if (choosenfraction >= 0) {
							fractionslist.get(choosenfraction).addDeputyFromKeyboard();
						} else System.out.println("Default Fractions wasn't choosen");
					}
					
					break;
				case "7":
					System.out.println("\n---[List of Fractions]---");
					verkhovnaRada.outputAllFractions();
					System.out.println();
					
					System.out.println("> Choose Fraction to remove deputy:");
					System.out.println("  - 1: Choose by name");
					System.out.println("  - 2: Choose by number");
					if (choosenfraction >= 0) { 
						System.out.println("  - 3: Choosen Fraction '" 
									+ fractionslist.get(choosenfraction).getName() + "'");
					}
					
					switch (sc.nextLine()) { 
					case "1":
						System.out.println("> Enter name of Fraction to remove the deputy:");
						res = sc.nextLine();
						if (res.length() > 0) verkhovnaRada.removeDeputyFromFractionByKeyboard(res); 
						break;
					case "2":
						System.out.println("> Enter number of Fraction to remove the deputy:");
						int resindex = Integer.valueOf(sc.nextLine()) - 1;
						if ((resindex >= 0) && (resindex < fractionslist.size())) {
							try {
								fractionslist.get(resindex).removeDeputyByKeyboard();
							} catch (NoSuchElementException e) {
								System.out.println("There isn't such deputy");
							}
						} else System.out.println("Fraction with number " + (resindex + 1) + " doesn't exist!");
						break;
					case "3": 
						System.out.println("Remove deputy from choosen Fraction:");
						if (choosenfraction >= 0) {		
							try {
								fractionslist.get(choosenfraction).removeDeputyByKeyboard();
							} catch (NoSuchElementException e) {
								System.out.println("There isn't such deputy");
							}
							
						} else System.out.println("Default Fractions wasn't choosen");
					}
					
					break;
				case "8":
					System.out.println("> Show up the list of all grafters of:");
					System.out.println("  - 1: some Fraction");
					System.out.println("  - 2: all Fractions of Verkhovna Rada");
					
					res = sc.nextLine();
					
					switch (res) {
					case "1": //some Fractions
						System.out.println("\n---[List of Fractions]---");
						verkhovnaRada.outputAllFractions();
						System.out.println();
						
						System.out.println("> Choose Fraction to show up list of grafters:");
						System.out.println("  - 1: Choose by name");
						System.out.println("  - 2: Choose by number");
						if (choosenfraction >= 0) { 
							System.out.println("  - 3: Choosen Fraction '" 
										+ fractionslist.get(choosenfraction).getName() + "'");
						}
						
						switch (sc.nextLine()) { 
						case "1": // Choose by name
							System.out.println("> Enter name of Fraction:");
							res = sc.nextLine();
							if (res.length() > 0) verkhovnaRada.outputAllGraftersOfFractionByName(res); 
							break;
						case "2": // Choose by number
							System.out.println("> Enter number of Fraction:");
							int resindex = Integer.valueOf(sc.nextLine()) - 1;
							if ((resindex >= 0) && (resindex < fractionslist.size())) {
								verkhovnaRada.outputAllGraftersOfFraction(fractionslist.get(resindex));
							} else System.out.println("Fraction with number " + (resindex + 1) + " doesn't exist!");
							break;
						case "3": //Choosen Fraction
							System.out.println("> Show up grafters of choosen Fraction:");
							if (choosenfraction >= 0) {
								verkhovnaRada.outputAllGraftersOfFraction(fractionslist.get(choosenfraction));
							} else System.out.println("Default Fractions wasn't choosen");
						}
						break;
					case "2": //all Fractions
						System.out.println("Show up grafters of All Fractions:");
						verkhovnaRada.outputAllGraftersOfAllFraction();
						break;
					default:
						break;
					}
					
					break;
				case "9":
					System.out.println("> Show up the biggest grafter of:");
					System.out.println("  - 1: some Fraction");
					System.out.println("  - 2: all Fractions of Verkhovna Rada");
					
					res = sc.nextLine();
					
					switch (res) {
					case "1": //some Fractions
						System.out.println("\n---[List of Fractions]---");
						verkhovnaRada.outputAllFractions();
						System.out.println();
						
						System.out.println("> Choose Fraction to show up the biggest grafter:");
						System.out.println("  - 1: Choose by name");
						System.out.println("  - 2: Choose by number");
						if (choosenfraction >= 0) { 
							System.out.println("  - 3: Choosen Fraction '" 
										+ fractionslist.get(choosenfraction).getName() + "'");
						}
						
						switch (sc.nextLine()) { 
						case "1": // Choose by name
							System.out.println("> Enter name of Fraction:");
							res = sc.nextLine();
							if (res.length() > 0) verkhovnaRada.outputBiggestGrafterOfFractionByName(res); 
							break;
						case "2": // Choose by number
							System.out.println("> Enter number of Fraction:");
							int resindex = Integer.valueOf(sc.nextLine()) - 1;
							if ((resindex >= 0) && (resindex < fractionslist.size())) {
								verkhovnaRada.outputBiggestGrafterOfFraction(fractionslist.get(resindex));
							} else System.out.println("Fraction with number " + (resindex + 1) + " doesn't exist!");
							break;
						case "3": //Choosen Fraction
							System.out.println("> Show up the biggest grafter of choosen Fraction:");
							if (choosenfraction >= 0) {
								verkhovnaRada.outputBiggestGrafterOfFraction(fractionslist.get(choosenfraction));
							} else System.out.println("Default Fractions wasn't choosen");
						}
						break;
					case "2": //all Fractions
						System.out.println("Show up the biggest grafter of All Fractions:");
						Deputy biggestgrafter = verkhovnaRada.outputBiggestGrafterOfAllFractions();
						if ((biggestgrafter.isGrafter()) && (biggestgrafter.getBribeSize() > 0)) {
							System.out.println("\n> The biggest frafter of all Fractions of Verkhovna Rada is " + biggestgrafter);
						}
						
						break;
					default:
						break;
					}
					break;
				default:
					break;
			}
			
		}
	}
}
