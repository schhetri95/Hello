package ExampleTest;

import java.util.*;
import java.util.stream.*;

import DishTest.Dish;

public class DataSearchonTraderTransaction {
	public static void main(String args[]){
	
	Trader raoul = new Trader("Raoul", "Cambridge");
	Trader mario = new Trader("Mario","Milan");
	Trader alan = new Trader("Alan","Cambridge");
	Trader brian = new Trader("Brian","Cambridge");
	List<Transaction> transactions = Arrays.asList(
			new Transaction(brian, 2011, 300),
			new Transaction(raoul, 2012, 1000),
			new Transaction(raoul, 2011, 400),
			new Transaction(mario, 2012, 710),
			new Transaction(mario, 2012, 700),
			new Transaction(alan, 2012, 950));
	
	
	List<Transaction> transaction2011 = transactions.stream()
			.filter(transaction -> transaction.getYear() == 2011)
			.sorted(Comparator.comparing(Transaction::getValue))
			.collect(Collectors.toList());
	
	List<String> uniqueCities = transactions.stream()
			.map(unit -> unit.getTrader().getCity())
			.distinct()
			.collect(Collectors.toList());
	
	List<Trader> traderName = transactions.stream()
			.map(Transaction::getTrader)
			.filter(tradername -> tradername.getCity().equals("Cambridge"))
			.distinct()
			.sorted(Comparator.comparing(Trader::getName))
			.collect(Collectors.toList());
	
	String shortedTraderName =  transactions.stream()
			.map(alphaName ->alphaName.getTrader().getName())
			.distinct()
			.sorted()
			.reduce ("", (a,b) -> a + b);
	
	List<Trader> MilanTrader = transactions.stream()
			.map(Transaction::getTrader)
			.filter(tradername -> tradername.getCity().equals("Milan"))
			.distinct()
			.collect(Collectors.toList());;
			
    List <Integer> transValue = transactions.stream()
	//		.map(Transaction::getTrader)
			.filter(tradername -> tradername.getTrader().getCity().equals("Cambridge"))
			.map(valuetran ->valuetran.getValue())
			.collect(Collectors.toList());
    
    Long Count= transactions.stream()
    		.filter(transaction->transaction.getValue() >400)
    		.count();
		
    transactions.stream()
      .map(tradername -> tradername.getTrader().getCity())
      .distinct()
      .forEach(System.out::println);
    
    
    System.out.println("Understanding lazy execution");
    List<String> names =
    		transactions.stream()
    		.map(Transaction::getTrader)
    		.filter(d -> {
    		System.out.println("filtering " + d.getName());
    		return d.getCity().equals("Milan"); })
    		.map(d -> {
    		System.out.println("mapping " + d.getName());
    		return d.getName(); })
    		.limit(3)
    		.collect(Collectors.toList());
    		System.out.println(names);
    		System.out.println("");
      
	//  .forEach(s -> {System.out.println (s.getCity());});
    		
    Optional<Transaction> smallestTransaction =
    				transactions.stream()
    				.reduce((t1, t2)
    				-> t1.getValue() < t2.getValue() ? t1 : t2);
    Optional<Integer> highestValue =
    		transactions.stream()
    		.map(Transaction::getValue)
    		.reduce(Integer::max);
    
    Optional<Transaction> max=transactions.stream()
			  .max(Comparator.comparing(caloriesDish->caloriesDish.getValue()));
    
    List<Transaction> max3 = transactions.stream()		
    					.sorted(Comparator.comparing(A1 -> ((Transaction) A1).getValue())
    					.reversed())
    					.collect(Collectors.toList());
    int[] arr = new int[10];
	arr[0] = 1;
	arr[1] = 2;
	arr[2] = 3;
	arr[3] = 4;
	int arrayLength = arr.length;
			
	System.out.println(transaction2011);
	System.out.println(uniqueCities);
	System.out.println(traderName);
	System.out.println(shortedTraderName);
	System.out.println(MilanTrader);
	System.out.println(transValue);
	System.out.println(Count);
	System.out.println(smallestTransaction);
	System.out.println(highestValue);
	System.out.println(max);
	System.out.println(max3);

	
	System.out.println(arrayLength);
	}
}
