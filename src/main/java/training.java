class Calculator {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Integer add (Integer a, Integer b) {
        return a + b  ;
    }


    public  Integer substract (Integer a, Integer b){
        return  b - a;
    }

    public  Integer multiply (Integer a, Integer b){
        return  b * a;
    }

    public  Integer divide (Integer a, Integer b){
        return  a / b;
    }

}





