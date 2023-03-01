package StreamJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicStream {
	@Test
	public void regular() {
	
	ArrayList<String> names= new ArrayList<String>();
	names.add("Ram");
	names.add("Radha");
	names.add("Raju");
	names.add("Shyam");
	names.add("Krishna");
	names.add("Amar");
	
	int count=0;
	for(int i=0;i<names.size();i++) {
		
		String s= names.get(i);
		if(s.startsWith("A")) {
			
			count++;
		}
	}
	System.out.println(count);
	System.out.println("-------------");
	}
	@Test
	public void streamFilter() {

		
		ArrayList<String> names= new ArrayList<String>();
		names.add("Ram");
		names.add("Radha");
		names.add("Raju");
		names.add("Shyam");
		names.add("Krishna");
		names.add("Amar");
		
		long L= names.stream().filter(s->s.startsWith("R")).count();
		System.out.println(L);
		
		long lo= Stream.of("Ram","Radha","Raju","Shyam","Krishna","Amar").filter(s->
		{
			
			s.startsWith("B");
			return true;
		}).count();
		System.out.println(lo);
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		System.out.println("$$$$$$$$$$$");
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		System.out.println("+++++++++++++++");
	}
	@Test
	public void streamMap() {
		
		Stream.of("Ram","Radha","Raju","Shyam","Krishna","Amar").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		System.out.println("##############");
		
		Stream.of("Ram","Radha","Raju","Shyam","Krishna","Amar").filter(s->s.startsWith("R")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		System.out.println("**********");
	}
	
	@Test
	public void streamfncn() {
		
		ArrayList<String> names= new ArrayList<String>();
		names.add("Ram");
		names.add("Radha");
		names.add("Raju");
		names.add("Shyam");
		names.add("Krishna");
		names.add("Amar");
		
		List<String> names1= Arrays.asList("abc","def","ghi","Ram");
		
		Stream<String> str= Stream.concat(names.stream(), names1.stream());
		//str.sorted().forEach(s->System.out.println(s));
		
		boolean mat= str.anyMatch(s->s.equalsIgnoreCase("abc"));
		System.out.println(mat);
		//Assert.assertTrue(mat);
		System.out.println("**********");
		
	}
	@Test
	public void streamCollect() {
		List<String> ls= Stream.of("adgsh","dsbjbc","hgjhg","vhvjg","gfih").filter(s->s.endsWith("h")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		List<Integer> names2= Arrays.asList(5,7,9,5,1);
		names2.stream().distinct().forEach(s->System.out.println(s));
		List<Integer> ll= names2.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(ll.get(2));
		System.out.println("!!!!!!!!!!!!");
	}

}
