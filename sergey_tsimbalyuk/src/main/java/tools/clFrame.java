package tools;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * Created by Sergey Tsimbalyuk on 10.03.15.
 */

/**
 * Класс окна программы который содержит меню и доску (clBoard)
 */

public class clFrame extends JFrame

{

    private static final long serialVersionUID = 1L;


    /**
     * Конструктор по умолчанию (для фрейма прогр)
     */

    clFrame()

    {

        super("Ход конем - Таранова Мария АСУ-09-2");/// заголовок окна который направляется конструктору предка

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/// устанавливаем событие на закрытие окна JFrame

        this.setSize(400, 300);/// Размер по умолчанию для окна

        this.setVisible(true);/// устанавливает Видимость окна программы (обязательно)

        this.setMenuBar(menubar);/// добавляет меню бар (с элементами меню)

        /// создание модального диалога "Создание шахматной доски с конем..."

        dialogBoard = new DialogBoard(this, "Создание шахматной доски с конем...", true);

    }

    /**
     * Конструктор с другим заголовком окна
     *
     * @param Title Новый заголовок окна
     */

    clFrame(String Title)

    {

        this();/// вызываем Конструктор по умолчанию

        this.setTitle(Title);/// устанавливаем новый заголовок для окна

    }

    /**
     * Конструктор с заголовком и размерами для окна
     *
     * @param Title  Новый заголовок окна
     * @param width  Ширина окна в пикселях
     * @param height Высота окна в пикселях
     */

    clFrame(String Title, int width, int height)

    {

        this(Title);/// устанавливаем новый заголовок для окна

        this.setSize(width, height);/// устан. новые размеры

    }

    /**
     * Инициализация добавления готовой доски(Board внутри JScrollPane(для прокрутки)) к окну программы
     */

    private void initPanelBoard()

    {

        if (Board != null)

        {

            scrollPanel = new JScrollPane(Board);

            this.add(scrollPanel);

        }

        this.validate();

    }

    /**
     * Экземпляр меню для программы
     */

    clMenuBar menubar = new clMenuBar();


    /**
     * Класс меню для Программы, содержит все пункты, и обработку действий меню
     */

    class clMenuBar extends MenuBar

    {

        private static final long serialVersionUID = 1L;

        /**
         * Конструктор по умолчанию, который проводит обязательную инициализацию пунктов меню
         */

        clMenuBar()

        {

            // добавляем меню "Доска" и его подпункты

            this.add(mBoard);

            mNew.addActionListener(menuEvent);// добавляем слушателя активации пункта меню

            mBoard.add(mNew);//добавляем пункт к соотв. меню

            /// разделительная черта в меню

            mBoard.addSeparator();


            mExit.addActionListener(menuEvent);// добавляем слушателя активации пункта меню

            mBoard.add(mExit);//добавляем пункт к соотв. меню


            // добавляем меню "Выполнить обход"

            this.add(mHorse);

            mRun.addActionListener(menuEvent);// добавляем слушателя активации пункта меню

            mHorse.add(mRun);//добавляем пункт к соотв. меню


            mStop.addActionListener(menuEvent);// добавляем слушателя активации пункта меню

            mHorse.add(mStop);//добавляем пункт к соотв. меню


            mClear.addActionListener(menuEvent);// добавляем слушателя активации пункта меню

            mHorse.add(mClear);//добавляем пункт к соотв. меню


            mColor.addActionListener(menuEvent);// добавляем слушателя активации пункта меню

            mHorse.add(mColor);//добавляем пункт к соотв. меню


            /// Заранее отключаем лишние пунты меню, ведь доска еще изначально не создана,

            /// затем после создания доски с конем они будут включены

            mColor.setEnabled(false);

            mClear.setEnabled(false);

            mRun.setEnabled(false);

            mStop.setEnabled(false);

        }

        /// объявление меню и подменю:

        /**
         * Меню "Доска" на менюбаре
         */

        public Menu mBoard = new Menu("Доска");

        /**
         * Пункт меню("Доска") "Создать доску"
         */

        public MenuItem mNew = new MenuItem("Создать доску");

        /**
         * Пункт меню("Доска") "Выход"
         */

        public MenuItem mExit = new MenuItem("Выход");


        /**
         * Меню "Выполнить обход" на менюбаре
         */

        public Menu mHorse = new Menu("Выполнить обход");

        /**
         * Пункт меню("Выполнить обход") "Выполнить обход"
         */

        public MenuItem mRun = new MenuItem("Выполнить обход");

        /**
         * Пункт меню("Выполнить обход") "Остановить обход"
         */

        public MenuItem mStop = new MenuItem("Остановить обход");

        /**
         * Пункт меню("Выполнить обход") "Очистить обход"
         */

        public MenuItem mClear = new MenuItem("Очистить обход");

        /**
         * Пункт меню("Выполнить обход") "Выбрать цвет для обхода"
         */

        public MenuItem mColor = new MenuItem("Выбрать цвет для обхода");


        /**
         * Экземпляр слушателя событии меню программы
         */

        MenuEvent menuEvent = new MenuEvent();


        /**
         * Класс слушателя событий меню,
         * <p>
         * все пункты меню различаюся по функции getSource() которая возвращает ссылку на объект который "создал(вызвал) событие"
         * <p>
         * , содержит также действия по выполнению пунктов меню.
         */

        class MenuEvent implements ActionListener

        {

            public void actionPerformed(ActionEvent arg0)

            {

                // Получаем ссылку на объект который вызвал событие

                Object ob = arg0.getSource();

                // начинаем сравнивать его с пунктами меню:

                /// Создать доску

                if (ob == mNew)

                {

                    // запускаем модальные диалог (пока он есть все остальное(окна и другое) в программе блокируется)

                    dialogBoard.runDialogBoard();

                    // добавляем созданую диалогом доску к окну

                    initPanelBoard();

                } else if (ob == mClear)

                {

                    if (Board != null)

                    {

                        Board.RunsImage = null;/// обнуляем его (слой(изобранение) с числами(порядком обхода))

                        Board.RunsImageInit();/// функция автоматом создает пустое прозрачное изображение

                        Board.RePaint();/// перепроисовка доски(панели)

                    }

                } else if (ob == mExit)

                {

                    System.exit(0);// выход из программы (0 - без ошибок)

                } else if (ob == mRun)

                {

                    // если доска создана, то...

                    if (Board != null)

                    {

                        int timer = 400;/// значение таймера итераций по умолчанию

                        // JOptionPane - стандартный модальный диалог

                        // showInputDialog - диалог для ввода, QUESTION_MESSAGE - это его тип (вид, стиль, тип иконки)

                        String timerStr = JOptionPane.showInputDialog(null, "Введите задержку передвижения коня в миллисекундах.\n" +

                                        "Допустимые значения от 0 до 30 секунд (30000 мс).\n" +

                                        "Общее время выполнения равно количеству клеток на поле * задержку.\n" +

                                        "Пример: 1 секунда = 1000 миллисекунд.\n" +

                                        "Рекомендуемое значение 400 миллисекунд.",

                                "Выполнение обхода конем шахматной доски...", JOptionPane.QUESTION_MESSAGE);

                        /// timerStr приемник того что ввел пользователь в диалог

                        /// может быть null если была отмена

                        if (timerStr != null)

                        {

                            /// создаем сканнер для перевода строки в число - количество мс задержки

                            Scanner scanner = new Scanner(timerStr);

                            /// проверяем присутствие целого числа

                            if (scanner.hasNextInt() == true)

                            {

                                /// получаем его в переменную таймер

                                timer = scanner.nextInt();

                                /// проверяем на правильность значения таймера

                                if ((timer >= 0) && (timer <= 30000))

                                {

                                    // запускаем итерации алгоритма по заданному интервалу

                                    Board.Runs.RunTimer(timer);

                                } else

                                {

                                    JOptionPane.showMessageDialog(null, "Было введено недопустимое значение для времени задержки \nпередвижения коня  в миллисекундах.\nОперация не выполнена.", "Операция отменена", JOptionPane.ERROR_MESSAGE);

                                    return;/// прерывание(обрывание выполнения) функции

                                }

                            } else

                            {

                                JOptionPane.showMessageDialog(null, "Было введено недопустимое значение (не целое число)\n для времени задержки передвижения коня  в миллисекундах.\nОперация не выполнена.", "Операция отменена", JOptionPane.ERROR_MESSAGE);

                                return;/// прерывание(обрывание выполнения) функции

                            }

                        } else

                        {

                            JOptionPane.showMessageDialog(null, "Был отменен ввод времени задержки \nпередвижения коня  в миллисекундах.\nОперация не выполнена.", "Обход доски отменен...", JOptionPane.WARNING_MESSAGE);

                            return;/// прерывание(обрывание выполнения) функции

                        }

                    }

                } else if (ob == mColor)

                {

                    /// Color temp - приемник цвета выбранного на JColorChooser, может быть null если была отмена

                    // Board.RunsColor текущий цвет подается как выбранный по умолчанию на панели

                    if (Board != null)/// тк работаем с доской ("цвет RunsColor внутри неё")

                    {

                        Color temp = JColorChooser.showDialog(null, "Выбор цвета для номеров клеток обхода доски", Board.RunsColor);

                        if ((temp != null))

                        {

                            Board.RunsColor = temp;

                        }

                    }
                    /// end Board!=null

                } else if (ob == mStop)

                {

                    // Останавливаем таймер и выполнение итераций алгоритма

                    if (Board != null && Board.Runs != null && Board.Runs.RunsTimer != null)

                    {

                        Board.Runs.RunsTimer.stop();// стоп

                    }

                }

            }

        }


    }

    /**
     * Панель с полосами прокрутки
     */

    JScrollPane scrollPanel = null;

    /**
     * Экземпляр шахматной доски
     */

    clBoard Board = null;

    /**
     * Экземпляр диалога создания доски
     */

    DialogBoard dialogBoard = null;


    /**
     * Сам диалог создания доски, подготавливает агрументы (параметры) для конструктора clBoard и загружаем изображения из файла
     */

    class DialogBoard extends JDialog

    {

        private static final long serialVersionUID = 1L;

        /**
         * Конструктор создания модального диалога создания доски
         *
         * @param owner владелец, фрейм к которому привязан диалог
         * @param title заголовок диалога
         * @param modal модальность, лучше true
         */

        DialogBoard(Frame owner, String title, boolean modal)

        {

            super(owner, title, modal);

            // выставляем размер окна диалога

            this.setSize(450, 320);

            // сбрасываем менеджер размещения, тк все элементы будем распологать вручную по координатам

            this.setLayout(null);

            // иниц отдельных элементов

            InitSpinners();

            InitCells();

            reSource();

            // значения по умолчанию

            BoardSpinner.setValue(new Integer(8));

            CellsSpinner.setValue(new Integer(80));

            HorseSpinnerX.setValue(new Integer(2));

            HorseSpinnerY.setValue(new Integer(2));

            CellFirst.setSelected(true);

            BoardCellsHorse.setSelected(true);

        }

        /**
         * Спиннер для: "Размер поля"
         */

        JSpinner BoardSpinner = new JSpinner();

        JLabel BoardLabel = new JLabel("Размер поля:");

        /**
         * Спиннер для: "Размер клетки"
         */

        JSpinner CellsSpinner = new JSpinner();

        JLabel CellsLabel = new JLabel("Размер клетки:");


        JSpinner HorseSpinnerX = new JSpinner();

        JSpinner HorseSpinnerY = new JSpinner();

        JLabel HorseLabel = new JLabel("Положение коня:");

        JLabel HorseX = new JLabel("X:");

        JLabel HorseY = new JLabel("Y:");

        // кнопки

        JButton BoardCellsBlackColor = new JButton("Выбрать фоновый цвет для темных клеток");

        JButton BoardCellsWhiteColor = new JButton("Выбрать фоновый цвет для светлых клеток");

        // галочки и кнопки загрузить

        JCheckBox BoardCellsBlack = new JCheckBox("Изображение для темных клеток из файла");

        JButton BoardCellsBlackImage = new JButton("Загрузить...");


        JCheckBox BoardCellsWhite = new JCheckBox("Изображение для светлых клеток из файла");

        JButton BoardCellsWhiteImage = new JButton("Загрузить...");


        JCheckBox BoardCellsHorse = new JCheckBox("Изображение для коня из файла");

        JButton BoardCellsHorseImage = new JButton("Загрузить...");


        JCheckBox CellsStretch = new JCheckBox("Растягивать изображение на клетке");

        JCheckBox CellFirst = new JCheckBox("Первая клетка на поле светлая");

        /**
         * фоновый цвет по умолчанию для светлых клеток
         */

        Color CellsWhite = Color.white;

        /**
         * фоновый цвет по умолчанию для темных клеток
         */

        Color CellsBlack = Color.black;


        JButton BoardRun = new JButton("Создать шахматную доску с конем");

        JButton BoardCancel = new JButton("Отмена (Закрыть)");

        /// изображения элементов доски: конь и клетки

        BufferedImage ImageCellsBlack = null;

        BufferedImage ImageCellsWhite = null;

        BufferedImage ImageCellsHorse = null;

        /// путь к файлам изображений

        String StrCellsBlack = null;

        String StrCellsWhite = null;

        String StrCellsHorse = null;

        /**
         * Файловый диалог для выбора изображения для использования на доске
         */

        FileDialog OpenImage = new FileDialog(this, "Загрузка изображения из файла", FileDialog.LOAD);

        /**
         * Иниц. на диалоге спиннеров и связанных элементов
         */

        void InitSpinners()

        {

            // Bounds: коодринаты левого верхнего угла, ширина и высота область

            BoardLabel.setBounds(10, 5, 100, 25);


            // Устанавливается шрифт со измененным размером

            this.setFont(this.getFont().deriveFont((float) 14.0));


            BoardLabel.setFont(getFont());

            this.add(BoardLabel);/// добавляем на диалог элемент


            BoardSpinner.setBounds(125, 5, 60, 25);

            this.add(BoardSpinner);/// добавляем на диалог элемент


            CellsLabel.setBounds(10, 40, 100, 25);

            CellsLabel.setFont(getFont());

            this.add(CellsLabel);/// добавляем на диалог элемент


            CellsSpinner.setBounds(125, 40, 60, 25);

            this.add(CellsSpinner);/// добавляем на диалог элемент


            HorseLabel.setBounds(240, 15, 150, 25);

            HorseLabel.setFont(getFont());

            this.add(HorseLabel);/// добавляем на диалог элемент


            HorseX.setBounds(240, 40, 50, 25);

            HorseX.setFont(getFont());

            this.add(HorseX);/// добавляем на диалог элемент


            HorseSpinnerX.setBounds(260, 40, 50, 25);

            this.add(HorseSpinnerX);/// добавляем на диалог элемент


            HorseY.setBounds(340, 40, 50, 25);

            HorseY.setFont(getFont());

            this.add(HorseY);/// добавляем на диалог элемент


            HorseSpinnerY.setBounds(360, 40, 50, 25);

            this.add(HorseSpinnerY);/// добавляем на диалог элемент

        }


        void InitCells()

        {

            // первая ячейка белая

            CellFirst.setBounds(10, 65, 250, 25);

            CellFirst.setFont(getFont());

            this.add(CellFirst);

            // растягивать(подгонять) изображение на клетке

            CellsStretch.setBounds(10, 90, 280, 25);

            CellsStretch.setFont(getFont());

            this.add(CellsStretch);

            // выбор фонового цвета для темных клеток

            BoardCellsBlackColor.setBounds(14, 120, 300, 20);

            BoardCellsBlackColor.addActionListener(actionButton);

            this.add(BoardCellsBlackColor);

            // выбор фонового цвета для светлых клеток

            BoardCellsWhiteColor.setBounds(14, 145, 300, 20);

            BoardCellsWhiteColor.addActionListener(actionButton);

            this.add(BoardCellsWhiteColor);

            //**********************

            // Изображения для элементов доски:

            //**********************

            BoardCellsBlack.setBounds(10, 170, 315, 25);

            BoardCellsBlack.setFont(getFont());

            this.add(BoardCellsBlack);

            BoardCellsBlackImage.setBounds(325, 175, 110, 18);

            BoardCellsBlackImage.addActionListener(actionButton);

            this.add(BoardCellsBlackImage);

            //***********************

            BoardCellsWhite.setBounds(10, 195, 315, 25);

            BoardCellsWhite.setFont(getFont());

            this.add(BoardCellsWhite);

            BoardCellsWhiteImage.setBounds(325, 200, 110, 18);

            BoardCellsWhiteImage.addActionListener(actionButton);

            this.add(BoardCellsWhiteImage);

            //***********************

            BoardCellsHorse.setBounds(10, 220, 315, 25);

            BoardCellsHorse.setFont(getFont());

            this.add(BoardCellsHorse);

            BoardCellsHorseImage.setBounds(325, 225, 110, 18);

            BoardCellsHorseImage.addActionListener(actionButton);

            this.add(BoardCellsHorseImage);

            //***********************

            // создать доску

            BoardRun.setBounds(10, 255, 255, 25);

            BoardRun.addActionListener(actionButton);

            this.add(BoardRun);

            // отмена

            BoardCancel.setBounds(275, 255, 160, 25);

            BoardCancel.addActionListener(actionButton);

            this.add(BoardCancel);

        }

        /**
         * Иниц. значениями по умолчанию ("обнуление") графических ресурсов
         */

        void reSource()

        {

            ImageCellsBlack = null;

            ImageCellsWhite = null;

            ImageCellsHorse = null;

            CellsWhite = Color.white;

            CellsBlack = Color.black;

        }

        /**
         * Запуск диалога на выполнение
         */

        public void runDialogBoard()

        {

            ImageCellsBlack = null;

            ImageCellsWhite = null;

            ImageCellsHorse = null;

            BoardCellsHorse.setSelected(true);

            this.setVisible(true);

        }

        /**
         * экземпляр слушателя событий кнопки
         */

        ActionButton actionButton = new ActionButton();


        /**
         * Класс слушателя событий кнопки на диалоге создания доски
         */

        class ActionButton implements ActionListener

        {


            public void actionPerformed(ActionEvent e)

            {

                Object ob = e.getSource();

                Color tempColor = null;


                if (ob == BoardCellsWhiteColor)///"Выбрать фоновый цвет для светлых клеток"

                {

                    /// вызываем диалог выбора цвета, где tempColor приёмник выбранного цвета, возможно null если была отмена

                    tempColor = JColorChooser.showDialog(null, BoardCellsWhiteColor.getText() + "...", CellsWhite);

                    if (tempColor != null)

                    {

                        CellsWhite = tempColor;

                    }

                } else if (ob == BoardCellsBlackColor)///"Выбрать фоновый цвет для темных клеток"

                {

                    /// вызываем диалог выбора цвета, где tempColor приёмник выбранного цвета, возможно null если была отмена

                    tempColor = JColorChooser.showDialog(null, BoardCellsBlackColor.getText() + "...", CellsBlack);

                    if (tempColor != null)

                    {

                        CellsBlack = tempColor;

                    }

                } else if (ob == BoardRun)////"Создать шахматную доску с конем"

                {

                    int BoardSize = ((Integer) BoardSpinner.getValue()).intValue();

                    if (!((BoardSize > 0) && ((BoardSize <= 500))))

                    {

                        JOptionPane.showMessageDialog(null, "Введены не правильное значение " + BoardLabel.getText() + "\nДоступные значения: >=1 AND <=500", "Ошибка " + getTitle() + "!!!", JOptionPane.ERROR_MESSAGE);

                        return;/// прерываем выполнения функции, но не скрываем модальный диалог

                    }


                    int CellsSize = ((Integer) CellsSpinner.getValue()).intValue();

                    if (!((CellsSize > 20) && (CellsSize < 1000)))

                    {

                        JOptionPane.showMessageDialog(null, "Введены не правильное значение " + CellsLabel.getText() + "\nДоступные значения: >20 AND <1000", "Ошибка " + getTitle() + "!!!", JOptionPane.ERROR_MESSAGE);

                        return;/// прерываем выполнения функции, но не скрываем модальный диалог

                    }

                    // тк позиция коня отсчитывается внутри от 0 (нуля0, а люди считают с 1 (единицы), по этому вычитаем единицу

                    int HorseXcell = ((Integer) HorseSpinnerX.getValue()).intValue() - 1;// начальное положение коня по горизонтали (справа налево)

                    int HorseYcell = ((Integer) HorseSpinnerY.getValue()).intValue() - 1;// начальное положение коня по вертикали (сверху вниз)


                    if (!((HorseXcell >= 0) && (BoardSize > HorseXcell) && (HorseYcell >= 0) && (BoardSize > HorseYcell)))

                    {

                        JOptionPane.showMessageDialog(null, "Введены не правильное значение " + HorseLabel + " X или Y" + "\nДоступные значения: >=1 AND =<Размер поля", "Ошибка " + getTitle() + "!!!", JOptionPane.ERROR_MESSAGE);

                        return;/// прерываем выполнения функции, но не скрываем модальный диалог

                    }

                    /// создаем изображение светлой клетки, на основе фонового цвета + если было загруженно изображение

                    BufferedImage imageCellsWhite = new BufferedImage(CellsSize, CellsSize, BufferedImage.TYPE_3BYTE_BGR);

                    Graphics gWhite = imageCellsWhite.getGraphics();

                    gWhite.setColor(CellsWhite);

                    gWhite.fillRect(0, 0, CellsSize, CellsSize);

                    if (BoardCellsWhite.isSelected() == true)

                    {

                        if (ImageCellsWhite != null)

                        {

                            gWhite.drawImage(ImageCellsWhite, 0, 0, null);

                        } else

                        {

                            JOptionPane.showMessageDialog(null, "Ошибка загрузки " + BoardCellsWhite.getText() + "\nСнимите галочку или Загрузите изображение", "Ошибка " + getTitle() + "!!!", JOptionPane.ERROR_MESSAGE);

                            return;

                        }

                    }


                    /// создаем изображение темной клетки, на основе фонового цвета + если было загруженно изображение

                    BufferedImage imageCellsBlack = new BufferedImage(CellsSize, CellsSize, BufferedImage.TYPE_3BYTE_BGR);

                    Graphics gBlack = imageCellsBlack.getGraphics();

                    gBlack.setColor(CellsBlack);

                    gBlack.fillRect(0, 0, CellsSize, CellsSize);

                    if (BoardCellsBlack.isSelected() == true)

                    {

                        if (ImageCellsBlack != null)

                        {

                            gBlack.drawImage(ImageCellsBlack, 0, 0, null);

                        } else

                        {

                            JOptionPane.showMessageDialog(null, "Ошибка загрузки " + BoardCellsBlack.getText() + "\nСнимите галочку или Загрузите изображение", "Ошибка " + getTitle() + "!!!", JOptionPane.ERROR_MESSAGE);

                            return;

                        }

                    }


                    /// загружаем изображение коня, если его нету (null) то в классе clBoard рисуется красный квадрат

                    if (BoardCellsHorse.isSelected() == true)

                    {

                        if (ImageCellsHorse != null)

                        {

                        } else

                        {

                            JOptionPane.showMessageDialog(null, "Ошибка загрузки " + BoardCellsHorse.getText() + "\nСнимите галочку или Загрузите изображение", "Ошибка " + getTitle() + "!!!", JOptionPane.ERROR_MESSAGE);

                            return;

                        }

                    }

                    /// создаем шахматную доску запуская конструктор с нужными проверенными параметрами

                    Board = new clBoard(BoardSize, CellsSize, CellsStretch.isSelected(), imageCellsWhite, imageCellsBlack, CellFirst.isSelected(), ImageCellsHorse, HorseXcell, HorseYcell);

                    /// включение пунктов меню

                    menubar.mNew.setEnabled(false);

                    menubar.mColor.setEnabled(true);

                    menubar.mClear.setEnabled(true);

                    menubar.mRun.setEnabled(true);

                    menubar.mStop.setEnabled(true);

                    // скрваем диалог и теперь мы работаем с окном

                    setVisible(false);

                } else if (ob == BoardCancel)///"Отмена"

                {

                    setVisible(false);

                } else if (ob == BoardCellsBlackImage)///Изображение для темных клеток из файла

                {

                    OpenImage.setDirectory(".");/// выбор текущей директории где работает программа

                    OpenImage.setTitle("Загрузка изображения темной клетки из файла...");/// заголовок

                    OpenImage.setFile("*.jpg;*.png");/// маска файлов изображений (которые точно откроются)

                    OpenImage.setVisible(true);// показываем диалог

                    String StrFile = OpenImage.getFile();// принимаем имя файла

                    String StrDir = OpenImage.getDirectory();// принимаем путь к директории

                    BufferedImage image = null;// изображение приёмник(temp image)


                    if ((StrFile != null) && (StrDir != null))

                    {

                        File ImageFile = new File(StrDir + StrFile);

                        /// если файл существует и его возможно прочитать то пробуем загрузить из него изображение

                        if (ImageFile.canRead())

                        {

                            try {

                                image = ImageIO.read(ImageFile);/// загружаем изображение в image (приемник)

                            } catch (IOException e1) {

                                e1.printStackTrace();

                            }

                        }

                    }
                    /// end if

                    ImageCellsBlack = image;/// загрузили и сохраняем для дальнейшего использования...


                } else if (ob == BoardCellsWhiteImage)///"Изображение для светлых клеток из файла"

                {

                    OpenImage.setDirectory(".");/// выбор текущей директории где работает программа

                    OpenImage.setTitle("Загрузка изображения светлой клетки из файла...");/// заголовок

                    OpenImage.setFile("*.jpg;*.png");/// маска файлов изображений (которые точно откроются)

                    OpenImage.setVisible(true);// показываем диалог

                    String StrFile = OpenImage.getFile();// принимаем имя файла

                    String StrDir = OpenImage.getDirectory();// принимаем путь к директории

                    BufferedImage image = null;// изображение приёмник(temp image)


                    if ((StrFile != null) && (StrDir != null))

                    {

                        File ImageFile = new File(StrDir + StrFile);

                        /// если файл существует и его возможно  то пробуем загрузить из него изображение

                        if (ImageFile.canRead())

                        {

                            try {

                                image = ImageIO.read(ImageFile);/// загружаем изображение в image (приемник)

                            } catch (IOException e1) {

                                e1.printStackTrace();

                            }

                        }

                    }
                    /// end if

                    ImageCellsWhite = image;/// загрузили и сохраняем для дальнейшего использования...

                } else if (ob == BoardCellsHorseImage)///Изображение для коня из файла

                {

                    OpenImage.setDirectory(".");/// выбор текущей директории где работает программа

                    OpenImage.setTitle("Загрузка изображения коня из файла...");/// заголовок

                    OpenImage.setFile("*.jpg;*.png");/// маска файлов изображений (которые точно откроются)

                    OpenImage.setVisible(true);// показываем диалог

                    String StrFile = OpenImage.getFile();// принимаем имя файла

                    String StrDir = OpenImage.getDirectory();// принимаем путь к директории

                    BufferedImage image = null;// изображение приёмник(temp image)


                    if ((StrFile != null) && (StrDir != null))

                    {

                        File ImageFile = new File(StrDir + StrFile);

                        /// если файл существует и его возможно  то пробуем загрузить из него изображение

                        if (ImageFile.canRead())

                        {

                            try {

                                image = ImageIO.read(ImageFile);/// загружаем изображение в image (приемник)

                            } catch (IOException e1) {

                                e1.printStackTrace();

                            }

                        }

                    }
                    // end if

                    ImageCellsHorse = image;/// загрузили и сохраняем для дальнейшего использования...

                }

            }

        }

    }


    /**
     * Точка входа в приложение (программу обхода доски конем)
     *
     * @param args
     */

    public static void main(String[] args)

    {

        // создаем экземпляр окна программы

        clFrame frame = new clFrame();

        // устанавливам иные размеры

        frame.setSize(600, 500);

        // и обязательно показываем

        frame.setVisible(true);

        // далее через меню выполняем нужные действия

    }
}