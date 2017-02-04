/**
 * Created by Aditya on 4 Feb, 2017.
 */
public class ClassGenerator {
    private static boolean classEnd = true;

    public static void main(String[] args) {
        generateClass("newClass", new String[]{"public"});
        generateMethod("main", "void", new String[]{"public", "static"}, new String[]{"String[]"}, new String[]{"args"});
        endClass();
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
        System.out.println("\t\tSystem.out.println(" + s + ");");
    }

}
