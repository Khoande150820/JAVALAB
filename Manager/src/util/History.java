package util;

/**
 *
 * @author eldee
 */
public class History extends Worker implements Comparable<History> {

    String status;
    String date;

    public History() {
    }

    @Override
    public int compareTo(History t) {
        return this.getId().compareTo(t.getId());
    }

}
