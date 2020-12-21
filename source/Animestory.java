import java.util.ArrayList;

public class Animestory implements Runnable{
    // А МОЖНО БЫЛО ИНТРФЕЙС, ДА?
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    public void run() {
        for (int i = 0; i<5; i++) {
            int a = (int) (Math.random() * 5);
            if (a == 1) animals.add(new Bear());
            else if (a == 2 | a == 4) animals.add(new KWA());
            else animals.add(new Duck());

        }
        for (Animal animal: animals
             ) {
            animal.sound();
        }
    }
}
