public class f_FirstBadVersion {
    private int firstBadVersion;

    public f_FirstBadVersion(int firstBadVersion){
        this.firstBadVersion = firstBadVersion;
    }
    public boolean isBadVersion(int version){
        return version >= firstBadVersion;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while(left<right){
            int mid = left + (right-left)/2;
            if(isBadVersion(mid)){
                right=mid;
            }else{
                left=mid+1;
            }

        }
        return left==right ? left:-1;
    }

    public static void main(String[] args) {
        f_FirstBadVersion firstBadVersion = new f_FirstBadVersion(4);
        System.out.println("First Bad Version: " + firstBadVersion.firstBadVersion(10)); // Output: 4
    }
}
