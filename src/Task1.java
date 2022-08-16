public class Task1 {

    public static void main(String[] args) {
        Stack stack = new Stack();
        String str = "{([";
        if (isCorrectStatement(str, stack)) {
            System.out.println("Bracket statement is correct");
        } else { System.out.println("Bracket statement is wrong");}



     if (isBracketsCorrect(str)) {
         System.out.println("Bracket statement is correct");
     } else { System.out.println("Bracket statement is wrong");}

}
    //first way to solve this task
    public static boolean isCorrectStatement(String str, Stack stack) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(' || c == '[' || c == '{') {

                stack.push(c);
                continue;
            }

            if (stack.isEmpty())
                return false;

            char test;
            switch (c) {
                case ')' -> {
                    test = stack.pop();
                    if (test == '{' || test == '[')
                        return false;
                }
                case '}' -> {
                    test = stack.pop();
                    if (test == '(' || test == '[')
                        return false;
                }
                case ']' -> {
                    test = stack.pop();
                    if (test == '(' || test == '{')
                        return false;
                }
            }
        }

        return (stack.isEmpty());

    }

   // another way to solve this task. It is more simple to change for another symbols or add another symbol, and I made it.
    public static boolean isBracketsCorrect(String str) {
        Stack stack = new Stack();
        char[] openBrackets = {'(', '[', '{','<'};
        char[] closeBrackets = {')', ']', '}','>'};

        for (int i = 0; i < str.length(); i++ ) {
            int numInOpenArray = contentsInArr(str.charAt(i), openBrackets);
            int numInCloseArray = contentsInArr(str.charAt(i), closeBrackets);

            if ((numInOpenArray == -1) && (numInCloseArray == -1)) {
                return false;
            }
            if (numInOpenArray != -1) {
                stack.push(str.charAt(i));
                continue;
            }
            if (stack.isEmpty()){
                return false;
            }
            char test;
            if (numInCloseArray != -1) {
                test = stack.pop();
                if (test != openBrackets[numInCloseArray]) {
                    return false;
                }
            }
        }
        return (stack.isEmpty());
    }

    public static int contentsInArr (char ch, char[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (ch == arr[i]) {
                return i;
            }
        }
        return -1;
    }


}


