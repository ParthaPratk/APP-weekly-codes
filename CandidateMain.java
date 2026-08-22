import java.util.Scanner;

class Candidate {
    int Candidate_Id;
    String name;
    int aptitude;
    int technical;
    int communication;

    Candidate(int Candidate_Id, String name, int aptitude,
              int technical, int communication) {

        this.Candidate_Id = Candidate_Id;
        this.name = name;
        this.aptitude = aptitude;
        this.technical = technical;
        this.communication = communication;
    }

    int getTotalScore() {
        return aptitude + technical + communication;
    }
}

public class CandidateMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = sc.nextInt();

        System.out.print("Enter K: ");
        int k = sc.nextInt();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details of Candidate " + (i + 1));

            System.out.print("Candidate ID: ");
            int id = sc.nextInt();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Aptitude: ");
            int aptitude = sc.nextInt();

            System.out.print("Technical: ");
            int technical = sc.nextInt();

            System.out.print("Communication: ");
            int communication = sc.nextInt();

            candidates[i] = new Candidate(
                id, name, aptitude, technical, communication
            );
        }

        // Sort candidates
        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {

                int score1 = candidates[i].getTotalScore();
                int score2 = candidates[j].getTotalScore();

                // Higher score first
                // If score is same, smaller ID first
                if (score1 < score2 ||
                   (score1 == score2 &&
                    candidates[i].Candidate_Id > candidates[j].Candidate_Id)) {

                    Candidate temp = candidates[i];
                    candidates[i] = candidates[j];
                    candidates[j] = temp;
                }
            }
        }

        System.out.println("\n--- Top " + k + " Candidates ---");

        for (int i = 0; i < k; i++) {
            System.out.println(
                candidates[i].Candidate_Id + " " +
                candidates[i].name + " " +
                candidates[i].getTotalScore()
            );
        }

        sc.close();
    }
}