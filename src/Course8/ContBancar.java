package Course8;

public class ContBancar {
    private static double sold = 0;

    public void depunere(double amount)
    {
        sold+=amount;
        System.out.println("Ati incarcat contul cu: " + amount + " lei");
    }
    public void retragere(double amount){
        if(sold<amount){
            System.out.println("Sold insuficient!");
        }else{
            sold-=amount;
            System.out.println("Ati retras: " + amount + " lei");
        }
    }

    public void verificaSold(){
        System.out.println("Soldul dvs. este: " + sold + " lei");
    }
}
