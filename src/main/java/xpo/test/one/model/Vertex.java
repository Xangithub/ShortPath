package xpo.test.one.model;

import java.util.ArrayList;

public class Vertex {
    Integer vertex;
    private boolean isVisited;
    private boolean passable;
    private ArrayList<Vertex> nbList = new ArrayList<>(4);
    private int distance = 0;
    private boolean end_point;
    private boolean start_point;
    private boolean path = false;

    public Vertex(Integer vertex) {
        this.vertex = vertex;
        this.passable = true;
        this.isVisited = false;
    }

    public Vertex(Integer vertex, boolean passable) {
        this.vertex = vertex;
        this.passable = passable;
        this.isVisited = false;
    }

    public void addNB(Vertex nb) {
        if (nbList.size() < 4) nbList.add(nb);
    }

    public ArrayList<Vertex> getNbList() {
        return nbList;
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

    public void setPassable(boolean passable) {
        this.passable = passable;
        if (!passable) {
            this.end_point = false;
            this.start_point = false;
        }
    }

    public void setEnd_point(boolean end_point) {
        this.end_point = end_point;
        if (end_point) passable = true;
    }

    public void setStart_point(boolean start_point) {
        this.start_point = start_point;
        if (start_point) passable = true;

    }

    public boolean isEnd_point() {
        return end_point;
    }

    public boolean isStart_point() {
        return start_point;
    }

    public boolean isPath() {
        return path;
    }

    public void setPath(boolean path) {
        this.path = path;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}

