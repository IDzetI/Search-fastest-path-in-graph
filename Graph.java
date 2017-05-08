import java.util.*;

/**
 * Created by User on 18.04.2017.
 */
public class Graph<V extends Comparable<V>> {

    //Data for storage graph
    private List<V> vertices;
    private List<Road<V>> roads;

    /**
     * create empty graph
     */
    public Graph(){
        vertices = new ArrayList<V>();
        roads = new ArrayList<Road<V>>();
    }

    /**
     * add new vertex
     * @param vertex
     */
    public void addVertex(V vertex){
        vertices.add(vertex);
    }

    /**
     * add new road
     * @param start
     * @param end
     * @param distance
     * @param time
     * @param cost
     */
    public void addRoad(V start, V end, double distance, double time, double cost){
        for (Road road:roads) {
            if(road.has(start) && road.next(start).compareTo(end) == 0 && distance == road.getDistance() && time == road.getTime() & cost == road.getCost()){
                return;
            }
        }
        roads.add(new Road<V>(start, end, distance,time, cost));
    }

    /**
     * search fastest path
     * @param start
     * @param end
     * @return
     */
    public Road<V> searchFastestPath(V start, V end){

        PriorityQueue<Road<V>,Double> queue = new PriorityQueue<>();
        List<V> colored = new ArrayList<>();

        queue.add(new Road<V>(start,start,0,0,0), (double) 0);

        while(!queue.isEmpty()) {
            Road<V> local = queue.remove();
            colored.add(local.getEnd());

            if(local.getEnd().compareTo(end) == 0 ){
                return local;
            }

            for (Road<V> item : roads) {
                if (item.has(local.getEnd()) && !colored.contains(item.next(local.getEnd()))) {
                    Road<V> next = new Road<V>(local.getStart(), item.next(local.getEnd()),
                            local.getDistance() + item.getDistance(),
                            local.getTime() + item.getTime(),
                            local.getCost() + item.getCost());
                    //queue.add(next, next.getDistance()); // shortest path
                    queue.add(next, next.getTime());//fastest path
                }
            }
        }
        return null;
    }

    /**
     * print all roads
     */
    public void printEdges() {
        for (Road road:roads) {
            System.out.println(road.getStart()+" "+
                    road.getEnd()+" "+
                    road.getDistance()+" "+
                    road.getTime()+" "+
                    road.getCost());
        }
    }
}
