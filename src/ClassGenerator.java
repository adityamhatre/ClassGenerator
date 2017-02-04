import java.util.ArrayList;

/**
 * Created by Aditya on 4 Feb, 2017.
 */
public class ClassGenerator {
    private static boolean classEnd = true;

    private static String accessModifiers[] = {"public", "private", "protected", ""};
    private static boolean isMethodStatic = false;
    private static String returnTypes[] = {"void", "int", "String"};
    private static String argumentTypes[] = {"int", "String"};
    private static ArrayList<Integer> methodNames = new ArrayList<>();


    public static void main(String[] args) {
        generateClass("newClass", new String[]{"public"});
        //generateMethod("main", "void", new String[]{"public", "static"}, new String[]{"String[]"}, new String[]{"args"});
        generateRandomMethodWithRandomArguments(5);
        endClass();
    }

    private static void generateRandomMethodWithRandomArguments(int loc) {
        String accessModifier = accessModifiers[(int) (Math.random() * accessModifiers.length)];
        String returnType = returnTypes[(int) (Math.random() * returnTypes.length)];
        String argumentType = argumentTypes[(int) (Math.random() * argumentTypes.length)];
        int methodIndex = (int) (Math.random() * loc);
        methodNames.add(methodIndex);
        isMethodStatic = methodIndex % 2 == 0;
        String staticOrNot = isMethodStatic ? "static" : "";

        System.out.println("\t" + accessModifier + " " + staticOrNot + " " + returnType + " method" + methodIndex + "(" + argumentType + " " + argumentType + "1) {");
        //if(returnType.equalsIgnoreCase("void"))
        System.out.println("\t\t" + returnType + " " + returnType + "2;");
        for (int i = 0; i < loc; i++) {
            printlnStatement("Hello world " + i);
        }
        System.out.println("\t\treturn " + returnType + "2;");
        System.out.println("\t}");
    }

    private static void endClass() {
        System.out.println("}");
    }


    private static void generateClass(String className, String[] modifiers) {
        classEnd = false;
        for (String modifier : modifiers) {
            System.out.print(modifier + " ");
        }
        System.out.println("class " + className + " {");
    }

    private static void generateMethod(String methodName, String returnType, String[] modifiers, String[] argumentTypes, String[] argumentNames) {
        if (!classEnd) {
            for (int i = 0; i < modifiers.length; i++) {
                if (i == 0)
                    System.out.print("\t" + modifiers[i] + " ");
                else
                    System.out.print(modifiers[i] + " ");
            }
            System.out.print(returnType + " " + methodName + "(");
            for (int i = 0; i < argumentTypes.length; i++) {
                if (i == argumentTypes.length - 1)
                    System.out.println(argumentTypes[i] + " " + argumentNames[i] + ") {");
                else
                    System.out.print(argumentTypes[i] + " " + argumentNames[i] + ", ");
            }
            printlnStatement("Hello World");
            System.out.println("\t}");
        }
    }

    private static void printlnStatement(String s) {
        System.out.println("\t\tSystem.out.println(\"" + s + "\");");
    }


}
