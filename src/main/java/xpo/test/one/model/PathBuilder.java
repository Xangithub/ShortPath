package xpo.test.one.model;

import java.util.ArrayList;

public class PathBuilder implements PathCreatable {
    Map map;
    Vertex[] vertex;
    int HEIGHT;
    int WIDE;

    @Override
    public Map buildPath(Map map) {
        WavePropagation(map.getStartVertex(), map.getEndVertex());
        ArrayList<Vertex> returnPointList = new ArrayList<>();
        returnPointList.add(map.getEndVertex());
        pathRestore(map.getStartVertex(), map.getEndVertex(), map.getEndVertex().getDistance(), returnPointList);
        return map;
    }

    private void WavePropagation(Vertex start, Vertex finish) {
        int mark = 1;
        start.setDistance(mark);
        while (finish.getDistance() == 0) {
            for (int i = 0; i < WIDE * HEIGHT; i++) { //движение по столбцам i номер поля
                if (vertex[i].getDistance() == mark) {
                    ArrayList<Vertex> list = vertex[i].getNbList();
                    for (Vertex vertEl : list) {
                        if (vertEl.isPassable() && vertEl.getDistance() == 0) {
                            vertEl.setDistance(mark + 1);
                        }
                    }

                }
            }
            mark++;
        }
    }

    private void pathRestore(Vertex start, Vertex finish, int mark, ArrayList<Vertex> returnPointList) {
        mark--;
        for (Vertex vertexElement : finish.getNbList()) {
            if (vertexElement.getDistance() == mark) { //ищем точки с расстоянием mark
                finish = vertexElement;
                finish.setPath(true);
                break;
            }

        }
        returnPointList.add(finish);
        if (finish != start) pathRestore(start, finish, mark, returnPointList);
    }

    private void clearPath() {
        for (Vertex vertexElement : vertex) {
            vertexElement.setPath(false);
            vertexElement.setDistance(0);
        }
    }

    public PathBuilder(Map map) {
        this.map = map;
        this.vertex = map.getArVertex();
        HEIGHT = map.getHEIGHT();
        WIDE = map.getWIDE();

    }
}

