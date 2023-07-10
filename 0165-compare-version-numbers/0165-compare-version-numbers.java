class Solution {
    public int compareVersion(String version1, String version2) {
        String[] strArr1 = version1.split("\\.");
        String[] strArr2 = version2.split("\\.");

        int i = 0;
        int j = 0;
        // System.out.println(strArr1.length + " " + strArr2.length);
        while (i < strArr1.length || j < strArr2.length) {
            int a = 0;
            if (i < strArr1.length)
                a = Integer.parseInt(strArr1[i]);
            int b = 0;
            if (j < strArr2.length)
                b = Integer.parseInt(strArr2[j]);

            // System.out.println(a + " " + b);

            if (a < b)
                return -1;
            else if (a > b)
                return 1;
            i++;
            j++;
        }
        return 0;
    }
}
