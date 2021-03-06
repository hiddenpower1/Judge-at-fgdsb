package tests;
import java.util.*;
import java.lang.*;
import java.io.*;
import judge.*;
import datastruct.*;

public class segregate_even_odd {
    public static int num_test = 100;
    public static int[][] in_0;
    public static int[][] in_org_0;
    public static int[][] out;
		public static boolean test(int i) {
      if(!common.test_anagram(in_0[i], in_org_0[i])) return false;
		  boolean flag = false;
		  for(int j = 0; j < in_0[i].length; ++j) {
        	if (in_0[i][j] % 2 == 0) {
					  if(flag) return false;
				  } else {
					  flag = true;
				  }
			}
      return true;
    }

    public static void load_test() {
        File fil = new File("judge/tests/segregate-even-odd.txt");
        FileReader inputFil = null;
        try {
            inputFil = new FileReader(fil);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader in = new BufferedReader(inputFil);
        try {
            in_0 = common.read_int_matrix(in);
            in_org_0 = test_common.copy(in_0);
            out = common.read_int_matrix(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void judge() {
        load_test();
        common.capture_stdout();
        Solution s = new Solution();

        long startTime = System.currentTimeMillis();

        for(int i = 0; i < num_test; ++i) {
            System.out.printf("Testing case #%d\n", i+1);
        s.segregate(in_0[i]);
        int[] answer = in_0[i];
            if(!segregate_even_odd.test(i)) {
                common.release_stdout();
                System.out.printf("%d / %d;", i+1, num_test);
                String outs = common.to_string(segregate_even_odd.in_org_0[i]);
                System.out.print(outs + ";");
                System.out.print(common.to_string(answer) + ";");
                System.out.println(common.to_string(out[i]));
                return;
            }
        }

        common.release_stdout();
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Accepted;");
        System.out.println(estimatedTime);
    }
}
