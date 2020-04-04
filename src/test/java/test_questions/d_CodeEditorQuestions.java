package test_questions;
// Questions 20 - 26
import static util.QuestionType.*;

class d_CodeEditorQuestions {

    static void Question20() {//20. d.All of the above
        System.out.println("\n\n20. Which of the following are the correct way(s) of incrementing the variable x by 1. " +
                "Assume the variable stores an integer value.\n\n" +
                "a. x+=1;\n" +  "b. ++x;\n" +  "c. x=x+1;\n" + "d. All of the above" );
        char ans = MulChoiceAns();
        if(ans == 'D' || ans == 'd'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question21() {//21. b. False
        System.out.println("21. The operators ‘=’ and ‘==’ have the same meaning in c++.\n\n" + "a. True\n" + "b. False\n\n");
        char ans = TrueFalseAns();
        if(ans == 'B' || ans == 'b'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question22() {//22. d. Relational
        System.out.println("22. ‘!=’ is an example of what type of operator? \n\n" +
                "a. Arithmetic\n" + "a. Assignment\n" + "a. Compound Assignment\n" +
                "d. Relational\n\n");
        char ans = MulChoiceAns();
        if(ans == 'D' || ans == 'd'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question23() {//23. b. False
        System.out.println("‘||’ corresponds to the boolean (logical) operator AND, which yields true if both its operands are true.\n\n" +
                "a. True\n" +
                "b. False\n\n");
        char ans = TrueFalseAns();
        if(ans == 'B' || ans == 'b'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question24() {//24. a. True
        System.out.println("24. ‘&&’ corresponds to the boolean (logical) operator AND, which yields true if both its operands are true." +
                "a. True\n" + "b. False\n\n");
        char ans = TrueFalseAns();
        if(ans == 'A' || ans == 'a'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question25() {//25. a. True
        System.out.println("25.‘||’ corresponds to the boolean (logical) operator OR, which yields true if either of its operands are true.\n\n" +
                "a. True\n" + "b. False\n\n");
        char ans = TrueFalseAns();
        if(ans == 'A' || ans == 'a'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question26() {//26. b. False
        System.out.println("26. The preprocessor directive that allows for standard input and output is.\n\n" +
                "a. True\n" + "b. False\n\n");
        char ans = TrueFalseAns();
        if(ans == 'B' || ans == 'b'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    public static void main(String[] args) {
        Question20();
        Question21();
        Question22();
        Question23();
        Question24();
        Question25();
        Question26();
    }
}