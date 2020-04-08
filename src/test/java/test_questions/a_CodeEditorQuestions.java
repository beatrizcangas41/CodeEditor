package test_questions;
// Questions 1 - 6

import static util.QuestionType.*;

public class a_CodeEditorQuestions {

    static void Question1() {// TRUE
        System.out.println("\n\n1. The following is an appropriate way to print a statement\n\n" +
                "cout << " + "\"I love C++\";");
        char ans = TrueFalseAns();
        if(ans == 'T' || ans == 't'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question2() {// TRUE
        System.out.println("2. Super classes are also called Parent classes/Base classes.\n\n");
        char ans = TrueFalseAns();
        if(ans == 'T' || ans == 't'){
            System.out.println("\nCorrect great job!\n\n"); 
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question3() {// FALSE
        System.out.println("3. The '#' is used for comments in c++");
        char ans = TrueFalseAns();
        if(ans == 'T' || ans == 't'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question4() {// FALSE
        System.out.println("4. When a loop is nested in side another loop, a break or continue statement\n" +
                "terminates or restarts the outermost loop of the nested loop structure. ");
        char ans = TrueFalseAns();
        if(ans == 'T' || ans == 't'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question5() {// b. Operator precedence
        System.out.println("5. Which of the following determines the operator that is processed prior to another\n" +
                "operator? \n\n" + "a. Operator associativity \n" + "b. Operator precedence \n" + "c. Whether the operator is an arithmetic operator\n" +
                "d. None of these determine the order in which operators are processed\n\n");
        char ans = MulChoiceAns();
        if(ans == 'C' || ans == 'c'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question6() {// d. none of the above
        System.out.println("6. A switch statement must have\n\n" +
                "a. a default case \n" + "b. more than one non-default case\n" + "c. a break statement \n" + "d. none of the above\n\n");
        char ans = MulChoiceAns();
        if(ans == 'D' || ans == 'd'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    public static void main(String[] args) {
        Question1();
        Question2();
        Question3();
        Question4();
        Question5();
        Question6();
    }
}

