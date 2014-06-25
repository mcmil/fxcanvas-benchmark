package pl.cmil.swtbench;

/**
 * Created by Michal on 2014-06-25.
 */
public class Choice {

    public static void main(String[] args) {
        if(args.length >0 ) {
            if (args[0].equals("canvas")) {
                FXCanvasTest.main(args);
            } else if (args[0].equals("native")) {
                NativeJavaFXTest.main(args);
            }
        } else
        {
            System.out.print("canvas or native?");
        }

    }
}
