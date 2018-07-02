import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	private Graph<String> g = new Graph<>();
    private Random random = new Random();
	
    private String name = "Die Körperform von Kugelfischen weicht stark von der typischen Fischgestalt ab. Er hat eine rundliche, gedrungene Gestalt. Kopf und Augen sind stark ausgebildet. Der schnabelähnliche Beißapparat besteht aus zu Zahnleisten verwachsenen Zähnen, wobei je zwei Zahnleisten oben und unten stehen. Hierauf bezieht sich auch die wissenschaftliche Namensgebung dieser Familie hochentwickelter Knochenfische: Tetraodontidae = Vierzähner. Ihre lederartige, widerstandsfähige Haut ist nackt, die Schuppen sind zu kurzen Stacheln reduziert.\n" +
            "\n" +
            "Der Antrieb erfolgt überwiegend durch die Brustflossen. Rückenflosse und Afterflosse schwirren nur zur Unterstützung mit. Schwanzstiel und Schwanzflosse dienen als Steuerruder. Dadurch ist der Kugelfisch zwar recht langsam, aber äußerst wendig. Er kann sowohl vorwärts als auch rückwärts schwimmen sowie aufwärts und abwärts steigen. Eine Besonderheit der Kugelfische ist, dass sie keine Bauchflossen besitzen.\n" +
            "\n" +
            "Kugelfische können sich bei Gefahr aufpumpen, indem eine kräftige Muskulatur ruckweise Wasser aus der Mundhöhle in eine bauchseitige, sackartige Erweiterung des Magens presst. Dies soll auf Angreifer abschreckend wirken. Starke Ringmuskeln am Mageneingang verhindern das Rückfließen des Wassers. Die Stacheln, die sonst eng am Körper anliegen, stehen nun nach außen und fungieren als Widerhaken. Dadurch und durch die enorme Volumenvergrößerung ist es einem Raubtier fast unmöglich, den Kugelfisch zu verschlingen. Jacques Cousteau berichtet, dass sich Kugelfische im Rachen großer Raubfische (Haie) noch aufblasen, so dass sie feststecken und der Räuber erstickt. Werden Kugelfische durch Menschen gezielt zum Aufblasen provoziert, ist dies mit großem Stress für die Fische verbunden – es fällt ihnen schwer, das aufgenommene Wasser wieder auszustoßen. Außerhalb des Wassers pumpen sie Luft in den Magensack, ersticken so aber bald.";

    public static void main(String[] args) {
        new Main();
    }

    private Main() {
        System.out.println(test().toString());
    	
        //System.out.println(randomGraph(50, 75).toString());
        
       
        //Vertex start = g.getVertices().get(new Random().nextInt(g.getVertices().size()));
        //Vertex goal = g.getVertices().get(new Random().nextInt(g.getVertices().size()));
        Vertex start = g.getVertex("Berlin");
        Vertex goal = g.getVertex("USA");
        
        while(start.equals(goal)) {
        	goal = g.getVertices().get(new Random().nextInt(g.getVertices().size()));
        }
        
        // cheapest
        CheapestPath cheapest = new CheapestPath();
        cheapest.computePaths(start);
        System.out.println("Distance from " + start.getData() + " to " + goal.getData() + ": " + goal.minDistance);
        List<Vertex> cheapestPath = cheapest.getCheapestPathTo(goal);
        System.out.println("Cheapest path: " + cheapestPath);
        
        // shortest
        ShortestPath shortest = new ShortestPath();
        shortest.computePaths(start);
        System.out.println("Path from " + start.getData() + " to " + goal.getData());
        List<Vertex> shortestPath = shortest.getShortestPathTo(goal);
        System.out.println("Shortest path: " + shortestPath);
    }


    private Graph randomGraph(int vertices, int edges) {
        String[] names = name.split(" +");
        
        for (int i = 0; i <= vertices; i++) {
            if (!g.addVertex(new Vertex<>(names[(new Random().nextInt(names.length))]))) {
                i--;
            }
        }
        for (int i = 0; i <= edges; i++) {
            List<Vertex<String>> verticesList = g.getVertices();
            if (!g.addEdge(verticesList.get(random.nextInt(verticesList.size())), verticesList.get(random.nextInt(verticesList.size())), random.nextInt(100))) {
                i--;
            }
        }

        return g;
    }



    private Graph test() {
        g.addEdge(new Vertex<>("Berlin"), new Vertex<>("Berlin"), 5);
        g.addEdge(new Vertex<>("Berlin"), new Vertex<>("Muenchen"), 3);
        g.addEdge(new Vertex<>("Muenchen"), new Vertex<>("Wien"), 2);
        g.addEdge(new Vertex<>("Berlin"), new Vertex<>("Prag"), 1);
        g.addEdge(new Vertex<>("Prag"), new Vertex<>("USA"), 9);

        g.addEdge("Berlin", "Prag", 3);
        g.addEdge("Berlin", "Muenchen", 8);
        g.addEdge("Berlin", "Hamburg", 423);
        g.addEdge("Berlin", "London", 1);
        g.addEdge("Berlin","USA", 30);

        return g;
    }
}
