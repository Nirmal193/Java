package com.design.Questions;

import com.design.util.Node;
import com.design.util.Pair;
import com.design.util.Tree;

import java.util.*;

public class Test2 {
    int v;
    LinkedList<Integer> adj[];
    int[] parent;
    int[] sizes;

    public Test2(int size) {
        this.v = size;
        parent = new int[size];
        sizes = new int[size];
        Arrays.fill(sizes, 1);
        adj = new LinkedList[size];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }


    /*
        end of the space for the inner classes
     */
    public void addEdgeUn(int s, int d) {
        adj[s].add(d);
        adj[d].add(s);
    }

    void addEdge(int v, int w)  { adj[v].add(w); }

    public void addColor() {
        int[] result = new int[v];
        boolean[] available = new boolean[v];
        Arrays.fill(result, -1);
        Arrays.fill(available, true);
        available[0] = false;
        result[0] = 0;
        for (int i = 1; i < v; i++) {
            Iterator<Integer> itr = adj[i].listIterator();
            while (itr.hasNext()) {
                int ngh = itr.next();
                if (result[ngh] != -1)
                    available[result[ngh]] = false;
            }
            int j = 0;
            for (j = 0; j < v; j++)
                if (available[j])
                    break;
            result[i] = j;
            Arrays.fill(available, true);
        }
        for (int i = 0; i < v; i++)
            System.out.println(result[i]);
    }
    int [][] graph;
    int row[] = {-1,0,1,0};
    int col[] = {0,1,0,-1};
    public static int mod = 1000000007;
    public int BFS(int n,int[] start,int end[]){
        Pair<Integer,Integer> currNode = new Pair(start[0],start[1]);
        Pair<Integer,Integer> destnode = new Pair<>(end[0],end[1]);
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        boolean visited[][] = new boolean[n][n];
        q.add(currNode);
        int ans = 0;
        visited[currNode.getFirst()][currNode.getSecond()] = true;
        while(!q.isEmpty()){
            ans++;
            for(int j = 0;j<q.size();j++) {
                Pair<Integer, Integer> curr = q.poll();
                for (int i = 0; i < row.length; i++) {
                    int newrow = curr.getFirst() + row[i];
                    int newcol = curr.getSecond() + col[i];
                    if (newrow == destnode.getFirst() && newcol == destnode.getSecond())
                        return ans;
                    if (newrow >= 0 && newcol >= 0 && newrow < n && newcol < n && visited[newrow][newcol] == false) {
                        visited[newrow][newcol] = true;
                        q.add(new Pair<>(newrow, newcol));
                    }
                }
            }
        }
        return ans;
    }

    public void solve(boolean graph[][], int m, int n) {
        int indegree[] = new int[n];
        int ans = 5;
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<n;j++){
                if(i!=j && graph[i][j])
                    indegree[j]++;
            }
        }
        for(int i=0;i<indegree.length;i++)
            ans = Math.max(indegree[i],ans);
    }

    public void topSort() {
        List<Integer> ans = new ArrayList<>();
        int[] indegree = new int[v];
        for (int i = 0; i < v; i++) {
            Iterator<Integer> itr = adj[i].listIterator();
            while (itr.hasNext()) {
                indegree[itr.next()]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }
        ;
        boolean multiDimaentional = false;
        while (!queue.isEmpty()) {
            if (queue.size() > 1)
                multiDimaentional = true;
            int curr = queue.getFirst();
            queue.removeFirst();
            ans.add(curr);
            Iterator<Integer> itr = adj[curr].listIterator();
            while (itr.hasNext()) {
                int ngh = itr.next();
                indegree[ngh]--;
                if (indegree[ngh] == 0)
                    queue.add(ngh);
            }
        }
        if (ans.size() != v)
            System.out.println("cycle present in the graph");
        else
            System.out.println(ans.toString());
    }

    public void DFSUtil(int x,boolean visited[]){
        visited[x] = true;
        System.out.print(x + " ");

        int n;

        Iterator<Integer> i =adj[x].iterator();
        while (i.hasNext())
        {
            n = i.next();
            if (!visited[n])
                DFSUtil(n,visited);
        }
    }
    public Test2  getTranspose(){
        Test2 g = new Test2(v);
        for (int x = 0; x < v; x++)
        {
            Iterator<Integer> i =adj[x].listIterator();
            while(i.hasNext())
                g.adj[i.next()].add(x);
        }
        return g;
    }
    public void fillOrder(int node,boolean[] visited,Stack stack){
        visited[node] = true;
        Iterator<Integer> i = adj[node].iterator();
        while (i.hasNext())
        {
            int n = i.next();
            if(!visited[n])
                fillOrder(n, visited, stack);
        }
        stack.push(new Integer(node));
    }
    public void solve(){
        Stack stack = new Stack();
        boolean visited[] = new boolean[v];
        for(int i = 0; i < v; i++)
            visited[i] = false;
        for (int i = 0; i < v; i++)
            if (visited[i] == false)
                fillOrder(i, visited, stack);
        Test2 gr = getTranspose();

        for (int i = 0; i < v; i++)
            visited[i] = false;
        int ans = 0;
        while (stack.empty() == false)
        {
            int v = (int)stack.pop();
            if (visited[v] == false)
            {
                ans++;
                gr.DFSUtil(v, visited);
                System.out.println();
            }
        }
        System.out.println(ans);
    }
    public void solved(int [][]grid,int i,int j){

    }
    public int solveRottenTamota(int [][] grid){
        LinkedList<Integer> rott=  new LinkedList<>();
        int len = Math.max(grid.length,grid[0].length)+1;
        int l = grid.length;
        boolean[][] visited = new boolean[l][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2)
                    rott.add( i * len + j);
            }
        }
        int ans = 0;
        while(!rott.isEmpty()){
            int sz = rott.size();
            boolean flag = false;
            for(int i=0;i<sz;i++){
                int curr_node = rott.poll();
                int x = curr_node / len;
                int y = curr_node % len;
                for(int j=0;j<4;j++){
                    int nrow = x+row[j];
                    int ncol = y+col[j];
                    if(ncol >=0 && nrow >=0 && ncol < l && nrow < l && grid[nrow][ncol] == 1 &&
                            visited[nrow][ncol] == false){
                        visited[nrow][ncol] = true;
                        rott.add(nrow * len + ncol);
                        flag = true;
                    }
                }
            }
            if(flag)
                ans++;
        }
        return ans;
    }
    public boolean solves(int[][] grid,boolean[][] visited,int i,int j,int n,int m){
        visited[i][j] = true;
        for(int x=0;x<4;x++){
            int nrow = i + row[x];
            int ncol = j + col[x];
            if(nrow >=0 && ncol >=0 && nrow < n && ncol < m  && visited[nrow][ncol]== false) {
                if(grid[nrow][ncol] == 3)
                    solves(grid, visited, nrow, ncol, n, m);
                else if(grid[nrow][ncol] == 2)
                    return true;
            }
        }
        return false;
    }
    public boolean isPossible(int[][] grid){
        boolean[][] visisted = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1) {
                    visisted[i][j] = true;
                    return solves(grid, visisted, i, j, grid.length, grid[0].length);
                }
            }
        }
        return false;
    }

    public int dijkstra(int[][] grid){
        int len = grid.length;
        boolean[][] visited = new boolean[len][len];
        PriorityQueue<Pair<Integer,Pair<Integer,Integer>>> map = new PriorityQueue<>(new Comparator<Pair<Integer, Pair<Integer, Integer>>>() {
            @Override
            public int compare(Pair<Integer, Pair<Integer, Integer>> o1, Pair<Integer, Pair<Integer, Integer>> o2) {
                return o1.getFirst() - o2.getFirst();
            }
        });
        int[][] dist = new int[len][len];
        for(int i=0;i<len;i++)
            for(int j=0;j<len;j++)
                dist[i][j] = Integer.MAX_VALUE;
        visited[0][0] = true;
        map.add(new Pair(grid[0][0],new Pair<>(0,0)));
        while(!map.isEmpty()){
            int sz = map.size();
            //for(int y=0;y<sz;y++) {
                Pair<Integer, Pair<Integer,Integer>> currNode = map.poll();
                int i = currNode.getSecond().getFirst();
                int j = currNode.getSecond().getSecond();
                int currDist = currNode.getFirst();
                if(i == 7 && j ==6){
                    System.out.println("reached");
                }
                for (int x = 0; x < 4; x++) {
                    int nrow = i + row[x];
                    int ncol = j + col[x];
                    if (nrow >= 0 && ncol >= 0 && nrow < len && ncol < len ) {
                        if(visited[nrow][ncol] == false) {
                            map.add(new Pair(currDist + grid[nrow][ncol], new Pair<>(nrow,ncol)));
                            visited[nrow][ncol] = true;
                        }
                        dist[nrow][ncol] = Math.min(dist[nrow][ncol], currDist + grid[nrow][ncol]);
                    }
                //}
            }
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }
        return dist[len-1][len-1];
    }

    public Tree helperTree(Tree node,Map<Tree,Tree> map){
        if(node == null)
            return null;
        Tree copy = new Tree(node.data);
        copy.left = helperTree(node.left,map);
        copy.right = helperTree(node.right,map);
        map.put(node,copy);
        return copy;
    }
    public void solveTree(Tree node,Tree copy,Map<Tree,Tree> map){
       if(node == null)
           return;
       copy.random = map.get(node.random);
       solveTree(node.left,copy.left,map);
       solveTree(node.right,copy.right,map);
    }

    public Tree cloneTree(Tree root){
        Map<Tree,Tree> map = new HashMap<>();
        Tree copy = helperTree(root,map);
        solveTree(root,copy,map);
        return copy;
    }
    public int size(Node head){
        int ans =0;
        while(head != null){
            System.out.println(head.data + "->");
            ans++;
            head = head.next;
        }
        return ans;
    }
    public Node copyList(Node head){
        Node temp = head;
        while(temp != null){
            Node nextNode  = temp.next;
            Node copy = new Node(temp.data);
            temp.next = copy;
            copy.next = nextNode;
            temp = temp.next.next;
        }
        temp = head;
        Node copy = new Node(-1);
        Node ans = copy.next;
        while(temp.next != null){
            temp.next.arb = temp.arb.next;
            copy.next = temp.next;
            copy = copy.next;
            temp = temp.next.next;
        }
        return ans;
    }
    static PriorityQueue<Integer> left = new  PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> right = new PriorityQueue<>();
    public static void insertHeap(int x) {
        if(right.size() > 0 && x >= right.peek()){
            right.add(x);
        }else{
            left.add(x);
        }
        balanceHeaps();
    }
    public static void balanceHeaps() {
        if(left.size() - right.size() == 2){
            right.add(left.remove());
        }else if(right.size() - left.size() == 2){
            left.add(right.remove());
        }
    }
    public static double getMedian() {
        double median = 0;
        if(left.size() > right.size()){
            median = (double)(left.peek());
        }else if(left.size() == right.size()){
            median = (double)(left.peek() + right.peek())/2;
        }else{
            median = (double)(right.peek());
        }
        return median;
    }
    public static int solveMat(int mat[][],int n,int m,int x){
        for(int i=0;i<n;i++){
            int j = m-1;
            while(j>=0){
                if(mat[i][j] >= x && mat[i][0] <= x){
                    if(mat[i][j] == x)
                        return 1;
                    j--;
                }
                if(mat[i][j]  < x){
                    break;
                }
            }
        }
        return 0;
    }
    public static int solveMatt(int mat[][],int n,int m,int x){
        for(int i=0;i<n;i++){
            int j = m-1;
            while(j>=0) {
                if (mat[i][j] >= x && mat[i][0] <= x) {
                    if (mat[i][j] == x)
                        return 1;
                }
                    j--;
            }
        }
            return 0;
    }

    public int solveCeleb(int mat[][],int n){
        if(n==0)
            return -1;
        int id = solveCeleb(mat,n-1);
        if(id  == -1)
            return n-1;
        if(mat[id][n-1] == 1)
            return n-1;
        if(mat[n-1][id] == 1)
            return id;
        return -1;
    }
    public int celebrity(int mat[][],int n){
        int celeb = solveCeleb(mat,n);
        if(celeb == -1)
            return -1;
        for(int i=0;i<n;i++){
            if(i!= celeb){
                if(mat[i][celeb] != 1)
                    return -1;
            }
        }
        return celeb;
    }
    public int celeb(int mat[][],int n){
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<n;i++)
            stk.push(i);
        while(stk.size()>1){
            int a = stk.pop();
            int b = stk.pop();
            if(mat[a][b] == 1)
                stk.push(b);
            if(mat[b][a] == 1)
                stk.push(a);
        }
        if(stk.size() == 0)
            return -1;
        int celeb = stk.pop();
        for(int i=0;i<n;i++){
            if(i!= celeb){
                if(mat[i][celeb] != 1)
                    return -1;
            }
        }
        return celeb;

    }

    public static long power(int a,int b){
        if(b==0)
            return 1;
        long temp = power(a,b/2);
        temp = (temp*temp)%mod;
        if(b%2==0)
            return temp;
        else
            return (temp%a)%mod;
    }
    public static int solveLong(int A[],int N,int K){
        HashMap<Integer,Integer>h=new HashMap<>();
        int presum=0;
        int res=0;
        for(int i=0;i<N;i++){
            presum+=A[i];
            if(presum==K){
                res=i+1;
            }
            if(!h.containsKey(presum)){
                h.put(presum,i);
            }
            if(h.containsKey(presum-K)){
                res=Math.max(res,i-h.get(presum-K));
            }
        }
        return res;
    }

    public static boolean solveword(Set<String> set,String b,String sub,int index){
        if(index == b.length()) {
            if(set.contains(sub))
                return true;
            else
                return false;
        }
        if(set.contains(sub)){
           return  solveword(set,b,sub += b.charAt(index),index+1) ||
                    solveword(set,b,"",index+1);
        }
        return solveword(set,b,sub += b.charAt(index),index+1);

    }
    public static int wordBreak(String A,ArrayList<String> B){
        Set<String> set = new HashSet<>(B);
        boolean ans = solveword(set,A,"",0);
        if(ans)
            return 1;
        else
            return 0;
    }

    public static  double medianOfTwoArray(int n,int m,int a[],int b[]){
        int size=(m+n)/2;
        int x = 0,y = 0;
        int i=0,j=0;
        int k=0;
        while(k<=size &&i<n &&j<m)
        {
            if(a[i]<b[j]) {
                y = x;
                x = a[i++];
            }
            else {
                y = x;
                x = b[j++];
            }
            k++;
        }
        while(k<=size && i<n) {
            y = x;
            x = a[i++];
            k++;
        }
        while(k<=size && j<m) {
            y = x;
            x = b[j++];
            k++;
        }
        if((m+n)%2==0)
        {

            return (double)(x+y)/2;
        }
        else
        {
            return x;
        }
    }

    public static Node solveLinkedList(Node head){
        int sz = 0;
        Node ref = head;
        while(ref!= null){
            sz++;
            ref = ref.next;
        }
        int m = (sz/2) + 1;
        Node mid =  head;
        int r = sz - m;
        while(m>=0){
            m--;
            mid = mid.next;
        }
        Node ans = head;
        while(r>0){
            Node temp = ans.next;
            ans.next = mid;
            mid.next = temp;
            ans = mid.next;
        }
        return head;
    }

    public List<Integer> list = new ArrayList<>();
    public void mergeTree(Tree root1,Tree root2){
        if(root1 == null && root2 == null)
            return;
        if(root1.left != null)
            mergeTree(root1.left,root2);
        if(root2.left != null)
            mergeTree(root1,root2.left);
        if(root1.data<=root2.data)
            list.add(root1.data);
        else
            list.add(root2.data);
        if(root1.right != null)
            mergeTree(root1.right,root2);
        if(root2.right != null)
            mergeTree(root1,root2.right);

    }

    public void inOrderTree(Tree root){
        List<Integer> ans = new ArrayList<>();
        Stack<Tree> stk = new Stack<>();
        while(root != null || !stk.empty()){
            if(root != null){
                stk.push(root);
                ans.add(root.data);
                root = root.left;
            }else{
                Tree temp = stk.pop();
                ans.add(temp.data);
                    root = temp.right;
            }
        }
    }
    Node prev = null;
    Node head;
    public void BtoDLL(Node root){
        if(root == null)
            return;
        BtoDLL(root.left);
        if(prev == null) {
            head = root;
        }else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        BtoDLL(root.right);
    }

    public static double getMedianOfArrays(int[] nums1,int[] nums2){
        int len = nums1.length + nums2.length;
        int prev = 0,curr = 0;
        int i =0,j=0,k = 0 ;
        int mid = len/2 + 1;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] < nums2[j]) {
                prev = curr;
                curr = nums1[i++];
            }
            else {
                prev = curr;
                curr = nums2[j++];
            }
            k++;
            if(i == nums1.length || j == nums2.length)
                break;
            if(k == mid)
                break;
        }
        while (k<mid && i< nums1.length) {
            prev = curr;
            curr = nums1[i++];
            k++;
        }
        while (k < mid && j<nums2.length){
            prev = curr;
            curr = nums2[j++];
            k++;
        }
        if(len%2 != 0)
            return (double)curr;
        else{
            return (double) (curr +prev)/2;
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval){
        List<int[]> res = new ArrayList<>();
        int sz = intervals.length;
        int i = 0;
        while(i<sz && intervals[i][1] < newInterval[0])
            res.add(new int[]{intervals[i][0],intervals[i++][1]});
        while(i<sz && intervals[i][0] <= newInterval[1])
            newInterval = new int[]{Math.min(intervals[i][0], newInterval[0]),
                    Math.max(intervals[i++][1], newInterval[1])};
        res.add(new int[]{newInterval[0],newInterval[1]});
        while(i<sz) res.add(new int[]{intervals[i][0],intervals[i++][1]});
        int[][] ans = new int[res.size()][2];
        System.out.println(res.size());
        for(i=0;i< res.size();i++) {
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }
        return ans;
    }

    public boolean isPossible (int x,int y,List<char[]> chess,int n){
        for(int i=0;i<n;i++)
            if(chess.get(x)[i]=='Q' )
                return false;
        for(int i=x,j = y; i>=0 && j>=0;i--,j--)
            if(chess.get(i)[j] == 'Q')
                return false;
        for(int i=x,j = y; i< n && j>=0;i++,j--)
            if(chess.get(i)[j] == 'Q')
                return false;
        return true;
    }
    List<List<char[]>> ans = new ArrayList<>();
    public boolean solveChess(List<char[]> chess,int n,int j,int start){
        if(j == n)
            return true;
        for(int i=0;i<n;i++){
            if(isPossible(i,j,chess,n)){
                chess.get(i)[j] = 'Q';
                if(solveChess(chess, n,j+1,start))
                    return true;
                chess.get(i)[j] = '.';
            }
        }
        return false;
    }
    public List<List<String>> solveNQueens(int n) {
        List<char[]> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            String temp = "";
            for(int j=0;j<n;j++){
                temp+=".";
            }
            ans.add(temp.toCharArray());
        }
        solveChess(ans,n,0,0);
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++)
                System.out.print(ans.get(i)[j] + " ");
            System.out.println();
        }
        return null;
    }



    private Set<Integer> colo = new HashSet<Integer>();
    private Set<Integer> diag1 = new HashSet<Integer>();
    private Set<Integer> diag2 = new HashSet<Integer>();
    public List<List<String>> solveNQueenss(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(res,new ArrayList<String>(), 0, n);
        return res;
    }
    private void dfs(List<List<String>> res, List<String> list, int row, int n){
        if (row == n){
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int i = 0; i < n; i++){
            if (colo.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)) continue;

            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[i] = 'Q';
            String rowString = new String(charArray);

            list.add(rowString);
            colo.add(i);
            diag1.add(row + i);
            diag2.add(row - i);

            dfs(res, list, row + 1, n);

            list.remove(list.size() - 1);
            colo.remove(i);
            diag1.remove(row + i);
            diag2.remove(row - i);
        }
    }

    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        for(int i =0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i=0;i<n;i++){

        }
    }

    public static int minimumNumberOfSwaps(Integer[] arr){
        int n = arr.length;
        int max_element =  Collections.max(Arrays.asList(arr));
        int min_element = Collections.min(Arrays.asList(arr));
        int max_index = -1;
        int min_index = -1;
        for(int i=0;i<n;i++){
            if(arr[i] == max_element)
                max_index = i;
            if(arr[i] == min_element)
                min_index = i;
        }
        if(max_index == min_index)
            return 0;
        if(min_index < max_index)
            return min_index + (n-max_index -1);
        else
            return min_index + (n-max_index -2);
    }

    public void scrambledString(String[] words,int index,String str,List<String> ans){
        if(index == words.length)
            ans.add(str);
        for(int i=index;i<words.length;i++){
            scrambledString(words,index+1,str+words[i],ans);
        }
    }
    public List<Integer> findSubstring(String[] words,String s){
        String[] str = {"1","2"};
        List<String> ans = new ArrayList<>();
        scrambledString(str,0,"",ans);
        ans.stream().forEach(System.out::println);
        return null;
    }



    public static void main(String[] args) {
        int grid[][] = {{9,7,6,2,4,3,5,7},{4,3,5,8,9,9,8,4},
                {9,1,1,1,9,8,9,3},{3,5,7,5,2,10,10,1},{3,5,1,3,4,5,10,3},{4,10,9,10,2,8,8,6},
                {9,9,7,5,6,8,3,1},{6,7,6,10,3,2,5,9}};
        Test2 ts = new Test2(3);
        String str[] = new String[0];
        ts.findSubstring(str,"");
    }
}
