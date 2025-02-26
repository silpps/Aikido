import java.util.ArrayList;
import java.util.Scanner;

public class AikidoTracker {
        private static int numberOfSessions = 0;
        private ArrayList<AikidoSession> sessions = new ArrayList<>();
        private Scanner scanner = new Scanner(System.in);

        public void addSession(String date, double duration) {
            sessions.add(new AikidoSession(date, duration));
            numberOfSessions++;

        }

        public double getTotalTime() {
            return sessions.stream().mapToDouble(s -> s.duration).sum();
        }

        public double viewTotalTime() {
            System.out.println("Total practice time: " + getTotalTime() + " hours");
            return sessions.stream().mapToDouble(s -> s.duration).sum();
        }

        public void checkGraduationEligibility() {
            if (numberOfSessions>=100) {
                System.out.println("Congratulations! You are eligible for graduation");
            } else {
                System.out.println(STR."You need \{100 - numberOfSessions} more sessions to be eligible for graduation");
            }
        }

        public void menu() {
            while (true) {
                System.out.println("===== Aikido Practice Tracker =====");
                System.out.println("1. Add Practice Session");
                System.out.println("2. View Total Practice Time");
                System.out.println("3. Check Graduation Eligibility");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                System.out.println();

                switch (choice) {
                    case 1:
                        System.out.print("Enter the date of the session: ");
                        String date = scanner.next();
                        System.out.print("Enter the duration of the session: ");
                        double duration = scanner.nextDouble();
                        addSession(date, duration);
                        break;
                    case 2:
                        viewTotalTime();
                        break;
                    case 3:
                        checkGraduationEligibility();
                        break;
                    case 4:
                        System.out.println("Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.\n");
                }
            }
        }
}
