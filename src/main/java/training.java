class Calculator {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int add (int a, int b) {
        return a + b  ;
    }


    public  int substract (int a, int b){
        return  b - a;
    }

    public  int multiply (int a, int b){
        return  b * a;
    }

    public  int divide (int a, int b){
        return  a / b;
    }

}





