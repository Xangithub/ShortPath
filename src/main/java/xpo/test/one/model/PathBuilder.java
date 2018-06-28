package xpo.test.one.model;

public class PathBuilder implements PathCreatable {
    Map map;

    @Override
    public Map buildPath(Map map) {
        System.out.println("путь построен");
        WavePropagation(map.getStartVertex(),map.getEndVertex());
        return null;
    }

    public PathBuilder(Map map) {
        this.map = map;
    }

    private void WavePropagation(Vertex start, Vertex finish){
        start.setDistance(1);

    }

    /*public int[] WavePropagation(int fromNode, int toNode, ElementManager elementManager) {  // распространение волны
        int[] markedNode = new int[elementManager.GetNumberOfAllNodes()]; // массив, где будут хранится "отметки" каждого узла
        int markNumber = 1;                        // счетчик
        markedNode[fromNode] = markNumber;         // инициализация стартового узла
        while (markedNode[toNode] == 0) {          // пока не достигли финишного узла
            for (int i = 0; i < markedNode.length; i++) {
                if (markedNode[i] == markNumber) {                                          // начинаем со стартового узла
                    for (int j = 0; j < elementManager.GetNode(i).near.size(); j++) {       // просматриваем все соседние узлы
                        if(markedNode[elementManager.GetNode(i).near.get(j).number] == 0    // если он еще не получил "отметку"
                                && elementManager.GetNode(i).near.get(j).isEnable){              // если доступен
                            markedNode[elementManager.GetNode(i).near.get(j).number] = (markNumber + 1);
                        }
                    }
                }
            }
            markNumber++;
        }
        return markedNode;
    }*/

}
