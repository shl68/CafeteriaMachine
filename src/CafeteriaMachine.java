import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CafeteriaMachine extends JFrame {
    private ImageIcon imageIcon;
    private JLabel imageLabel;

    {
        imageIcon = new ImageIcon("res/week1.jpg");

        Image image = imageIcon.getImage();
        Image newImage = image.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImage);

        imageLabel = new JLabel(imageIcon);

        add(imageLabel, BorderLayout.AFTER_LAST_LINE);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(100, 100);
        setVisible(true);

        setIconImage(Toolkit.getDefaultToolkit().

      getImage("res/logo.png"));

     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     setSize(500,500);
     setVisible(true);

}
    public CafeteriaMachine() {

        int[] sales = new int[5];


        setTitle("학생식당 자판기");

        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JPanel jp3 = new JPanel();
        JPanel jp4 = new JPanel();


        JLabel jl1 = new JLabel("원하는 메뉴 선택");


        JRadioButton jrb1 = new JRadioButton("정식(4000)");
        JRadioButton jrb2 = new JRadioButton("일품(4500)");
        JRadioButton jrb3 = new JRadioButton("분식(2000)");
        JRadioButton jrb4 = new JRadioButton("면류(3000)");
        JRadioButton jrb5 = new JRadioButton("탕류(4000)");


        ButtonGroup bg = new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
        bg.add(jrb4);
        bg.add(jrb5);


        JLabel jl2 = new JLabel("수   량 : ");
        JTextField su = new JTextField(5);

        JLabel jl3 = new JLabel("입금액 : ");
        JTextField money = new JTextField(10);


        JTextArea jta = new JTextArea(5, 30);
        JScrollPane jsp = new JScrollPane(
                jta,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jta.setLineWrap(true);


        JButton jb1 = new JButton("계   산");
        JButton jb2 = new JButton("종   료");
        JButton jb3 = new JButton("취   소");
        JButton jb4 = new JButton("관리자 호출");
        JButton statButton = new JButton("통계 보기");




        jp1.add(jl1);


        jp2.add(jrb1);
        jp2.add(jrb2);
        jp2.add(jrb3);
        jp2.add(jrb4);
        jp2.add(jrb5);


        jp3.add(jl2);
        jp3.add(su);
        jp3.add(jl3);
        jp3.add(money);


        jp4.add(jb1);
        jp4.add(jb2);
        jp4.add(jb3);
        jp4.add(jb4);
        jp4.add(statButton);



        JPanel pg1 = new JPanel(new BorderLayout());
        JPanel pg2 = new JPanel(new BorderLayout());


        pg1.add(jp1, BorderLayout.NORTH);
        pg1.add(jp2, BorderLayout.CENTER);


        pg2.add(jp3, BorderLayout.NORTH);
        pg2.add(jsp, BorderLayout.CENTER);
        pg2.add(jp4, BorderLayout.SOUTH);


        add(pg1, BorderLayout.NORTH);
        add(pg2, BorderLayout.CENTER);


        setBounds(200, 200, 300, 300);

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);


        jb1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String mealStr = null;
                int mealInt = 0;
                int amount = Integer.parseInt(su.getText());


                if (jrb1.isSelected()) {
                    mealStr = "정식";
                    mealInt = 4000;
                    sales[0]+=1*amount;
                } else if (jrb2.isSelected()) {
                    mealStr = "일품";
                    mealInt = 4500;
                    sales[1]+=1*amount;
                } else if (jrb3.isSelected()) {
                    mealStr = "분식";
                    mealInt = 2000;
                    sales[2]+=1*amount;
                } else if (jrb4.isSelected()) {
                    mealStr = "면류";
                    mealInt = 3000;
                    sales[3]+=1*amount;
                }
                else if (jrb5.isSelected()) {
                    mealStr = "탕류";
                    mealInt = 4000;
                    sales[4]+=1*amount;
                }


                int money1 = Integer.parseInt(money.getText());


                int sum = amount * mealInt;



                int total = sum;

                int result = money1 - total;
                if (money1 < total) {
                    Lessmoney lessmoney = new Lessmoney();
                    lessmoney.excute();
                }

                jta.append("식사종류 : " + mealStr + "\n");
                jta.append("식사금액 : " + String.format("%,d원", mealInt) + "\n");
                jta.append("수     량 : " + amount + "\n");
                jta.append("총 금 액 : " + String.format("%,d원", total) + "\n");
                jta.append("입 금 액 : " + String.format("%,d원", money1) + "\n");
                jta.append((money1 < total) ? "발권 되지 않았습니다. 다시 시도해주세요." : "거스름돈 : " + String.format("%,d원", result) + "\n");

                bg.clearSelection();
                su.setText(null);
                money.setText(null);

            }
        });

        jb2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }
        });

        jb3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                bg.clearSelection();
                su.setText(null);
                money.setText(null);
                jta.setText(null);

            }

        });
        jb4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            CallAdmin calladmin = new CallAdmin();
            calladmin.excute();
            }
        });
        statButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int total = 0;
                        for (int s : sales) {
                            total += s;
                        }
                        jta.append("메뉴별 구매 횟수\n");
                        jta.append("정식: " + sales[0] + "개\n");
                        jta.append("일품: " + sales[1] + "개\n");
                        jta.append("분식: " + sales[2] + "개\n");
                        jta.append("면류: " + sales[3] + "개\n");
                        jta.append("탕류: " + sales[4] + "개\n");
                        jta.append("총 판매량: " + total + "개\n");
                    }
                });
            }
        });








    }


}