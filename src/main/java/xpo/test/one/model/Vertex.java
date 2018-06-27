package xpo.test.one.model;

import java.util.ArrayList;

public class Vertex{
    Integer vertex;
    private boolean isVisited;
    private final boolean passable;
    private ArrayList<Vertex> nbList = new ArrayList<>(4);
    private int distance = 0;


    public Vertex(Integer vertex, boolean passable) {
        this.vertex = vertex;
        this.passable = passable;
        this.isVisited = false;
    }

    public void addNB(Vertex nb) {
        if (nbList.size() < 4) nbList.add(nb);
    }

    public Integer getVertex() {
        return vertex;
    }

    public void clearMark() {
        isVisited = false;
        distance = 0;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    void display() {
        System.out.println(this.getVertex());
    }

    public boolean isPassable() {
        return passable;
    }

}

