/**
 *
 * 3.6 Animal Shelter
 *     An animal shelter, which holds only dogs and cats, operates on a strictly "first in,
 *      first out". basis. People must adopt either the "oldest"(based on arrival time)
 *      of all animals at the shelter, or the can select whether they should prefer a dog
 *      or a cat (and will receive the oldest animal of that type). They cannot select
 *      which specific animal they would like. Create the data structures to maintain
 *      this system and implement operations such as enqueue, dequeueAny, dequeueDog,
 *      and dequeueCat. You may use the build-in LinkedList data structure.
 *
 */
class Animal {
    private static int counter;
    private int index;
    private String name;

    public Animal(String name) {
        this.name = name;
        index = counter;
        ++counter;
    }

    public int getIndex() {
        return index;
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }
}

class AnimalQueue {
    private LinkedList<Cat> cats;
    private LinkedList<Dog> dogs;

    public AnimalQueue() {
        cats = new LinkedList<>();
        dogs = new LinkedList<>();
    }

    public void enqueue(Animal animal) {
        if (animal instanceof Cat) {
            cats.add((Cat) animal);
        } else {
            dogs.add((Dog) animal);
        }
    }

    public Animal dequeueAny() {
        if (cats.isEmpty()) {
            return dogs.poll();
        } else if (dogs.isEmpty()) {
            return cats.poll();
        }
        return (cats.getFirst().getIndex() < dogs.getFirst().getIndex()) ? cats.removeFirst() : dogs.removeFirst();
    }

    public Cat dequeueCat() {
        return cats.poll();
    }

    public Dog dequeueDog() {
        return dogs.poll();
    }
}

class AnimalShelter {
	public static void main(String[] args) {
		
	}
}