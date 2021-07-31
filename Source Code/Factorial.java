/*
Να δημιουργήσετε αναδρομική (recursive) μέθοδο long factor (long n) που δέχεται ως
παράμετρο έναν μη αρνητικό ακέραιο n και επιστρέφει το n παραγοντικό.

Χρησιμοποιήστε την μέθοδο long factor (long n) σε ένα πρόγραμμα κοσόλας
Factorial.java που δέχεται ως παραμέτρους (command line arguments) ένα πλήθος από μη
αρνητικούς ακέραιους και εκτυπώνει τα αντίστοιχα παραγοντικά στην κονσόλα και στο αρχείο
χαρακτήρων results.txt. Το πρόγραμμα θα περιλαμβάνει ρουτίνες για τον έλεγχο σφαλμάτων (π.χ.,
εγκυρότητα δεδομένων εισόδου, εγγραφή αποτελεσμάτων, κλπ.)

Ενδεικτικά δεδομένα:
$ Java Factorial 1 3 0 9 44 7…
Results:
1!: 1
3!: 6
*/

import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Factorial {


    public static void main(String[] args) throws IOException {
        long num[] = new long[args.length];
        FileWriter writer = new FileWriter("results.txt");
        BufferedWriter buffer = new BufferedWriter(writer);
        //Εκτύπωση του παραγοντικού
        for (int i = 0; i < args.length; i++) {

            num[i] = Long.parseLong(args[i]);

            if (num[i] > 0)
            {
                System.out.println(num[i] + "! = " + factor(num[i]));
                buffer.write(num[i] + "! = " + factor(num[i]));
            }
            else if (num[i] == 0)
            {
                System.out.println(num[i] + "! = " + 1);
                buffer.write(num[i] + "! = " + 1);
            }
            else
            {
                System.out.println(num[i]+ " is negative and has no factorial");
                buffer.write(num[i]+ " is negative and has no factorial");
                return;
            }
        }
        buffer.close();
    }


    public static long factor(long n) {
        if (n >= 1)
            return n * factor(n - 1);
        else
            return 1;
    }

}

