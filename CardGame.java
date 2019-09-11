import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName CardGame
 * @Desc TODO
 * @Auther 28893
 * @Date 2019/9/11  12:12
 * @Veresion 1.0
 */
public class CardGame {
    private static final String[] Color={"♥","♠","♣","♦"};
    private static List<Card> buyCard() {
        List<Card>deck=new ArrayList<>(52);
        for(int i=0;i<4;i++){
            String color=Color[i];
            for(int j=1;j<=13;j++){
                int value=j;
                Card card=new Card(value,color);
                deck.add(card);
            }
        }
        return deck;
    }
    private static void shuffle(List<Card>deck){
        Random random=new Random(20190911);
        for(int i=deck.size()-1;i>0;i--){
            int r=random.nextInt(i);
            swap(deck,r,i);
        }
    }
    private static void swap(List<Card>deck,int i,int j){
        Card t=deck.get(i);
        deck.set(i,deck.get(j));
        deck.set(j,t);
    }
    private static void send(List<List<Card>>hands,List<Card>deck,int numPerson,int numCard){
        for(int k=0;k<numPerson;k++){
            hands.add(new ArrayList<>());
        }
        for(int i=0;i<numCard;i++){
            for(int j=0;j<numPerson;j++){
                Card card=deck.remove(0);
                hands.get(j).add(card);
            }
        }
    }
    private static void play(List<List<Card>>hands){
        Card card=new Card(10,"♦");
        for(int i=0;i<hands.size();i++){
            if(hands.get(i).contains(card)){
                System.out.print(i+1);
                System.out.println("号玩家输了");
                return;
            }
        }
    }
    public static void main(String[] args) {
        List<Card>deck=buyCard();
        System.out.println(deck);
        shuffle(deck);
        System.out.println(deck);
        List<List<Card>>hands=new ArrayList<>();
        send(hands,deck,3,5);
        System.out.println(hands.get(0));
        System.out.println(hands.get(1));
        System.out.println(hands.get(2));
        play(hands);
    }
}
