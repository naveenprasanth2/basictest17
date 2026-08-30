package com.symphony.practise;

public class CountVowels1 {
    static void main() {
        String name = "ee";
        int count = 0;
        for(int i = 0; i < name.length(); i++){
            count += findVowel(name.charAt(i));
        }
        System.out.println(count);
    }

    private static int findVowel(char c) {
        char[] vowels = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
        int start = 0, end = vowels.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (vowels[mid] == c) {
                return 1;
            }else if (vowels[mid] < c) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return 0;
    }
}
