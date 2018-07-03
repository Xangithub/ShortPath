package xpo.test.one;

import xpo.test.one.file.DataProvider;
import xpo.test.one.file.FileProvider;
import xpo.test.one.model.DataParse;
import xpo.test.one.model.Map;
import xpo.test.one.model.PathBuilder;
import xpo.test.one.model.PathCreatable;
import xpo.test.one.view.IDisplayMap;
import xpo.test.one.view.MapDisplayOnConsole;

public class Start {
    DataProvider dataProvider;


    DataParse dataParser;
    // final static String FILE = "ccor3.txt";
    String data;

    public Start(String fileName) {
        if (fileName == null) dataProvider = new FileProvider();
        else dataProvider = new FileProvider(fileName);

        data = dataProvider.getData();

        if (data != null) {
            dataParser = new DataParse(data);
            Map map = dataParser.getMap();
            PathCreatable pathBuilder = new PathBuilder(map);
            IDisplayMap displayMap = new MapDisplayOnConsole();
            //печать входных данных для проверки корректности
            // displayMap.printMap(map);
            pathBuilder.buildPath(map);
            //печать карты расстояний от точки старта
            // ((MapDisplayOnConsole) displayMap).printDistanceMap(map);
            displayMap.printMap(map);

        }
    }

    public static void main(String[] args) {
        String fileName = null;
        if (args.length > 0) {
            fileName = args[0];
        }
        new Start(fileName);
    }

}
