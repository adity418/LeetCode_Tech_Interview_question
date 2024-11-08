// 43. Multiply String

public class Solution43 {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0"))
            return "0";
        int num[]=new int [num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--)
        {
            for(int j=num2.length()-1;j>=0;j--)
            {
                num[i+j+1]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                num[i+j]+=num[i+j+1]/10;
                num[i+j+1]%=10;
            }
        }
        int i=0;
        while(num.length>i&&num[i]==0)
            i++;
        String s="";
        
        while(i!=num.length)
        {
            s+=num[i];
            i++;
        }
        return s;
    }
}
