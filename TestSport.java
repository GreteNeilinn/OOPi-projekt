import java.util.ArrayList;
import java.util.List;

public class TestSport {

    public static void main(String[] args) {

        Võrkpall treening1 = new Võrkpall("pallitrenn", 90, 75);
        Spordialad treening2 = new Jalgpall("jalkatrenn", 60, 64);  //polümorfism?
        Spordialad treening3 = new Pikamaajooks("10 kilti", 76, 83);
        Spordialad sport = new Spordialad("sportsport", 45, 72.0);

        List<Spordialad> spordialad = new ArrayList<>();
        spordialad.add(treening1);
        spordialad.add(treening2);
        spordialad.add(treening3);
        spordialad.add(sport);

        for (int treening = 0; treening < spordialad.size(); treening++) {
            System.out.println(spordialad.get(treening));
        }

        System.out.println(Spordialad.arvutaNädalasKokku());

    }
}
