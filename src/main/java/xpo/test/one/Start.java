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
        // если файл задан, то передаём его в конструктор провайдера
        if (fileName == null) dataProvider = new FileProvider();
        else dataProvider = new FileProvider(fileName);

        //получаем строку с данными от провайдера
        data = dataProvider.getData();

        if (data != null) {
            //создаем парсер и передаем ему строку
            dataParser = new DataParse(data);

            //получаем от парсера объект карты
            Map map = dataParser.getMap();

            //создаём построитель пути и передаём ему карту
            PathCreatable pathBuilder = new PathBuilder(map);

            //создаём сервис для отображения карты на консоли
            IDisplayMap displayMap = new MapDisplayOnConsole();

            //печать входных данных для проверки корректности
            // displayMap.printMap(map);

            // просим билдер построить маршрут
            pathBuilder.buildPath(map);

            //печать карты расстояний от точки старта
            // ((MapDisplayOnConsole) displayMap).printDistanceMap(map);

            //печатаем карту
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
