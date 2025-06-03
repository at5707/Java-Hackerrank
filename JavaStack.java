import java.util.*;
class JavaStack{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            System.out.println(isBalanced(input));
		}
	}
    public static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch:input.toCharArray()) {
            if (ch =='('||ch=='{'||ch=='[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top=stack.pop();
                if (!matches(top,ch)) return false;
            }
        }
        return stack.isEmpty();
    }
    public static boolean matches(char open,char close) {
        return (open=='(' && close==')') ||
               (open=='{' && close=='}') ||
               (open=='[' && close==']'); 
    }
}
