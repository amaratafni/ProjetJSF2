import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Bean {

    private String  input1;
    private Integer input2;

    public String getInput1() {
        return input1;
    }

    public void setInput1( String input1 ) {
        this.input1 = input1;
    }

    public Integer getInput2() {
        return input2;
    }

    public void setInput2( Integer input2 ) {
        this.input2 = input2;
    }

    public void submit() {
        //
    }

    public void update() {
        input1 = "Updated!";
        input2 = 42;
    }

    // Getters/setters.
}