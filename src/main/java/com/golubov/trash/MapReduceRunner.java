package com.golubov.trash;

import java.util.Arrays;
import java.util.List;

/**
 * Created by SGolubov on 9/30/2015.
 */
public class MapReduceRunner {

    private static final Double NAV = 375.0;

    public static void main(String[] args) {
        List<Position> positions = getPositions();
        long start = System.currentTimeMillis();
        double[] firstCase = positions.parallelStream().filter(p -> p.getAssetType().equals(Position.AssetType.EQUITY))
                .mapToDouble(p -> ((p.getSmv() + p.getLmv()) / 2) / NAV).filter(p -> p > 0.1).toArray();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(Arrays.toString(firstCase));
        start = System.currentTimeMillis();
        double[] secondCase = positions.parallelStream().filter(p -> p.getAssetType().equals(Position.AssetType.CORPORATE_BOND) || p.getAssetType().equals(Position.AssetType.GOVERNMENT_BOND))
                .mapToDouble(p -> p.getLmv() / NAV).filter(p -> p >= 0.15 && p <= 0.25).toArray();
        end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(Arrays.toString(secondCase));
    }

    private static List<Position> getPositions() {
        return Arrays.asList(new Position(1, 1, 10d, 20d, Position.AssetType.EQUITY),
                new Position(1, 2, 15d, 25d, Position.AssetType.EQUITY),
                new Position(1, 1, 25d, 30d, Position.AssetType.CORPORATE_BOND),
                new Position(1, 1, 15d, 20d, Position.AssetType.GOVERNMENT_BOND),
                new Position(1, 1, 60d, 60d, Position.AssetType.EQUITY),
                new Position(1, 1, 60d, 60d, Position.AssetType.EQUITY),
                new Position(1, 1, 60d, 50d, Position.AssetType.GOVERNMENT_BOND),
                new Position(1, 1, 35d, 40d, Position.AssetType.EQUITY)
        );

    }

}
