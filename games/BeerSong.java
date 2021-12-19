public class BeerSong {
	public static void main(String[] args) {
		int beerNum = 99;
		String word = "bottles";
		
		while (beerNum > 1) {
			
			if (beerNum == 1) { // make singular
				word = "bottle";
			} // end if statement
			
			System.out.println(beerNum + " "+ word + " of beer on the wall. "+ beerNum + " " + word + " of beer.");
			System.out.println("Take one down.");
			System.out.println("Pass it around");
			beerNum -= 1;
			System.out.println(beerNum + " " + word + " of beer on the wall.");
		} // End of while loop
		
		System.out.println("No more bottles of beer on the wall!");
	} // end of main
} // end of class
