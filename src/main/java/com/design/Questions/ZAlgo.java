package com.design.Questions;

public class ZAlgo {
    public static int[] calculateZarray(char[] input){
        int len = input.length;
        int[] z = new int[len];
        int left = 0;
        int right = 0;
        for(int i=1;i<len;i++){
            if(i>right){
                left = right = i;
                while (right<len && input[right] == input[right-left])
                    right++;
                z[i] = right-left;
                right--;
            }else{
                int j = i-left;
                if(z[j] < right-i + 1)
                    z[i] = z[j];
                else{
                    while (right<len && input[right] == input[right-left])
                        right++;
                    z[i] = right-left;
                    right--;
                }
            }
        }
        return z;
    }
    public static int[] calculateZ(char[] str){
        int z[] = new int[str.length];
        int left = 0;
        int right =0;
        for(int k = 1;k<str.length;k++){
            if(k>right) {
                left = right = k;
                while(right<str.length && str[right] == str[right-left])
                    right++;
                z[k] = right-left;
                right--;
            }else{
                int k1 = k-left;
                if(z[k1] < right-k+1){
                    z[k] = z[k1];
                }else{
                    left = k;
                    while(right< str.length && str[right] == str[right-left]){
                        right++;
                    }
                    z[k] = right-left;
                    right--;
                }
            }
        }
        return z;
    }
    public static  int[] getLarray(String str){
        int len = str.length();
        int[] ans = new int[len];
        int start = 0;
        int i=1;
        while(i<len){
            if(str.charAt(i)==str.charAt(start)){
                start++;
                ans[i] = start;
                i++;
            }else{
                if(start != 0)
                    start = ans[start-1];
                else{
                    ans[i] = start;
                    i++;
                }
            }
        }
        return  ans;
    }
    public static boolean kmp(String str,String pat){
        int[] larray = getLarray(pat);
        int len = str.length();
        int start = 0;
        int i=1;
        while(i<len){
            if(str.charAt(i) == pat.charAt(start)){
                start++;
                if(start == pat.length())
                    return true;
                i++;
            }else{
                if(start != 0)
                    start = larray[start-1];
                else{
                    i++;
                }
            }
        }
        return false;
    }
    public static boolean solve(String str,String pat){
        int[] ans = calculateZ((pat + "$" + str).toCharArray());
        int[] ans1 = calculateZarray((pat + "$" + str).toCharArray());
        for(int i=0;i<ans.length;i++)
            System.out.println(ans[i] + " ----> "+ans1[i]);
        return true;
    }
    public static void main(String[] args) {
        String test = "abcaaabc";
        System.out.println(kmp("abcdnirmalrotuniharritu","nirmal"));
    }
}
