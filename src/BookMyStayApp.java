public abstract class Room{
    protected int numberofbeds;
    protected int squarefeet;
    protected double pricepernight;

    public Room(int numberofbeds,int squarefeet,double pricepernight){
        this.numberofbeds=numberofbeds;
        this.squarefeet=squarefeet;
        this.pricepernight=pricepernight;
    }
    public void displayroomdetails(){
        System.out.println("numberofbeds:"+numberofbeds);
        System.out.println("squarefeet:"+squarefeet);
        System.out.println("pricepernight"+pricepernight);
    }
}
public class SingleRoom extends Room{
    public SingleRoom(){
        super(1,250,1500.0);
    }
}
public class DoubleRoom extends Room{
    public DoubleRoom(){
        super(2,400,2500.0);
    }
}
public class SuiteRoom extends Room{
    public SuiteRoom(){
        super(3,750,5000.0);
    }
}
public class BookMyStayApp{

}



