import java.util.Arrays;
import java.util.Random;

public class MonntyHall {


    public static void main(String[] args){
        long SIZE = 10000000000l;
        Random rand = new Random();
        long[] result = new long[3];
        for(long i = 0; i < SIZE; i++){
            Game game = new Game(rand);
            if(game.openFirst()){
                result[0]++;
            }
            else if(rand.nextBoolean()){
                game.switchChoice();
                if(game.openSecond()){
                    result[1]++;
                }
            }
            else if(game.openSecond()){
                result[2]++;
            }
        }
        System.out.println(Arrays.toString(result));

    }


}

class Game{
    int door;
    boolean one;
    boolean two;
    boolean three;
    int choice;
    boolean win;
    Random rand;

    public Game(Random rand){
        this.rand = rand;
        door = rand.nextInt(3);
        one = false;
        two = false;
        three = false;

    }

    public void choice(int choice){
        this.choice = choice;
    }

    public boolean openFirst(){
        int choice = rand.nextInt(3);
        if(this.door == choice){
            win = true;
            return win;
        }
        switch(choice){
            case 0: one = true; break;
            case 1: two = true; break;
            case 2: three = true; break;
        }
        return false;
    }

    public void switchChoice(){
        switch(choice){
            case 0: choice = two? 2 : 1; break;
            case 1: choice = three? 0 : 2; break;
            case 2: choice = one? 1 : 0; break;
        }
    }

    public boolean openSecond(){
        return choice == door;

    }




}