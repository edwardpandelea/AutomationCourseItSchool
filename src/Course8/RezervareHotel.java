package Course8;

public class RezervareHotel {
    String numeClient;
    String tipCamera;
    public RezervareHotel(String numeClient)
    {
        this.numeClient = numeClient;
        System.out.println("NumeClient: " + this.numeClient);
    }
    public RezervareHotel(String numeClient, String tipCamera)
    {
        this.numeClient = numeClient;
        this.tipCamera = tipCamera;
        System.out.println("NumeClient: " + this.numeClient);
        System.out.println("TipCamera: " + this.tipCamera);
    }
}
