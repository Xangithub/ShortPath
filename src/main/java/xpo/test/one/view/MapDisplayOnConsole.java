package xpo.test.one.view;

import xpo.test.one.model.Map;
import xpo.test.one.model.Vertex;

public class MapDisplayOnConsole implements IDisplayMap {

    final private char EMPTY_SPACE = '.';
    final private char WALL = '#';
    final private char BEGIN_POINT = 'o';
    final private char END_POINT = 'x';
    final private char PATH = '*';

    @Override
    public void printMap(Map map) {
        int WIDE = map.getWIDE();
        int HEIGHT = map.getHEIGHT();
        Vertex[] arVertex = map.getArVertex();
        StringBuffer mapBuf= new StringBuffer();
        for (int j = 0; j < HEIGHT; j++) { //движение по строкам. j номер строки
            for (int i = 0; i < WIDE; i++) { //движение по столбцам i номер поля
                int k = j * WIDE + i;
                Vertex vertex = arVertex[k];
                char z = '.';

                if (vertex.isPassable()) z = EMPTY_SPACE; else  z=WALL;
                if (vertex.isEnd_point()) z = END_POINT;
                if (vertex.isStart_point()) z = BEGIN_POINT;
                if (vertex.isPath()) z =PATH;
                mapBuf.append(z);
            }
            mapBuf.append('\n');
        }
        System.out.println(mapBuf.toString());
    }
}
