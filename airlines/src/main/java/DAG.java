import java.util.*;

public class DAG<T> {
    private final List<Vertex<T>> vertices = new ArrayList<>();

    public Vertex<T> createVertex(T value) {
        Vertex<T> v = new Vertex<>(value);
        vertices.add(v);
        return v;
    }

    public void createEdge(Vertex<T> from, Vertex<T> to) {
        // добавляем в список смежности только в одном направлении
        from.getAdjacent().add(to);
    }

    public int path(Vertex<T> from, Vertex<T> to) {

        // Длина пути до вершины
        Map<Vertex<T>, Integer> paths = new HashMap<>();

        // добраться из пункта отправления до него же самого можно вообще не летая
        paths.put(from, 0);

        Queue<Vertex<T>> queue = new ArrayDeque<>(); // очередь обхода вершин
        queue.add(from); // начинать будем из города отправления

        int minPath = -1;

        while (!queue.isEmpty()) { // пока очередь не пуста

            // вынимаем следующий элемент из очереди
            Vertex<T> v = queue.poll();

            // Количество перелётов для вынутой вершины
            int path = paths.get(v);

            // если v это город назначения, то конечный путь заносим текущее значение
            // если оно короче предыдущего
            if (v.equals(to) && (minPath > path || minPath == -1)) {
                minPath = path;
            }

            // перебираем вершины по дугам из v
            for (Vertex<T> vertexToQueue : v.getAdjacent()) {

                // если такую вершину уже добавляли в очередь, то
                // пропускаем её если путь до неё был короче чем из данной вершины
                if (paths.containsKey(vertexToQueue) && (paths.get(vertexToQueue) <= (path + 1))) {
                    continue;
                }

                // иначе, добавляем её в очередь, и paths
                paths.put(vertexToQueue, path + 1);
                queue.add(vertexToQueue);
            }
        }

        return minPath;
    }

}