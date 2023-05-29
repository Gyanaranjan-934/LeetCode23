class ParkingSystem {
    int bigSpace ;
    int mediumSpace;
    int smallSpace;
    public ParkingSystem(int big, int medium, int small) {
        this.bigSpace = big;
        this.mediumSpace = medium;
        this.smallSpace = small;
    }
    
    public boolean addCar(int carType) {
        if(carType==1){
            if(bigSpace>0){
                bigSpace--;
                return true;
            }else return false;
        }else if(carType==2){
            if(mediumSpace>0){
                mediumSpace--;
                return true;
            }else return false;
        }else{
            if(smallSpace>0){
                smallSpace--;
                return true;
            }else return false;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */