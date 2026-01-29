class Solution {
    public String intToRoman(int num) {
        HashMap<Integer,String> dataBase = new HashMap<>();
        dataBase.put(1000,"M");
        dataBase.put(900,"CM");
        dataBase.put(500,"D");
        dataBase.put(400,"CD");
        dataBase.put(100,"C");
        dataBase.put(90,"XC");
        dataBase.put(50,"L");
        dataBase.put(40,"XL");
        dataBase.put(10,"X");
        dataBase.put(9,"IX");
        dataBase.put(5,"V");
        dataBase.put(4,"IV");
        dataBase.put(1,"I");
        int [] values = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<values.length;i++){
            if(num==0){
                break;
            }
            while(num>=values[i]){
                sb.append(dataBase.get(values[i]));
                num=num-values[i];
            }
        }
        return sb.toString();
    }
}