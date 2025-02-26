public class AikidoSession {
    String date;
    double duration;

    public AikidoSession(String date, double duration) {
        this.date = date;
        this.duration = duration;
    }

    public double totalDuration(double duration) {
        return duration + this.duration;
    }
}
