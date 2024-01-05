// WaterConservationSystem interface
interface WaterConservationSystem {
    int calculateTrappedWater(int[] blockHeights);
}

// Abstract class implementing WaterConservationSystem interface
abstract class RainySeasonConservation implements WaterConservationSystem {
}

// Concrete class extending RainySeasonConservation
class CityBlockConservation extends RainySeasonConservation {
    @Override
    public int calculateTrappedWater(int[] blockHeights) {
        int n = blockHeights.length;
        if (n <= 2) {
            return 0; // Not enough blocks to trap water
        }

        int[] leftMaxHeight = new int[n];
        int[] rightMaxHeight = new int[n];

        // Calculate the maximum height to the left of each block
        leftMaxHeight[0] = blockHeights[0];
        for (int i = 1; i < n; i++) {
            leftMaxHeight[i] = Math.max(leftMaxHeight[i - 1], blockHeights[i]);
        }

        // Calculate the maximum height to the right of each block
        rightMaxHeight[n - 1] = blockHeights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMaxHeight[i] = Math.max(rightMaxHeight[i + 1], blockHeights[i]);
        }

        // Calculate the trapped water for each block
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(leftMaxHeight[i], rightMaxHeight[i]);
            trappedWater += Math.max(0, minHeight - blockHeights[i]);
        }

        return trappedWater;
    }
}
public class Main2 {
    public static void main(String[] args) {
        WaterConservationSystem conservationSystem = new CityBlockConservation();
        int[] blockHeights = {4,0,1,0,2};
        int trappedWater = conservationSystem.calculateTrappedWater(blockHeights);
        System.out.println("Total trapped water: " + trappedWater + " units");
    }
}
