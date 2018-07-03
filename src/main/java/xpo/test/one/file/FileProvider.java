package xpo.test.one.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * класс призван обеспечить поставку данных из заданного текстового файла
 * если имя не задано, то по умолчанию имя файла "coor.txt"
 */

public class FileProvider implements DataProvider {

    private Path fileName;


    public FileProvider() {
        fileName = Paths.get("coor.txt");
        if (!Files.exists(fileName)) {
            System.err.println("файл coor.txt не найден.... Выход из приложения");
            System.exit(1);
        }
    }

    public FileProvider(Path fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getData() {
        List<String> list = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        if (Files.exists(fileName)) {
            try {
                list = Files.readAllLines(fileName);

                for (String s : list) {
                    stringBuffer.append(s).append('\n');
                }

            } catch (IOException e) {
                System.err.println("Файл не читается");
                e.printStackTrace();
            }

        }
        return stringBuffer.toString();
    }
}
