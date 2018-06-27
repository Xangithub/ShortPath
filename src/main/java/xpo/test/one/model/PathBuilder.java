package xpo.test.one.model;

public class PathBuilder implements PathCreatable {
    Vertex[] arVertex;

    @Override
    public Vertex[] buildPath(Vertex[] arVertex) {
        System.out.println("путь построен");
        return new Vertex[0];
    }

    public PathBuilder(Vertex[] arVertex) {
        this.arVertex = arVertex;
    }
}
