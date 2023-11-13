package Main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
	public static LinkedList dna1 = new LinkedList(); // Randomly generated Queue dna1
	public static LinkedList dna2 = new LinkedList(); // Randomly generated Queue dna2
	public static LinkedList dna1Comp = new LinkedList(); // dna1's complement
	public static LinkedList dna1AA = new LinkedList(); // dna1's amino acids
	public static LinkedList dna2AA = new LinkedList(); // dna2's amino acids
	public static LinkedList dna1Crossover = new LinkedList(); // dna1's and dna2's crossover (dna1 part)
	public static LinkedList dna2Crossover = new LinkedList(); // dna1's and dna2's crossover (dna2 part)

	public static void addInQueue() {
		// Adds 21 nucleotides in two queues
		// Used A => Adenine, T => Thymine, G => Guanine, C => Cytosine
		Random rnd = new Random();
		int random = -1;
		char nucleotide;
		for (int i = 0; i < 21; i++) {
			random = rnd.nextInt(4);
			if (random == 0)
				nucleotide = 'A';
			else if (random == 1)
				nucleotide = 'T';
			else if (random == 2)
				nucleotide = 'G';
			else
				nucleotide = 'C';
			dna1.add(nucleotide);
			random = rnd.nextInt(4);
			if (random == 0)
				nucleotide = 'A';
			else if (random == 1)
				nucleotide = 'T';
			else if (random == 2)
				nucleotide = 'G';
			else
				nucleotide = 'C';
			dna2.add(nucleotide);
		}
	}
	
	public static void complement() {
		int dna1size = dna1.size();
		char hold;
		for (int i = 0; i < dna1size; i++) {
			if ((char) dna1.peek() == 'A') {
				dna1Comp.add('T');
				hold = (char) dna1.pollFirst();
				dna1.add(hold);
			} else if ((char) dna1.peek() == 'T') {
				dna1Comp.add('A');
				hold = (char) dna1.pollFirst();
				dna1.add(hold);
			} else if ((char) dna1.peek() == 'G') {
				dna1Comp.add('C');
				hold = (char) dna1.pollFirst();
				dna1.add(hold);
			} else { // C
				dna1Comp.add('G');
				hold = (char) dna1.pollFirst();
				dna1.add(hold);
			}
		}
	}
	
	public static void aminoAcids() {
		int dna1size;
		dna1size = dna1.size();
		if (dna1size != 21)
			System.out.println("Your queue is not 21 character long");
		else {
			aminoAcidsNames(dna1, dna1AA);
			aminoAcidsNames(dna2, dna2AA);
		}
	}
	
	public static void aminoAcidsNames(Queue dna, Queue aminoAcids) throws NullPointerException {
		char hold;
		if ((char) dna.peek() == 'A') {
			hold = (char) dna.poll();
			dna.add(hold);
			if ((char) dna.peek() == 'A') {
				hold = (char) dna.poll();
				dna.add(hold);
				if ((char) dna.peek() == 'T' || (char) dna.peek() == 'C') {
					hold = (char) dna.poll();
					dna.add(hold);
					aminoAcids.add("Asn");
				} else {
					hold = (char) dna.poll();
					dna.add(hold);
					aminoAcids.add("Lys");
				}
			} else if ((char) dna.peek() == 'T') {
				hold = (char) dna.poll();
				dna.add(hold);
				if ((char) dna.peek() == 'T' || (char) dna.peek() == 'C' || (char) dna.peek() == 'A') {
					hold = (char) dna.poll();
					dna.add(hold);
					aminoAcids.add("Ile");
				} else {
					hold = (char) dna.poll();
					dna.add(hold);
					aminoAcids.add("Met");
				}
			} else if ((char) dna.peek() == 'G') {
				hold = (char) dna.poll();
				dna.add(hold);
				if ((char) dna.peek() == 'T' || (char) dna.peek() == 'C') {
					hold = (char) dna.poll();
					dna.add(hold);
					aminoAcids.add("Ser");
				} else {
					hold = (char) dna.poll();
					dna.add(hold);
					aminoAcids.add("Arg");
				}
			} else { // C
				hold = (char) dna.poll();
				dna.add(hold);
				hold = (char) dna.poll();
				dna.add(hold);
				aminoAcids.add("Thr");
			}
		} else if ((char) dna.peek() == 'T') {
			hold = (char) dna.poll();
			dna.add(hold);
			if ((char) dna.peek() == 'A') {
				hold = (char) dna.poll();
				dna.add(hold);
				if ((char) dna.peek() == 'A' || (char) dna.peek() == 'G') {
					hold = (char) dna.poll();
					dna.add(hold);
					aminoAcids.add("(STOP)");
				} else { // C
					hold = (char) dna.poll();
					dna.add(hold);
					aminoAcids.add("Tyr");
				}
			} else if ((char) dna.peek() == 'T') {
				hold = (char) dna.poll();
				dna.add(hold);
				if ((char) dna.peek() == 'T' || (char) dna.peek() == 'C') {
					hold = (char) dna.poll();
					dna.add(hold);
					aminoAcids.add("Phe");
				} else { // C
					hold = (char) dna.poll();
					dna.add(hold);
					aminoAcids.add("Leu");
				}
			} else if ((char) dna.peek() == 'G') {
				hold = (char) dna.poll();
				dna.add(hold);
				if ((char) dna.peek() == 'T' || (char) dna.peek() == 'C') {
					hold = (char) dna.poll();
					dna.add(hold);
					aminoAcids.add("Cys");
				} else if ((char) dna.peek() == 'A') {
					hold = (char) dna.poll();
					dna.add(hold);
					aminoAcids.add("(STOP)");
				} else { // C
					hold = (char) dna.poll();
					dna.add(hold);
					aminoAcids.add("Trp");
				}
			} else { // C
				hold = (char) dna.poll();
				dna.add(hold);
				hold = (char) dna.poll();
				dna.add(hold);
				aminoAcids.add("Ser");
			}
		} else if ((char) dna.peek() == 'G') {
			hold = (char) dna.poll();
			dna.add(hold);
			if ((char) dna.peek() == 'A') {
				hold = (char) dna.poll();
				dna.add(hold);
				if ((char) dna.peek() == 'A' || (char) dna.peek() == 'G') {
					hold = (char) dna.poll();
					dna.add(hold);
					aminoAcids.add("Glu");
				} else { // C
					hold = (char) dna.poll();
					dna.add(hold);
					aminoAcids.add("Asp");
				}
			} else if ((char) dna.peek() == 'T') {
				hold = (char) dna.poll();
				dna.add(hold);
				hold = (char) dna.poll();
				dna.add(hold);
				aminoAcids.add("Val");
			} else if ((char) dna.peek() == 'G') {
				hold = (char) dna.poll();
				dna.add(hold);
				hold = (char) dna.poll();
				dna.add(hold);
				aminoAcids.add("Gly");
			} else { // C
				hold = (char) dna.poll();
				dna.add(hold);
				hold = (char) dna.poll();
				dna.add(hold);
				aminoAcids.add("Ala");
			}
		} else { // C
			hold = (char) dna.poll();
			dna.add(hold);
			if ((char) dna.peek() == 'A') {
				hold = (char) dna.poll();
				dna.add(hold);
				if ((char) dna.peek() == 'A' || (char) dna.peek() == 'G') {
					hold = (char) dna.poll();
					dna.add(hold);
					aminoAcids.add("Gln");
				} else { // C
					hold = (char) dna.poll();
					dna.add(hold);
					aminoAcids.add("His");
				}
			} else if ((char) dna.peek() == 'T') {
				hold = (char) dna.poll();
				dna.add(hold);
				hold = (char) dna.poll();
				dna.add(hold);
				aminoAcids.add("Leu");
			} else if ((char) dna.peek() == 'G') {
				hold = (char) dna.poll();
				dna.add(hold);
				hold = (char) dna.poll();
				dna.add(hold);
				aminoAcids.add("Arg");
			} else { // C
				hold = (char) dna.poll();
				dna.add(hold);
				hold = (char) dna.poll();
				dna.add(hold);
				aminoAcids.add("Pro");
			}
		}
	}
	
	public static int crossover() {
		int size;
		char hold;
		size = dna1.size();
		for (int i = 0; i < size; i++) {
			dna1Crossover.add(dna1.peek());
			hold = (char) dna1.poll();
			dna1.add(hold);
			dna2Crossover.add(dna2.peek());
			hold = (char) dna2.poll();
			dna2.add(hold);
		}
		Random rnd = new Random();
		int random = -1;
		random = rnd.nextInt(20) + 1;
		int crossoverSize = random;
		LinkedList holder1 = new LinkedList();
		LinkedList holder2 = new LinkedList();
		for (int i = 0; i < random; i++) {
			holder1.add(dna1Crossover.poll());
			holder2.add(dna2Crossover.poll());
		}
		for (int i = 0; i < size - random; i++) {
			holder1.add(dna2Crossover.poll());
			holder2.add(dna1Crossover.poll());
		}
		while (holder2.isEmpty() != true)
			dna1Crossover.add(holder2.poll());
		while (holder1.isEmpty() != true)
			dna2Crossover.add(holder1.poll());
		return crossoverSize;
	}
	
	public static void main(String[] args) {
		addInQueue();
		complement();
		aminoAcids();
		int crossoverSize = 0;
		crossoverSize = crossover();
		int size1 = dna1.size();
		LinkedList holder1 = new LinkedList();
		LinkedList holder2 = new LinkedList();

// NORMAL ------------------------------------------------------
		System.out.println("---Normal---");
		System.out.println("DNA 1");
		for (int i = 0; i < size1; i++) {
			System.out.print(dna1.peek() + " ");
			holder1.add(dna1.poll());
			dna1.add(holder1.poll());
		}
		System.out.println();
		System.out.println();
		System.out.println("DNA 2");
		size1 = dna2.size();
		for (int i = 0; i < size1; i++) {
			System.out.print(dna2.peek() + " ");
			holder2.add(dna2.poll());
			dna2.add(holder2.poll());
		}
		System.out.println("\n");
		size1 = dna1.size();
// COMPLEMENT --------------------------------------------------
		System.out.println("---Complement---");
		for (int i = 0; i < size1; i++) {
			System.out.print(dna1.peek() + " ");
			holder1.add(dna1.poll());
			dna1.add(holder1.poll());
		}
		System.out.println();
		for (int i = 0; i < size1; i++) {
			System.out.print(dna1Comp.peek() + " ");
			holder1.add(dna1Comp.poll());
			dna1Comp.add(holder1.poll());
		}
		System.out.println("\n");
// AMINO ACIDS -------------------------------------------------
		System.out.println("---Amino Acids---");
		for (int i = 0; i < size1 / 3; i++) {
			System.out.print(dna1.peek());
			holder1.add(dna1.poll());
			dna1.add(holder1.poll());
			System.out.print(dna1.peek());
			holder1.add(dna1.poll());
			dna1.add(holder1.poll());
			System.out.print(dna1.peek() + " ");
			holder1.add(dna1.poll());
			dna1.add(holder1.poll());
		}
		System.out.println();
		for (int i = 0; i < size1 / 3; i++) {
			System.out.print(dna1AA.peek() + " ");
			holder1.add(dna1AA.poll());
			dna1AA.add(holder1.poll());
		}
		System.out.println("\n");
		for (int i = 0; i < size1 / 3; i++) {
			System.out.print(dna2.peek());
			holder1.add(dna2.poll());
			dna2.add(holder1.poll());
			System.out.print(dna2.peek());
			holder1.add(dna2.poll());
			dna2.add(holder1.poll());
			System.out.print(dna2.peek() + " ");
			holder1.add(dna2.poll());
			dna2.add(holder1.poll());
		}
		System.out.println();
		for (int i = 0; i < size1 / 3; i++) {
			System.out.print(dna2AA.peek() + " ");
			holder1.add(dna2AA.poll());
			dna2AA.add(holder1.poll());
		}
		System.out.println("\n");
// CROSSOVER ---------------------------------------------------
		System.out.println("---Crossover---");
		System.out.println("Which amino acid we changed => " + crossoverSize);
		while (dna1Crossover.isEmpty() != true)
			System.out.print(dna1Crossover.poll() + " ");
		System.out.println();
		while (dna2Crossover.isEmpty() != true)
			System.out.print(dna2Crossover.poll() + " ");
	}

}
