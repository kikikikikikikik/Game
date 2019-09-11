/**
 * @ClassName Card
 * @Desc TODO
 * @Auther 28893
 * @Date 2019/9/11  12:10
 * @Veresion 1.0
 */
public class Card {
    int value;
    String color;
    public Card(int value,String color){
        this.value=value;
        this.color=color;
    }
    @Override
    public String toString(){
        String v;
        if(value==1){
            v="A";
        }
       else if(value==11){
            v="J";
        }
        else if(value==12){
            v="Q";
        }
       else  if(value==13){
            v="K";
        }
        else{
            v=String.valueOf(value);
        }
        return String.format("[%s %s]",color,v);
    }
    @Override
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(!(obj instanceof Card)) {
            return false;
        }
        if(obj==this){
            return true;
        }
        Card o=(Card)obj;
        return o.value==value&&color.equals(o.color);
    }
}
