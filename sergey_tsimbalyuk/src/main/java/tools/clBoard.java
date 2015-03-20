package tools;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;

import java.awt.FontMetrics;

import java.awt.Graphics;

import java.awt.Graphics2D;

import java.awt.Image;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;

import java.awt.event.MouseMotionListener;

import java.awt.image.BufferedImage;

import javax.swing.JButton;

import javax.swing.JPanel;

import javax.swing.Timer;


/**
 * Created by Sergey Tsimbalyuk on 10.03.15.
 */


public class clBoard extends JPanel

{

    private static final long serialVersionUID = 1L;

    /**
     * Конструктор (по умолчанию) класса доски
     */

    clBoard()

    {

        super();/// вызов конструктора предка

        this.setLayout(null);/// убираем менеджер размещения, т.к. сами будет распологать фигуры

    }


    /**
     * Главный конструктор создания доски с одним конем
     *
     * @param Diagonal          Размер доски, т.е. колич. клеток по горизонтали и вертикали.
     * @param Size              Размер в пикселях клеток на доске.
     * @param ImageCellsStretch Растягивать ли изображение до размера клетки.
     * @param ImageWhiteCells   Изображение светлой ячейки, если null то рисуется белый квадрат.
     * @param ImageBlackCells   Изображение темной ячейки, если null то рисует черный квадрат.
     * @param FirstCellWhite    Флаг того что первая ячейка на доске белая, при false - темная.
     * @param ImageHorse        Изображение этого одного коня, с прозрачными областями(+Альфа-канал).
     * @param PosX              Позиция коня по горизонтали: 0,1,2..(Size-1)
     * @param PosY              Позиция коня по вертикали: 0,1,2..(Size-1)
     */

    clBoard(int Diagonal, int Size, boolean ImageCellsStretch, BufferedImage ImageWhiteCells, BufferedImage ImageBlackCells, boolean FirstCellWhite, Image ImageHorse, int PosX, int PosY)

    {

        this();//вызывает конструктор по умолчанию

        BoardSizeInit(Diagonal, Size);///инициализируем размерные параметры доски

        //создаем озображение белой клетки под размеры ячейки

        BufferedImage imageWhiteCells = new BufferedImage(CellsSize, CellsSize, BufferedImage.TYPE_3BYTE_BGR);

        Graphics2D gImageWhiteCells = imageWhiteCells.createGraphics();//создаем графический контекст этого изображения, для рисования на нем

        //создаем озображение черной клетки

        BufferedImage imageBlackCells = new BufferedImage(CellsSize, CellsSize, BufferedImage.TYPE_3BYTE_BGR);

        Graphics2D gImageBlackCells = imageBlackCells.createGraphics();


        //если аргумент конструктора изображения клетки нулевое(null), то создаем изображение клетки по умолчанию

        if (ImageWhiteCells == null)

        {

            gImageWhiteCells.setBackground(Color.white);// выбираем фоновый цвет

            gImageWhiteCells.clearRect(0, 0, CellsSize, CellsSize);//очищаем всю область изображения клетки фоновым цветом

        } else////если изображение не нулевое, то мы его рисуем на (для) изображении клетки

        {

            if (ImageCellsStretch == true)///растягивание (подгон под размер области)изображения под квадратную клетку

            {

                gImageWhiteCells.drawImage(ImageWhiteCells, 0, 0, CellsSize, CellsSize, null);

                /// CellsSize, CellsSize - размеры области, в которую должен уместиться рисунок, он сам подгоняется под размеры области(растягивается, сжимается)

            } else

            {

                gImageWhiteCells.drawImage(ImageWhiteCells, 0, 0, null);

                /// null - нет хозяина(сервера) у графиша, которого надо было бы уведомить о том что "рисунок" обновился,

                //он должен выполнить соотв. действия (перепрорисовка объекта)

            }

        }

        ///аналогично, что и для белой клетки

        if (ImageBlackCells == null)

        {

            gImageBlackCells.setBackground(Color.black);

            gImageBlackCells.clearRect(0, 0, CellsSize, CellsSize);

        } else

        {

            if (ImageCellsStretch == true)

            {

                gImageBlackCells.drawImage(ImageBlackCells, 0, 0, CellsSize, CellsSize, null);

            } else

            {

                gImageBlackCells.drawImage(ImageBlackCells, 0, 0, null);

            }

        }

        ///вызываем функцию, которая на основе изобр. черной и белой клетки создаст единое изображение доски,где клетки будут выложены в соответ. порядке

        BoardFonCreate(imageWhiteCells, imageBlackCells, FirstCellWhite);


        ///создаем изображение коня(в классе)

        HorseImage = new BufferedImage(CellsSize, CellsSize, BufferedImage.TYPE_4BYTE_ABGR);/// с прозрачностью

        Graphics2D gImageHorseCells = HorseImage.createGraphics();

        if (ImageHorse == null)

        {///если изображение коня нулевое, то рисуем изображение по умолчанию - красный квадратик по центру

            gImageHorseCells.setBackground(Color.red);

            gImageHorseCells.clearRect(CellsSize / 2 - 5, CellsSize / 2 - 5, 10, 10);

        } else

        {

            if (ImageCellsStretch == true)

            {

                gImageHorseCells.drawImage(ImageHorse, 0, 0, CellsSize, CellsSize, null);

            } else

            {

                gImageHorseCells.drawImage(ImageHorse, 0, 0, null);

            }

        }


        ///создаем коня и ставим его на определенную позицию на доске(изображение коня хранится в классе доски т.к. кони не нуждаются в индивидуальности внешнего вида)

        Horse = new clHorse(PosX, PosY);

        this.add(Horse);///добавляем коня (предок коня это кнопка), на доску (которая является потомком от JPanel)

        this.revalidate();//обновляем доску

        //создаем экземпляр класса, который содержит в себе тело алгоритма, связанное с графикой(с доской)

        Runs = new clRun();

        //создаем изображение на котором будет рисоваться порядок обхода доски (числа), в результате работы алгоритма,рисуется поверх доски

        RunsImage = new BufferedImage(BoardSize, BoardSize, BufferedImage.TYPE_4BYTE_ABGR);

    }


    /**
     * Проверяет и устанавливает значения размера доски (в клетках и пикселях(BoardDiagonal*CellsSize)),
     * <p>
     * и применяет их к панели(доске) JPanel(clBoard),
     * <p>
     * при неверных значениях, устанавливает на минимальные, верхней границы для значений нету.
     *
     * @param Diagonal Размер доски в клетках, для квадратной доски.
     * @param Size     Размер в пикселях для клетки поля, рекомендуется не менее 40.
     * @return true - верные параметры, false - параметры с ошибками, при любых значениях размеры применяются.
     */

    boolean BoardSizeInit(int Diagonal, int Size)

    {

        boolean Ok = false;//флаг возврата

        if ((Diagonal > 0) && (Size > 0))//проверка правильности параметров

        {

            BoardDiagonal = Diagonal;

            CellsSize = Size;

            Ok = true;

        } else

        {

            BoardDiagonal = 1;

            CellsSize = 10;

            Ok = false;

        }

        BoardSize = BoardDiagonal * CellsSize;///вычисляем ширину(высоту)доски в пикселях

        this.setPreferredSize(new Dimension(BoardSize, BoardSize));/// устанавливает размер панели

        return Ok;

    }

    /**
     * Количество клеток по диагонали на доске (штуки, клетки)
     */

    public int BoardDiagonal = 1;

    /**
     * Размер ячейки поля в пикселях (на доске), ячейки квадратные.
     */

    int CellsSize = 1;

    /**
     * Размер доски по горизонтали и вертикали (пиксели)
     */

    int BoardSize = 0;

    /**
     * Изображение (фоновое) доски
     */

    BufferedImage BoardFon = null;

    /**
     * Изображение коня (с прозрачными областями)
     */

    BufferedImage HorseImage = null;

    /**
     * Рисование доски т.е. Переопределение функции рисования объекта JPanel.
     */

    protected void paintComponent(Graphics g)

    {

        // если фон готов, то рисуем его

        if (BoardFon != null) {
            g.drawImage(BoardFon, 0, 0, this);
        }

        // если изображение порядка обходя(чисел) готово, то рисуем его

        if (RunsImage != null) {
            g.drawImage(RunsImage, 0, 0, this);
        }

        // при перемещении коня мышью, рисуем его под указателем мыши

        if (BoardHorseMoveMouse == true)

        {

            // проверяем то что конь в горизонтальных пределах доски, если нет то не даем ему выйти за пределы

            if ((EventBoardHorseMovedelX + CellsSize) > BoardSize)

            {

                EventBoardHorseMovedelX = BoardSize - CellsSize;

            } else if (EventBoardHorseMovedelX < 0)

            {

                EventBoardHorseMovedelX = 0;

            }

            // проверяем то что конь в горизонтальных пределах доски, если нет то не даем ему выйти за пределы

            if ((EventBoardHorseMovedelY + CellsSize) > BoardSize)

            {

                EventBoardHorseMovedelY = BoardSize - CellsSize;

            } else if (EventBoardHorseMovedelY < 0)

            {

                EventBoardHorseMovedelY = 0;

            }

            // рисуем изображение коня в пределах поля

            g.drawImage(HorseImage, EventBoardHorseMovedelX, EventBoardHorseMovedelY, null);

        }

    }

    /**
     * Создает фоновое изображение шахматной доски из плотного массива светлых и темных клеток,
     * <p>
     * если изображение не иниц.(null), то фон не рисуется,
     * <p>
     * порядок расположения клеток "по строчно, через одну", какая первая ячейка на поле первая определяется параметром.
     *
     * @param whiteCells     Изображение светлой ячейки(клетки).
     * @param blackCells     Изображение темной ячейки(клетки).
     * @param firstCellWhite если true - то первая клетка поля светлая, если false - то темная
     * @return true - фон нарисован, false - фон не нарисован, из-за того что изобращения не иниц. или не иниц. размеры доски.
     */

    public boolean BoardFonCreate(BufferedImage whiteCells, BufferedImage blackCells, boolean firstCellWhite)

    {

        if ((whiteCells != null) && (blackCells != null) && (BoardSize > 0) && (CellsSize > 0) && (BoardDiagonal > 0))

        {

            BoardFon = new BufferedImage(BoardSize, BoardSize, BufferedImage.TYPE_INT_RGB);

            int kX = 0;///координаты "точки рисования"

            int kY = 0;

            boolean firstCell = firstCellWhite;/// флаг для первой ячейки

            Graphics Fon = BoardFon.createGraphics();/// для рисования

            Fon.clearRect(0, 0, BoardFon.getWidth(), BoardFon.getHeight());///очищаем


            for (int j = 0; j < BoardDiagonal; j++)///цикл рисования по строкам

            {

                kY = j * CellsSize;

                kX = 0;// новая строка

                for (int i = 0; i < BoardDiagonal; i++)///цикл рисования внутри строки

                {

                    if (((i % 2 == 0) && (firstCell == true)) || ((i % 2 > 0) && (firstCell == false)))

                    {

                        // белая в случае если четная ячейка и первая ячейка белая

                        // белая в случае если нечетная ячейка и первая ячейка черная

                        Fon.drawImage(whiteCells, kX, kY, CellsSize, CellsSize, null);

                    } else

                    {

                        // между белыми

                        Fon.drawImage(blackCells, kX, kY, CellsSize, CellsSize, null);

                    }

                    kX = kX + CellsSize;//передвигаемся в строке вправо для рисования следующей ячейки(клетки)

                }
                //end for i

                /// следующая строка начинается с противоположного цвета ячейки

                firstCell = !firstCell;

            }
            // end for j

            return true;

        }

        return false;

    }

    /**
     * Флаг того что по доске перетаскивается конь, с помощью мыши
     */

    boolean BoardHorseMoveMouse = false;

    /**
     * Начальные координаты коня до перетаскивания, X по горизотали (пиксели)
     */

    int EventBoardHorseMovekX = 0;

    /**
     * Начальные координаты коня до перетаскивания, Y по вертикали (пиксели)
     */

    int EventBoardHorseMovekY = 0;

    /**
     * Изменение координат, X по горизотали (пиксели)
     */

    int EventBoardHorseMovedelX = 0;

    /**
     * Изменение координат, Y по вертикали (пиксели)
     */

    int EventBoardHorseMovedelY = 0;

    /**
     * Координаты мыши при нажатии ЛКМ, в системе координат коня (JButton), X по горизотали (пиксели)
     */

    int EventBoardHorseMovePressX = 0;

    /**
     * Координаты мыши при нажатии ЛКМ, в системе координат коня (JButton), Y по вертикали (пиксели)
     */

    int EventBoardHorseMovePressY = 0;

    /**
     * Перепрорисовка панели (доски)
     */

    void RePaint() {
        this.repaint();
    }

    /**
     * Начальные координаты при перемещении стрелками,
     * <p>
     * перед первой частью "Г"-образного хода,
     * <p>
     * т.е. позиция ячейки по горизонтали (штуки, клетки).
     */

    int firstCellPosX = 0;

    /**
     * Начальные координаты при перемещении стрелками,
     * <p>
     * перед первой частью "Г"-образного хода,
     * <p>
     * т.е. позиция ячейки по вертикали (штуки, клетки).
     */

    int firstCellPosY = 0;

    /**
     * Код клавиши которая была нажата первой: "первая стрелка"
     */

    int firstKeyCode = 0;

    /**
     * Составляющая смещения у первой части "Г"-образного хода
     * <p>
     * (длинна отрезка в клетках -1)
     */

    final int firstPartG = 2;

    /**
     * Напраление первой части "Г"-образного хода,
     * <p>
     * чтобы вторая часть была перпендикулярна первой (буква "Г"),
     * <p>
     * true - вертикально, false - горизонтально.
     */

    boolean firstLine = false;


    /**
     * Код клавиши которая была нажата второй: вторая стрелка т.е. после первой стрелка
     */

    int secondKeyCode = 0;

    /**
     * Составляющая смещения у второй части "Г"-образного хода
     * <p>
     * (длинна отрезка в клетках -1)
     */

    final int secondPartG = 1;


    /**
     * экземпляр Коня (принадлежащий доске)
     */

    public clHorse Horse = null;

    /**
     * Класс Конь наследованный от класса JButton, для дальнейшего размещения на панели т.е. доске.
     * <p>
     * Изображение Коня не содержиться в классе, а берется из класса Доски, а также берутся параметры и функции.
     * <p>
     * (Классы Конь и Доска не разделимы совсем).
     */

    class clHorse extends JButton

    {

        private static final long serialVersionUID = 1L;

        /**
         * Конструктор по умолчанию, инициализирует коня
         */

        clHorse()

        {

            this.setBounds(0, 0, CellsSize, CellsSize);///помещаем коня на доску(по умолчанию)

            this.addKeyListener(new KeyMoveListener());//добавляем слушателя события нажатия клавиш для коня

            mouseMoveListener = new MouseMoveListener();//слушатель событий мыши применительно к коню

            this.addMouseListener(mouseMoveListener);

            this.addMouseMotionListener(mouseMoveListener);

        }

        /**
         * Конструктор инициализирует коня с помещением его на определенную позицию
         *
         * @param PosX номер клетки по горизонтали
         * @param PosY номер клетки по вертикали
         */

        clHorse(int PosX, int PosY)

        {

            this();//вызываем конструктор (по умолчанию) коня

            HorseMove(PosX, PosY);///переносит коня в определенное место на доске

        }

        /**
         * Позиция Коня по горизонтали, ячейки: 0,1,2...CellsNumberX-1
         */

        int CellPositionX = 0;

        /**
         * Позиция Коня по вертикали, ячейки: 0,1,2...CellsNumberY-1
         */

        int CellPositionY = 0;


        /**
         * Флаг того что мы перемещаем коня с помощью стрелок
         */

        boolean HorseMoveKey = false;

        /**
         * Флаг того что мы перемещаем коня с помощью перетаскивания мышью
         */

        boolean HorseMoveMouse = false;


        /**
         * Перемещает коня в соотв. с "Г"-образным ходом из текущей позиции(местонахождения)
         *
         * @param PosX - номер клетки по горизонтали, в которую нужно перейти "Г"-образным ходом
         * @param PosY - номер клетки по вертикали, в которую нужно перейти "Г"-образным ходом
         * @return true - если ход был выполнен, false - если невозможно сходить "Г"-образным ходом
         */

        boolean HorseIsMove(int PosX, int PosY)

        {

            boolean flag = false;

            if ((PosX < BoardDiagonal) && (PosX >= 0) && (PosY < BoardDiagonal) && (PosY >= 0))

            {

                //flag=false;

                // горизонталь - верикаль

                if (((PosX - CellPositionX) == firstPartG) || ((CellPositionX - PosX) == firstPartG))

                {

                    if (((PosY - CellPositionY) == secondPartG) || ((CellPositionY - PosY) == secondPartG))

                    {

                        flag = true;

                    }

                }

                // верикаль - горизонталь

                if ((flag == false) && (((PosY - CellPositionY) == firstPartG) || ((CellPositionY - PosY) == firstPartG)))

                {

                    if (((PosX - CellPositionX) == secondPartG) || ((CellPositionX - PosX) == secondPartG))

                    {

                        flag = true;

                    }

                }

            } else

            {

                flag = false;

            }


            if (flag == true)

            {

                HorseMove(PosX, PosY);

            }

            return flag;

        }

        /**
         * Вручную переносит(перемещает) коня в пределах доски(без учета "Г"-образного хода)
         *
         * @param PosX - номер клетки по горизонтали, в которую нужно перейти
         * @param PosY - номер клетки по вертикали, в которую нужно перейти
         * @return true - если координаты в пределах доски, false - если параметры неверны(они сбрасываются в 0)
         */

        public boolean HorseMove(int PosX, int PosY)

        {


            boolean flag = true;

            if ((PosX < BoardDiagonal) && (PosX >= 0))

            {

                CellPositionX = PosX;

            } else

            {

                CellPositionX = 0;

                flag = false;

            }


            if ((PosY < BoardDiagonal) && (PosY >= 0))

            {

                CellPositionY = PosY;

            } else

            {

                CellPositionY = 0;

                flag = false;

            }


            this.setBounds(CellPositionX * CellsSize, CellPositionY * CellsSize, CellsSize, CellsSize);


            return flag;

        }


        /**
         * Переопределенная функция рисования самого коня(класса, объекта)
         */

        protected void paintComponent(Graphics g)

        {

            ///оболочка(одежда, изображения) коня рисуется лишь в том случае, когда есть изображение(не null) и не перетаскивается мышью(т.к. он рисуется доской при перетаскивании)

            if ((HorseImage != null) && (HorseMoveMouse == false))////т.к. при перетаскивании конь рисуется на доске

            {

                g.drawImage(HorseImage, 0, 0, null);

            }

        }

        /**
         * удаляем бордюр JButton
         */

        protected void paintBorder(Graphics g) {
        }


        /**
         * класс слушателя событий, связанных с клавишами
         *
         * @author Машунечка
         */

        public class KeyMoveListener implements KeyListener

        {

            /**
             * функция, которая обрабатывает нажатие клавиш
             */

            public void keyPressed(KeyEvent arg0)

            {

                boolean first = false;//флаг совершения первой части "Г"-образного хода

                boolean second = false;//флаг совершения второй части "Г"-образного хода

                int secondPartGlocal = secondPartG;//локальная копия смещения при второй части "Г"-образного хода


                ///после того как совершена вторая часть "Г"-образного хода и мы нажали стрелку противоположную той,

                ///которую нажали ранее, томы можем выбирать варианты второй части "Г"-образного хода

                // т.е. вторая часть "Г"-образного хода совершается несколько раз(более 1 раза)

                if ((arg0.getKeyCode() != secondKeyCode) && (secondKeyCode != 0))

                {

                    secondPartGlocal = 2 * secondPartG;

                }


                //**рассмотрение стрелок по вертикали


                ///начинаем рассматривать клавиши для хода конем лишь в том случае:

                ///если флаг перемещения сброшен или (стоит и первая часть хода была по горизонтали)

                if ((HorseMoveKey == false) || ((HorseMoveKey == true) && (firstLine == false)))

                    /// рассмотрение стрелки вверх

                    if (arg0.getKeyCode() == KeyEvent.VK_UP)///стрелка вверх

                    {//первая часть хода

                        /// если направление вверх "Г" не выйдет за доску

                        if ((CellPositionY >= firstPartG) && (HorseMoveKey == false))

                        {

                            firstCellPosX = CellPositionX;//исходная позиция сохраняется

                            firstCellPosY = CellPositionY;

                            ///записывается новая позиция по вертикали

                            CellPositionY = CellPositionY - firstPartG;

                            //отмечается, что совершена первая часть хода

                            first = true;

                            firstLine = true;///по вертикали

                        } else if ((arg0.getKeyCode() != secondKeyCode) && (CellPositionY >= secondPartGlocal) && (HorseMoveKey == true))

                        {//вторая часть хода

                            ///записывается новая позиция по вертикали

                            CellPositionY = CellPositionY - secondPartGlocal;

                            //отмечается, что совершена вторая часть хода

                            second = true;

                        }

                    } else if (arg0.getKeyCode() == KeyEvent.VK_DOWN)///стрелка вниз

                    {

                        if ((CellPositionY < (BoardDiagonal - firstPartG)) && (HorseMoveKey == false))

                        {


                            firstCellPosX = CellPositionX;

                            firstCellPosY = CellPositionY;


                            CellPositionY = CellPositionY + firstPartG;


                            first = true;

                            firstLine = true;

                        } else if ((arg0.getKeyCode() != secondKeyCode) && (CellPositionY < (BoardDiagonal - secondPartGlocal)) && (HorseMoveKey == true))

                        {

                            CellPositionY = CellPositionY + secondPartGlocal;


                            second = true;

                        }

                    }


                //**рассмотрение стрелок по горизонтали


                ///начинаем рассматривать клавиши для хода конем лишь в том случае:

                ///если флаг перемещения сброшен или (стоит и первая часть хода была по вертикали)

                if ((HorseMoveKey == false) || ((HorseMoveKey == true) && (firstLine == true)))

                    if (arg0.getKeyCode() == KeyEvent.VK_RIGHT)///стрелка вправо

                    {

                        if ((CellPositionX < (BoardDiagonal - firstPartG)) && (HorseMoveKey == false))

                        {


                            firstCellPosX = CellPositionX;

                            firstCellPosY = CellPositionY;


                            CellPositionX = CellPositionX + firstPartG;


                            first = true;

                            firstLine = false;

                        } else if ((arg0.getKeyCode() != secondKeyCode) && (CellPositionX < (BoardDiagonal - secondPartGlocal)) && (HorseMoveKey == true))

                        {

                            CellPositionX = CellPositionX + secondPartGlocal;


                            second = true;

                        }

                    } else if (arg0.getKeyCode() == KeyEvent.VK_LEFT)///стрелка влево

                    {

                        if ((CellPositionX >= firstPartG) && (HorseMoveKey == false))

                        {

                            firstCellPosX = CellPositionX;

                            firstCellPosY = CellPositionY;


                            CellPositionX = CellPositionX - firstPartG;


                            first = true;

                            firstLine = false;

                        } else if ((arg0.getKeyCode() != secondKeyCode) && (CellPositionX >= secondPartGlocal) && (HorseMoveKey == true))

                        {

                            CellPositionX = CellPositionX - secondPartGlocal;


                            second = true;

                        }


                    }

                //если была совершена первая часть хода, то перемещаем коня по правилу

                ///и запоминаем код клавиши(стрелочки), которая была нажата,

                ///и устанавливается флаг перемещения коня с помощью стрелок

                if (first == true)

                {

                    HorseMove(CellPositionX, CellPositionY);

                    firstKeyCode = arg0.getKeyCode();

                    HorseMoveKey = true;

                }


                //если была совершена первая часть хода, то перемещаем коня по правилу

                ///и запоминаем код клавиши(стрелочки), которая была нажата

                if (second == true)

                {

                    HorseMove(CellPositionX, CellPositionY);

                    secondKeyCode = arg0.getKeyCode();

                }

            }


            /**
             * функция, которая обрабатывает отпускание клавиш
             */

            public void keyReleased(KeyEvent arg0)

            {

                //если отпустили клавишу, которая была нажата на первой части хода, то

                if (firstKeyCode == arg0.getKeyCode())

                {

                    firstKeyCode = 0;//код клавиши сбрасывается

                    HorseMoveKey = false;//сбрасывается флаг перемещения коня с помощью стрелок

                    // >=37(проще !=0) код клавиши второй части хода не сброшен(т.е. был выполнен)

                    if (secondKeyCode >= 37)

                    {

                        //перемещаем коня в свою же позицию

                        HorseMove(CellPositionX, CellPositionY);

                    } else

                    {

                        //перемещаем коня на изначальное место

                        HorseMove(firstCellPosX, firstCellPosY);

                    }

                    secondKeyCode = 0;//код клавиши сбрасывается

                    HorseMove(CellPositionX, CellPositionY);

                }

            }


            public void keyTyped(KeyEvent arg0) {
            }

        }

        /**
         * экземпляр слушателя событий мыши
         */

        MouseMoveListener mouseMoveListener = null;


        /**
         * класс слушателя событий мыши
         *
         * @author Машунечка
         */

        public class MouseMoveListener implements MouseListener, MouseMotionListener

        {

            // клики

            public void mouseClicked(MouseEvent e) {
            }

            // появление мыши в компоненте

            public void mouseEntered(MouseEvent e) {
            }

            // выход мыши из компоненнта

            public void mouseExited(MouseEvent e) {
            }

            // нажатие кнопки мыши

            public void mousePressed(MouseEvent e)

            {

                ///если левая кнопка то начинаем перетаскивать

                if ((e.getModifiers() & MouseEvent.BUTTON3_MASK) == 0)

                {

                    ///сохраняем начальные координаты коня на доске

                    EventBoardHorseMovekX = getX();/// или CellPositionX*CellsSize

                    EventBoardHorseMovekY = getY();

                    /// запоминаем координаты курсора мыши на коне

                    EventBoardHorseMovePressX = e.getX();

                    EventBoardHorseMovePressY = e.getY();


                    EventBoardHorseMovedelX = 0;

                    EventBoardHorseMovedelY = 0;

                }

            }


            public void mouseReleased(MouseEvent e)

            {

                if ((BoardHorseMoveMouse == true) && ((e.getModifiers() & MouseEvent.BUTTON3_MASK) == 0))

                {

                    HorseMoveMouse = false;

                    BoardHorseMoveMouse = false;

                    RePaint();

                    ///при отпускании клавиши вычисляются координаты ячейки(клетки) по координатам центра коня

                    HorseIsMove((EventBoardHorseMovedelX + CellsSize / 2) / CellsSize, (EventBoardHorseMovedelY + CellsSize / 2) / CellsSize);

                }

            }


            public void mouseDragged(MouseEvent arg0)

            {

                ///левая кнопка

                if ((arg0.getModifiers() & MouseEvent.BUTTON3_MASK) == 0)

                {

                    if (BoardHorseMoveMouse == false)

                    {

                        HorseMoveMouse = true;

                        BoardHorseMoveMouse = true;

                    }

                    /// тут EventBoardHorseMovedel становяться координатами левого угла

                    EventBoardHorseMovedelX = EventBoardHorseMovekX + arg0.getX() - EventBoardHorseMovePressX;

                    EventBoardHorseMovedelY = EventBoardHorseMovekY + arg0.getY() - EventBoardHorseMovePressY;

                    RePaint();

                }

            }


            public void mouseMoved(MouseEvent arg0) {
            }


        }


    }

    /**
     * изображение по размерам доски содержит порядок обхода(числа) при работе алгоритма
     */

    BufferedImage RunsImage;

    /**
     * цвет чисел на RunsImage
     */

    Color RunsColor = Color.green;

    /**
     * шрифт чисел на RunsImage
     */

    Font RunsFont = getFont();

    /**
     * метрики шрифта RunsFont
     */

    FontMetrics RunsFontMetrics;


    /**
     * инициализация шрифта, метрик, изображения на(в) RunsImage(если оно не созданно)
     */

    public void RunsImageInit()

    {

        if (RunsImage == null)

        {

            RunsImage = new BufferedImage(BoardSize, BoardSize, BufferedImage.TYPE_4BYTE_ABGR);

        }


        Graphics gRunsImage = RunsImage.getGraphics();

        if (CellsSize > 30)

        {

            RunsFont = gRunsImage.getFont();

            //устанавливаем размер шрифта по размеру клетки

            RunsFont = RunsFont.deriveFont((float) ((int) (CellsSize / 2)));

        } else

        {

            RunsFont = gRunsImage.getFont();

            RunsFont = RunsFont.deriveFont((float) 15.0);

        }

        RunsFont = RunsFont.deriveFont(Font.BOLD);

        ///инициализируем метрики шрифта

        RunsFontMetrics = getFontMetrics(RunsFont);

    }


    /**
     * Рисует на RunsImage в клетке номер порядка обхода
     *
     * @param X     - номер ячейки(клетки) по горизонтали
     * @param Y     - номер ячейки(клетки) по вертикали
     * @param Nomer - номер, который будет рисоваться
     */

    void RunsMetkaCells(int X, int Y, int Nomer)

    {

        if (RunsImage == null)

        {

            RunsImage = new BufferedImage(BoardSize, BoardSize, BufferedImage.TYPE_4BYTE_ABGR);

        }

        Graphics gRunsImage = RunsImage.getGraphics();

        gRunsImage.setFont(RunsFont);


        gRunsImage.setColor(RunsColor);

        String strNomer = String.valueOf(Nomer);

        gRunsImage.drawString(strNomer, X * CellsSize + CellsSize / 2 - RunsFontMetrics.stringWidth(strNomer) / 2, Y * CellsSize + CellsSize / 2 + RunsFontMetrics.getHeight() / 2);

    }


    /**
     * экземпляр класса Выполнение алгоритма
     */

    public clRun Runs = null;


    /**
     * Класс Выполнение алгоритма, выполняет итерации алгоритма по таймеру
     *
     * @author Машунечкая
     */

    public class clRun

    {

        /**
         * сам таймер, который запускает итерации алгоритма
         */

        public Timer RunsTimer;

        /**
         * возможные ходы (X)
         */

        private final int EnslavedX[] = {-1, -2, -2, -1, 1, 2, 2, 1};// возможные ходы

        /**
         * возможные ходы (Y)
         */

        private final int EnslavedY[] = {-2, -1, 1, 2, 2, 1, -1, -2};

        /**
         * шахматное поле
         */

        private int Ch[][] = null;

        /**
         * массив возможности хода (bool)
         */

        private int ChBool[];

        /**
         * массив рейтинга возможных ходов
         */

        private int ChReit[];

        /**
         * то же самое что и ChBool но используется при вычислении рейтинга
         */

        private int ChBoolReit;

        /**
         * x и y временной псефдо коня который используется при вычислении рейтинга
         */

        private int xhR, yhR;

        /**
         * размеры поля
         */

        private int xCh, yCh;

        /**
         * текуще координаты коня
         */

        private int xh, yh;

        /**
         * b-обчный bool
         */

        private int b = 0;

        /**
         * а-число сделанных ходов
         */

        private int a = 1;

        /**
         * номер хода в массивах Enslaved у которого наименьший рейтинг
         */

        private int NR = 0;

        /**
         * временные данные
         */

        private int tmp = 0;


        /**
         * конструктор по умолчанию инициализирует шахматное поле для выполнения алгоритма(не графика)
         */

        clRun()

        {

            Ch = new int[BoardDiagonal + 1][BoardDiagonal + 1];

        }


        /**
         * начальная инициализация перед началом алгоритма
         */

        public void RunsInit()

        {

            Ch = new int[BoardDiagonal + 1][BoardDiagonal + 1];

            ChBool = new int[8];//массив возможности хода (bool)

            ChReit = new int[8];//массив рейтинга возможных ходов

            ChBoolReit = 0;// то же самое что и ChBool но используется при вычислении рейтинга

            xhR = 0;
            yhR = 0;//x и y временной псефдо коня который используется при вычислении рейтинга

            xCh = BoardDiagonal;
            yCh = BoardDiagonal;//размеры поля

            xh = Horse.CellPositionX + 1;
            yh = Horse.CellPositionY + 1;// текуще координаты коня

            b = 0;
            a = 1; // b-обчный bool , а-число сделанных ходов

            NR = 0; //номер хода в массивах Enslaved у которого наименьший рейтинг

            tmp = 0; // временные данные

            ////for (int i = 0; i < xCh; i++)for (int i2 = 0; i2 < yCh; i2++) Ch [i][i2] =0;   //обнуление массива

            Ch[xh][yh] = 1;


            RunsMetkaCells(Horse.CellPositionX, Horse.CellPositionY, 1);

        }


        /**
         * Ииц. и запускает таймер, и выполнение итераций алгорима
         *
         * @param leadTime задержка таймера (интервал) между выполнением итераций, значение только >0
         */

        public void RunTimer(int leadTime)

        {

            RunsImageInit();

            RunsInit();

            actionTimer = new ActionTimer();

            RunsTimer = new Timer(leadTime, actionTimer);

            RunsTimer.start();

        }


        /**
         * экземпляр слушателя события активации (срабатывания) таймера
         */

        ActionTimer actionTimer = null;


        /**
         * Слушатель события активации (срабатывания) таймера, кот. выполняет итерации алгоритма
         *
         * @author Машунечка
         */

        class ActionTimer implements ActionListener

        {

            public void actionPerformed(ActionEvent arg0)

            {

                if (b == 0 && a != 1)//условия окончания действия алгоритма

                {

                    RunsTimer.stop();//останавливает таймер

                    return;//прерывает выполнения функции

                }

                {

                    b = 0;

                    tmp = 8;

                    a++;///наращиваем число сделланных ходов, который показывает порядок обхода доски(отображается на пройденной клетке)

                    for (int i = 0; i <= 7; i++) ChReit[i] = 0; //обнуление

                    for (int i = 0; i <= 7; i++) // вычисление возможности хода с позиции лошадки

                    {

                        //заполняем массив возможности хода, при ходе в пределах поля и на непройденную ячейку

                        ChBool[i] = 1;

                        if (xh + EnslavedX[i] < 1) ChBool[i] = 0;

                        if (xh + EnslavedX[i] > xCh) ChBool[i] = 0;

                        if (yh + EnslavedY[i] < 1) ChBool[i] = 0;

                        if (yh + EnslavedY[i] > yCh) ChBool[i] = 0;


                        if ((xh + EnslavedX[i] <= xCh) && (yh + EnslavedY[i] <= yCh) && (xh + EnslavedX[i] >= 0) && (yh + EnslavedY[i] >= 0) && (Ch[xh + EnslavedX[i]][yh + EnslavedY[i]] != 0))

                            ChBool[i] = 0;

                    }


                    for (int i = 0; i <= 7; i++) //начисление рейтинга в массив ChReit

                    {

                        if (ChBool[i] == 1)//если ход возможен то

                        {

                            xhR = xh + EnslavedX[i];

                            yhR = yh + EnslavedY[i];

                            for (int i2 = 0; i2 <= 7; i2++)

                            {

                                ChBoolReit = 1;

                                if (xhR + EnslavedX[i2] < 1) ChBoolReit = 0;

                                if (xhR + EnslavedX[i2] > xCh) ChBoolReit = 0;

                                if (yhR + EnslavedY[i2] < 1) ChBoolReit = 0;

                                if (yhR + EnslavedY[i2] > yCh) ChBoolReit = 0;

                                if ((xhR + EnslavedX[i2] <= xCh) && (yhR + EnslavedY[i2] <= yCh) && (xhR + EnslavedX[i2] >= 0) && (yhR + EnslavedY[i2] >= 0) && (Ch[xhR + EnslavedX[i2]][yhR + EnslavedY[i2]] != 0))
                                    ChBoolReit = 0;

                                ChReit[i] = ChReit[i] + ChBoolReit;

                            }

                        }

                    }

                    for (int i = 0; i <= 7; i++)// выявление самого низкого рейтинга

                    {

                        if (ChReit[i] < tmp)

                        {

                            if (ChBool[i] == 1)

                            {

                                tmp = ChReit[i];

                                NR = i;

                            }

                        }

                    }

                    for (int i = 0; i <= 7; i++)
                        b = b + ChBool[i];//сколько ходов возможно (но всёравно b используется как бул в котором результат отличный от 0 =1)

                    if (b != 0) //делаем ход (вы не поверите, конём!)

                    {

                        xh = xh + EnslavedX[NR];

                        yh = yh + EnslavedY[NR];

                        Ch[xh][yh] = a;

                        RunsMetkaCells(xh - 1, yh - 1, a);

                        Horse.HorseIsMove(xh - 1, yh - 1);

                    }

                }

            }

        }

        /// end ActionTimer

    }

}