import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class Main {

    private static Writer writer;
    private static Reader reader;
    private static Reader input;
    //graph for map
    private static Graph<String> graph;

    /**
     *open readers and writer
     * @throws IOException
     */
    private static void init() throws IOException {
        //System.out.print("Initialisation...");
        writer = new Writer("output.txt");
        reader = new Reader("russia.txt");
        input = new Reader("input.txt");
        //System.out.println("/tOK");
    }

    /**
     * close readers and writer
     * @throws IOException
     */
    private static void finish() throws IOException {
        //System.out.print("Finishing...");
        writer.close();
        reader.close();
        input.close();
        //System.out.println("/tOK");
    }

    /**
     * dead date from file and create graph
     */
    private static void readData(){
        //System.out.println("Read...");
        graph = new Graph<String>();

        //read all cities
        String[] buff = reader.readLine().split(" ");
        for (String aBuff : buff) {
            graph.addVertex(aBuff);
        }

        //read all roads
        buff = reader.readLine().split(" ");
        for(int i = 0; i < buff.length; i+=3){
            String[] roadInfo = buff[i+2].split(":");
            double distance = Double.valueOf(roadInfo[0]);
            double time = Double.valueOf(roadInfo[1]);
            double cost = Double.valueOf(roadInfo[2]);
            graph.addRoad(buff[i],buff[i+1],distance,time,cost);
        }
        //System.out.println("\tOK");
    }

    /**
     * search needed paths
     * @throws IOException
     */
    private static void searchRoads() throws IOException {
        while(input.hasNextLine()){
            String strPath = input.readLine();
            String[] path = strPath.split(" ");

            Road road = graph.searchFastestPath(path[0],path[1]);
            double cost = road.getCost() * Double.valueOf(path[2]);

            //create answer
            String out = "";
            out += path[0] + " " + path[1] + " ";
            out += Double.valueOf(path[2]) + " ";
            out += ((double)Math.round(road.getTime()*10))/10 + " ";
            out += cost;
            if (input.hasNextLine()) out += "\n";

            writer.write(out);
        }
    }

    /**
     * main body
     * @throws IOException
     */
    private static void program() throws IOException {
        readData();
        searchRoads();
    }

    /**
     * start point
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        init();
        program();
        finish();
    }
}
