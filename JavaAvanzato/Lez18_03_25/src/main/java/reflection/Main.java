package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class Main {
    public static void main(String[] args) {
        inspectClass(Studente.class);
    }

    static void inspectClass(Class<?> c) {
        System.out.println("Classe: " + c.getCanonicalName());

        System.out.println("***Costruttori***");

        Constructor<?>[] cc = c.getConstructors();

        for(Constructor<?> ccc : cc) {
            StringBuilder signature = new StringBuilder();

            //Identificatore int che convertiamo in stringa
            signature.append(Modifier.toString(ccc.getModifiers())).append(" ");

            signature.append(ccc.getName()).append("(");

            Parameter[] p = ccc.getParameters();

            for(Parameter pc : p) {
                signature.append(pc.getType().getSimpleName()).append(" ");
                signature.append(pc.getName()).append(", ");
            }

            signature.setCharAt(signature.length()-2,')');

            System.out.println(signature);
        }

        System.out.println("***metodi***");

        Method m[] = c.getDeclaredMethods();

        for(Method mc : m) {
            StringBuilder s = new StringBuilder();

            s.append(Modifier.toString(mc.getModifiers())).append(" ");
            s.append(mc.getReturnType().getSimpleName()).append(" ");
            s.append(mc.getName()).append("( ");

            Parameter[] p = mc.getParameters();

            for(Parameter pc : p) {
                s.append(pc.getType().getSimpleName()).append(" ");
                s.append(pc.getName()).append(",");
            }

            s.setCharAt(s.length()-1,')');
            s.insert(s.length()-1,' ');
            System.out.println(s);

            //ANNOTAZIONI
            DaImplementare di = null;

            if((di = mc.getAnnotation(DaImplementare.class))!=null) {
                System.out.println("---> DA IMPLEMENTARE " + di.assegnatoA() + " " + di.dataTermine()A);
            }
        }
    }
}
