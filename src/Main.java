public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack();
        String str = "(([{]}))";
        if (isCorrectStatement(str, stack)) {
            System.out.println("Bracket statement is correct");
        } else
            System.out.println("Bracket statement is wrong");

    }

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


}


