/**
 *
 * 16.10 Living People
 *     Given a list of people with their birth and death years, implement a method to 
 *     compute the year with the most number of people a live. You may assume that all 
 *     people were born between 1900 and 2000(inclusive). If a person was alive during 
 *     any portion of that year, they should be included in that year's count. For example, 
 *     Person(birth = 1908, death = 1909) is included in the counts for both 1908 and 1909.
 *
 */

class Person {
	public int birth;
	public int death;
	
	public Person(int birth, int death) {
		this.birth = birth;
		this.death = death;
	}
}

class LivingPeople {
	public static int maxAliveYear(Person[] people, int begin, int end) {
		int[] bornCount = new int[end - begin + 1];
		int[] deathCount = new int[end - begin + 1];
		
		for (Person person : people) {
			bornCount[person.birth - begin]++;
			deathCount[person.death - begin]++;
		}
		
		int max = 0;
		int yearOfMax = 0;
		for (int i = 1; i < (end - begin + 1); ++i) {
			bornCount[i] += bornCount[i - 1];
			deathCount[i] += deathCount[i - 1];
			int totalAlive = bornCount[i] - deathCount[i - 1];
			if (totalAlive > max) {
				max = totalAlive;
				yearOfMax = i + begin;
			}
		}
		
		return yearOfMax;
	}
	
	public static void main(String[] args) {
		Person[] people = new Person[3];
		
		people[0] = new Person(1945, 1950);
		people[1] = new Person(1950, 1960);
		people[2] = new Person(1945, 1950);
		
		System.out.println(maxAliveYear(people, 1940, 1960));
	}
}