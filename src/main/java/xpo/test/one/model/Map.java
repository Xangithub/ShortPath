package xpo.test.one.model;

public class Map {
    public int WIDE;
    public int HEIGHT;
    public int SIZE_INPUT_DATA;
    private Vertex[] arVertex;
    private Vertex startVertex;
    private Vertex endVertex;


    public Map(int wide, int height) {
        if (wide > 0 && height > 0) {
            WIDE = wide;
            HEIGHT = height;
        } else System.exit(1);
        SIZE_INPUT_DATA = WIDE * HEIGHT;
        arVertex = new Vertex[SIZE_INPUT_DATA];
    }

    public Map(int wide, int height, Vertex[] arVertex) {
        if (wide > 0 && height > 0) {
            WIDE = wide;
            HEIGHT = height;
        } else System.exit(1);
        SIZE_INPUT_DATA = WIDE * HEIGHT;
        this.arVertex = arVertex;
    }

    //    private void clearDistance
    private void generateData() {
        for (int i = 0; i < SIZE_INPUT_DATA; i++) {
            arVertex[i] = new Vertex(i);
        }

    }

    public int getWIDE() {
        return WIDE;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getSIZE_INPUT_DATA() {
        return SIZE_INPUT_DATA;
    }

    public Vertex[] getArVertex() {
        return arVertex;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getEndVertex() {
        return endVertex;
    }

    public void setEndVertex(Vertex endVertex) {
        this.endVertex = endVertex;
    }

}
