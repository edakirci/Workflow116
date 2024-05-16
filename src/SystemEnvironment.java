import java.util.ArrayList;
import java.util.List;

public class SystemEnvironment {
    private static List<Station> stations = new ArrayList<>();

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static Station findSuitableStation(Task task) {
        for (Station station : stations) {
            if (station.canExecuteTask(task)) {
                return station;
            }
        }
        return null;
    }
}
