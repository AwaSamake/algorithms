/**
 *
 * 4.7 Build Order
 *     You are given a list of dependencies (which is a list of pair of projects, where
 *     the second project is dependent on the first project). All of a projects' dependencies
 *     must be build before the project is. Find a build order that will allow the projects
 *     to be build. If there is no valid build order, return an error.
 *     EXAMPLE
 *     Input:
 *         project: a, b, c, d, e, f
 *         dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
 *     Output: f, e, a, b, d, c
 *
 */
import java.util.ArrayList;
import java.util.HashMap;;

class Project {
    private ArrayList<Project> children = new ArrayList<Project>();
    private HashMap<String,Project> map = new HashMap<String, Project>();
    public String name;
    private int dependencies;
    
    public Project(String n) {
        name = n;
    }
    
    public void addNeightbor(Project node) {
        if (!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
            node.incrementDependencies();
        }
    }
    
    public void incrementDependencies() {
        dependencies++;
    }
    
    public void decrementDependencies() {
        dependencies--;
    }
    
    public String getName() {
        return name;
    }
    
    public ArrayList<Project> getChildren() {
        return children;
    }
    
    public int getNumberDependencies() {
        return dependencies;
    }
    
}

class Graph {
    private ArrayList<Project> nodes = new ArrayList<Project>();
    private HashMap<String, Project> map = new HashMap<String, Project>();
    
    public Project getOrCreateNode(String name) {
        if (!map.containsKey(name)) {
            Project node = new Project(name);
            nodes.add(node);
            map.put(name, node);
        }
        return map.get(name);
    }
    
    public void addEdge(String startName, String endName) {
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);
        start.addNeightbor(end);
    }
    
    public ArrayList<Project> getNodes() {
        return nodes;
    }
}

class BuildOrder {
    public static Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }
    
    public static Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects) {
            graph.getOrCreateNode(project);
        }
        
        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }
        return graph;
    }
    
    public static Project[] orderProjects(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];
        
        int endOfList = addNonDependent(order, projects, 0);
        
        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];
            
            if (current == null) {
                return null;
            }
            
            ArrayList<Project> children = current.getChildren();
            for (Project child : children) {
                child.decrementDependencies();
            }
            
            endOfList = addNonDependent(order, children, endOfList);
        }
        
        return order;
    }
    
    public static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
        for (Project project : projects) {
            if (project.getNumberDependencies() == 0) {
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }
    
	public static void main(String[] args) {
		String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[][] dependencies = {
                {"a", "b"},
                {"b", "c"},
                {"a", "c"},
                {"a", "c"},
                {"d", "e"},
                {"b", "d"},
                {"e", "f"},
                {"a", "f"},
                {"h", "i"},
                {"h", "j"},
                {"i", "j"},
                {"g", "j"}};
                
        Project[] buildOrder = findBuildOrder(projects, dependencies);
        if (buildOrder == null) {
            System.out.println("Circular Dependency.");
        } else {
            for (Project s : buildOrder) {
                System.out.println(s.name);
            }
        }
	}
}

























