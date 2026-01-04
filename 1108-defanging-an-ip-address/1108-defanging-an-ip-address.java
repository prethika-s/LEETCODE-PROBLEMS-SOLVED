class Solution {
    public String defangIPaddr(String address) {
        String[] defang = address.split("\\.");
        String defanged = "";
        for(int i=0; i<defang.length-1; i++){
            defanged+=defang[i]+"[.]";
        }
        defanged=defanged+defang[defang.length-1];
        return defanged;
    }
}