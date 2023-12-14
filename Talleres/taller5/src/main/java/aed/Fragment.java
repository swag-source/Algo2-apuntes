package aed;

public class Fragment implements Comparable<Fragment> {
    int _id;

    public Fragment(int id) {
        _id = id;
    }
    @Override
    public int compareTo(Fragment o) {
        Collector.getInstance().inc();
        return Integer.compare(this._id, o._id);
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append(_id);
        return s.toString();
    }
}
