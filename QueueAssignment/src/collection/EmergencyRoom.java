package collection;
import java.util.PriorityQueue;
import java.util.Comparator;

class Patient {
    String name;
    int priority;

    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String toString() {
        return "Patient{name='" + name + "', priority=" + priority + "}";
    }
}

class PatientComparator implements Comparator<Patient> {
  
    public int compare(Patient p1, Patient p2) {
        return Integer.compare(p2.priority, p1.priority);
    }
}

public class EmergencyRoom {
    public static void main(String[] args) {

        PriorityQueue<Patient> emergencyRoomQueue = new PriorityQueue<>(new PatientComparator());


        emergencyRoomQueue.add(new Patient("Saurabh", 3));
        emergencyRoomQueue.add(new Patient("Ram", 1));
        emergencyRoomQueue.add(new Patient("Sham", 4));
        emergencyRoomQueue.add(new Patient("Rana", 2));

        while (!emergencyRoomQueue.isEmpty()) {
            Patient nextPatient = emergencyRoomQueue.poll();
            System.out.println("Processing patient: " + nextPatient);
        }
    }
}
