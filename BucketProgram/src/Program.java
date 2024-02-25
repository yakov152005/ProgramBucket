import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Program {
	public static void main(String[] args){
		date();
		playBucketsGame();


	}
	public static void Magic(){
		Bucket b1 = new Bucket(7);
		Bucket b2 = new Bucket(5);
		System.out.println("Before magic: |b1|=" +b1 + " |b2|=" +b2);
		b1.fill();
		b2.fill(b1);
		b2.spill();
		b2.fill(b1);
		b1.fill();
		b2.fill(b1);
		b2.spill();
		b2.fill(b1);
		b1.fill();
		b2.fill(b1);
		System.out.println("After magic: |b1|=" +b1+" |b2|=" + b2);
	}
	public static void playBucketsGame() {
		Random r = new Random();
		Bucket[] buckets = new Bucket[3];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new Bucket(r.nextInt(20) + 1);
			buckets[i].addLiters(r.nextInt(15) + 1);
		}
		Bucket emptyBucket = new Bucket(r.nextInt(20));

		for (int i = 0; i < buckets.length; i++) {
			System.out.println("Bucket " + (i+1) + ":" + buckets[i]);
		}
		System.out.println("emptyBucket:" + emptyBucket);

		System.out.println("|The game has started|\n" +
				"-Choose your steps carefully- ");


		for (int i = 0; i < buckets.length; i++) {
			System.out.println("press " + (i+1) + " to fill emptyBucket with bucket" + (i+1) );
		}
		System.out.println("press 4 to fill bucket1 with bucket2");
		System.out.println("press 5 to fill bucket1 with bucket3");
		System.out.println("press 6 to fill bucket2 with bucket1");
		System.out.println("press 7 to fill bucket2 with bucket3");
		System.out.println("press 8 to fill bucket3 with bucket1");
		System.out.println("press 9 to fill bucket3 with bucket2");

		int choice;
		int moves = 1;
		while (!emptyBucket.isFull()) {
			choice = getInput();
			switch (choice){
				case 1: emptyBucket.fill(buckets[0]);
					break;
				case 2: emptyBucket.fill(buckets[1]);
					break;
				case 3: emptyBucket.fill(buckets[2]);
					break;
				case 4: buckets[0].fill(buckets[1]);
					break;
				case 5: buckets[0].fill(buckets[2]);
					break;
				case 6: buckets[1].fill(buckets[0]);
					break;
				case 7: buckets[1].fill(buckets[2]);
					break;
				case 8: buckets[2].fill(buckets[0]);
					break;
				case 9: buckets[2].fill(buckets[1]);
			}
			if (emptyBucket.isFull()) {
				System.out.println("You succeeded in filling the bucket in " + moves + " moves!");
				break;
			} else {
				moves++;
			}
			if (moves==5){//if u reach 5 steps you have lost the game
				System.out.println("You lose :(");
				break;
			}
		}
		System.out.println("GAME OVER [^_^]");
	}
	public static void exCheckForProgramBucket(){

		System.out.println("Ex1");
		Bucket b1 = new Bucket(20);//Ex1

		System.out.println("Ex2");
		System.out.println(b1.toString());//Ex2

		System.out.println("Ex3");
		Bucket b2 = new Bucket(2);//Ex3
		if (b2.isEmpty()){
			System.out.println("The bucket b2 is empty. ");
		}else {
			System.out.println("In the bucket there is" + b2.toString());
		}

		System.out.println("Ex4");
		Bucket b3 = new Bucket(0);//Ex4
		if (b3.isFull()){
			System.out.println("The bucket b3 is full.");
		}else {
			System.out.println("In the bucket there is " + b3.toString());
		}

		System.out.println("Ex5");
		Bucket b4 = new Bucket(10);//Ex5
		b4.fill();
		System.out.println("In bucket b4 there is: " +  b4.percent()+ "% ");

		System.out.println("Ex6");
		Bucket b5 = new Bucket(10);//Ex6
		b5.fill();
		System.out.println("Before add liter -" + b5.toString());
		if (!b5.isFull()){
			b5.addLiter();
			System.out.println("After add liter -" + b5.toString());
		}else {
			System.out.println("The bucket is full.");
		}

		System.out.println("Ex7");
		Bucket b6 = new Bucket(10);//Ex7
		b6.fill();
		System.out.println("Before add liters -" + b6.toString());
		System.out.println( "After add liters - The yeter is " + b6.addLiters(5) +  b6.toString());

		System.out.println("Ex8");
		Bucket b7 = new Bucket(0);//Ex8
		System.out.println("Before spill the bucket -"+ b7.toString());
		System.out.println("Is there still water in the bucket? |" +b7.spill()+"|"+ b7.toString());

		System.out.println("Ex9");
		Bucket b8 = new Bucket(10);//Ex9
		b8.addLiters(6);
		System.out.println("Before spill liters the bucket-" +b8.toString());
		System.out.println("Is there enough water to pour the full amount? |" + b8.spill(4)+"|"+ b8.toString());

		System.out.println("Ex10");
		Bucket b9 = new Bucket(10);//Ex10
		b9.addLiters(8);
		System.out.println("Before fill the bucket to full" + b9);
		b9.fill();
		System.out.println("After fill the bucket to full" + b9 );

		System.out.println("Ex11");
		Bucket b10 = new Bucket(20);//Ex11
		b10.addLiters(13);
		Bucket b11 = new Bucket(20);
		b11.addLiters(11);
		System.out.println(b10+ " " + b11);
		b10.fill(b11);
		System.out.println(b10+ " " + b11);
	}
	public static int getInput() {
		Scanner s = new Scanner(System.in);
		return s.nextInt();
	}
	public static void date(){
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("|dd/MM/yyyy HH:mm|");
		System.out.println(df.format(date));
	}

}

