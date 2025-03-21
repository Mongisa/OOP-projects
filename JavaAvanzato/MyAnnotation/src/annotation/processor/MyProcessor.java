package annotation.processor;

import annotation.AtMostThree;
import annotation.FieldNumberConstraint;

import java.util.Set;
import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.tools.Diagnostic; /* per produrre messaggi di compilazione */

@SupportedAnnotationTypes({"annotation.AtMostThree","annotation.FieldNumberConstraint"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class MyProcessor extends AbstractProcessor {
    private Messager messager;

    @Override
    public void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        messager = processingEnvironment.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> atMostThreeClasses = roundEnv.getElementsAnnotatedWith(AtMostThree.class);
        for (Element element : atMostThreeClasses) {
            if (element.getKind() == ElementKind.CLASS) {
                checkAtMostThree((TypeElement)element);
            }
        }

        Set<? extends Element> fieldNumberClasses = roundEnv.getElementsAnnotatedWith(FieldNumberConstraint.class);
        for (Element element : fieldNumberClasses) {
            if (element.getKind() == ElementKind.CLASS) {
                checkFieldNumberConstraint((TypeElement) element);
            }
        }

        return false;
    }

    private void checkAtMostThree(TypeElement typeElement){
        int methodCount = typeElement.getEnclosedElements().stream()
            .filter(e -> e.getKind() == ElementKind.METHOD).toList().size();

        if(methodCount > 3) {
            printError(typeElement, "La classe deve contenere al massimo 3 metodi!");
        }
    }
    
    private void checkFieldNumberConstraint(TypeElement typeElement) {
        FieldNumberConstraint annotation = typeElement.getAnnotation(FieldNumberConstraint.class);
        if (annotation == null) {
            printError(typeElement, "Errore: annotazione FieldNumberConstraint non trovata");
            return;
        }

        int expectedFieldCount = annotation.value();

        int fieldCount = typeElement.getEnclosedElements().stream()
            .filter(e -> e.getKind() == ElementKind.FIELD).toList().size();

        if (fieldCount != expectedFieldCount) {
            printError(typeElement, "Il numero di campi è diverso dal valore dell'annotazione!");
        }
}

    private void printError(Element element, String message) {
        messager.printMessage(Diagnostic.Kind.ERROR, message, element);
    }

    private void printWarning(Element element, String message) {
        messager.printMessage(Diagnostic.Kind.WARNING, message, element);
    }
}