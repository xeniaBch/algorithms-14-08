import java.util.Arrays;
import java.util.Objects;
    public class Task2
    {
        public static void main(String[] args) {
            String[] ops = {"5","-2","4","C","D","9","+","+"};
            //System.out.println(Arrays.toString(ops));
            System.out.println(finalScore(ops));
        }
        public static int finalScore(String[] ops) {
            StackInt stack = new StackInt();
            int total = 0;
            for (int i=0; i<ops.length; i++) {
                if (Objects.equals(ops[i], "C")) {
                    stack.pop();
                    continue;
                }
                if (Objects.equals(ops[i], "D")) {
                    int score = stack.pop();
                    stack.push(score);
                    stack.push(score * 2);
                    continue;
                }
                if (Objects.equals(ops[i], "+")) {
                    int score1 = stack.pop();
                    int score2 = stack.pop();
                    stack.push(score2);
                    stack.push(score1);
                    stack.push(score1 + score2);
                    continue;
                }
                stack.push(Integer.parseInt(ops[i]));
            }
            while (!stack.isEmpty()) {
                int score = stack.pop();
                total += score;
            }
            return total;
        }
    }

