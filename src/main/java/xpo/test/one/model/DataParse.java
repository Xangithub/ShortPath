package xpo.test.one.model;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class DataParse {

    public int WIDE = 10;
    public int HEIGHT = 10;
    public int SIZE_INPUT_DATA;


    private Vertex[] arVertex;
    private String data;
    private Map map;

    final private char EMPTY_SPACE = '.';
    final private char WALL = '#';
    final private char BEGIN_POINT = 'o';
    final private char END_POINT = 'x';
    final private char PATH = '*';

    public DataParse(String str) {
        this.data = str;
        System.out.println("Работает detect");
        detect(data);
        System.out.println("Работает validate");
        validateData(data);
        arVertex = new Vertex[SIZE_INPUT_DATA];
        System.out.println("Работает generate");
        generateData();
        System.out.println("Работает convert");
        convert(data);
        System.out.println("Матрица создана");
    }

    private void detect(String data) {
        String[] strings = data.split("\n");
        WIDE = strings[0].length();
        HEIGHT = strings.length;
        SIZE_INPUT_DATA = WIDE * HEIGHT;
        System.out.printf("Подана карта размером ширина= %d высота= %d \n", WIDE, HEIGHT);
    }

   /* public DataParse(Map map) {
        this.WIDE=map.getWIDE();
        this.HEIGHT=map.getHEIGHT();
        this.SIZE_INPUT_DATA=WIDE*HEIGHT;
        this.arVertex=map.getArVertex();

        validateData(data);
        System.out.println("Данные проверены");
        generateData();
        convert(data);
        System.out.println("Матрица создана");
        arVertex = new Vertex[SIZE_INPUT_DATA];
    }*/

    private void generateData() {
        for (int i = 0; i < SIZE_INPUT_DATA; i++) {
            arVertex[i] = new Vertex(i);
        }

    }


    private void convert(String data) {
//        System.out.println(data);
        for (int i = 0; i < SIZE_INPUT_DATA; i++) {
            char z = data.charAt(i);
            switch (z) {
                case END_POINT:
                    arVertex[i].setEnd_point(true);
                    map.setEndVertex(arVertex[i]);
                    break;
                case BEGIN_POINT:
                    arVertex[i].setStart_point(true);
                    map.setStartVertex(arVertex[i]);
                    break;
                case EMPTY_SPACE:
                    arVertex[i].setPassable(true);
                    break;
                case WALL:
                    arVertex[i].setPassable(false);
                    break;
                default:
                    System.err.printf("в строке присутствую посторонние символы позиция =%d =%c \n", i, z);
                    System.exit(1);
            }
        }

        // настройка соседей
        for (int j = 0; j < HEIGHT; j++) { //движение по строкам. j номер строки
            for (int i = 0; i < WIDE; i++) { //движение по столбцам i номер поля
                int k = j * WIDE + i;
                if (i != 0) arVertex[k].addNB(arVertex[k - 1]);
                if (i != WIDE-1) arVertex[k].addNB(arVertex[k + 1]);
                if (j != 0) arVertex[k].addNB(arVertex[k - WIDE]);
                if (j != HEIGHT-1) arVertex[k].addNB(arVertex[k + WIDE]);
            }
        }

    }

    /**
     * Проверяем соответствует ли строка
     * 1. длине данных {@value SIZE_INPUT_DATA}  символов
     * 2. содержит только одну начальную и конечную точки
     * 3. посторонние символы
     * в случае провала проверки прерываем выполнение программы
     *
     * @param str
     **/
    void validateData(String str) {
        data = str.toLowerCase().replaceAll("\n", "");
        if (data == null) return;
        //валидация на наличие множества/полного отсутствия начальных точек или конечных, посторонние символы
        Pattern p = Pattern.compile("([.|#]*[xX][.|#]*[oO][.|#]*)|([.|#]*[oO][.|#]*[xX][.|#]*)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(data);
        boolean b = m.matches();

        if (!b) try {
            throw new Exception("Внутри поля ошибки разметки. Посторонние символы или много начальных или конечных точек");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            exit(1);
        }

       /* int coountO = 0, countX = 0;
        for (int i = 0; i < dataSize; i++) {
            if (data.charAt(i) == 'o' || data.charAt(i) == 'O') coountO++;
            if (data.charAt(i) == 'x' || data.charAt(i) == 'X') coountO++;
            if (coountO > 1 || countX > 1) try {
                throw new Exception("Внутри поля больше 1 начальной  или конечной точки");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                exit(1);
            }
        }*/
    }

    /**
     *
     * */
    public Map getMap() {
        map = new Map(WIDE,HEIGHT,arVertex);
        return map;
    }

}
