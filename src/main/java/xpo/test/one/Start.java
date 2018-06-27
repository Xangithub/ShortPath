package xpo.test.one;

import com.sun.istack.internal.NotNull;
import xpo.test.one.file.DataProvider;
import xpo.test.one.file.FileProvider;
import xpo.test.one.model.DataParse;
import xpo.test.one.model.PathBuilder;
import xpo.test.one.model.PathCreatable;
import xpo.test.one.model.Vertex;

public class Start {
    @NotNull
    final DataProvider dataProvider = new FileProvider();
    DataParse dataParser;

    @NotNull
    String data;


    public Start() {
        data = dataProvider.getData();
        if (data!= null) {
            dataParser = new DataParse(data);
            Vertex[] arVertex=dataParser.getMatrix();
            PathCreatable pathBuilder= new PathBuilder(arVertex);
        }
    }

    public static void main(String[] args) {
        new Start();
    }

}
