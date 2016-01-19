package com.golubov.trash;

/**
 * Created by SGolubov on 9/30/2015.
 */
public final class Position {

    private int accountId, positionId;
    private double lmv, smv;
    private AssetType assetType;

    public Position(int accountId, int positionId, double lmv, double smv, AssetType assetType) {
        this.accountId = accountId;
        this.positionId = positionId;
        this.lmv = lmv;
        this.smv = smv;
        this.assetType = assetType;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getPositionId() {
        return positionId;
    }

    public double getLmv() {
        return lmv;
    }

    public double getSmv() {
        return smv;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public enum AssetType {
        EQUITY, CORPORATE_BOND, GOVERNMENT_BOND;
    }
}
