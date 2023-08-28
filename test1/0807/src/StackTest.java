
public class StackTest {

	public static void main(String[] args) {
		IStack<String> stack = new LinkedListStack<String>();
		System.out.println(stack.size() + "//" +stack.isEmpty());
		stack.push("111");
		stack.push("222");
		stack.push("333");
		System.out.println(stack.size() + "//" +stack.isEmpty());
		System.out.println(stack.peek());
		System.out.println(stack.size() + "//" +stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		System.out.println(stack.size() + "//" +stack.isEmpty());
		System.out.println(stack.pop());
		
	}
}
