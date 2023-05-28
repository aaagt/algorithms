import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex<T> {
    private final T value;
    private final List<Vertex> adjacent = new ArrayList<>(); // список смешности

    public Vertex(T value) {
        this.value = value;
    }

    public List<Vertex> getAdjacent() {
        return adjacent;
    }

    public void addAdjacentVertex(Vertex<T> adjacentVertex) {
        this.adjacent.add(adjacentVertex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return value.equals(vertex.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
