import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            String S = sc.nextLine();
            if("#".equals(S)) break;

            Stack<String> stack = new Stack<>();
            boolean isLegal = true;
            String tag = "";

            for(int i = 0; i < S.length(); i++){
                char c = S.charAt(i);
                if(c == '<'){
                    tag = "";
                } else if(c == '>') {
                    if (tag.endsWith("/")) continue;

                    if (tag.startsWith("/")) {
                        String tagName = tag.substring(1);
                        if (!stack.isEmpty() && stack.peek().equals(tagName)) {
                            stack.pop();
                        } else {
                            isLegal = false;
                            break;
                        }
                    } else {
                        tag = tag.split(" ")[0];
                        stack.push(tag);
                    }
                } else {
                    tag += c;
                }
            }

            if(isLegal && stack.isEmpty()){
                System.out.println("legal");
            }else {
                System.out.println("illegal");
            }
        }
    }
}
