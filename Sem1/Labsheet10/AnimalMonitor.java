import java.util.ArrayList;
import java.util.Iterator;

/**
 * Monitor counts of different types of animal.
 * Sightings are recorded by spotters.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (imperative)
 */
public class AnimalMonitor 
{
    // Records of all the sightings of animals.
    private ArrayList<Sighting> sightings;
    
    /**
     * Create an AnimalMonitor.
     */
    public AnimalMonitor()
    {
        this.sightings = new ArrayList<>();
    }
    
    public static void main(String[] args) {
        AnimalMonitor animalMonitor1 = new AnimalMonitor();
        animalMonitor1.addSightings("sightings.csv");
        animalMonitor1.printList();
        animalMonitor1.printSightingsOf("Buffalo");
        animalMonitor1.printSightingsInPeriod(2);
        animalMonitor1.printSightingsOfAnimalInPeriod("Mountain Gorilla", 2);
        System.out.println(animalMonitor1.getCount("Buffalo"));
        animalMonitor1.printSightingsBy(3);
    }

    /**
     * Add the sightings recorded in the given filename to the current list.
     * @param filename A CSV file of Sighting records.
     */
    public void addSightings(String filename)
    {
        SightingReader reader = new SightingReader();
        sightings.addAll(reader.getSightings(filename));
    }
    
    /**
     * Print details of all the sightings.
     */
    public void printList()
    {
        sightings.forEach((Sighting record) -> System.out.println(record.getDetails()));
    }
    
    /**
     * Print the details of all the sightings of the given animal.
     * @param animal The type of animal.
     */
    public void printSightingsOf(String animal)
    { 
        sightings.stream().filter(s -> animal.equals(s.getAnimal())).forEach((Sighting record) -> System.out.println(record.getDetails()));
    }

    /**
     * Print the details of all the sightings recorded during a particular period.
     * @param period The period of the sightings.
     */
    public void printSightingsInPeriod(int period)
    {
        sightings.stream().filter(s -> period == s.getPeriod()).forEach((Sighting record) -> System.out.println(record.getDetails()));
    }

    /**
     * Print the details of all the sightings recorded of a particular animal during a particular period.
     * @param animal The type of animal.
     * @param period The period of the sightings.
     */
    public void printSightingsOfAnimalInPeriod(String animal, int period)
    {
        sightings.stream().filter(s -> animal.equals(s.getAnimal())).filter(s -> period == s.getPeriod()).forEach((Sighting record) -> System.out.println(record.getDetails()));
    } 

    /**
     * Print all the sightings by the given spotter.
     * @param spotter The ID of the spotter.
     */
    public void printSightingsBy(int spotter)
    {
        sightings.stream().filter(s -> s.getSpotter() == spotter).map(s -> s.getDetails()).forEach(System.out::println);;
    }
    
    /**
     * Print a list of the types of animal considered to be endangered.
     * @param animalNames A list of animals names.
     * @param dangerThreshold Counts less-than or equal-to to this level
     *                        are considered to be dangerous.
     */
    public void printEndangered(ArrayList<String> animalNames, 
                                int dangerThreshold)
    {
        for(String animal : animalNames) {
            if(getCount(animal) <= dangerThreshold) {
                System.out.println(animal + " is endangered.");
            }
        }
    }
    
    /**
     * Return a count of the number of sightings of the given animal.
     * @param animal The type of animal.
     * @return The count of sightings of the given animal.
     */
    public int getCount(String animal)
    {
        return sightings.stream().filter(s -> animal.equals(s.getAnimal())).map(s -> s.getCount()).reduce(0, (acc, element) -> (acc + element));
    }
    
    /**
     * Remove from the sightings list all of those records with
     * a count of zero.
     */
    public void removeZeroCounts()
    {
        Iterator<Sighting> it = sightings.iterator();
        while(it.hasNext()) {
            Sighting record = it.next();
            if(record.getCount() == 0) {
                it.remove();
            }
        }
    }
    
    /**
     * Return a list of all sightings of the given type of animal
     * in a particular area.
     * @param animal The type of animal.
     * @param area The ID of the area.
     * @return A list of sightings.
     */
    public ArrayList<Sighting> getSightingsInArea(String animal, int area)
    {
        ArrayList<Sighting> records = new ArrayList<>();
        for(Sighting record : sightings) {
            if(animal.equals(record.getAnimal())) {
                if(record.getArea() == area) {
                    records.add(record);
                }
            }
        }
        return records;
    }
    
    /**
     * Return a list of all the sightings of the given animal.
     * @param animal The type of animal.
     * @return A list of all sightings of the given animal.
     */
    public ArrayList<Sighting> getSightingsOf(String animal)
    {
        ArrayList<Sighting> filtered = new ArrayList<>();
        for(Sighting record : sightings) {
            if(animal.equals(record.getAnimal())) {
                filtered.add(record);
            }
        }
        return filtered;
    }

}
