/**
 * Created by User on 18.04.2017.
 */
public class Road<V extends Comparable<V>>{

    // data for store information about road
    private V start;
    private V end;
    private double distance;
    private double time;
    private double cost;

    /**
     * create road
     * @param start
     * @param end
     * @param distance
     * @param time
     * @param cost
     */
    public Road(V start, V end, double distance, double time, double cost){
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.time = time;
        this.cost = cost;
    }

    /**
     * get start
     * @return start
     */
    public V getStart() {
        return start;
    }

    /**
     * get end
     * @return end
     */
    public V getEnd() {
        return end;
    }

    /**
     * get distance
     * @return distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * get time
     * @return time
     */
    public double getTime() {return time;}

    /**
     * get cost
     * @return cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * if road has vertex
     * @param vertex
     * @return is has
     */
    public boolean has(V vertex){
        return start.compareTo(vertex) == 0 || end.compareTo(vertex) == 0;
    }

    /**
     * get other vertex
     * @param vertex
     * @return other vertex
     */
    public V next(V vertex){
        if(has(vertex)){
            if (start.compareTo(vertex) == 0) return end;
            else return start;
        }else
            return null;
    }
}
