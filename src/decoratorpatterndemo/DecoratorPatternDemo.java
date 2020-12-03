//GUI was manually done to best suit this assignment's description

package decoratorpatterndemo;


import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;


/**
 * @author Mickael Walters | Object-oriented Design and Programming | Final
 * ID #: 2016111033
 */
public class DecoratorPatternDemo extends JFrame {
    
    //Variables
    private int beverageOption;
    private double totalCost, totalcost;
    private double Total;
    private Beverage choice;
    private final JPanel panelA;
    private final JPanel panelB;
    private final JPanel panelC;
    private final JPanel billTop;
    private final JLabel total, descrip, added;
    
    //Global Objects
    StringBuilder stream = new StringBuilder();
    DecimalFormat df = new DecimalFormat("#.00");
    
    //default constructor
    public DecoratorPatternDemo() {
        
        
        //OBJECTS
        JFrame frameA = new JFrame();
        panelA = new JPanel(); //For menu
        
        String menuInfo = "<html> <font size = '12' color = '#883300' text align = 'center'> Coffee Menu  </font> </html>";
        
        JLabel menu = new JLabel(menuInfo, JLabel.CENTER);
        menu.setIcon(new ImageIcon("icons/coffee-to-go-48.png"));
        
        //Buttons on Panel-A
        JButton HBbtn = new JButton("HOUSE BLEND 💲18.00");
        HBbtn.setIcon(new ImageIcon("icons/cafe-32.png"));
        
        JButton DcafBTN = new JButton("DECAF 💲16.00");
        DcafBTN.setIcon(new ImageIcon("icons/cafe-32.png"));
        
        JButton espresoBTN = new JButton("ESPRESSO 💲30.00");
        espresoBTN.setIcon(new ImageIcon("icons/cafe-32.png"));
        
        JButton drkRstBTN = new JButton("DARK ROAST 💲22.00");
        drkRstBTN.setIcon(new ImageIcon("icons/cafe-32.png"));
        //END Buttons on PanelA
        
            //Use of Objects - panelA
        frameA.setSize(350, 400);
        frameA.setLocationRelativeTo(null); //Frame is to be centered
        frameA.add(panelA, BorderLayout.CENTER);
        frameA.setResizable(false);
        frameA.setTitle("WELLHRD'S COFFEE");
        frameA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frameA.pack();
        frameA.setVisible(true); //Opens on start of program
        
        panelA.setVisible(true);
        
        panelA.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panelA.setBackground(Color.lightGray);
        panelA.setLayout(new GridLayout(0,1));
        
        panelA.add(menu);
        panelA.add(new JSeparator() );
        
        panelA.add(HBbtn);
        panelA.add(DcafBTN);
        panelA.add(espresoBTN);
        panelA.add(drkRstBTN);
        
            //Used to create Action listener for functionality
        HBbtn.setActionCommand("HOUSE BLEND 💲18.00");
        DcafBTN.setActionCommand("DECAF 💲16.00");
        espresoBTN.setActionCommand("ESPRESSO 💲30.00");
        drkRstBTN.setActionCommand("DARK ROAST 💲22.00");
        
        HBbtn.addActionListener(new ButtonClickedListener() );
        DcafBTN.addActionListener(new ButtonClickedListener() );
        espresoBTN.addActionListener(new ButtonClickedListener() );
        drkRstBTN.addActionListener(new ButtonClickedListener() );
            //*****END PANEL A ITEMS****
        
        
            //PANEL-B OBJECTS AND USE
        panelB = new JPanel(); //For Toppings
        
        String toppingInfo = "<html> <font size = '12' color = '#d6c6b4' text align = 'center'> Your Topping  </font> </html>";
        frameA.add(panelB, BorderLayout.CENTER);
        
        JLabel topping = new JLabel(toppingInfo, JLabel.CENTER);
        
        panelB.add(topping);
        panelB.add(new JSeparator() );
        
            //BUTTONS
        JButton milkBTN = new JButton("ADD MILK 💲1.50");
        milkBTN.setIcon(new ImageIcon("icons/milk-32.png") );
        
        JButton mochaBTN = new JButton("ADD MOCHA 💲1.75");
        mochaBTN.setIcon(new ImageIcon("icons/mocha.png"));
        
        JButton whipBTN = new JButton("ADD WHIP CREAM 💲2.00");
        whipBTN.setIcon(new ImageIcon("icons/whipped-cream-28.png"));
        
        JButton chocBTN = new JButton("ADD CHOCOLATE SYRUP 💲3.00");
        chocBTN.setIcon(new ImageIcon("icons/syrup.png"));
        
        JButton caramelBTN = new JButton("ADD CARAMEL SYRUP 💲2.50");  
        caramelBTN.setIcon(new ImageIcon("icons/caramel-syrup.png"));
        
        
        panelB.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panelB.setBackground(Color.GRAY);
        panelB.setLayout(new GridLayout(0,1));
        
        panelB.setVisible(false); //Testing
        
        panelB.add(milkBTN);
        panelB.add(mochaBTN);
        panelB.add(whipBTN);
        panelB.add(chocBTN);
        panelB.add(caramelBTN);
        
        milkBTN.setActionCommand("ADD MILK 💲1.50");
        milkBTN.addActionListener(new OptionsAddedListener() );
        
        mochaBTN.setActionCommand("ADD MOCHA 💲1.75");
        mochaBTN.addActionListener(new OptionsAddedListener() );
        
        whipBTN.setActionCommand("ADD WHIP CREAM 💲2.00");
        whipBTN.addActionListener(new OptionsAddedListener() );
        
        chocBTN.setActionCommand("ADD CHOCOLATE SYRUP 💲3.00");
        chocBTN.addActionListener(new OptionsAddedListener() );
        
        caramelBTN.setActionCommand("ADD CARAMEL SYRUP 💲2.50");
        caramelBTN.addActionListener(new OptionsAddedListener() );
            //****END PANEL B ITEMS****
        
        
            //DISPLAY BILL PANEL - PANEL C
        panelC = new JPanel(); 
        billTop = new JPanel(); //testng a new panel on top of C-working as title for bill
        
            //Set panel layouts
        billTop.setLayout(new BorderLayout() );
        panelC.setLayout(new FlowLayout() );
        
        
        //Add panel to frame
        frameA.add(panelC);
        
        //Define objects 
        String billInfo = "<html> <font size = '12' color = '#883300' text align = 'center'> BILL  </font> </html>";        
        JLabel bill = new JLabel(billInfo, JLabel.CENTER);
        bill.setIcon(new ImageIcon("icons/bill-32.png") );
        
        billTop.add(bill, BorderLayout.NORTH);
        billTop.add(new JSeparator(), BorderLayout.CENTER ); 
        
        String complete = "<html> <h2> Your transaction is completed... </h2>   </html>   ";
        JLabel comp = new JLabel(complete);
        
        
        String costInfo = "TOTAL COST 💲";
        JLabel cost = new JLabel(costInfo);
        total = new JLabel();  
        
        //Sets the width and heigth of LABEL for better UI
        cost.setPreferredSize(new Dimension (100,20) );
        total.setPreferredSize(new Dimension (150,20) );
                
        
        String beverageInfo = "BEVERAGE: ";
        JLabel bev = new JLabel(beverageInfo);
        descrip = new JLabel();
        
        //Sets the width and heigth of LABEL for better UI
        bev.setPreferredSize(new Dimension(100,75) );
        descrip.setPreferredSize(new Dimension(150,75) );
        
        String optionsInfo = "OPTIONS ADDED: ";
        JLabel options = new JLabel(optionsInfo);
        added = new JLabel();
        
        //Sets the width and heigth of LABEL for better UI
        options.setPreferredSize(new Dimension(100,20) );
        added.setPreferredSize(new Dimension(150,20) );
        
        String messageInfo = "<html> <i> ☕ Thank you and do come again... 🤝🏽 </i>   </html>";
        JLabel message = new JLabel(messageInfo);
        
        //Sets the width and heigth of LABEL for better UI
        message.setPreferredSize(new Dimension(250,50) );
        
        //Add panel on top of panel C
        panelC.add(billTop);
        
        //Add components to panel C
        panelC.add(comp);
        panelC.add(cost);
        panelC.add(total);
        
        panelC.add(bev);
        panelC.add(descrip);
        
        panelC.add(options);
        panelC.add(added);
        
        panelC.add(message);     
        
        panelC.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.cyan));
        panelC.setBackground(Color.white);
        billTop.setBackground(Color.white);
               
        panelC.setVisible(false);
        
    } //End Constructor

    
    //Start Main Class
    public static void main(String[] args) {
        
        //GUI START
        DecoratorPatternDemo decoratorPatternDemo = new DecoratorPatternDemo();
        //GUI END

           
    } //End of MAIN CLASS  


    private class OptionsAddedListener implements ActionListener {

        public OptionsAddedListener() {
        }
        
        public int optionCount(String str) {
            return str.split("%n|\r").length;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String whatsAdd = e.getActionCommand();
            
            String str = whatsAdd;
                        
            if (whatsAdd.equals("ADD MILK 💲1.50")) {
                Beverage milk = (Beverage) new Milk(choice);
                stream.append(milk.getDescription() );
                totalcost += milk.getCost();
                
                Total = totalcost + totalCost;      
                //Sets data to panel objects
                total.setText(String.valueOf(Total) );
                added.setText(stream.toString());
            }
            if (whatsAdd.equals("ADD MOCHA 💲1.75")) {
                Beverage mocha = (Beverage) new Mocha(choice);
                stream.append(mocha.getDescription() );
                totalcost += mocha.getCost();
                
                Total = totalcost + totalCost;                
                total.setText(String.valueOf(Total) );
                added.setText(stream.toString());
                
            }
            if (whatsAdd.equals("ADD WHIP CREAM 💲2.00")) {
                Beverage whip = (Beverage) new WhipCream(choice);
                stream.append(whip.getDescription());
                totalcost += whip.getCost();
                //addOptions(choice, totalcost, stream);
                Total = totalcost + totalCost;   
                total.setText(String.valueOf(Total) );
                added.setText(stream.toString());
                
            }
            if (whatsAdd.equals("ADD CHOCOLATE SYRUP 💲3.00")) {
                Beverage chocolate = (Beverage) new ChocolateSyrup(choice);
                stream.append(chocolate.getDescription());
                totalcost += chocolate.getCost();
                //addOptions(choice, totalcost, stream);
                Total = totalcost + totalCost;
                total.setText(String.valueOf(Total) );
                added.setText(stream.toString());
                
            }
            if (whatsAdd.equals("ADD CARAMEL SYRUP 💲2.50")) {
                Beverage caramel = (Beverage) new CaramelSyrup(choice);
                stream.append(caramel.getDescription());
                totalcost += caramel.getCost();
                //addOptions(choice, totalcost, stream);
                Total = totalcost + totalCost;
                total.setText(String.valueOf(Total) );
                added.setText(stream.toString());
               
            }
                
                if (optionCount(str) == 1) { //Suppose to be == 2 but bugs ----
                    
                    panelB.setVisible(false);
                    panelC.setVisible(true); 
            }
                Total = totalcost + totalCost;
                //System.out.println(str);
                //System.out.println(optionCount(str));
        }
    }
    
    /*
    public static String beverageWithoutOptions(int beverageOption) {
        DecimalFormat df = new DecimalFormat("#.00");
        String description = null;
        double totalCost = 0.00;
        
        if (beverageOption == 1){
            Beverage houseblend = new HouseBlend();
            description = houseblend.getDescription();
            totalCost = houseblend.getCost();
        }
        else if (beverageOption == 2 ){
            Beverage decaf = new Decaf();
            description = decaf.getDescription();
            totalCost = decaf.getCost();
        }
        else if (beverageOption == 3 ) {
            Beverage espresso = new Espresso();
            description = espresso.getDescription();
            totalCost = espresso.getCost();
        }
        else if (beverageOption == 4 ){
            Beverage darkroast = new DarkRoast();
            description = darkroast.getDescription();
            totalCost = darkroast.getCost();
        }
        return "Total Cost $" + df.format(totalCost) + "\n Beverage:" + description; 
    }
*/
    
    private class ButtonClickedListener implements ActionListener {

        public ButtonClickedListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
                        
            if (command.equals("HOUSE BLEND 💲18.00")){
                
                int a = JOptionPane.showConfirmDialog(null, "Do you want to additional options?");
        
                if (a == JOptionPane.YES_OPTION) {
                    choice = new HouseBlend();
                    totalCost = choice.getCost();
                
                    Beverage houseblend = new HouseBlend();
                    String description = houseblend.getDescription();
                    totalCost = houseblend.getCost();
                    
                    Total = totalcost + totalCost;
                    total.setText(String.valueOf(Total) );
                    descrip.setText(String.valueOf(description));
                    
                    
                    //System.out.println(Total+ " " + description);
                
                    panelA.setVisible(false);
                    panelB.setVisible(true);                       
                }
                else if (a == JOptionPane.NO_OPTION) {
                    panelA.setVisible(false);
                    panelC.setVisible(true);
                
                    Beverage houseblend = new HouseBlend();
                    String description = houseblend.getDescription();
                    totalCost = houseblend.getCost();
                    
                    Total = totalcost + totalCost;
                    
                    total.setText(String.valueOf(Total) );
                    descrip.setText(String.valueOf(description));
                }
            }
            if (command.equals("DECAF 💲16.00")){
                int b = JOptionPane.showConfirmDialog(null, "Do you want to additional options?");
        
                if (b == JOptionPane.YES_OPTION) {
                    choice = new Decaf();
                    totalCost = choice.getCost();
                
                    Beverage decaf = new Decaf();
                    String description = decaf.getDescription();
                    totalCost = decaf.getCost();
                
                    //System.out.println(totalCost);
                    Total = totalcost + totalCost;
                    total.setText(String.valueOf(Total) );
                    descrip.setText(String.valueOf(description));
                
                    panelA.setVisible(false);
                    panelB.setVisible(true);
                }
                else if (b == JOptionPane.NO_OPTION) {
                    panelA.setVisible(false);
                    panelC.setVisible(true);
                
                    Beverage decaf = new Decaf();
                    String description = decaf.getDescription();
                    totalCost = decaf.getCost();
                    
                    Total = totalcost + totalCost;
                    total.setText(String.valueOf(Total) );
                    descrip.setText(String.valueOf(description));
                }
            }
            if (command.equals("ESPRESSO 💲30.00")) {
                int c = JOptionPane.showConfirmDialog(null, "Do you want to additional options?");
        
                if (c == JOptionPane.YES_OPTION) {
                    choice = new Espresso();
                    totalCost = choice.getCost();
                
                    Beverage espresso = new Espresso();
                    String description = espresso.getDescription();
                    totalCost = espresso.getCost();
                    Total = totalcost + totalCost;
                    total.setText(String.valueOf(Total) );
                    descrip.setText(String.valueOf(description));
                
                    //System.out.println(totalCost);
                
                    panelA.setVisible(false);
                    panelB.setVisible(true);
                }
                if (c == JOptionPane.NO_OPTION) {
                    panelA.setVisible(false);
                    panelC.setVisible(true);
                
                    Beverage espresso = new Espresso();
                    String description = espresso.getDescription();
                    totalCost = espresso.getCost();
                    Total = totalcost + totalCost;
                    total.setText(String.valueOf(Total) );
                    descrip.setText(String.valueOf(description));
                
                    //System.out.println(description + " " + totalCost);
                }
            }
            if (command.equals("DARK ROAST 💲22.00")) {
                int d = JOptionPane.showConfirmDialog(null, "Do you want to additional options?");
        
                if (d == JOptionPane.YES_OPTION) {
                    choice = new DarkRoast();
                    totalCost = choice.getCost();
                
                    Beverage darkroast = new DarkRoast();
                    String description = darkroast.getDescription();
                    totalCost = darkroast.getCost();
                    
                    Total = totalcost + totalCost;
                    total.setText(String.valueOf(Total) );
                    descrip.setText(String.valueOf(description));
                
                    //System.out.println(totalCost);
                
                    panelA.setVisible(false);
                    panelB.setVisible(true);
                }
                if (d == JOptionPane.NO_OPTION) {
                    panelA.setVisible(false);
                    panelC.setVisible(true);
                
                    Beverage darkroast = new DarkRoast();
                    String description = darkroast.getDescription();
                    totalCost = darkroast.getCost();
                    Total = totalcost + totalCost;
                    total.setText(String.valueOf(Total) );
                    descrip.setText(String.valueOf(description));
                
                    //System.out.println(description + " " + totalCost);
                }
            }
        }
    }
}


        /*      📚  Resource links: 
    1. https://www.javatpoint.com/java-swing

    2. https://beginnersbook.com/2015/07/java-swing-tutorial/

    3. https://www.tutorialspoint.com/swing/index.htm
    
    4. JAVA How to program 9th ed

    5. https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
        */