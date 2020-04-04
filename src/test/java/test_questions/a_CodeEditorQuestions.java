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
        System.out.println("2. The following is an appropriate way to declare a variable as an int.\n\n" +
                "int main()\n" + "{\n" + "int a;\n" + "return 0;\n" + "}\n\n" + "a. True\n" + "b. False\n\n");
        char ans = TrueFalseAns();
        if(ans == 'T' || ans == 't'){
            System.out.println("\nCorrect great job!\n\n"); 
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question3() {// TRUE
        System.out.println("3. The following is an appropriate way to declare and initialize a variable as an " +
                "integer.\n\n" + "int main()\n" + "{\n" + "int a = 5;\n" + "return 0;\n" + "}\n\n" + "a. True\n" +
                "b. False\n\n");
        char ans = TrueFalseAns();
        if(ans == 'T' || ans == 't'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question4() {// TRUE
        System.out.println("4. The two following codes are equivalent.\n\n" + "\tdouble a, b, c;\n\n" +
                "and\n\n" + "\tdouble a;\n" + "\tdouble b;\n" + "\tdouble c;\n\n" + "a. True\n" +
                "b. False\n\n");
        char ans = TrueFalseAns();
        if(ans == 'T' || ans == 't'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question5() {// c. STRING
        System.out.println("5. Which of the following is the appropriate variable type to use with the word " +
                "“float”?\n\n" + "a. word\n" + "b. char\n" + "c. string\n" + "d. float\n\n");
        char ans = MulChoiceAns();
        if(ans == 'C' || ans == 'c'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question6() {//12. d. ;
        System.out.println("6. What is the correct statement ending character in c++?\n\n" +
                "a. :\n" + "b. #\n" + "c. /\n" + "d. ;\n\n");
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

