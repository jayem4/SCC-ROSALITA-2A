
package rosalita;


public class Product {
    
         int id;
    String name;
    int price, stocks;
    int tep;
    
    public void AddProduct(int pid, String pname, int pr, int st, int temp){
    
        this.id = pid;
        this.name = pname;
        this.price = pr;
        this.stocks = st;
        this.tep = temp;
        
    }
    
    public void viewProduct(){
        double total = this.price * this.stocks;
        String status = ( this.stocks == 0) ? "Out of Stuck " : "Available";
        
        
        System.out.printf("%-10d %-10s %-10d %-10d %-10s %-10.2f\n", this.id, this.name, this.price, this.stocks, status, total);
    }
    
}
