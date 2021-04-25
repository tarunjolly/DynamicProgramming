import java.util.*;

public class l001{
     public static void print1D(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void print2D(int[][] arr) {
        for (int[] ar : arr) {
            print1D(ar);
        }
    }

    public static int fibo_01(int n){
        if(n<=1) return 1;

        int ans= fibo_01(n-1)+fibo_01(n-2);
        return ans;
    }

    //always use default value that one which cannot be a part of the ans
    public static int fibo_01_memo(int n,int[] dp){
        if(n<=1) return dp[n]=n;

        if(dp[n]!=-1)return dp[n];

        int ans= fibo_01(n-1)+fibo_01(n-2);
        return dp[n]=ans;
    }
    public static int fibo_01_dp(int N,int[] dp){

        for(int n=0;n<=N;n++){
        if(n<=1){
         dp[n]=n;
         continue;
        }

        int ans=dp[n-1]+dp[n-2]; // fibo_01(n-1)+fibo_01(n-2);
         dp[n]=ans;
        }
        return dp[N];
    }

    public static int fibo_01_twoPointer(int N){
        int a=0,b=1;
        for(int n=0;n<=N;n++){
        int sum=a+b;
        a=b;
        b=sum;
        }
        return a;
    }
      public static void fibo() {
        int n = 8;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(fibo_01_memo(n, dp));
        System.out.println(fibo_01_dp(n, dp));
        System.out.println(fibo_01_twoPointer(n));

        print1D(dp);
    }

    public static int mazePath(int sr,int sc,int er,int ec){
        if(sr==er && sc==ec){
            return 1;
        }
        int count=0;
        if(sr+1<=er){
            count+=mazePath(sr+1,sc,er,ec);
        }
        if(sc+1<=ec){
            count+=mazePath(sr,sc+1,er,ec);
        }
        if(sr+1<=er && sc+1<=ec){
            count+=mazePath(sr+1,sc+1,er,ec);
        }
        return count;
    }

    public static int mazePath_memo(int sr,int sc,int er,int ec,int dp[][]){
        if(sr==er && sc==ec){
            return dp[sr][sc]=1;
        }
        if(dp[sr][sc]!=0)return dp[sr][sc];
        
        int count=0;

        if(sr+1<=er){
            count+=mazePath_memo(sr+1,sc,er,ec,dp);
        }
        if(sc+1<=ec){
            count+=mazePath_memo(sr,sc+1,er,ec,dp);
        }
        if(sr+1<=er && sc+1<=ec){
            count+=mazePath_memo(sr+1,sc+1,er,ec,dp);
        }
        return dp[sr][sc]=count;

    }

    public static int mazePath_DP(int SR,int SC,int er,int ec,int dp[][]){
       
       for(int sr=er;sr>=0;sr--){
           for(int sc=ec;sc>=0;sc--){
               if(sr==er && sc==ec){
                dp[sr][sc]=1;
                continue;
            }
        
        
        int count=0;

        if(sr+1<=er){
            count+=dp[sr+1][sc];// mazePath_memo(sr+1,sc,er,ec,dp);
        }
        if(sc+1<=ec){
            count+=dp[sr][sc+1]; //mazePath_memo(sr,sc+1,er,ec,dp);
        }
        if(sr+1<=er && sc+1<=ec){
            count+=dp[sr+1][sc+1]; //mazePath_memo(sr+1,sc+1,er,ec,dp);
        }
         dp[sr][sc]=count;

           }
       }

       return dp[SR][SC];

       
        
    }

    public static int mazePathInfi(int sr,int sc,int er,int ec){
        if(sr==er && sc==ec){
            return 1;
        }
        int count=0;

        for(int jump=1;sr+jump<=er;jump++){
            count+=mazePath(sr+1,sc,er,ec);
        }
        for(int jump=1;sc+jump<=ec;jump++){
            count+=mazePath(sr,sc+1,er,ec);
        }

        for(int jump=1;sc+jump<=ec && sr+jump<=er;jump++ ){
            count+=mazePath(sr+1,sc+1,er,ec);
        }
        return count;
    }

    public static int mazePathInfi_memo(int sr,int sc,int er,int ec,int dp[][]){
        if(sr==er && sc==ec){
            return dp[sr][sc]=1;
        }

        if(dp[sr][sc]!=0)return dp[sr][sc];

        int count=0;

        for(int jump=1;sr+jump<=er;jump++){
            count+=mazePath(sr+1,sc,er,ec);
        }
        for(int jump=1;sc+jump<=ec;jump++){
            count+=mazePath(sr,sc+1,er,ec);
        }

        for(int jump=1;sc+jump<=ec && sr+jump<=er;jump++ ){
            count+=mazePath(sr+1,sc+1,er,ec);
        }
        return dp[sr][sc]=count;
    }

    public static int mazePathInfi_DP(int SR,int SC,int er,int ec,int dp[][]){
        
        for(int sr=er;er>=0;sr--){
            for(int sc=ec;ec>=0;sc--){
                if(sr==er && sc==ec){
                 dp[sr][sc]=1;
                 continue;
             }



        int count=0;

        for(int jump=1;sr+jump<=er;jump++){
            count+=dp[sr+jump][sc];//mazePath(sr+1,sc,er,ec);
        }
        for(int jump=1;sc+jump<=ec;jump++){
            count+=dp[sr][sc+jump];//mazePath(sr,sc+1,er,ec);
        }

        for(int jump=1;sc+jump<=ec && sr+jump<=er;jump++ ){
            count+=dp[sr+jump][sc+jump];//mazePath(sr+1,sc+1,er,ec);
        }
         dp[sr][sc]=count;


            }
        }

        return dp[SR][SC];
        
        
    }

    public static int board_dice(int sp,int ep){
        if(sp==ep){
            return 1;
        }
        int count=0;
        for(int dice=1;dice<=6;dice++){
            
            if(sp+dice<=ep)
           count+=board_dice(sp+dice,ep);
        }
        return count;

    }


    public static int board_dice_memo(int sp,int ep,int dp[]){
        if(sp==ep){
            return dp[sp]=1;
        }
        if(dp[sp]!=0)return dp[sp];
        int count=0;
        for(int dice=1;dice<=6;dice++){
            
            if(sp+dice<=ep)
           count+=board_dice(sp+dice,ep);
        }
        return dp[sp]=count;

    }

    public static int board_dice_DP(int sp,int ep,int dp[]){
        
        for(int i=ep;i>=0;i--){
        
            if(sp==ep){
                 dp[sp]=1;
                 continue;
            }
        
        int count=0;
        for(int dice=1;dice<=6;dice++){
            
            if(sp+dice<=ep)
           count+=board_dice(sp+dice,ep);
        }
        dp[sp]=count;

            
        }

        return dp[0];


    }

    public static int boardPath_opti(int sp, int ep) {
        LinkedList<Integer> list = new LinkedList<>();

        for (sp = ep; sp >= 0; sp--) {
            if (sp >= ep - 1)
                list.addFirst(1);
            else {
                if (list.size() <= 6)
                    list.addFirst(list.getFirst() * 2);
                else
                    list.addFirst(list.getFirst() * 2 - list.removeLast());
            }
        }

        return list.getFirst();

    }

    //leetcode 70
    public int climbStairs(int n) {
        if(n==0)return 1;
        
        int count=0;
        if(n-1>=0)
            count+=climbStairs(n-1);
        
        if(n-2>=0)
            count+=climbStairs(n-2);
        
        return count;
        
    }
    public int climbStairs_memo(int n,int []dp){
        if(n==0)return dp[n]=1;
        
        if(dp[n]!=0)return dp[n];
        
        int count=0;
        if(n-1>=0)
            count+=climbStairs(n-1);
        
        if(n-2>=0)
            count+=climbStairs(n-2);
        
        return dp[n]=count;

    }
    public int climbStairs_dp(int n,int []dp){
        
        for(int i=n;i>=0;i--){
            if(i==n){ dp[i]=1;continue;}
        
        
        
        int count=0;
        if(i+1<=n)
            count+=dp[i+1];//climbStairs(n-1);
        
        if(i+2<=n)
            count+=dp[i+2];//climbStairs(n-2);
        
         dp[i]=count;
    
        }
        
        return dp[0];
    }


    public int climbStairs_(int n) {
        int dp[]=new int[n+1];
           return climbStairs_dp(n,dp);
    }
    

    public int minCostClimbingStairs_Rec(int n,int[] cost){
        if(n<=1){
            return cost[n];
        }
        int minCost1=0,minCost2=0;
        
        minCost1=minCostClimbingStairs_Rec(n-1,cost);
        minCost2=minCostClimbingStairs_Rec(n-2,cost);
        
        int myans= Math.min(minCost1,minCost2);
        return myans+(n==cost.length?0:cost[n]);
        
        
    }
    public int minCostClimbingStairs_memo(int n,int[] cost,int dp[]){
        if(n<=1){
            return dp[n]=cost[n];
        }
        if(dp[n]!=-1)return dp[n];
        
        int minCost1=0,minCost2=0;
        
        minCost1=minCostClimbingStairs_memo(n-1,cost,dp);
        minCost2=minCostClimbingStairs_memo(n-2,cost,dp);
        
        int myans= Math.min(minCost1,minCost2);
        return dp[n]=myans+(n==cost.length?0:cost[n]);
        
        
    }
     public int minCostClimbingStairs_dp(int n,int[] cost,int dp[]){
        
        for(int i=0;i<=n;i++){
            if(i<=1){
             dp[i]=cost[i];
                continue;
            }
            //if(dp[n]!=-1)return dp[n];
        
            int minCost1=0,minCost2=0;
        
            minCost1=dp[i-1]; //minCostClimbingStairs_memo(n-1,cost,dp);
            minCost2=dp[i-2];// minCostClimbingStairs_memo(n-2,cost,dp);
        
            int myans= Math.min(minCost1,minCost2);
            dp[i]=myans+(i==cost.length?0:cost[i]);
        }
        return dp[n];
        

        
        
    }
    public int minCostClimbingStairs_Opti(int N, int[] cost) {
        int a = cost[0];
        int b = cost[1];
        for (int i = 2; i < N; i++) {
            int minCost = Math.min(a, b) + cost[i];
            a = b;
            b = minCost;
        }

        return Math.min(a, b);
    }
    
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int ans= minCostClimbingStairs_dp(n,cost,dp);
        //System.out.println(ans);
        return ans;
    }

        static int mod=(int)1e9+7;
    
    public long countFriendsPairings(int n) 
    { 
        if(n<=1){
            return 1;
        }
        long single=countFriendsPairings(n-1);
        long pair=countFriendsPairings(n-2)*(n-1);
        return (single%mod + pair%mod )%mod;
    }

    public long countFriendsPairing_memo(int n,long dp[]){
        if(n<=1){
            return dp[n]=1;
        }
        if(dp[n]!=0) return dp[n];
        
        long single=countFriendsPairing_memo(n-1,dp);
        long pair=countFriendsPairing_memo(n-2,dp)*(n-1);
        return dp[n]=(long)((single%mod + pair%mod)%mod);
    }
        public long countFriendsPairings_dp(int N, long[] dp) {

        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = 1;
                continue;
            }

            long single = dp[n - 1]; // countFriendsPairings_memo(n-1,dp);
            long pairup = dp[n - 2] * (n - 1); // countFriendsPairings_memo(n-2,dp) * (n-1);

            dp[n] = (single % mod + pairup % mod) % mod;
        }

        return dp[N];
    }

    public static long printFriendsPairing(String friends,String ans){
        if(friends.length()==0){
            System.out.println(ans);
            return 1;
        }
        char ch=friends.charAt(0);
        long count=printFriendsPairing(friends.substring(1),ans+ch+" ");
        for(int i=1;i<friends.length();i++){
            String roq=friends.substring(0,i)+friends.substring(i+1);
            count+=printFriendsPairing(roq,ans+ch+friends.charAt(i)+" ");

        }
        return count;

    }

    public static void countFriendsPairings() 
    { 
        // long dp[]=new long[n+1];
        // return countFriendsPairing_memo(n,dp);
        System.out.println(printFriendsPairing("ABC",""));
    }

    //goldmin geeks for geeks recursive solution
    static int maxGold_rec(int r,int c,int arr[][]){
        if(c==arr[0].length-1)return arr[r][c];
        int one,two,three,myans;
        myans=0;
        one=Integer.MIN_VALUE;
        two=Integer.MIN_VALUE;
        three=Integer.MIN_VALUE;
        if(c+1<arr[0].length)
        one=maxGold_rec(r,c+1,arr);
        
        if(c+1<arr[0].length && r-1>=0)
        two=maxGold_rec(r-1,c+1,arr);
        
        if(c+1<arr[0].length && r+1<arr.length )
        three=maxGold_rec(r+1,c+1,arr);
        
        myans=arr[r][c]+Math.max( one,Math.max(two,three) );
        return myans;
        
        
    }
    
    static int maxGold(int n, int m, int arr[][])
    {
        int maxGold=0;
        // System.out.println("n"+n);
        // System.out.println("m"+m);
        for(int j=0;j<n;j++){
            int recans=maxGold_rec(j,0,arr);
            // System.out.println("recans"+ recans);
            maxGold=maxGold>recans?maxGold:recans;
        }
        return maxGold;
        
        
    }


    //goldmine memo solution
    static int maxGold_memo(int r,int c,int arr[][],int dp[][]){
        if(c==arr[0].length-1)return dp[r][c]=arr[r][c];
        
        if(dp[r][c]!=0) return dp[r][c];
        
        int one,two,three,myans;
        myans=0;
        one=Integer.MIN_VALUE;
        two=Integer.MIN_VALUE;
        three=Integer.MIN_VALUE;
        if(c+1<arr[0].length)
        one=maxGold_memo(r,c+1,arr,dp);
        
        if(c+1<arr[0].length && r-1>=0)
        two=maxGold_memo(r-1,c+1,arr,dp);
        
        if(c+1<arr[0].length && r+1<arr.length )
        three=maxGold_memo(r+1,c+1,arr,dp);
        
        myans=arr[r][c]+Math.max( one,Math.max(two,three) );
        return dp[r][c]=myans;
        
        
    }
    
    static int maxGold(int n, int m, int arr[][])
    {
        int dp[][]=new int[n][m];
        int maxGold=0;
        for(int j=0;j<n;j++){
            int recans=maxGold_memo(j,0,arr,dp);
            // System.out.println("recans"+ recans);
            maxGold=maxGold>recans?maxGold:recans;
        }
        return maxGold;
        
        
    }
    
    //goldmine dp 
    public static int goldMine_dp(int[][] mat, int[][] dp, int[][] dir) {
        int n = mat.length;
        int m = mat[0].length;

        for (int c = m - 1; c >= 0; c--) {
            for (int r = n - 1; r >= 0; r--) {

                if (c == mat[0].length - 1) {
                    dp[r][c] = mat[r][c];
                    continue;
                }

                int maxGold = 0;
                for (int d = 0; d < 3; d++) {
                    int x = r + dir[d][0];
                    int y = c + dir[d][1];
                    if (x >= 0 && x < n) {
                        maxGold = Math.max(maxGold, dp[x][y]);
                    }
                }

                dp[r][c] = maxGold + mat[r][c];
            }
        }

        int maxGold = 0;
        for (int i = 0; i < mat.length; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }

        return maxGold;
    }
    public static void goldMine() {
        int[][] mat = { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 1, 2 } };

        int[][] dp = new int[mat.length][mat[0].length];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

        int maxGold = 0;
        for (int i = 0; i < mat.length; i++) {
            maxGold = Math.max(maxGold, goldMine_memo(i, 0, mat, dp, dir));
        }

        System.out.println(goldMine_dp(mat, dp, dir));
        print2D(dp);
        // System.out.println(maxGold);
    }

    //leetcode 91
      public int numDecodings_(String s,String ans){
        if(s.length()==0){
            // System.out.println(ans);
            return 1;
        }
        int count=0;
        if(s.charAt(0)=='0'){
            return 0;
        }
        count+=numDecodings_(s.substring(1),ans+s.charAt(0)+" ");
        if(s.length()>=2){
            int isPossible=(s.charAt(0)-48)*10+(s.charAt(1)-48);
            // System.out.println("ispossible"+isPossible);
            if(isPossible<=26)
            {
            count+=numDecodings_(s.substring(2),ans+s.charAt(0)+s.charAt(1)+" ");            
            }            
        }

        
        return count;
        
    }
    
    public int numDecodings(String s) {
        
      return  numDecodings_(s,"");
        
    }

    //leetcode 91 recursion with idx instead of substring funciton as substring function is an o(n) function
        public int numDecodings_(String s,int idx){
        if(s.length()==idx){
            // System.out.println(ans);
            return 1;
        }
        int count=0;
        if(s.charAt(idx)=='0'){
            return 0;
        }
        count+=numDecodings_(s,idx+1);
        if(idx<s.length()-1){
            int isPossible=(s.charAt(idx)-48)*10+(s.charAt(idx+1)-48);
            // System.out.println("ispossible"+isPossible);
            if(isPossible<=26)
            {
            count+=numDecodings_(s,idx+2);            
            }            
        }

        
        return count;
        
    }

    public int numDecodings_memo(String s,int idx,int []dp){
        if(s.length()==idx){
            // System.out.println(ans);
            return dp[idx]=1;
        }
        if(dp[idx]!=-1)return dp[idx];
        int count=0;
        if(s.charAt(idx)=='0'){
            return 0;
        }
        count+=numDecodings_memo(s,idx+1,dp);
        if(idx<s.length()-1){
            int isPossible=(s.charAt(idx)-48)*10+(s.charAt(idx+1)-48);
            // System.out.println("ispossible"+isPossible);
            if(isPossible<=26)
            {
            count+=numDecodings_memo(s,idx+2,dp);            
            }            
        }

        
        return dp[idx]=count;
        
    }

        public int numDecodings_DP(String s,int IDX,int []dp){
        
        for(int idx=s.length();idx>=0;idx--){
            
        
        if(s.length()==idx){
            
             dp[idx]=1;
            continue;
            }   
        
        int count=0;
        if(s.charAt(idx)=='0'){
            dp[idx]=0;
            continue;
        }
        count+=dp[idx+1];//numDecodings_memo(s,idx+1,dp);
        if(idx<s.length()-1){
            int isPossible=(s.charAt(idx)-48)*10+(s.charAt(idx+1)-48);
            // System.out.println("ispossible"+isPossible);
            if(isPossible<=26)
            {
            count+=dp[idx+2];//numDecodings_memo(s,idx+2,dp);            
            }            
        }

        
         dp[idx]=count;
        }
        return dp[IDX];
        
    }
    int numDecodings_Opti(String s) {
        int a = 1, b = 0;
        for (int idx = s.length() - 1; idx >= 0; idx--) {

            int count = 0;
            char ch1 = s.charAt(idx);
            if (ch1 != '0') {

                count += a;

                if (idx < s.length() - 1) {
                    char ch2 = s.charAt(idx + 1);
                    int num = (ch1 - '0') * 10 + (ch2 - '0');
                    if (num <= 26)
                        count += b;
                }
            }
            b = a;
            a = count;
        }

        return a;
    }
    
    public int numDecodings(String s) {
        int dp[]=new int[s.length()+1];
      return  numDecodings_(s,0);
        
    }


    //leetcode 639
     static int mod=(int)1e9+7;
    long numDecodings_memo(String s, int idx, long[] dp) {

        if (idx == s.length()) {
            return dp[idx] = 1;
        }

        if (dp[idx] != -1)
            return dp[idx];
        if (s.charAt(idx) == '0') {
            return 0;
        }

        long count = 0;
        char ch1 = s.charAt(idx);

        if (s.charAt(idx) == '*') {
            count = (count + 9 * numDecodings_memo(s, idx + 1, dp)) % mod;
            if (idx < s.length() - 1) {
                char ch2 = s.charAt(idx + 1);
                if (ch2 == '*')
                    count = (count + 15 * numDecodings_memo(s,idx+2,dp)) % mod;
                else if (ch2 >= '0' && ch2 <= '6')
                    count = (count + 2 * numDecodings_memo(s,idx+2,dp)) % mod;
                else if (ch2 > '6')
                    count = (count + numDecodings_memo(s,idx+2,dp)) % mod;

            }
        } else {
            count = (count + numDecodings_memo(s, idx + 1, dp)) % mod;
            if (idx < s.length() - 1) {
                if (s.charAt(idx + 1) != '*') {
                    char ch2 = s.charAt(idx + 1);
                    int num = (ch1 - '0') * 10 + (ch2 - '0');
                    if (num <= 26)
                        count = (count + numDecodings_memo(s,idx+2,dp)) % mod;
                } else {
                    if (s.charAt(idx) == '1')
                        count = (count + 9 * numDecodings_memo(s,idx+2,dp)) % mod;
                    else if (s.charAt(idx) == '2')
                        count = (count + 6 * numDecodings_memo(s,idx+2,dp)) % mod;
                }
            }
        }

        return dp[idx] = count;
    }

    long numDecodings_dp(String s, int IDX, long[] dp) {
        for (int idx = s.length(); idx >= 0; idx--) {
            if (idx == s.length()) {
                dp[idx] = 1;
                continue;
            }

            if (s.charAt(idx) == '0') {
                dp[idx] = 0;
                continue;
            }

            long count = 0;
            char ch1 = s.charAt(idx);

            if (s.charAt(idx) == '*') {
                count = (count + 9 * a) % mod;
                if (idx < s.length() - 1) {
                    char ch2 = s.charAt(idx + 1);
                    if (ch2 == '*')
                        count = (count + 15 * b) % mod;
                    else if (ch2 >= '0' && ch2 <= '6')
                        count = (count + 2 * b) % mod;
                    else if (ch2 > '6')
                        count = (count + b) % mod;

                }
            } else {
                count = (count + a) % mod;
                if (idx < s.length() - 1) {
                    if (s.charAt(idx + 1) != '*') {
                        char ch2 = s.charAt(idx + 1);
                        int num = (ch1 - '0') * 10 + (ch2 - '0');
                        if (num <= 26)
                            count = (count + b) % mod;
                    } else {
                        if (s.charAt(idx) == '1')
                            count = (count + 9 * b) % mod;
                        else if (s.charAt(idx) == '2')
                            count = (count + 6 * b) % mod;
                    }
                }
            }

            dp[idx] = count;
        }

        return (int) dp[IDX];
    }

    long numDecodings_opti(String s) {
        long a = 1, b = 0;
        for (int idx = s.length() - 1; idx >= 0; idx--) {

            long count = 0;
            char ch1 = s.charAt(idx);
            if (ch1 == '0') {
                count = 0;
            } else if (ch1 == '*') {
                count = (count + 9 * a) % mod;
                if (idx < s.length() - 1) {
                    char ch2 = s.charAt(idx + 1);
                    if (ch2 == '*')
                        count = (count + 15 * b) % mod;
                    else if (ch2 >= '0' && ch2 <= '6')
                        count = (count + 2 * b) % mod;
                    else if (ch2 > '6')
                        count = (count + b) % mod;

                }
            } else {
                count = (count + a) % mod;
                if (idx < s.length() - 1) {
                    if (s.charAt(idx + 1) != '*') {
                        char ch2 = s.charAt(idx + 1);
                        int num = (ch1 - '0') * 10 + (ch2 - '0');
                        if (num <= 26)
                            count = (count + b) % mod;
                    } else {
                        if (s.charAt(idx) == '1')
                            count = (count + 9 * b) % mod;
                        else if (s.charAt(idx) == '2')
                            count = (count + 6 * b) % mod;
                    }
                }
            }

            b = a;
            a = count;
        }

        return (int) a;
    }
    
    public int numDecodings(String s) {
        long dp[]=new long[s.length()+1];
        Arrays.fill(dp,-1);
      return (int)numDecodings_memo(s,0,dp);
    }

    // https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/
    public static int noOfWays_memo(int n,int k,int dp[][]){
        if(k==1){
            dp[n][k]=1;
        }
        if(n==k){
            dp[n][k]=1;
        }
        if(dp[n][k]!=0) return dp[n][k];

        int uniqueGroup=noOfWays(n-1,k-1,dp);
        int partOfexistingGroup=noOfWays(n-1,k,dp)*k;
        return dp[n][k]=uniqueGroup+partOfexistingGroup;

    }




    public static void main(String []args){
        // fibo();
        // int dp[][]=new int[3][3];
        // int dp[]=new int[11];
        // int dp[][]=new int[11][11];

        // System.out.println(mazePathInfi_memo(0,0,2,2,dp));
        // System.out.println(mazePath(0,0,10,10));
        //  System.out.println(board_dice_DP(0,10,dp));

        // System.out.println(mazePath_memo(0,0,10,10,dp));
        // print2D(dp);
        countFriendsPairings();

    }

}