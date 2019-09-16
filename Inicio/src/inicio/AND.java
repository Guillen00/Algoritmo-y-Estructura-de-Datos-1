
package inicio;


public class AND {

    static int and;
    
     

    static int and (int x,int y) {
        int OUT = x*y;
        System.out.println(OUT);
        return OUT;
       }
    static int nand (int x,int y) {
        int OUT = x*y;
        if (OUT==0){
            System.out.println('1');
            return 1;}
        else{
            System.out.println('0');
            return 0;}
            
        }
    static int nor (int x,int y) {
        int OUT = x+y;
        if(OUT >0){
            System.out.println("0");
            return 0;
        }
            else{
            System.out.println("1");}
            return 1;
            
       }
    static int not (int x) {
        if(x == 0){
            System.out.println("1");
            return 1;
        }
            else{
            System.out.println("0");}
            return 0;
            
       }
    static int or (int x,int y) {
        int OUT = x+y;
        if(OUT >0){
            System.out.println("1");
            return 1;
        }
            else{
            System.out.println("0");}
            return 0;
            
       }
    static int xnor (int x,int y) {
        
        if (x==y){
            System.out.println('1');
            return 1;}
        else{
            System.out.println('0');
            return 0;}
            
        }
    static int xor (int x,int y) {
        
        if (x==y){
            System.out.println('0');
            return 0;}
        else{
            System.out.println('1');
            return 1;}
            
        }  
    }
/*}*/

