import java.util.ArrayList;
import java.util.Scanner;

public class AikidoTracker {
        private static final double graduationHours = 100;
        private ArrayList<AikidoSession> sessions = new ArrayList<>();
        private Scanner scanner = new Scanner(System.in);

        public void addSession(String date, double duration) {
            sessions.add(new AikidoSession(date, duration));

        }

        public double viewTotalTime() {
            return sessions.stream().mapToDouble(s -> s.duration).sum();
        }

        public void checkGraduationEligibility() {
            double totalHours = sessions.stream().mapToDouble(s -> s.duration).sum();
            if (totalHours >= graduationHours) {
                System.out.println("Congratulations! You are eligible for graduation");
            } else {
                System.out.println("You need " + (graduationHours-totalHours) + " more hours to be eligible for graduation");
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
