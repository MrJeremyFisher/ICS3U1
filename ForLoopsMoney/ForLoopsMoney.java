/*
 * Author: Jeremy Favro
 * Date: 3/7/22
 * Class: ICS3U1
 * Project name: ForLoopsMoney
 * Description: Double money every day for every day of March
 */

package forloopsmoney;
import java.text.DecimalFormat;

public class ForLoopsMoney 
{
    public static double MoneyAmount = .01;
    public static DecimalFormat money = new DecimalFormat("###,###,###.##$");
    public static void main(String[] args) 
    
    {
        for (int i = 0; i <= 31; i ++) {
            MoneyAmount = MoneyAmount * 2;
            System.out.println("Day: " + i + " Money amount: " + money.format(MoneyAmount));
        
        
        }
    } //EndOfMain

} // EndOfClass
