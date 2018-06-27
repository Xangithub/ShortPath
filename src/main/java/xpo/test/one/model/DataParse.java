package xpo.test.one.model;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class DataParse {
    public static final int SIZE_INPUT_DATA = 100;
    private Vertex[] arVertex = new Vertex[SIZE_INPUT_DATA];
    private int dataSize;

    final private char EMPTY_SPACE = '.';
    final private char WALL = '#';
    final private char BEGIN_POINT = 'o';
    final private char END_POINT = 'x';

    public DataParse(String data) {

//        String str ="#.x...o..#";
        checkSize(data);
        System.out.println("Данные проверены");
        //todo код по преобразованию
        convert(data);
        System.out.println("Матрица создана");
    }

    private void convert(String data) {
        Vertex current;
        for (int i = 0; i < dataSize; i++) {
            char z = data.charAt(i);
            switch (z) {
                case EMPTY_SPACE:
                case END_POINT:
                case BEGIN_POINT:
                    current = new Vertex(i, true);
                    break;
                case WALL:
                    current = new Vertex(i, false);
                    break;
                default:
                    System.err.println("в строке присутствую посторонние символы");
                    System.exit(1);
            }


        }

    }

    /**
     * Проверяем соответствует ли
     * 1. длина данных {@value SIZE_INPUT_DATA}  символов
     * 2. Начальная и конечная точки только по одной штуке
     * в случае провала проверки прерываем выполнение программы
     *
     * @param data
     **/
    void checkSize(String data) {
        data = data.toLowerCase();
        if (data == null) return;
        dataSize = data.length();
        if (dataSize != SIZE_INPUT_DATA) {
            try {
                throw new Exception("Размер входной строки не позволяет создать матрицу 10 на 10");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                exit(1);
            }

        }
        //наличие множества/полного отсутствия начальных точек или конечных
        Pattern p = Pattern.compile("[.|#]*[xXoO][.|#]*[xXoO][.|#]*", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(data);
        boolean b = m.matches();

        if (!b) try {
            throw new Exception("Внутри поля ошибки разметки");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            exit(1);
        }

       /* int coountO = 0, countX = 0; //todo есть идея заменить эту проверку регексом.
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
    public Vertex[] getMatrix() {

        return arVertex;
    }

}
