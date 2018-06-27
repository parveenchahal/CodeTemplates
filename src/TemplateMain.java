
import java.util.Arrays;

public class TemplateMain extends CodeTemplates {

    public static void main(String[] args) {
        String str = "14557 54752 334634 4575 556567 6686 75686 8686 9686";
        int[] arr = toIntArrFromStringArr(str.split(" "));
        System.out.println(Arrays.toString(arr));
    }
}
