package org.example.Login;

import Pin.Generator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;


// TODO: 15.05.2024 Добавить возможность гернерации пароля

public class GUI extends JFrame {

    JFrame menuFrame = new JFrame("Войдите в ваш аккаунт !");


    JLabel menuLabel1 = new JLabel("Войдите или создайте новую учетную запись");
    JLabel menuLabel2 = new JLabel("Если у вас еще нет учетной записи - создайте ее нажав на кнопку ниже");
    JLabel menuName = new JLabel("Логин");
    JLabel menuPassword = new JLabel("Пароль");

    JLabel label = new JLabel("Создание аккаунта");
    JLabel name = new JLabel("Имя");
    JLabel login = new JLabel("Логин");
    JLabel lastName = new JLabel("Фамилия");
    JLabel eMail = new JLabel("Почта");
    JLabel password = new JLabel("Пароль");


    JButton menuButtonLogIn = new JButton("Войти");
    JButton menuButtonCreateAcc = new JButton("Создать Аккаунт");
    JButton create = new JButton("Создать");
    JCheckBox isAdmin = new JCheckBox("Админ");
    JButton findPersButton = new JButton("Найти пользователя");
    JButton allUsersButton = new JButton("Все пользователи");
    JButton again = new JButton("Заново");
    JButton backToMenu = new JButton("<-");
    JButton backToAdmins1 = new JButton("<-");
    JButton backToAdmins2 = new JButton("<-");
    JButton backToAdmins3 = new JButton("<-");
    JButton createPers = new JButton("Создать аккаунт");
    JButton create2 = new JButton("Создать");
    JButton deleteUser = new JButton("Удалить");
    JButton blockUser = new JButton("Заблокировать");
    JButton backToAdmins4 = new JButton("<-");
    JButton BackToAdmins5 = new JButton("<-");
    JButton backToMenu2 = new JButton("<-");
    JButton nextButton = new JButton("->");
    JButton previosButton = new JButton("<-");

    private JTextField menuPassword_fild = new JTextField();
    private JTextField role = new JTextField();
    private JTextField name_fild = new JTextField();
    private JTextField lastName_fild = new JTextField();
    private JTextField login_fild = new JTextField();
    private JTextField eMail_fild = new JTextField();
    private JTextField password_fild = new JTextField();
    private JTextField findPers_fild = new JTextField();
    private JTextField passwordGen = new JTextField("");
    private JTextField findPers_fild2 = new JTextField("");
    private JTextField menuLogin_fild = new JTextField("");


    JPanel menuPanel = new JPanel();
    JPanel creatAccPanel = new JPanel();
    JPanel adminsPanel = new JPanel();
    JPanel findUserPanel = new JPanel();
    JPanel allUsersPanel = new JPanel();
    JPanel userPanel = new JPanel();
    JPanel creatPersPanel = new JPanel();
    JPanel catPanel = new JPanel();

    ArrayList<String[]> r = File1.readFromFile("Clients.txt");


    String[][] data = new String[File1.getLineCountByReader("Clients.txt")][7];
    String[] columnNames = {"Name", "LastName", "Login", "eMail","role","isBlocked"};
    String temp;
    JTable table = new JTable(data, columnNames);
    JScrollPane scrollPane = new JScrollPane(table);
    int current = 1;

    ImageIcon cat1 = new ImageIcon("C:\\Users\\nicol\\IdeaProjects\\LogIn\\src\\main\\java\\cats\\cat1.jpg");
    ImageIcon cat3 = new ImageIcon("C:\\Users\\nicol\\IdeaProjects\\LogIn\\src\\main\\java\\cats\\cat3.jpg");
    ImageIcon cat4 = new ImageIcon("C:\\Users\\nicol\\IdeaProjects\\LogIn\\src\\main\\java\\cats\\cat4.jpg");
    ImageIcon cat5 = new ImageIcon("C:\\Users\\nicol\\IdeaProjects\\LogIn\\src\\main\\java\\cats\\cat5.jpg");
    ImageIcon cat6 = new ImageIcon("C:\\Users\\nicol\\IdeaProjects\\LogIn\\src\\main\\java\\cats\\cat6.jpg");
    ImageIcon cat7 = new ImageIcon("C:\\Users\\nicol\\IdeaProjects\\LogIn\\src\\main\\java\\cats\\cat7.jpg");
    JLabel catLabel = new JLabel(cat1);

    ArrayList<ImageIcon> catsArray = new ArrayList<>();

    int temp2 = 0;


    public GUI() throws IOException {

        catsArray.add(cat1);
        catsArray.add(cat3);
        catsArray.add(cat4);
        catsArray.add(cat5);
        catsArray.add(cat6);
        catsArray.add(cat7);


        menuFrame.setSize(600, 400);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
        menuFrame.setVisible(true);
        menuFrame.add(menuPanel);

        menuPanel.add(menuLabel1);
        menuPanel.add(menuButtonLogIn);
        menuPanel.add(menuButtonCreateAcc);
        menuPanel.add(menuName);
        menuPanel.add(menuPassword);
        menuPanel.add(menuLogin_fild);
        menuPanel.add(menuPassword_fild);
        menuPanel.add(menuLabel2);


        menuPanel.setSize(600, 400);
        menuPanel.setLocation(0, 0);
        menuPanel.setVisible(true);
        menuPanel.setLayout(null);
        menuPanel.setBackground(Color.LIGHT_GRAY);



        adminsPanel.setSize(600, 400);
        adminsPanel.setLocation(0, 0);
        adminsPanel.setVisible(false);
        adminsPanel.setLayout(null);
        adminsPanel.setBackground(Color.LIGHT_GRAY);
        menuFrame.add(adminsPanel);

        catPanel.setSize(600, 400);
        catPanel.setLocation(0, 0);
        catPanel.setVisible(false);
        catPanel.setLayout(null);
        catPanel.setBackground(Color.LIGHT_GRAY);
        menuFrame.add(catPanel);

        creatPersPanel.setSize(600, 400);
        creatPersPanel.setLocation(0, 0);
        creatPersPanel.setVisible(false);
        creatPersPanel.setLayout(null);
        creatPersPanel.setBackground(Color.LIGHT_GRAY);
        menuFrame.add(creatPersPanel);

        userPanel.setSize(600, 400);
        userPanel.setLocation(0, 0);
        userPanel.setVisible(false);
        userPanel.setLayout(null);
        userPanel.setBackground(Color.LIGHT_GRAY);
        menuFrame.add(userPanel);


        allUsersPanel.setSize(600, 400);
        allUsersPanel.setLocation(0, 0);
        allUsersPanel.setVisible(false);
        allUsersPanel.setLayout(null);
        allUsersPanel.setBackground(Color.LIGHT_GRAY);
        menuFrame.add(allUsersPanel);


        findUserPanel.setSize(600, 400);
        findUserPanel.setLocation(0, 0);
        findUserPanel.setVisible(false);
        findUserPanel.setLayout(null);
        findUserPanel.setBackground(Color.LIGHT_GRAY);
        menuFrame.add(findUserPanel);


        creatAccPanel.setVisible(false);


        menuLabel1.setLocation(150, 20);
        menuLabel1.setSize(300, 70);

        menuLabel2.setLocation(90, 230);
        menuLabel2.setSize(420, 70);

        menuButtonLogIn.setLocation(260, 180);
        menuButtonLogIn.setSize(80, 30);

        menuButtonCreateAcc.setLocation(230, 290);
        menuButtonCreateAcc.setSize(140, 30);

        menuName.setLocation(200, 90);
        menuName.setSize(180, 20);

        menuPassword.setLocation(200, 135);
        menuPassword.setSize(180, 20);


        menuLogin_fild.setLocation(250, 94);
        menuLogin_fild.setSize(100, 20);

        menuPassword_fild.setLocation(250, 135);
        menuPassword_fild.setSize(100, 20);


        ///////


        menuButtonLogIn.addActionListener(e -> {

            boolean isOkA = false;


            System.out.println("Number of lines: " + r.size());
            try {
                System.out.println(File1.getLineCountByReader("Clients.txt"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }


            for (String i[] : r) {

                System.out.println("login: [" + i[2] + "] pwd: [" + i[4] + "]");

                // для Админа


                if (i[2].equals(menuLogin_fild.getText()) &&
                        i[4].equals(menuPassword_fild.getText()) && i[5].equals("admin") && i[6].equals("false") ) {
                    isOkA = true;
                    break;
                }

                else if (i[2].equals(menuLogin_fild.getText()) &&
                        i[4].equals(menuPassword_fild.getText()) && i[5].equals("admin") && i[6].equals("true"))
                {
                    JOptionPane.showMessageDialog(null, "Ваш аккаунт был заблокирован",
                            "InfoBox: " + "hello", JOptionPane.INFORMATION_MESSAGE);

                }

                else if (i[2].equals(menuLogin_fild.getText()) && i[4].equals(menuPassword_fild.getText())
                        && i[5].equals("user")) {

                    JOptionPane.showMessageDialog(null, "Вы юзер",
                            "InfoBox: " + "hello", JOptionPane.INFORMATION_MESSAGE);


                    menuPanel.setVisible(false);
                    catPanel.setVisible(true);
                    catPanel.add(backToMenu2);
                    catPanel.add(nextButton);
                    catPanel.add(previosButton);

                    backToMenu2.setSize(50,20);
                    backToMenu2.setLocation(500,20);

                    nextButton.setSize(50,30);
                    nextButton.setLocation(510,175);

                    previosButton.setSize(50,30);
                    previosButton.setLocation(40,175);



                    catPanel.add(catLabel).setBounds(100,100,400,200);



                }

            }

            if(isOkA)
            {

                menuPanel.setVisible(false);
                adminsPanel.setVisible(true);

                adminsPanel.add(findPersButton);
                adminsPanel.add(backToMenu);
                adminsPanel.add(createPers);
                adminsPanel.add(findPers_fild2);
                adminsPanel.add(allUsersButton);


                findPersButton.setSize(160, 20);
                findPersButton.setLocation(220, 30);

                allUsersButton.setSize(160,20);
                allUsersButton.setLocation(220,120);

                findPers_fild2.setSize(170, 20);
                findPers_fild2.setLocation(215, 5);

                backToMenu.setSize(50, 20);
                backToMenu.setLocation(500, 20);

                createPers.setSize(160, 20);
                createPers.setLocation(220, 330);
            }
        });

        menuButtonCreateAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                menuPanel.setVisible(false);

                creatAccPanel.setSize(600, 400);
                creatAccPanel.setLocation(0, 0);
                creatAccPanel.setVisible(true);
                creatAccPanel.setLayout(null);
                creatAccPanel.setBackground(Color.LIGHT_GRAY);

                menuFrame.add(creatAccPanel);

                creatAccPanel.add(label);
                creatAccPanel.add(name);
                creatAccPanel.add(lastName);
                creatAccPanel.add(login);
                creatAccPanel.add(eMail);
                creatAccPanel.add(password);
                creatAccPanel.add(isAdmin);

                creatAccPanel.add(name_fild);
                creatAccPanel.add(lastName_fild);
                creatAccPanel.add(login_fild);
                creatAccPanel.add(eMail_fild);
                creatAccPanel.add(password_fild);
                creatAccPanel.add(isAdmin);
                creatAccPanel.add(again);
                creatAccPanel.add(passwordGen);
                creatAccPanel.add(backToMenu);


                label.setSize(120, 20);
                label.setLocation(240, 30);


                name.setSize(50, 20);
                name.setLocation(170, 80);

                lastName.setSize(70, 20);
                lastName.setLocation(170, 130);

                login.setSize(150, 20);
                login.setLocation(170, 180);

                eMail.setSize(150, 20);
                eMail.setLocation(170, 230);

                password.setSize(150, 20);
                password.setLocation(170, 280);


                name_fild.setSize(150, 20);
                name_fild.setLocation(240, 80);

                lastName_fild.setSize(150, 20);
                lastName_fild.setLocation(240, 130);

                login_fild.setSize(150, 20);
                login_fild.setLocation(240, 180);

                eMail_fild.setSize(150, 20);
                eMail_fild.setLocation(240, 230);

                password_fild.setSize(150, 20);
                password_fild.setLocation(240, 280);

                creatAccPanel.add(create);
                create.setSize(100, 30);
                create.setLocation(300, 320);

                isAdmin.setSize(100, 30);
                isAdmin.setLocation(450, 320);

                passwordGen.setText("");
                passwordGen.setSize(50, 30);
                passwordGen.setLocation(100, 320);

                again.setSize(80, 20);
                again.setLocation(190, 320);

                backToMenu.setSize(50, 20);
                backToMenu.setLocation(500, 20);


            }
        });


        create.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (isAlreadyAdded()) {

                } else {

                    if (name_fild.getText().isEmpty() | lastName_fild.getText().isEmpty() | login_fild.getText().isEmpty() |
                            eMail_fild.getText().isEmpty()) {

                        JOptionPane.showMessageDialog(null, "Введите все данные",
                                "InfoBox: " + "passwordErr", JOptionPane.INFORMATION_MESSAGE);
                    } else if (password_fild.getText().length() < 5) {
                        JOptionPane.showMessageDialog(null, "Длинна пароля должна быть больше 4",
                                "InfoBox: " + "passwordErr", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if (isAlreadyAdded())
                    {
                        JOptionPane.showMessageDialog(null, "Аккаунт с такими данными уже создан",
                                "InfoBox: " + "passwordErr", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {

                        for (String[] i : r) {
                            Random rn = new Random();
                            int randomNum = rn.nextInt(100 - 1 + 1) + 1;

                            if (!i[6].equals(randomNum)) {
                                Client client = new Client(name_fild.getText(), lastName_fild.getText(), login_fild.getText(),
                                        eMail_fild.getText(), password_fild.getText(), "admin", "false", randomNum);


                                try {
                                    File1.writeToFile("Clients.txt", client.toString());
                                    r.clear();

                                    r = File1.readFromFile("Clients.txt");
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }

                                menuPanel.setVisible(true);
                                creatAccPanel.setVisible(false);

                                JOptionPane.showMessageDialog(null, "Вы создали аккаунт",
                                        "InfoBox: " + "hello", JOptionPane.INFORMATION_MESSAGE);

                                name_fild.setText("");
                                lastName_fild.setText("");
                                login_fild.setText("");
                                eMail_fild.setText("");
                                password_fild.setText("");

                                creatAccPanel.updateUI();

                                break;
                            }
                        }
                    }
                }
            }
        });


        again.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Generator generator = new Generator();

                passwordGen.setText(generator.generate(5));

            }
        });

        backToMenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                creatAccPanel.setVisible(false);
                adminsPanel.setVisible(false);
                menuPanel.setVisible(true);

            }
        });

        backToAdmins1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                findUserPanel.setVisible(false);
                adminsPanel.setVisible(true);
            }
        });

        backToAdmins2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                allUsersPanel.setVisible(false);
                adminsPanel.setVisible(true);
            }
        });

        createPers.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                adminsPanel.setVisible(false);
                creatPersPanel.setVisible(true);


                creatPersPanel.add(name);
                creatPersPanel.add(lastName);
                creatPersPanel.add(login);
                creatPersPanel.add(eMail);
                creatPersPanel.add(password);
                creatPersPanel.add(isAdmin);

                creatPersPanel.add(name_fild);
                creatPersPanel.add(lastName_fild);
                creatPersPanel.add(login_fild);
                creatPersPanel.add(eMail_fild);
                creatPersPanel.add(password_fild);
                creatPersPanel.add(isAdmin);
                creatPersPanel.add(again);
                creatPersPanel.add(passwordGen);
                creatPersPanel.add(backToAdmins3);
                creatPersPanel.add(create2);


                name.setSize(50, 20);
                name.setLocation(170, 80);

                lastName.setSize(70, 20);
                lastName.setLocation(170, 130);

                login.setSize(150, 20);
                login.setLocation(170, 180);

                eMail.setSize(150, 20);
                eMail.setLocation(170, 230);

                password.setSize(150, 20);
                password.setLocation(170, 280);


                name_fild.setSize(150, 20);
                name_fild.setLocation(240, 80);

                lastName_fild.setSize(150, 20);
                lastName_fild.setLocation(240, 130);

                login_fild.setSize(150, 20);
                login_fild.setLocation(240, 180);

                eMail_fild.setSize(150, 20);
                eMail_fild.setLocation(240, 230);

                password_fild.setSize(150, 20);
                password_fild.setLocation(240, 280);


                isAdmin.setSize(100, 30);
                isAdmin.setLocation(450, 320);

                passwordGen.setText("");
                passwordGen.setSize(50, 30);
                passwordGen.setLocation(100, 320);

                again.setSize(80, 20);
                again.setLocation(190, 320);

                backToAdmins3.setSize(50, 20);
                backToAdmins3.setLocation(500, 20);

                create2.setSize(100, 30);
                create2.setLocation(300, 320);


            }
        });

        backToAdmins3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                creatPersPanel.setVisible(false);
                adminsPanel.setVisible(true);
            }
        });

        backToAdmins4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                userPanel.setVisible(false);
                adminsPanel.setVisible(true);
            }
        });

        BackToAdmins5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                scrollPane.setVisible(false);
                adminsPanel.setVisible(true);
            }
        });


        create2.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {

                for (String[] i : r) {
                    Random rn = new Random();
                    int randomNum = rn.nextInt(100 - 1 + 1) + 1;

                    if (!i[7].equals(randomNum)) {
                        Client client = new Client(name_fild.getText(), lastName_fild.getText(), login_fild.getText(),
                                eMail_fild.getText(), password_fild.getText(), "admin", "false", randomNum);
                        try {
                            File1.writeToFile("Clients.txt", client.toString());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);

                        }
                        break;
                    }
                }

                adminsPanel.setVisible(true);
                creatPersPanel.setVisible(false);

                JOptionPane.showMessageDialog(null, "Вы создали аккаунт",
                        "InfoBox: " + "hello", JOptionPane.INFORMATION_MESSAGE);

                name_fild.setText("");
                lastName_fild.setText("");
                login_fild.setText("");
                eMail_fild.setText("");
                password_fild.setText("");

                creatPersPanel.updateUI();

            }
        });

        findPersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean isOk = false;

                for (String[] i : r) {

                    if (i[2].equals(findPers_fild2.getText())) {
                        temp = i[6];
                        isOk = true;
                        break;
                    }
                }

                if (isOk) {

                    JOptionPane.showMessageDialog(null, "пользователь найден",
                            "InfoBox: " + "hello", JOptionPane.INFORMATION_MESSAGE);

                    adminsPanel.setVisible(false);
                    userPanel.setVisible(true);


                    userPanel.add(deleteUser);
                    userPanel.add(blockUser);
                    userPanel.add(backToAdmins4);


                    deleteUser.setSize(135, 20);
                    deleteUser.setLocation(240, 100);

                    blockUser.setSize(135, 20);
                    blockUser.setLocation(240, 200);

                    backToAdmins4.setSize(50, 20);
                    backToAdmins4.setLocation(500, 20);



                } else {
                    JOptionPane.showMessageDialog(null, "пользователь не найден",
                            "InfoBox: " + "hello", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        blockUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Iterator itr = r.iterator();

                while( itr.hasNext() ) {

                    String[] i = (String[]) itr.next();


                    if( i[2].equals(findPers_fild2.getText()) && !i[2].equals(menuLogin_fild.getText()) &&
                            !i[5].equals("admin") ) {


                        if(i[6].equals("false"))
                        {
                            i[6] = "true";
                            JOptionPane.showMessageDialog(null, "пользователь заблокирован",
                                    "InfoBox: " + "hello", JOptionPane.INFORMATION_MESSAGE);
                            blockUser.setText("Разблокировать");
                        }

                        else
                        {
                            i[6] = "false";
                            JOptionPane.showMessageDialog(null, "пользователь разблокирован",
                                    "InfoBox: " + "hello", JOptionPane.INFORMATION_MESSAGE);
                            blockUser.setText("Заблокирвать");
                        }

                            try {
                            File1.writeToFile( "Clients.txt", r);
                        } catch( Exception ex )
                        {
                            System.out.println( ex.getMessage() );
                        }
                        break;
                    }
                }
            }
        });

        allUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.add(scrollPane);
                scrollPane.add(BackToAdmins5);

                BackToAdmins5.setSize(50,20);
                BackToAdmins5.setLocation(340,20);

                int i = 0;

                for (String z[] : r) {

                    for (int j = 0; j < 7; j++) {

                        if(j==4)
                        {
                            data[i][j] = z[5];
                            j++;
                        }

                        else if (j==6)
                        {
                            data[i][j-1] = z[6];
                        }

                        else
                        {
                            data[i][j] = z[j];
                        }
                    }
                    i++;
                }


                adminsPanel.setVisible(false);
                table.setVisible(true);
            }
        });

        deleteUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Iterator itr = r.iterator();

                while( itr.hasNext() ) {

                    String[] i = (String[]) itr.next();

                    if(  i[2].equals(findPers_fild2.getText()) && !i[2].equals(menuLogin_fild.getText()) &&
                            !i[5].equals("admin") ) {
                        itr.remove();
                        try {
                            File1.writeToFile( "Clients.txt", r);
                        } catch( Exception ex )
                        {
                            System.out.println( ex.getMessage() );
                        }
                        break;
                    }
                }
            }
        });

        backToMenu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                catPanel.setVisible(false);
                menuPanel.setVisible(true);
            }
        });



        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(temp2);
                temp2++;
                catLabel.setIcon(helper(catsArray));


            }
        });

        previosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){


                System.out.println(temp2);
                temp2--;
                catLabel.setIcon(helper(catsArray));
        }

        });
    }

    public ImageIcon helper(ArrayList<ImageIcon> a) {

        if (temp2 >= a.size())
            temp2 = 0;


        else if (temp2 < 0 )
            temp2 = a.size() - 1;


        return a.get(temp2);
    }


    public boolean isAlreadyAdded() {

        for (String i[] : r) {

            boolean isOk = false;

            if (i[2].equals(login_fild.getText()))
            {
                isOk = true;
            }

            if (isOk) {
                JOptionPane.showMessageDialog(null, "Такой аккаунт уже создан",
                        "InfoBox: " + "hello", JOptionPane.INFORMATION_MESSAGE);

                return true;

            }
        }

        return false;
    }
}