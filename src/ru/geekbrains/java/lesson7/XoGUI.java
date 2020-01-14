package ru.geekbrains.java.lesson7;

public class XoGUI {
    public static void main(String[] args) {
        new GameWindow();
    }
}

/*
Иван, вопросы такие (заранее спасибо!):
1. Вопрос по последнему ДЗ (п. 3  Расчертить панель Map):
Изначально у меня был такой код (чтобы хотя бы что-то нарисовалось):
 В классе Map
 ...
  Map(int NumberOfLines) {
        setBackground(Color.BLUE);
        NumberOfLines=this.NumberOfLines;
        }
@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellWidth = getWidth() / NumberOfLines;
        int cellHeight = getHeight() / NumberOfLines;
        for (int i = 1; i < NumberOfLines; i++) {
            g.drawLine(i * cellWidth, 0, i * cellWidth, getHeight());
            g.drawLine(0, i * cellHeight, getWidth(), i * cellHeight);
        }
    }
 void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        repaint();
        System.out.printf("mode = %d\nfsX = %d\nwin = %d", gameMode, fieldSizeX, winLength);

    }

    А в GameWindow создавался экземпляр класса   map = new Map(3);
    И все равно возникала ошибка деления на 0. Я не поняла, ну откуда она берется, ведь явно прописано, что NumberOfLines=3??

2. В ДЗ №4 у меня был метод SalaryUp(int age, int raise) в классе Employee и Вы написали комментарий, что это не логично,
   что сотрудник внутри себя решает, что ему должны поднять з/п. Но ведь он не решает - возраст и сумма передаются извне.
   Кроме того, внутри класса есть метод setSalary, который также устанавливает з/п, новый метод ведь
   не особо от него отличается по смыслу?

3. В 3 четверти будет автоматизация тестирования, в каком направлении двигаться в самообразовании по Java,
   чтобы подготовиться (может можно выделить какие-то темы, которые нужны больше других)?
 */
