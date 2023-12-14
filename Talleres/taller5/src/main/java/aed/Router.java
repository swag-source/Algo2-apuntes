package aed;

public class Router implements Comparable<Router> {
    private int _id;
    private int _trafico;
    public Router(int id, int trafico) {
        _id = id;
        _trafico = trafico;
    }

    public int getTrafico() {
        return _trafico;
    }


    @Override
    public int compareTo(Router o) {
        Collector.getInstance().inc();
        return Integer.compare(this._trafico, o._trafico);
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append(_id);
        s.append(", ");
        s.append(_trafico);
        return s.toString();
    }
}