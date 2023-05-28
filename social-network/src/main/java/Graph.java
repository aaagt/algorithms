import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph<T> {
    private final List<Vertex<T>> vertices = new ArrayList<>();

    public Vertex<T> createVertex(T value) {
        Vertex<T> v = new Vertex<>(value);
        vertices.add(v);
        return v;
    }

    public void createEdge(Vertex<T> a, Vertex<T> b) {
        a.addAdjacentVertex(b);
        b.addAdjacentVertex(a);
    }

    public boolean isConnected(Vertex<T> a, Vertex<T> b) {
        return dfsFind(a, b, new HashSet<>()); //
    }

    /**
     * рекурсивный обход в глубину
     * метод отвечает на вопрос, нашли ли мы обходом из v вершину target с учётом
     * посещённых вершин, которые записаны в visited
     *
     * @param v
     * @param target
     * @param visited
     * @return
     */
    private boolean dfsFind(Vertex<T> v, Vertex<T> target, Set<Vertex<T>> visited) {
        // если вершина в которую зашли (v) это та которую мы искали (target), то поиск закончен
        if (v.equals(target)) {
            return true; // нашли
        }
        visited.add(v); // запоминаем вершину которую посетили

        // перебираем все смежные вершины у v
        for (Vertex<T> vertexToCheck : v.getAdjacent()) {

            // посещённые пропускаем
            if (visited.contains(vertexToCheck)) {
                continue;
            }

            // если нашли - возвращаем true
            if (vertexToCheck.equals(target)) {
                return true;
            }

            // если такую вершину ещё не посещали, заходим рекурсивно в неё
            // если такой заход завершился нахождением target-а - выходим из метода с true
            if (dfsFind(vertexToCheck, target, visited)) {
                return true;
            }
        }

        return false; // ничего не нашли
    }

}
