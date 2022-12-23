import java.util.Date;

public class Object {
    public int number;
    public Date created;
    public Date completed;
    public String header;
    public String description;



    Object(int _number, String _title, String _description) {
        this.number = _number;
        this.created = new Date();
        this.completed = null;
        this.header = _title;
        this.description = _description;
    }

}

