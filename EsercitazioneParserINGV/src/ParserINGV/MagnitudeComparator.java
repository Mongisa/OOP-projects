package ParserINGV;

import java.util.Comparator;

public class MagnitudeComparator implements Comparator<EQEvent> {
    public int compare(EQEvent e1, EQEvent e2) {
        return Double.compare(e1.getMagnitude(), e2.getMagnitude());
    }
}
