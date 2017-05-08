import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 18.04.2017.
 */
public class Vertex {

    private String name;
    //private static List<Vertex> neighbors;
    private List<Road> roads;
    private boolean color;


    public Vertex(String name){
        this.name = name;
        color = false;
       // neighbors = new ArrayList<>();
        roads = new ArrayList<>();
    }

//    public void addNeighbors(Vertex neighbor){
//        if(!neighbors.contains(neighbor))
//            neighbors.add(neighbor);
//    }

//    public void deleteNeighbor(Vertex neighbor){
//        if(neighbors.contains(neighbor ))
//            neighbors.remove(neighbor);
//    }
}
