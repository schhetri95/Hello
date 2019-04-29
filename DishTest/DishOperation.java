package DishTest;

import java.util.*;
import java.util.stream.*;
import DishTest.Dish.Type;

public class DishOperation {
	public static void main(String args[]) {
		
		List<String> highestCalories= Dish.menu.stream()
				.filter(calories->calories.getCalories()>300)
				.sorted(Comparator.comparing(Dish::getCalories)
				.reversed())
				.limit(3)
				.map(Dish::getName)
				.collect(Collectors.toList());
		System.out.println(highestCalories);
		
		
	  List<String> lowCaloriesDishes=Dish.menu.stream()
			  .filter(calories->calories.getCalories()<400)
			  .sorted(Comparator.comparing(Dish::getCalories))
			  .map(Dish::getName)
			  .collect(Collectors.toList());
	  System.out.println(lowCaloriesDishes);
	  
	  List<Dish> isVegetarian= Dish.menu.stream()
			  .filter(dish-> dish.isVegetarian())
			  .collect(Collectors.toList());
	  System.out.println(isVegetarian);
	  
	  List<String> uniqueCharacters= Dish.menu.stream()
			  .map(dishname->dishname.getName())
			  .map(w->w.split(""))
			  .flatMap(Arrays::stream)
			  .distinct()
			  .collect(Collectors.toList());
	  System.out.println(uniqueCharacters);
	  
	  boolean isVegetarianDish= Dish.menu.stream()
			  .anyMatch(Vege->Vege.isVegetarian());
	  System.out.println(isVegetarianDish);
	  
	  boolean isHealthy = Dish.menu.stream()
			  .noneMatch(d -> d.getCalories() >= 1000);
	  System.out.println(isHealthy);
	  
	  Optional<Dish> findVegetarianDish= Dish.menu.stream()
			  .filter(dish-> dish.isVegetarian())
			  .findFirst();
	  System.out.println(findVegetarianDish);
	  
	  Optional<Dish> findAnyVegetarianDish= Dish.menu.stream()
			  .filter(dish-> dish.isVegetarian())
			  .findAny();
	  System.out.println(findAnyVegetarianDish);
	  
	  Optional<Integer> min = Dish.menu.stream()
			  .map(caloriesDish->caloriesDish.getCalories())
			  .reduce(Integer::min);
	  
	  Optional<Dish> min2 = Dish.menu.stream()
			  .min(Comparator.comparing(caloriesDish->caloriesDish.getCalories()));
	  System.out.println(min);
	  System.out.println(min2);
	 
	  Optional<Dish> max=Dish.menu.stream()
			  .max(Comparator.comparing(caloriesDish->caloriesDish.getCalories()));
	  
	  Optional<Dish> smallestTransaction =
			  Dish.menu.stream()
			  .reduce((t1, t2)
			  -> t1.getCalories() < t2.getCalories() ? t1 : t2);
	  
	  System.out.println("smallestTransaction"+smallestTransaction);
	  
	  Optional<Integer> maxCal = Dish.menu.stream()
			  .map(caloriesDish->caloriesDish.getCalories())
			  .reduce(Integer::max);
	  System.out.println("max calories dish name"+max+" has "+maxCal+ "Calories");
	  
	  Dish.menu.stream()
	  .forEach(s -> {System.out.println (s.getName());});
	 
	  int calories = Dish.menu.stream()
			  .map(Dish::getCalories)
			//  .reduce(0, Integer::sum);
			  .reduce(0, (a,b) -> a + b);
			  
	  System.out.println(calories);
	  
	  int calories2 = Dish.menu.stream()
			  .mapToInt(Dish::getCalories)
			  .sum();
	  System.out.println(calories2);
	  
	  OptionalInt MinCal= Dish.menu.stream()
			     .mapToInt(Dish::getCalories)
			     .min();
	  System.out.println(MinCal);
	  
	  OptionalInt Maxcal= Dish.menu.stream()
			     .mapToInt(Dish::getCalories)
			     .max();
	  System.out.println(Maxcal);
	  
	  // Groupby example
	  Map<Type, List<Dish>> groupingDish= Dish.menu.stream()
			  .collect(Collectors.groupingBy(Dish::getType));
	  System.out.println(groupingDish);
	  
	  //partitioning example
	  Map<Boolean, List<Dish>> partitioningDish= Dish.menu.stream()
			  .collect(Collectors.partitioningBy(partDish->partDish.getType()== Dish.Type.MEAT));
	  System.out.println(partitioningDish);
	  
	  
	//  LongestDishname
	  
	  Optional<Dish> LongestDishName = Dish.menu.stream()
			  .max(Comparator.comparing(caloriesDish->caloriesDish.getName().length()));
	  System.out.println(LongestDishName);
	  
	  Optional<Dish> SmallestDishName = Dish.menu.stream()
			  .min(Comparator.comparing(caloriesDish->caloriesDish.getName().length()));
	  System.out.println(SmallestDishName);
	}
}
