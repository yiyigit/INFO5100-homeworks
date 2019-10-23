public abstract class Moody {
    protected abstract String getMood();
    protected abstract void expressFeelings();
    public void queryMood(){
        System.out.println("I feel " + getMood() + " today!" + "\n");
    };
}

public class Happy extends Moody {
    protected String getMood(){
        return getClass().getSimpleName().toLowerCase();
    }
    public void expressFeelings(){
        System.out.println("hehehe...hahahah...HAHAHAHAHA!!!");
    }

    public String toString(){
        return "Subject laughs a lot";
    }
}


public class Sad extends Moody{

    protected String getMood(){
        return getClass().getSimpleName().toLowerCase();
    }
    public void expressFeelings(){
        System.out.println("\'wah\' \'boo hoo\' \'weep\' \'sob\' \'weep\'");
    }
    public String toString(){
        return "Subject cries a lot";
    }
}

public class Psychiatrist {
    public void examine(Moody md){
        System.out.println("How are you feeling today?");
        md.queryMood();
    }

    public void observe(Moody md){
        md.expressFeelings();
        System.out.println("Observation: " + md.toString() + "\n");
    }


    public static void main(String[] args) {
        Psychiatrist p = new Psychiatrist();
        Sad sd = new Sad();
        Happy h = new Happy();
        p.examine(h);
        p.observe(h);
        p.examine(sd);
        p.observe(sd);
    }
}
