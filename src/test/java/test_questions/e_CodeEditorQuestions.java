package test_questions;
// Questions 27 - 32

import java.util.Scanner;

class e_CodeEditorQuestions {

    public static char TrueFalseAns() {
        char tfans = 'T';
        do{
            if(tfans != 'T' && tfans != 't' && tfans != 'F' && tfans != 'f'){
                System.out.println("You have entered an invalid character.  Please try again!");
            }
            Scanner tfObj = new Scanner(System.in);
            System.out.println("Enter T for True and F for False:");
            tfans = tfObj.next().charAt(0);
        }while(tfans != 'T' && tfans != 't' && tfans != 'F' && tfans != 'f');
        return tfans;
    }

    public static char MulChoiceAns(){
        char mcans = 'A';
        do{
            if(mcans != 'a' && mcans != 'A' && mcans != 'b' && mcans != 'B' &&
                    mcans != 'c' && mcans != 'C' && mcans != 'd' && mcans != 'D'){
                System.out.println("You have entered an invalid character.  Please try again!");
            }
            Scanner mcObj = new Scanner(System.in);
            System.out.println("Enter (a), (b), (c), or (d):");
            mcans = mcObj.next().charAt(0);
        }while(mcans != 'a' && mcans != 'A' && mcans != 'b' && mcans != 'B' &&
                mcans != 'c' && mcans != 'C' && mcans != 'd' && mcans != 'D');
        return mcans;
    }

    static void Question27() {//27. TRUE
        System.out.println("\n\n27. The preprocessor directive that allows for standard input and output is:\n\n" +
                "#include <iostream>\n\n" + "a. True\n" + "b. False\n\n");
        char ans = TrueFalseAns();
        if(ans == 'T' || ans == 't'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question28() {//28. C
        System.out.println("28. Which of the following is the insertion operator?\n\n" +
                "a. >>\n" + "b. ==\n" + "c. <<\n" + "d. \\\n\n");
        char ans = MulChoiceAns();
        if(ans == 'C' || ans == 'c'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question29() {//29. A
        System.out.println("29. Which of the following is the extraction operator?\n\n" + 
                "a. >>\n" + "b. ==\n" + "c. <<\n" + "d. \\\n\n");
        char ans = MulChoiceAns();
        if(ans == 'A' || ans == 'a'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question30() {//30. TRUE
        System.out.println("30. The extraction operator is used with the standard input “cin”.\n\n" + "a. True\n" +
                "b. False\n\n");
        char ans = TrueFalseAns();
        if(ans == 'T' || ans == 't'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question31() {//31. FALSE
        System.out.println("31. The insertion operator is used with the standard input “cin”.\n\n" + "a. True\n" +
                "b. False\n\n");
        char ans = TrueFalseAns();
        if(ans == 'F' || ans == 'f'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    static void Question32() {//32. TRUE
        System.out.println("32. The following code correctly accepts a user entered value into the string “hobby”" + 
                           " and prints “Your favorite hobby is” followed by the hobby entered by the user:\n\n" +
                           "#include <iostream>\n" + "#include <string>\n" + "using namespace std;\n\n" +
                           "int main ()\n" + "{\n" + "    string hobby ;\n" + "    cout << “Please enter your favorite hobby: ”;\n"
                           + "    cin >> hobby;\n" + "    cout << “Your favorite hobby is ” << hobby;\n" +
                           "    return 0;\n" + "}\n\n" + "a. True\n" + "b. False\n\n");
        char ans = TrueFalseAns();
        if(ans == 'T' || ans == 't'){
            System.out.println("\nCorrect great job!\n\n");
        }else{
            System.out.println("\nSorry that is incorrect\n\n");
        }
    }

    public static void main(String[] args) {
        Question27();
        Question28();
        Question29();
        Question30();
        Question31();
        Question32();
    }
}
