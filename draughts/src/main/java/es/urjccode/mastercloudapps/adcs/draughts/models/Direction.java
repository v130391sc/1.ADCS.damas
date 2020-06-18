package es.urjccode.mastercloudapps.adcs.draughts.models;

enum Direction {
    NE(1, 1),
    SE(-1, 1),
    SW(-1, -1),
    NW(1, -1);

    private int horizontalShift;
    private int verticalShift;

    Direction(int horizontalShift, int verticalShift) {
        this.horizontalShift = horizontalShift;
        this.verticalShift = verticalShift;
    }

    public boolean isOnDirection(Coordinate coordinate) {
        if (Math.abs(coordinate.getRow()) != Math.abs(coordinate.getColumn()))
            return false;
        if (coordinate.getRow()==0)
            return false;
        if (horizontalShift * coordinate.getRow() < 0)
            return false;
        return verticalShift * coordinate.getColumn() >= 0;
    }

    Coordinate getDistanceCoordinate(int distance) {
        int row = this.horizontalShift * distance;
        int column = this.verticalShift * distance;
        return new Coordinate(row, column);
    }

}
